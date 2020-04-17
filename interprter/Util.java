import javax.swing.JOptionPane;

public class Util {

	static Class<?> searchByBinaryName(String binaryName, Class<?> superClass) {
		if (binaryName.equals("boolean")) {
			return boolean.class;

		} else if (binaryName.equals("char")) {

			return char.class;
		} else if (binaryName.equals("byte")) {
			return byte.class;

		} else if (binaryName.equals("short")) {
			return short.class;
		} else if (binaryName.equals("int")) {
			return int.class;
		} else if (binaryName.equals("long")) {
			return long.class;
		} else if (binaryName.equals("float")) {
			return float.class;
		} else if (binaryName.equals("double")) {
			return double.class;
		}
		try {
			Class<?> clazz = Class.forName(binaryName);
			if (clazz == null) {
				throw new AssertionError("not to be passed.");
			}
			if (superClass != null && !superClass.isAssignableFrom(clazz)) {
				JOptionPane.showMessageDialog(null, " (" + binaryName + ") is not subclass of" + superClass.getName(),
						"faild to search", JOptionPane.ERROR_MESSAGE);

			}
			return clazz;
		} catch (ClassNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "(" + binaryName + ") cant be found", "faild to search",
					JOptionPane.ERROR_MESSAGE);
		}
		throw new AssertionError("not to be passed.");

	}

}
