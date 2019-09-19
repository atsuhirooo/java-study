package ch01.ex16;

public class BadDataSetException extends Exception {
	private String setName;
	private Exception e;

	public BadDataSetException(String setName, Exception e) {
		this.setName = setName;
		this.e = e;
	}

	public String getName() {
		return setName;
	}

	public Exception getException() {
		return e;
	}

}
