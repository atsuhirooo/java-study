package ch10.ex04;

public class Replace {
	public static void main(String[] args) {
		System.out.println(replaceMethod("\n \t \b \r \f \\ \' \""));
		System.out.println(replaceMethod("\\"));

	}

	static String replaceMethod(String str) {
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while (sb.length() < str.length()) {

			char targetChar = str.charAt(i++);
			if (targetChar == '\n') {
				sb.append("\\n");
			} else if (targetChar == '\t') {
				sb.append("\\t");
			} else if (targetChar == '\b') {
				sb.append("\\b");
			} else if (targetChar == '\r') {
				sb.append("\\r");
			} else if (targetChar == '\f') {
				sb.append("\\f");
			} else if (targetChar == '\\') {
				sb.append("\\\\");
			} else if (targetChar == '\'') {
				sb.append("\\'");
			} else if (targetChar == '\"') {
				sb.append("\\\"");
			} else {
				sb.append(targetChar);
			}

		}
		return sb.toString();

	}
}