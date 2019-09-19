package ch01.ex15;

interface LookupExt extends Lookup {
	Object add(String name, Object value);

	Object remove(String name);
}
