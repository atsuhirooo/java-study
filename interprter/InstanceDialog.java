import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class InstanceDialog extends BaseDialog {

	;
	private static final String TITLE = "Create Instance";
	private static final int MARGIN = 3;

	private final PropertyChangeSupport properChangeSupport;

	private final GridBagConstraints componentConstraints = new GridBagConstraints();
	private final JLabel constructorComboLabel = new JLabel("Constractors");
	private final JComboBox<Constructor<?>> constructorCombo = new JComboBox<>();
	private final JLabel parameterLabel = new JLabel("parameters");
	private JPanel parameterPanel = new JPanel();
	private Map<java.lang.reflect.Type, Object> parameterMap = new LinkedHashMap<>();
	private final JButton createButton = new JButton("new and save Instance");
	private Object targetInstance;
	// private final JButton createAndOpenButton = new JButton("manipulate

	public InstanceDialog(Class<?> clazz, boolean isArray, int arraySize) {

		setTitle(clazz.getName());

		this.isArray = isArray;
		this.arraySize = arraySize;

		componentConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);

		properChangeSupport = new PropertyChangeSupport(this);

		componentConstraints.gridx = 0;
		componentConstraints.gridy = 0;
		componentConstraints.fill = GridBagConstraints.HORIZONTAL;
		componentConstraints.anchor = GridBagConstraints.CENTER;

		getConstractor(clazz);
		constructorCombo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Constructor<?> selectedConstructor = (Constructor<?>) constructorCombo.getSelectedItem();
				if (selectedConstructor == null) { // removeAllのとき
					return;
				}
				remove(parameterLabel);
				remove(parameterPanel);
				remove(createButton);
				// remove(createAndOpenButton);

				java.lang.reflect.Type[] parameters = selectedConstructor.getGenericParameterTypes();
				// properChangeSupport.firePropertyChange(ParameterPanel.PARAMETER_CHANGE_KEY,
				// null, parameters);
				parameterPanel = createParameterPanel(parameters);
				componentConstraints.gridx = 0;
				componentConstraints.fill = GridBagConstraints.NONE;
				componentConstraints.anchor = GridBagConstraints.CENTER;
				add(parameterLabel, componentConstraints);

				componentConstraints.gridx = 0;
				componentConstraints.gridy = 4;
				componentConstraints.fill = GridBagConstraints.NONE;
				componentConstraints.anchor = GridBagConstraints.CENTER;

				add(parameterPanel, componentConstraints);

				componentConstraints.gridx = 0;
				componentConstraints.gridy = 5;
				componentConstraints.fill = GridBagConstraints.HORIZONTAL;
				componentConstraints.anchor = GridBagConstraints.CENTER;
				add(createButton, componentConstraints);

				// componentConstraints.gridx = 0;
				// componentConstraints.gridy = 6;
				// componentConstraints.fill = GridBagConstraints.HORIZONTAL;
				// componentConstraints.anchor = GridBagConstraints.CENTER;
				// add(createAndOpenButton, componentConstraints);

				revalidate();
				Dimension d = getPreferredSize();
				setSize(LEFT_RIGHT_MARGIN + d.width, TOP_BOTTOM_MARGIN + d.height);
				repaint();
			}
		});

		createButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					createAndSaveInstance((Constructor<?>) constructorCombo.getSelectedItem());
					dispose();
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "(" + e.getClass() + ") is thrown", "faild to create instance",
							JOptionPane.ERROR_MESSAGE);
				} catch (InvocationTargetException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "(" + e.getTargetException().getClass() + ") is thrown",
							"faild to create instance", JOptionPane.ERROR_MESSAGE);
				}
				//
			}
		});

		Dimension d = getPreferredSize();
		setSize(LEFT_RIGHT_MARGIN + d.width, TOP_BOTTOM_MARGIN + d.height);
	}

	private void getConstractor(Class<?> clazz) {

		if (clazz.isPrimitive()) {
			JOptionPane.showMessageDialog(null, "primitive type", "invalid", JOptionPane.ERROR_MESSAGE);
			return;
		}

		remove(constructorComboLabel);
		constructorCombo.removeAllItems();
		remove(constructorCombo);

		addComboBox(clazz.getDeclaredConstructors());

		revalidate();
		Dimension d = getPreferredSize();
		setSize(LEFT_RIGHT_MARGIN + d.width, TOP_BOTTOM_MARGIN + d.height);
		repaint();
	}

	public Object getTargetInstance() {
		return targetInstance;

	}

	private void addComboBox(Constructor<?>[] constructors) {
		assert constructors != null;

		componentConstraints.gridx = 0;
		componentConstraints.gridy = 1;
		componentConstraints.fill = GridBagConstraints.NONE;
		componentConstraints.anchor = GridBagConstraints.CENTER;
		add(constructorComboLabel, componentConstraints);

		for (Constructor<?> c : constructors) {
			if (c.getDeclaringClass() == Class.class) {
				continue;
			}
			c.setAccessible(true);
			constructorCombo.addItem(c);
		}
		componentConstraints.gridx = 0;
		componentConstraints.gridy = 2;
		componentConstraints.fill = GridBagConstraints.NONE;
		componentConstraints.anchor = GridBagConstraints.CENTER;
		add(constructorCombo, componentConstraints);
	}

	private void createAndSaveInstance(Constructor<?> constructor)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		assert constructor != null;

		targetInstance = constructor.newInstance(makeParameterArray());

		notifyObservers();

	}

	Object[] makeParameterArray() {
		List parameterArray = new ArrayList();
		for (Map.Entry<java.lang.reflect.Type, Object> ent : parameterMap.entrySet()) {
			parameterArray.add(ent.getValue());

		}
		return parameterArray.toArray(new Object[0]);

	}

	private JPanel createParameterPanel(java.lang.reflect.Type[] parameters) {

		assert parameters != null;

		JPanel panel = new JPanel();
		List<? super Component> parameterComponents = new ArrayList<>();
		GridBagConstraints componentConstraints = new GridBagConstraints();

		componentConstraints.fill = GridBagConstraints.HORIZONTAL;
		componentConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
		for (int i = 0; i < parameters.length; i++) {
			componentConstraints.gridy = i;
			if (parameters[i] == boolean.class || parameters[i] == byte.class || parameters[i] == char.class
					|| parameters[i] == short.class || parameters[i] == int.class || parameters[i] == long.class
					|| parameters[i] == float.class || parameters[i] == double.class) {
				componentConstraints.gridx = 0;
				componentConstraints.anchor = GridBagConstraints.EAST;
				panel.add(new JLabel(parameters[i].toString()), componentConstraints);

				componentConstraints.gridx = 1;
				componentConstraints.anchor = GridBagConstraints.WEST;
				final JTextField text = new JTextField(10);
				final java.lang.reflect.Type type = parameters[i];
				parameterMap.put(parameters[i], null);
				text.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {

						parameterMap.put(type, text.getText());
					}
				});

				text.setName(parameters[i].toString());
				panel.add(text, componentConstraints);

				parameterComponents.add(text);
			} else {
				final Class<?> cls;
				if (parameters[i] instanceof Class<?>) {
					cls = (Class<?>) parameters[i];
				} else if (parameters[i] instanceof ParameterizedType) {
					cls = (Class<?>) ((ParameterizedType) parameters[i]).getRawType();
				} else {
					throw new Error("Unexpected non-class parameters[" + i + "]");
				}
				componentConstraints.gridx = 0;
				componentConstraints.anchor = GridBagConstraints.EAST;
				panel.add(new JLabel(cls.getName() + ": "), componentConstraints);

				assert cls != null;
				componentConstraints.gridx = 1;
				componentConstraints.anchor = GridBagConstraints.WEST;
				final JButton button;
				final InstanceDialog instanceDialog;
				// if (cls.isArray()) {

				// } else {
				button = new JButton("create Instance");
				instanceDialog = new InstanceDialog(cls, false, 0);
				// }

				final java.lang.reflect.Type type = parameters[i];
				parameterMap.put(parameters[i], instanceDialog.targetInstance);

				instanceDialog.setName(parameters[i].toString());
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						instanceDialog.setLocationRelativeTo(null);
						instanceDialog.setVisible(true);
					}
				});
				parameterComponents.add(instanceDialog);
				panel.add(button, componentConstraints);
			}
		}
		panel.setVisible(true);
		return panel;
	}

}
