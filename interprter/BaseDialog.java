import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

abstract class BaseDialog extends JDialog {

	protected List<DataChangeObserver> dataChangeObserverList = new ArrayList<>();

	protected static final int TOP_BOTTOM_MARGIN = 34;
	protected static final int LEFT_RIGHT_MARGIN = 4;

	protected boolean isArray;
	protected int arraySize;
	protected Object targetInstance = null;

	public BaseDialog() {
		setModal(true);
		setResizable(false);
		setLayout(new GridBagLayout());
	}

	public void addObserver(DataChangeObserver dco) {
		dataChangeObserverList.add(dco);

	}

	public void deleteObserver(DataChangeObserver dco) {
		dataChangeObserverList.remove(dco);

	}

	public abstract Object getTargetInstance();

	public void notifyObservers() {
		for (DataChangeObserver dco : dataChangeObserverList) {
			dco.update(this);
		}

	}

}
