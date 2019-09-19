package ch01.ex03;

class Fibonacci {

	public static void main(String[] args) {
		int lo = 1, hi = 1, count = 1;

		System.out.println("Number:" + count + " " + lo);
		while (hi < 50) {

			count = count + 1;
			System.out.println("Number:" + count + " " + hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
