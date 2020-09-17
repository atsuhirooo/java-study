
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public final class MainFrame extends JFrame {

	private static final long serialVersionUID = 776059298091831885L;
	private static final String TITLE = "Interpret";
	private static final int WIDTH = 400;
	private static final int HEIGHT = 200;
	private static final int MARGIN = 5;

	private final JPanel buttonArea = new JPanel(new GridBagLayout());
	private final JButton instanceCreationButton = new JButton("インスタンスを生成する");
	private final JButton manipulationButton = new JButton("操作する");

	public static JList createdInstanceList = new JList();
	public static DefaultListModel model = new DefaultListModel();

	// JTextField className = new JTextField("", 20);
	JCheckBox arraycheck = new JCheckBox("Array check");
	SpinnerNumberModel numModel = new SpinnerNumberModel();
	JSpinner spinner = new JSpinner(numModel);

	public MainFrame() {
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		instanceCreationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (arraycheck.isSelected()) {
					InstanceHoldingDialog arrayDialog = new ArrayCreationDialog(null);
					arrayDialog.setLocationRelativeTo(null);
					arrayDialog.setVisible(true);

				} else {

					InstanceHoldingDialog instanceDialog = new InstanceCreationDialog(null);
					instanceDialog.setLocationRelativeTo(null);
					instanceDialog.setVisible(true);
				}
			}
		});

		// arrayCreationButton.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// InstanceHoldingDialog arrayDialog = new ArrayCreationDialog(null);
		// arrayDialog.setLocationRelativeTo(null);
		// arrayDialog.setVisible(true);
		// }
		// });

		// GridBagConstraints componetConstraints = new GridBagConstraints();
		// componetConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
		// componetConstraints.gridx = 0;
		// componetConstraints.anchor = GridBagConstraints.CENTER;
		// componetConstraints.fill = GridBagConstraints.HORIZONTAL;
		//
		// componetConstraints.gridy = 0;
		// buttonArea.add(instanceCreationButton, componetConstraints);
		//
		// componetConstraints.gridy = 1;
		// buttonArea.add(arrayCreationButton, componetConstraints);
		//
		// componetConstraints.gridy = 2;
		// buttonArea.add(createdInstanceList, componetConstraints);
		//
		// add(buttonArea, "Center");

		GridBagConstraints componetConstraints = new GridBagConstraints();
		componetConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
		componetConstraints.gridx = 0;
		componetConstraints.anchor = GridBagConstraints.CENTER;
		componetConstraints.fill = GridBagConstraints.HORIZONTAL;

		componetConstraints.gridy = 0;
		if (arraycheck.isSelected()) {
			System.out.println("selected");
		}
		buttonArea.add(instanceCreationButton, componetConstraints);

		componetConstraints.gridy = 1;
		// arraycheck.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent actionEvent) {
		// if(arraycheck.isSelected()){}
		//
		//
		// }
		// });

		buttonArea.add(arraycheck, componetConstraints);
		// buttonArea.add(arrayCreationButton, componetConstraints);
		// componetConstraints.gridx = 1;
		// componetConstraints.gridy = 1;
		// buttonArea.add(spinner, componetConstraints);
		// componetConstraints.gridx = 0;
		// componetConstraints.gridy = 3;
		// buttonArea.add(new JLabel("search class"), componetConstraints);
		// componetConstraints.gridx = 1;
		// componetConstraints.gridy = 3;
		// buttonArea.add(className, componetConstraints);
		componetConstraints.gridx = 0;
		componetConstraints.gridy = 4;
		buttonArea.add(new JLabel("Created Objects"), componetConstraints);

		// model.addElement(new BaseDialog(){
		// @Override
		// public Object getTargetInstance() {
		// return null;
		// }
		// //@Override
		// // public String toString(){
		//
		//
		// //}
		//
		// });
		// createdInstanceList = new JList(model);
		componetConstraints.gridy = 5;
		buttonArea.add(createdInstanceList, componetConstraints);

		componetConstraints.gridy = 6;
		buttonArea.add(manipulationButton, componetConstraints);
		add(buttonArea, "Center");

	}
}
