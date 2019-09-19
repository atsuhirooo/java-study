package ch01.ex10;

class ImprovedFibonacci {
	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		FibonacciNumber[] fibarray = new FibonacciNumber[MAX_INDEX];

		fibarray[0] = new FibonacciNumber(lo, false);

		for (int i = 1; i < MAX_INDEX; i++) {
			fibarray[i] = new FibonacciNumber(hi, hi % 2 == 0);
			hi = lo + hi;
			lo = hi - lo;

		}

		for (int i = MAX_INDEX; i > 0; i--) {

			if (fibarray[i - 1].isEven())
				mark = " *";
			else
				mark = "";
			System.out.println(i + ": " + fibarray[i - 1].getNumber() + mark);

		}
	}
}

class FibonacciNumber {
	private int number;
	private boolean isEven;

	FibonacciNumber(int number, boolean isEven) {
		this.number = number;
		this.isEven = isEven;
	}

	public void setNumber(int n) {
		number = n;
	}

	public int getNumber() {
		return number;
	}

	public boolean isEven() {
		return isEven;
	}
}
