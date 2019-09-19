package ch01.ex15;

class SimpleLookupExt implements LookupExt {
	private static final int MAX_INDEX = 10;
	private String[] names = new String[MAX_INDEX];
	private Object[] values = new Object[MAX_INDEX];

	public Object find(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null && names[i].equals(name)) {
				System.out.println("find " + name);
				return values[i];
			}
		}
		System.out.println("can't find " + name);
		return null;
	}

	public Object add(String name, Object value) {

		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				names[i] = name;
				values[i] = value;
				System.out.println("add " + name);
				return value;
			}

		}
		System.out.println("can't add" + name);
		return null;

	}

	public Object remove(String name) {

		for (int i = 0; i < names.length; i++) {
			if (names[i] != null && names[i].equals(name)) {
				System.out.println("remove " + name);
				names[i] = null;
				Object value = values[i];
				values[i] = null;
				return value;
			}
		}
		System.out.println("can't remove " + name);
		return null;
	}

	public static void main(String[] args) {
		LookupExt lue = new SimpleLookupExt();
		lue.add("a", new Object());
		lue.add("b", new Object());
		lue.remove("c");
		lue.find("a");
		lue.remove("a");
		lue.find("a");

	}

}
