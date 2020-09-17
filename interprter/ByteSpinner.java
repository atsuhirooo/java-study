
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

final class ByteSpinner extends JSpinner {

	private static final long serialVersionUID = 1369867053796890428L;
	private final SpinnerNumberModel model = new SpinnerNumberModel(0, Byte.MIN_VALUE, Byte.MAX_VALUE, 1);

	public ByteSpinner() {
		setModel(model);
	}

	public byte getByte() {
		Object i = getValue();
		if (!(i instanceof Integer)) {
			throw new AssertionError("not to be passed.");
		}
		int temp = (Integer) i;
		return (byte) temp;
	}
}

final class IntSpinner extends JSpinner {

	private static final long serialVersionUID = 9197382091961633958L;
	private final SpinnerNumberModel model = new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);

	public IntSpinner() {
		setModel(model);
	}

	public int getInt() {
		Object i = getValue();
		if (i instanceof Integer) {
			return (Integer) i;
		}
		throw new AssertionError("not to be passed.");
	}
}

final class ShortSpinner extends JSpinner {

	private static final long serialVersionUID = 8881810745637821332L;
	private final SpinnerNumberModel model = new SpinnerNumberModel(0, Short.MIN_VALUE, Short.MAX_VALUE, 1);

	public ShortSpinner() {
		setModel(model);
	}

	public short getShort() {
		Object i = getValue();
		if (!(i instanceof Integer)) {
			throw new AssertionError("not to be passed.");
		}
		int temp = (Integer) i;
		return (short) temp;
	}
}

class LongSpinner extends JSpinner {

	private static final long serialVersionUID = 7040483528112226952L;
	private final SpinnerNumberModel model = new SpinnerNumberModel(0, Long.MIN_VALUE, Long.MAX_VALUE, 1);

	public LongSpinner() {
		setModel(model);
	}

	public long getLong() {
		Object d = getValue();
		if (!(d instanceof Double)) {
			throw new AssertionError("not to be passed.");
		}
		double temp = (Double) d;
		return (long) temp;
	}
}
