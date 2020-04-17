import javax.swing.SwingUtilities;

public final class Interpret {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable () {

			@Override
			public void run() {
				MainFrame  mainFrame = new MainFrame();
				System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooo");
				mainFrame.setLocationRelativeTo(null);
				mainFrame.setVisible(true);
			}
			
		});
	}

}
