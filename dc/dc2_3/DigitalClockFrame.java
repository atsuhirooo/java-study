package dc2_3;

import java.awt.Color;
import java.awt.Font;
//import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.Preferences;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DigitalClockFrame extends JFrame {

	private static final Preferences preferences = Preferences.userNodeForPackage(DigitalClockFrame.class);

	private static final String PREFIX = "aaa";
	private static final String FONT_NAME_KEY = PREFIX + "font_name_key";
	private static final String FONT_SIZE_KEY = PREFIX + "font_size_key";
	private static final String FONT_COLOR_KEY = PREFIX + "font_color_key";
	private static final String BACKGROUND_COLOR_KEY = PREFIX + "background_color_key";
	private static final String X_COORDINATE_KEY = PREFIX + "x_coordinate_key";
	private static final String Y_COORDINATE_KEY = PREFIX + "y_coordinate_key";

	// DEFAULT PROPERTY
	private static final String FONT_NAME = preferences.get(FONT_NAME_KEY, "Arial");
	private static final int FONT_SIZE = Integer.parseInt(preferences.get(FONT_SIZE_KEY, "10"));
	private static final Color FONT_COLOR = PropDialog.colorSet.get(preferences.get(FONT_COLOR_KEY, "BLUE"));
	private static final Color BACKGROUND_COLOR = PropDialog.colorSet.get(preferences.get(FONT_COLOR_KEY, "YELLOW"));
	private static final int X_CORDINATE = Integer.parseInt(preferences.get(X_COORDINATE_KEY, "0"));
	private static final int Y_CORDINATE = Integer.parseInt(preferences.get(Y_COORDINATE_KEY, "0"));

	private PropDialog myPropDialog;
	/// public int fontSize = 10;
	public String fontType = "Monospaced";

	int xclicked;
	int yclicked;

	Font font = new Font("ITALIC", 3, 2);
	// int WindowWidth = 100;
	// int WindowHeigth = 100;

	public DigitalClockFrame(JFrame owner) {
		// super(new Frame());

		setLocation(X_CORDINATE, Y_CORDINATE);

		myPropDialog = new PropDialog(this);

		myPropDialog.currentFontSize = FONT_SIZE;

		myPropDialog.currentFontString = FONT_NAME;
		myPropDialog.currentFontColor = FONT_COLOR;
		myPropDialog.currentBackGroundColor = BACKGROUND_COLOR;
		setSize(myPropDialog.currentFontSize * 10 + 50, myPropDialog.currentFontSize * 10 + 50);

		add(panel);

		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
					// myPropDialog.show(DigitalClockFrame.this, mouseEvent.getX(),
					// mouseEvent.getY());
				}

			}

			@Override
			public void mousePressed(MouseEvent mouseEvent) {
				DigitalClockFrame.this.xclicked = mouseEvent.getX();
				DigitalClockFrame.this.yclicked = mouseEvent.getY();

			}

			@Override
			public void mouseReleased(MouseEvent mouseEvent) {

			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent) {

			}

			@Override
			public void mouseExited(MouseEvent mouseEvent) {

			}
		}

		);

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent mouseEvent) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void mouseDragged(MouseEvent mouseEvent) {
				// TODO 自動生成されたメソッド・スタブ
				// if (mouseEvent.getButton() == MouseEvent.BUTTON1) {

				DigitalClockFrame.this.setLocation(mouseEvent.getXOnScreen() - xclicked,
						mouseEvent.getYOnScreen() - yclicked);
			}

			// }
		});

		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// timer.cancel();

				preferences.put(FONT_NAME_KEY, myPropDialog.currentFontString);
				preferences.put(FONT_SIZE_KEY, String.valueOf(myPropDialog.currentFontSize));
				preferences.put(FONT_COLOR_KEY, PropDialog.rColorSet.get(myPropDialog.currentFontColor));
				preferences.put(BACKGROUND_COLOR_KEY, PropDialog.rColorSet.get(myPropDialog.currentBackGroundColor));
				preferences.put(X_COORDINATE_KEY, String.valueOf(getX()));
				preferences.put(Y_COORDINATE_KEY, String.valueOf(getY()));

				System.exit(0);
			}
		});

	}

	Image buffer;

	public void update(Graphics g) {
		paint(g);
	}

	JPanel panel = new JPanel() {

		public void paintComponent(Graphics graphics) {

			super.paintComponent(graphics);
			LocalTime localTime = LocalTime.now();
			// buffer = createImage(this.getWidth(), this.getHeight());

			graphics.setColor(myPropDialog.currentBackGroundColor);
			graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

			graphics.setColor(myPropDialog.currentFontColor);
			font = new Font(myPropDialog.currentFontString, 3, myPropDialog.currentFontSize);
			setFont(font);
			graphics.drawString(
					String.format("%02d:%02d:%02d", localTime.getHour(), localTime.getMinute(), localTime.getSecond()),
					0, myPropDialog.currentFontSize);
			// graphics.drawImage(buffer, 0, 50, this);

		}

	};

	public static void main(String[] args) {

		DigitalClockFrame dcw = new DigitalClockFrame(new JFrame());
		int cnt = 0;
		// while (true) {
		// if (cnt % 1000 == 0)
		//// dcw.repaint();
		//
		// cnt++;
		// }

		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				dcw.panel.repaint();
			}
		}, new Date(), 1000);

	}
}
