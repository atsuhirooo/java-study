package ch01.ex12;

class ImprovedFibonacci {
	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		String[] PrintStr = new String[MAX_INDEX];

		PrintStr[0] = new String(1 + ": " + hi + "");
		for (int i = 1; i < MAX_INDEX; i++) {

			if (hi % 2 == 0)
				mark = " *";
			else
				mark = "";

			PrintStr[i] = new String(i + 1 + ": " + hi + mark);

			hi = lo + hi;
			lo = hi - lo;
		}

		for (int i = MAX_INDEX - 1; i >= 0; i--) {

			System.out.println(PrintStr[i]);

		}

	}
}
