
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

final class ClassSearchPanel extends JPanel {

	private static final long serialVersionUID = -7993862776611436241L;
	private static final int MARGIN = 5;
	public static final String SEARCH_RESULT_KEY = "SEARCH_RESULT";

	private final PropertyChangeSupport properChangeSupport;

	private final GridBagConstraints componentConstraints = new GridBagConstraints();

	private Class<?> searchResult = null;
	private final JLabel caption;
	private final JTextField classNameField = TextFieldUtil.createStringTextField();
	private final JButton searchButton = new JButton("検索");

	private ClassSearchPanel(PropertyChangeListener l, Class<?> superClass) {
		super(new GridBagLayout());

		properChangeSupport = new PropertyChangeSupport(this);
		properChangeSupport.addPropertyChangeListener(l);

		componentConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
		componentConstraints.anchor = GridBagConstraints.CENTER;
		componentConstraints.fill = GridBagConstraints.HORIZONTAL;

		if (superClass == null) {
			caption = new JLabel("検索したいクラスのバイナリ名を入力してください");
		} else {
			caption = new JLabel(superClass.getName() + "または" + superClass.getName() + "のサブクラスのバイナリ名を入力してください");
		}
		componentConstraints.gridx = 0;
		componentConstraints.gridy = 0;
		add(caption, componentConstraints);

		componentConstraints.gridx = 0;
		componentConstraints.gridy = 1;
		add(classNameField, componentConstraints);

		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String binaryName = classNameField.getText();
				if (binaryName.equals("boolean")) {
					setSearchResult(boolean.class);
					return;
				} else if (binaryName.equals("char")) {
					setSearchResult(char.class);
					return;
				} else if (binaryName.equals("byte")) {
					setSearchResult(byte.class);
					return;
				} else if (binaryName.equals("short")) {
					setSearchResult(short.class);
					return;
				} else if (binaryName.equals("int")) {
					setSearchResult(int.class);
					return;
				} else if (binaryName.equals("long")) {
					setSearchResult(long.class);
					return;
				} else if (binaryName.equals("float")) {
					setSearchResult(float.class);
					return;
				} else if (binaryName.equals("double")) {
					setSearchResult(double.class);
					return;
				}
				try {
					Class<?> clazz = Class.forName(binaryName);
					if (clazz == null) {
						throw new AssertionError("not to be passed.");
					}
					if (superClass != null && !superClass.isAssignableFrom(clazz)) {
						JOptionPane.showMessageDialog(null,
								"指定されたクラス (" + binaryName + ") は" + superClass.getName() + "のサブクラスではありません", "クラス検索失敗",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					setSearchResult(clazz);
				} catch (ClassNotFoundException exception) {
					JOptionPane.showMessageDialog(null, "指定されたクラス (" + binaryName + ") が見つかりませんでした", "クラス検索失敗",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		componentConstraints.gridx = 1;
		componentConstraints.gridy = 1;
		add(searchButton, componentConstraints);
	}

	private ClassSearchPanel(PropertyChangeListener l, JTextField jTextField) {
		super(new GridBagLayout());
		caption = new JLabel("");
		properChangeSupport = new PropertyChangeSupport(this);
		properChangeSupport.addPropertyChangeListener(l);

		componentConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
		componentConstraints.anchor = GridBagConstraints.CENTER;
		componentConstraints.fill = GridBagConstraints.HORIZONTAL;

		// if (superClass == null) {
		// caption = new JLabel("検索したいクラスのバイナリ名を入力してください");
		// } else {
		// caption = new JLabel(superClass.getName() + "または" + superClass.getName() +
		// "のサブクラスのバイナリ名を入力してください");
		//// }
		// componentConstraints.gridx = 0;
		// componentConstraints.gridy = 0;
		// add(caption, componentConstraints);

		componentConstraints.gridx = 0;
		componentConstraints.gridy = 1;
		add(classNameField, componentConstraints);

		// searchButton.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		String binaryName = jTextField.getText();
		if (binaryName.equals("boolean")) {
			setSearchResult(boolean.class);
			return;
		} else if (binaryName.equals("char")) {
			setSearchResult(char.class);
			return;
		} else if (binaryName.equals("byte")) {
			setSearchResult(byte.class);
			return;
		} else if (binaryName.equals("short")) {
			setSearchResult(short.class);
			return;
		} else if (binaryName.equals("int")) {
			setSearchResult(int.class);
			return;
		} else if (binaryName.equals("long")) {
			setSearchResult(long.class);
			return;
		} else if (binaryName.equals("float")) {
			setSearchResult(float.class);
			return;
		} else if (binaryName.equals("double")) {
			setSearchResult(double.class);
			return;
		}
		try {
			Class<?> clazz = Class.forName(binaryName);
			if (clazz == null) {
				throw new AssertionError("not to be passed.");
			}
			// if (superClass != null && !superClass.isAssignableFrom(clazz)) {
			// JOptionPane.showMessageDialog(null,
			// "指定されたクラス (" + binaryName + ") は" + superClass.getName() + "のサブクラスではありません",
			// "クラス検索失敗",
			// JOptionPane.ERROR_MESSAGE);
			// return;
			// }
			setSearchResult(clazz);
		} catch (ClassNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "指定されたクラス (" + binaryName + ") が見つかりませんでした", "クラス検索失敗",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// componentConstraints.gridx = 1;
	// componentConstraints.gridy = 1;
	// add(searchButton, componentConstraints);

	public static ClassSearchPanel createClassSearchPanel(PropertyChangeListener l, Class<?> superClass) {
		return new ClassSearchPanel(l, superClass);
	}

	public static ClassSearchPanel createClassSearchPanel(PropertyChangeListener l, JTextField jTextField) {
		return new ClassSearchPanel(l, jTextField);
	}

	private Class<?> getSearchResult() {
		return searchResult;
	}

	private void setSearchResult(Class<?> searchResult) {
		Class<?> oldValue = getSearchResult();
		Class<?> newValue = searchResult;
		this.searchResult = searchResult;
		this.properChangeSupport.firePropertyChange(SEARCH_RESULT_KEY, oldValue, newValue);
	}
}
