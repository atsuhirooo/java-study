package dc2_4;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
//import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class PropDialog extends Dialog {

	int currentFontSize = 10;
	Color currentFontColor = new Color(0, 0, 0);
	Color currentBackGroundColor = new Color(255, 255, 255);
	String currentFontString = "ITALIC";
	DigitalClockFrame digitalClockWindow;
	MenuBar menuBar;
	Menu menu;
	MenuItem menuItem;

	private final JPanel propertyArea = new JPanel(new GridBagLayout());
	private final JLabel fontLabel = new JLabel("font");
	private final JLabel fontSizeLabel = new JLabel("font size");
	private final JLabel fontColorLabel = new JLabel("font color");
	private final JLabel backgroungColorLabel = new JLabel("background color");
	final int MARGIN = 5;

	// private final Choice fontChoice = new Choice();
	// private final Choice fontSizeChoice = new Choice();
	// private final Choice fontColorChoice = new Choice();
	// private final Choice backgroungColorChoice = new Choice();

	private final JComboBox<String> fontCombo = new JComboBox<>();
	private final JComboBox<String> fontSizeCombo = new JComboBox<>();
	private JComboBox<Color> fontColorCombo = new JComboBox<>();
	private JComboBox<Color> backgroundColorCombo = new JComboBox<>();

	private final JPanel okCancelArea = new JPanel();
	private final JButton okButton = new JButton("OK");
	private final JButton cancelButton = new JButton("Cancel");

	Map<String, Integer> sizeMap = new HashMap<String, Integer>();
	List<String> fontList = new ArrayList<String>();
	Map<String, Color> colormap = new HashMap<String, Color>();
	Map<String, Color> colormap2 = new HashMap<String, Color>();

	{

		for (int i = 0; i < 10; i++) {
			int fontSize = 5 + 5 * i;
			sizeMap.put(Integer.toString(fontSize), fontSize);
			fontSizeCombo.addItem(Integer.toString(fontSize));
			// fontSizeChoice.add(Integer.toString(fontSize));

		}
		// add(menu1);

		List<String> fontlist = new ArrayList<String>();
		fontlist.add("DIALOG");
		fontlist.add("SANS_SERIF");
		fontlist.add("SERIF");

		for (String s : fontlist) {
			fontCombo.addItem(s);
			// fontChoice.add(s);

		}

		Menu menu3 = new Menu("time color");

		colormap.put("RED", Color.RED);
		colormap.put("YELLOW", Color.YELLOW);
		colormap.put("BLUE", Color.BLUE);
		for (Map.Entry<String, Color> e : colormap.entrySet()) {
			// MenuItem mi = new MenuItem(e.getKey());
			// mi.addActionListener(new ActionListener() {
			// @Override
			// public void actionPerformed(ActionEvent actionEvent) {
			// currentFontColor = e.getValue();
			// // digitalClockWindow.setSize(currentFontSize * 10 + 10, currentFontSize +
			// 10);
			// }
			// });

			// menu3.add(mi);

			// fontColorChoice.add(e.getKey());
			fontColorCombo.addItem(e.getValue());
		}

		// menuBar.add(menu3);

		colormap2.put("RED", Color.RED);
		colormap2.put("YELLOW", Color.YELLOW);
		colormap2.put("BLUE", Color.BLUE);
		for (Map.Entry<String, Color> e : colormap2.entrySet()) {
			// MenuItem mi = new MenuItem(e.getKey());
			// mi.addActionListener(new ActionListener() {
			// @Override
			// public void actionPerformed(ActionEvent actionEvent) {
			// currentBackGroundColor = e.getValue();
			// // digitalClockWindow.setSize(currentFontSize * 10 + 10, currentFontSize +
			// 10);
			// }
			// });

			// menu4.add(mi);
			// backgroungColorChoice.add(e.getKey());
			backgroundColorCombo.addItem(e.getValue());
		}
	}

	PropDialog(DigitalClockFrame digitalClockWindow_) {
		super(digitalClockWindow_);
		digitalClockWindow = digitalClockWindow_;

		// for (int i = 0; i < 10; i++) {
		// int fontSize = 5 + 5 * i;
		// sizeMap.put(Integer.toString(fontSize), fontSize);
		// fontSizeCombo.addItem(Integer.toString(fontSize));
		// // fontSizeChoice.add(Integer.toString(fontSize));
		//
		// }
		// // add(menu1);
		//
		// List<String> fontlist = new ArrayList<String>();
		// fontlist.add("DIALOG");
		// fontlist.add("SANS_SERIF");
		// fontlist.add("SERIF");
		//
		// for (String s : fontlist) {
		// fontCombo.addItem(s);
		// // fontChoice.add(s);
		//
		// }
		//
		// Menu menu3 = new Menu("time color");
		//
		// colormap.put("RED", Color.RED);
		// colormap.put("YELLOW", Color.YELLOW);
		// colormap.put("BLUE", Color.BLUE);
		// for (Map.Entry<String, Color> e : colormap.entrySet()) {
		// // MenuItem mi = new MenuItem(e.getKey());
		// // mi.addActionListener(new ActionListener() {
		// // @Override
		// // public void actionPerformed(ActionEvent actionEvent) {
		// // currentFontColor = e.getValue();
		// // // digitalClockWindow.setSize(currentFontSize * 10 + 10, currentFontSize +
		// // 10);
		// // }
		// // });
		//
		// // menu3.add(mi);
		//
		// // fontColorChoice.add(e.getKey());
		// fontColorCombo.addItem(e.getValue());
		// }
		//
		// // menuBar.add(menu3);
		//
		// colormap2.put("RED", Color.RED);
		// colormap2.put("YELLOW", Color.YELLOW);
		// colormap2.put("BLUE", Color.BLUE);
		// for (Map.Entry<String, Color> e : colormap2.entrySet()) {
		// // MenuItem mi = new MenuItem(e.getKey());
		// // mi.addActionListener(new ActionListener() {
		// // @Override
		// // public void actionPerformed(ActionEvent actionEvent) {
		// // currentBackGroundColor = e.getValue();
		// // // digitalClockWindow.setSize(currentFontSize * 10 + 10, currentFontSize +
		// // 10);
		// // }
		// // });
		//
		// // menu4.add(mi);
		// // backgroungColorChoice.add(e.getKey());
		// backgroundColorCombo.addItem(e.getValue());
		// }

		fontColorCombo.setEditable(false);
		backgroundColorCombo.setEditable(false);

		ColorTipLabel label = new ColorTipLabel();
		fontColorCombo.setRenderer(label);
		backgroundColorCombo.setRenderer(label);

		// menuBar.add(menu4);
		menuBar = new MenuBar();
		menu = new Menu("menu");
		menuItem = new MenuItem("setting");

		// menuItem.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// PropDialog.this.setLocation(getLocation());
		// PropDialog.this.setVisible(true);
		//
		//
		// }
		// });
		// menu.add(menuItem);
		// menuBar.add(menu);
		//
		// digitalClockWindow.setMenuBar(menuBar);
		// digitalClockWindow.setVisible(true);

		// setResizable(false);
		// setModal(true);
		// setTitle("property");
		// // setSize(WIDTH, HEIGHT);
		// // setFont(new Font(null, Font.PLAIN, 10));
		// propertyArea.setFont(getFont());
		// okCancelArea.setFont(getFont());

		// propertyArea.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		// propertyArea.setLayout(new GridBagLayout());
		GridBagConstraints componetConstraints = new GridBagConstraints();
		componetConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);

		componetConstraints.gridx = 0;
		componetConstraints.gridy = 0;
		componetConstraints.anchor = GridBagConstraints.EAST;
		componetConstraints.fill = GridBagConstraints.NONE;
		propertyArea.add(new JLabel("font"), componetConstraints);
		componetConstraints.gridx = 1;
		componetConstraints.gridy = 0;
		componetConstraints.anchor = GridBagConstraints.WEST;
		componetConstraints.fill = GridBagConstraints.HORIZONTAL;
		propertyArea.add(fontCombo, componetConstraints);

		componetConstraints.gridx = 0;
		componetConstraints.gridy = 1;
		componetConstraints.anchor = GridBagConstraints.EAST;
		componetConstraints.fill = GridBagConstraints.NONE;
		propertyArea.add(fontSizeLabel, componetConstraints);
		componetConstraints.gridx = 1;
		componetConstraints.gridy = 1;
		componetConstraints.anchor = GridBagConstraints.WEST;
		componetConstraints.fill = GridBagConstraints.HORIZONTAL;
		propertyArea.add(fontSizeCombo, componetConstraints);

		componetConstraints.gridx = 0;
		componetConstraints.gridy = 2;
		componetConstraints.anchor = GridBagConstraints.EAST;
		componetConstraints.fill = GridBagConstraints.NONE;
		propertyArea.add(fontColorLabel, componetConstraints);
		componetConstraints.gridx = 1;
		componetConstraints.gridy = 2;
		componetConstraints.anchor = GridBagConstraints.WEST;
		componetConstraints.fill = GridBagConstraints.HORIZONTAL;
		propertyArea.add(fontColorCombo, componetConstraints);

		componetConstraints.gridx = 0;
		componetConstraints.gridy = 3;
		componetConstraints.anchor = GridBagConstraints.EAST;
		componetConstraints.fill = GridBagConstraints.NONE;
		propertyArea.add(new JLabel("background color"), componetConstraints);
		componetConstraints.gridx = 1;
		componetConstraints.gridy = 3;
		componetConstraints.anchor = GridBagConstraints.WEST;
		componetConstraints.fill = GridBagConstraints.HORIZONTAL;
		propertyArea.add(backgroundColorCombo, componetConstraints);

		add(propertyArea, "Center");

		setVisible(true);

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				okSeleceted();
				dispose();
			}
		});
		okButton.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// Do nothing
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// Do nothing
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					okSeleceted();
					dispose();
				}
			}
		});
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					dispose();
				}
			}
		});

		okCancelArea.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		okCancelArea.setLayout(new FlowLayout(FlowLayout.RIGHT));
		okCancelArea.add(okButton);
		okCancelArea.add(cancelButton);

		// okCancelArea.setVisible(true);

		add(okCancelArea, "South");

		setSize(300, 300);

		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PropDialog.this.setLocation(getLocation());
				PropDialog.this.setVisible(true);
				// PropDialog pDialog = new PropDialog(digitalClockWindow);
				// currentFontSize = sizeMap.get(fontSizeCombo.getSelectedItem());
				// currentFontString = (String) fontCombo.getSelectedItem();
				// currentFontColor = (Color) fontColorCombo.getSelectedItem();
				// currentBackGroundColor = (Color) backgroundColorCombo.getSelectedItem();
				// pDialog.fontColorCombo.setSelectedItem((Color)
				// fontColorCombo.getSelectedItem());
				// pDialog.backgroundColorCombo.setSelectedItem((Color)
				// backgroundColorCombo.getSelectedItem());

				// digitalClockWindow.myPropDialog = pDialog;
				// pDialog.setVisible(true);

				// digitalClockWindow.update(getGraphics());

			}
		});
		menu.add(menuItem);
		menuBar.add(menu);

		digitalClockWindow.setMenuBar(menuBar);

		digitalClockWindow.setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	private void okSeleceted() {

		currentFontSize = sizeMap.get(fontSizeCombo.getSelectedItem());
		currentFontString = (String) fontCombo.getSelectedItem();
		currentFontColor = (Color) fontColorCombo.getSelectedItem();
		currentBackGroundColor = (Color) backgroundColorCombo.getSelectedItem();

	}

	public static final Map<String, Color> colorSet = new HashMap<>();

	static {

		colorSet.put("BLUE", Color.BLUE);

		colorSet.put("RED", Color.RED);

		colorSet.put("YELLOW", Color.YELLOW);
	}

	public static final Map<Color, String> rColorSet = new HashMap<>();

	static {

		rColorSet.put(Color.BLUE, "BLUE");

		rColorSet.put(Color.RED, "RED");

		rColorSet.put(Color.YELLOW, "YELLOW");
	}

	public static final class ColorTipLabel extends JLabel implements ListCellRenderer<Color> {

		private static class ColorTip implements Icon {

			private static final int ICON_SIZE = 24;
			private final Color color;

			ColorTip(Color color) {
				this.color = color;
			}

			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {
				g.setColor(color);
				g.fillRect(x, y, getIconWidth(), getIconHeight());
			}

			@Override
			public int getIconWidth() {
				return ICON_SIZE;
			}

			@Override
			public int getIconHeight() {
				return ICON_SIZE;
			}

		}

		private final Icon BLUE_ICON = new ColorTip(Color.BLUE);

		private final Icon RED_ICON = new ColorTip(Color.RED);

		private final Icon YELLOW_ICON = new ColorTip(Color.YELLOW);

		@Override
		public Component getListCellRendererComponent(JList<? extends Color> list, Color value, int index,
				boolean isSelected, boolean cellHasFocus) {

			if (value.equals(Color.YELLOW)) {
				setIcon(YELLOW_ICON);

			} else if (value.equals(Color.BLUE)) {
				setIcon(BLUE_ICON);
			} else if (value.equals(Color.RED)) {
				setIcon(RED_ICON);
			}

			setText(rColorSet.get(value));

			return this;
		}

	}

}
