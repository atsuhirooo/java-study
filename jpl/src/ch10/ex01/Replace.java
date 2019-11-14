package ch10.ex01;

public class Replace {
	public static void main(String[] args) {
		System.out.println("\'");
	}

	static String replaceMethod(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char targetChar = str.charAt(i);
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