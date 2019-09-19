package ch01.ex04;

class TableOfSquare {

	public static void main(String[] args) {
		int count = 1;

		while (count * count < 50) {

			System.out.println("Number:" + count + " " + count * count);
			count = count + 1;
		}
	}
}
