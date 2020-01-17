package dc1_2;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;

public class DigitalClockFrame extends Frame {
	private MyPropDialog myPropDialog;
	/// public int fontSize = 10;
	public String fontType = "Monospaced";

	int xclicked;
	int yclicked;

	Font font = new Font("ITALIC", 3, 2);
	// int WindowWidth = 100;
	// int WindowHeigth = 100;

	public DigitalClockFrame(Frame owner) {
		// super(new Frame());

		myPropDialog = new MyPropDialog(this);

		setSize(myPropDialog.currentFontSize * 10 + 50, myPropDialog.currentFontSize * 10 + 50);

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

				System.exit(0);
			}
		});

	}

	Image buffer;

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics graphics) {
		LocalTime localTime = LocalTime.now();
		buffer = createImage(this.getWidth(), this.getHeight());
		Graphics bufferGraphics = buffer.getGraphics();

		bufferGraphics.setColor(myPropDialog.currentBackGroundColor);
		bufferGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());

		bufferGraphics.setColor(myPropDialog.currentFontColor);
		font = new Font(myPropDialog.currentFontString, 3, myPropDialog.currentFontSize);
		setFont(font);
		bufferGraphics.drawString(
				String.format("%02d:%02d:%02d", localTime.getHour(), localTime.getMinute(), localTime.getSecond()), 0,
				myPropDialog.currentFontSize);
		graphics.drawImage(buffer, 0, 50, this);
		bufferGraphics.dispose();
	}

	public static void main(String[] args) {

		DigitalClockFrame dcw = new DigitalClockFrame(new Frame());
		int cnt = 0;
		while (true) {
			if (cnt % 1000 == 0)
				dcw.repaint();

			cnt++;
		}
	}
}
