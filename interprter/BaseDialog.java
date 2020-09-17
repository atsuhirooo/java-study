import javax.swing.JTextField;

abstract class BaseDialog extends InstanceHoldingDialog {


	private static final long serialVersionUID = -2121890427136178457L;

	private final ClassSearchPanel classSeachPanel;

	public BaseDialog(Class<?> superClass) {
		classSeachPanel = ClassSearchPanel.createClassSearchPanel(this, superClass);
	}

	public BaseDialog(JTextField jTextField) {
		classSeachPanel = ClassSearchPanel.createClassSearchPanel(this, jTextField);
	}

	public final ClassSearchPanel getClassSeachPanel() {
		return classSeachPanel;
	}
}
