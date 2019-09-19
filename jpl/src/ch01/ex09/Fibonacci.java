package ch01.ex09;

class Fibonacci {
	private static String TITLE = "Number";
	private static int MAX_VALUE = 50;
	private static int ARRAY_SIZE = 10;

	public static void main(String[] args) {
		int lo = 1, hi = 1, index = 0;

		int[] fibarray = new int[ARRAY_SIZE];

		fibarray[index] = lo;

		while (hi < MAX_VALUE) {
			index = index + 1;
			fibarray[index] = hi;
			hi = lo + hi;
			lo = hi - lo;
		}

		if (fibarray == null || fibarray.length == 0)
			throw new IllegalArgumentException();

		for (int i = 0; i < index; i++) {
			System.out.println(fibarray[i]);
		}
	}
}
