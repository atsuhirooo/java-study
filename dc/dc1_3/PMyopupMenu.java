package dc1_3;

import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PMyopupMenu extends PopupMenu {

	int currentFontSize = 10;
	Color currentFontColor = new Color(0, 0, 0);
	Color currentBackGroundColor = new Color(255, 255, 255);
	String currentFontString = "ITALIC";
	DigitalClockWindow digitalClockWindow;

	PMyopupMenu(DigitalClockWindow digitalClockWindow_) {
		digitalClockWindow = digitalClockWindow_;
		Menu menu1 = new Menu("font size");
		for (int i = 0; i < 5; i++) {
			int fontSize = 5 + 5 * i;
			MenuItem mi = new MenuItem(Integer.toString(fontSize));
			mi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					currentFontSize = fontSize;
					digitalClockWindow.setSize(currentFontSize * 10 + 10, currentFontSize + 10);
				}
			});

			menu1.add(mi);

		}
		add(menu1);

		Menu menu2 = new Menu("font");

		List<String> fontlist = new ArrayList<String>();
		fontlist.add("ITALIC");
		fontlist.add("BOLD");
		fontlist.add("MONOSPACED");

		for (String s : fontlist) {

			MenuItem mi = new MenuItem(s);
			mi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					currentFontString = s;
					// digitalClockWindow.setSize(currentFontSize * 10 + 10, currentFontSize + 10);
				}
			});

			menu2.add(mi);

		}

		add(menu2);

		Menu menu3 = new Menu("time color");

		Map<String, Color> colormap = new HashMap<String, Color>();
		colormap.put("RED", Color.RED);
		colormap.put("YELLOW", Color.YELLOW);
		colormap.put("BLUE", Color.BLUE);
		for (Map.Entry<String, Color> e : colormap.entrySet()) {
			MenuItem mi = new MenuItem(e.getKey());
			mi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					currentFontColor = e.getValue();
					// digitalClockWindow.setSize(currentFontSize * 10 + 10, currentFontSize + 10);
				}
			});

			menu3.add(mi);

		}

		add(menu3);

		Menu menu4 = new Menu("back ground color");

		Map<String, Color> colormap2 = new HashMap<String, Color>();
		colormap2.put("RED", Color.RED);
		colormap2.put("YELLOW", Color.YELLOW);
		colormap2.put("BLUE", Color.BLUE);
		for (Map.Entry<String, Color> e : colormap2.entrySet()) {
			MenuItem mi = new MenuItem(e.getKey());
			mi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					currentBackGroundColor = e.getValue();
					// digitalClockWindow.setSize(currentFontSize * 10 + 10, currentFontSize + 10);
				}
			});

			menu4.add(mi);

		}

		add(menu4);

	};

}
