package dc2_2;

//import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dialog;
import java.awt.FlowLayout;
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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPropDialog extends Dialog {

	int currentFontSize = 10;
	Color currentFontColor = new Color(0, 0, 0);
	Color currentBackGroundColor = new Color(255, 255, 255);
	String currentFontString = "ITALIC";
	DigitalClockFrame digitalClockWindow;
	MenuBar menuBar;
	Menu menu;
	MenuItem menuItem;

	private final JPanel propertyArea = new JPanel();
	private final JLabel fontLabel = new JLabel("font");
	private final JLabel fontSizeLabel = new JLabel("font size");
	private final JLabel fontColorLabel = new JLabel("font color");
	private final JLabel backgroungColorLabel = new JLabel("background color");
	final int MARGIN = 5;

	private final Choice fontChoice = new Choice();
	private final Choice fontSizeChoice = new Choice();
	private final Choice fontColorChoice = new Choice();
	private final Choice backgroungColorChoice = new Choice();

	private final JPanel okCancelArea = new JPanel();
	private final JButton okButton = new JButton("OK");
	private final JButton cancelButton = new JButton("Cancel");

	Map<String, Integer> sizeMap = new HashMap<String, Integer>();
	List<String> fontList = new ArrayList<String>();
	Map<String, Color> colormap = new HashMap<String, Color>();
	Map<String, Color> colormap2 = new HashMap<String, Color>();

	MyPropDialog(DigitalClockFrame digitalClockWindow_) {
		super(digitalClockWindow_);
		digitalClockWindow = digitalClockWindow_;

		for (int i = 0; i < 10; i++) {
			int fontSize = 5 + 5 * i;
			sizeMap.put(Integer.toString(fontSize), fontSize);
			fontSizeChoice.add(Integer.toString(fontSize));

		}
		// add(menu1);

		List<String> fontlist = new ArrayList<String>();
		fontlist.add("DIALOG");
		fontlist.add("SANS_SERIF");
		fontlist.add("SERIF");

		for (String s : fontlist) {

			fontChoice.add(s);

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

			fontColorChoice.add(e.getKey());
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
			backgroungColorChoice.add(e.getKey());

		}

		// menuBar.add(menu4);
		menuBar = new MenuBar();
		menu = new Menu("menu");
		menuItem = new MenuItem("setting");

		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MyPropDialog.this.setLocation(getLocation());
				MyPropDialog.this.setVisible(true);
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);

		digitalClockWindow.setMenuBar(menuBar);
		digitalClockWindow.setVisible(true);

		propertyArea.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		propertyArea.setLayout(new GridBagLayout());
		GridBagConstraints componetConstraints = new GridBagConstraints();
		componetConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);

		componetConstraints.gridx = 0;
		componetConstraints.gridy = 0;
		componetConstraints.anchor = GridBagConstraints.EAST;
		componetConstraints.fill = GridBagConstraints.NONE;
		propertyArea.add(fontLabel, componetConstraints);
		componetConstraints.gridx = 1;
		componetConstraints.gridy = 0;
		componetConstraints.anchor = GridBagConstraints.WEST;
		componetConstraints.fill = GridBagConstraints.HORIZONTAL;
		propertyArea.add(fontChoice, componetConstraints);

		componetConstraints.gridx = 0;
		componetConstraints.gridy = 1;
		componetConstraints.anchor = GridBagConstraints.EAST;
		componetConstraints.fill = GridBagConstraints.NONE;
		propertyArea.add(fontSizeLabel, componetConstraints);
		componetConstraints.gridx = 1;
		componetConstraints.gridy = 1;
		componetConstraints.anchor = GridBagConstraints.WEST;
		componetConstraints.fill = GridBagConstraints.HORIZONTAL;
		propertyArea.add(fontSizeChoice, componetConstraints);

		componetConstraints.gridx = 0;
		componetConstraints.gridy = 2;
		componetConstraints.anchor = GridBagConstraints.EAST;
		componetConstraints.fill = GridBagConstraints.NONE;
		propertyArea.add(fontColorLabel, componetConstraints);
		componetConstraints.gridx = 1;
		componetConstraints.gridy = 2;
		componetConstraints.anchor = GridBagConstraints.WEST;
		componetConstraints.fill = GridBagConstraints.HORIZONTAL;
		propertyArea.add(fontColorChoice, componetConstraints);

		componetConstraints.gridx = 0;
		componetConstraints.gridy = 3;
		componetConstraints.anchor = GridBagConstraints.EAST;
		componetConstraints.fill = GridBagConstraints.NONE;
		propertyArea.add(backgroungColorLabel, componetConstraints);
		componetConstraints.gridx = 1;
		componetConstraints.gridy = 3;
		componetConstraints.anchor = GridBagConstraints.WEST;
		componetConstraints.fill = GridBagConstraints.HORIZONTAL;
		propertyArea.add(backgroungColorChoice, componetConstraints);

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

		add(propertyArea, "Center");
		add(okCancelArea, "South");

		setSize(300, 300);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	private void okSeleceted() {

		currentFontSize = sizeMap.get(fontSizeChoice.getSelectedItem());
		currentFontString = fontChoice.getSelectedItem();
		currentFontColor = colormap.get(fontColorChoice.getSelectedItem());
		currentBackGroundColor = colormap2.get(backgroungColorChoice.getSelectedItem());

	}

}
