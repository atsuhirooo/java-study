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
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class MainFrame extends JFrame implements DataChangeObserver {

	private static final String TITLE = "Interpret";
	private static final int WIDTH = 400;
	private static final int HEIGHT = 200;
	private static final int MARGIN = 5;

	private final JPanel buttonArea = new JPanel(new GridBagLayout());

	private final JButton instanceCreationButton = new JButton("new Instance");
	private final JButton arrayCreationButton = new JButton("new Array Instance");

	JCheckBox arraycheck = new JCheckBox("Array check");
	SpinnerNumberModel numModel = new SpinnerNumberModel();
	JSpinner spinner = new JSpinner(numModel);

	private DefaultListModel model = new DefaultListModel();

	private JList createdInstanceList = new JList();
	JTextField className = new JTextField("", 20);

	static int count = 0;

	public MainFrame() {
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		//

		instanceCreationButton.setActionCommand("CreateInstanceOnMainFrame");
		instanceCreationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// if("CreateInstanceOnMainFrame".equals(e.getActionCommand())){
				System.out.println("ccccccccccccccccccccccccccccccccccccccccccccccc" + MainFrame.count++);
				Class<?> clazz = Util.searchByBinaryName(className.getText(), null);
				if (clazz != null) {

					BaseDialog instanceDialog = new InstanceDialog(clazz, arraycheck.isSelected(),
							(int) spinner.getValue());
					instanceDialog.addObserver(MainFrame.this);
					// BaseDialog instanceDialog = new BaseDialog(){

					// @Override
					// public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
					//
					//
					// };
					instanceDialog.setLocationRelativeTo(null);
					instanceDialog.setVisible(true);

				}
			}

		});

		GridBagConstraints componetConstraints = new GridBagConstraints();
		componetConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
		componetConstraints.gridx = 0;
		componetConstraints.anchor = GridBagConstraints.CENTER;
		componetConstraints.fill = GridBagConstraints.HORIZONTAL;

		componetConstraints.gridy = 0;
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
		componetConstraints.gridx = 1;
		componetConstraints.gridy = 1;
		buttonArea.add(spinner, componetConstraints);
		componetConstraints.gridx = 0;
		componetConstraints.gridy = 3;
		buttonArea.add(new JLabel("search class"), componetConstraints);
		componetConstraints.gridx = 1;
		componetConstraints.gridy = 3;
		buttonArea.add(className, componetConstraints);
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
		add(buttonArea, "Center");

	}

	@Override
	public void update(BaseDialog bd) {

		// remove(buttonArea);
		model.addElement(bd);
		createdInstanceList.setModel(model);

	}

}
