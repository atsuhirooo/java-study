package ch01.ex06;

class Fibonacci {
	private static String TITLE = "Number";

	public static void main(String[] args) {
		int lo = 1, hi = 1, count = 1;

		System.out.println(TITLE + count + " " + lo);
		while (hi < 50) {

			count = count + 1;
			System.out.println(TITLE + count + " " + hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
