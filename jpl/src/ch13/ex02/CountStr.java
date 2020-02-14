package ch13.ex02;

class CountStr {
	public static int countStr(String str, String query) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			int matchedCharCount = 0;
			if (str.length() < i + query.length())
				continue;

			for (int j = 0; j < query.length(); j++) {
				if (str.charAt(i + j) == query.charAt(j)) {
					matchedCharCount++;
				} else {
					continue;
				}
			}
			if (matchedCharCount == query.length())
				count++;

		}
		return count;
	}

	public static void main(String[] args) {

		System.out.println(countStr("abcabc", "bc"));
	}
}
