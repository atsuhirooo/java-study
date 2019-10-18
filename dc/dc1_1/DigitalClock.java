package dc1_1;

import java.awt.Canvas;
import java.awt.Graphics;
import java.time.LocalTime;

import javax.swing.JFrame;

public final class DigitalClock {

	private JFrame jFrame;
	private Canvas canvas;

	public static void main(String[] args) {

		DigitalClock dClock = new DigitalClock();

		int cnt = 0;
		while (true) {
			if (cnt % 1000 == 0)
				dClock.canvas.repaint();

			cnt++;
		}

	}

	private DigitalClock() {
		{
			jFrame = new JFrame("DigitalClock");

			canvas = new Canvas() {

				public void paint(Graphics graphics) {
					LocalTime localTime = LocalTime.now();
					graphics.drawString(String.format("%02d:%02d:%02d", localTime.getHour(), localTime.getMinute(),
							localTime.getSecond()), 10, 10);
				}
			};

			jFrame.setSize(100, 100);

			jFrame.add(canvas);
			jFrame.setVisible(true);

		}
	}

}