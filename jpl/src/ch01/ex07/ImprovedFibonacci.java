package ch01.ex07;

class ImprovedFibonacci {
	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		for (int i = 2; i < MAX_INDEX; i++) {
			hi = lo + hi;
			lo = hi - lo;
		}

		for (int i = MAX_INDEX; i > 1; i--) {

			if (hi % 2 == 0)
				mark = " *";
			else
				mark = "";
			System.out.println(i + ": " + hi + mark);

			lo = hi - lo;
			hi = hi - lo;

		}

		System.out.println("1: " + hi);
	}
}
