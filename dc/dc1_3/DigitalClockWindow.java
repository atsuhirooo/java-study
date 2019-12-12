package dc1_3;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;

public class DigitalClockWindow extends Window {
	private PMyopupMenu myopupMenu;
	/// public int fontSize = 10;
	public String fontType = "Monospaced";

	int xclicked;
	int yclicked;

	// private Canvas canvas;

	Font font = new Font("ITALIC", 3, 2);
	// int WindowWidth = 100;
	// int WindowHeigth = 100;

	public DigitalClockWindow(Frame owner) {
		super(new Frame());

		myopupMenu = new PMyopupMenu(this);
		add(myopupMenu);

		setSize(myopupMenu.currentFontSize * 10 + 10, myopupMenu.currentFontSize + 10);

		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
					myopupMenu.show(DigitalClockWindow.this, mouseEvent.getX(), mouseEvent.getY());
				}

			}

			@Override
			public void mousePressed(MouseEvent mouseEvent) {
				DigitalClockWindow.this.xclicked = mouseEvent.getX();
				DigitalClockWindow.this.yclicked = mouseEvent.getY();

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

				DigitalClockWindow.this.setLocation(mouseEvent.getXOnScreen() - xclicked,
						mouseEvent.getYOnScreen() - yclicked);
			}

			// }
		});

		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// timer.cancel();

				System.exit(0);
			}
		});

	}

	Image buffer;

	public void paint(Graphics graphics) {
		LocalTime localTime = LocalTime.now();
		buffer = createImage(this.getWidth(), this.getHeight());
		Graphics bufferGraphics = buffer.getGraphics();
		// if (bufferGraphics instanceof Graphics2D) {
		// Graphics2D g2d = (Graphics2D) bufferGraphics;
		// g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
		// RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		// }

		bufferGraphics.setColor(myopupMenu.currentBackGroundColor);
		bufferGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());

		bufferGraphics.setColor(myopupMenu.currentFontColor);
		font = new Font(myopupMenu.currentFontString, 3, myopupMenu.currentFontSize);
		setFont(font);
		bufferGraphics.drawString(
				String.format("%02d:%02d:%02d", localTime.getHour(), localTime.getMinute(), localTime.getSecond()), 0,
				myopupMenu.currentFontSize);
		graphics.drawImage(buffer, 0, 0, this);
		bufferGraphics.dispose();
	}

	public static void main(String[] args) {

		DigitalClockWindow dcw = new DigitalClockWindow(new Frame());
		int cnt = 0;
		while (true) {
			if (cnt % 1000 == 0)
				dcw.repaint();

			cnt++;
		}

	}

}
