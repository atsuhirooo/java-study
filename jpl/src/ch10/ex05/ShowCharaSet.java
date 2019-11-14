package ch10.ex05;

public class ShowCharaSet {

	static String getString(char a, char b) {

		StringBuffer sb = new StringBuffer();
		for (char i = a; i <= b; i++) {
			sb.append(i);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getString('a', 'z'));

	}

}
