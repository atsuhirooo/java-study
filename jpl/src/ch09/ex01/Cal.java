package ch09.ex01;

public class Cal {
	public static void main(String[] args) {
		System.out.println(Double.POSITIVE_INFINITY + Double.POSITIVE_INFINITY);
		System.out.println(Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY);
		System.out.println(Double.POSITIVE_INFINITY * Double.POSITIVE_INFINITY);
		System.out.println(Double.POSITIVE_INFINITY / Double.POSITIVE_INFINITY);

		System.out.println(Double.NEGATIVE_INFINITY + Double.POSITIVE_INFINITY);
		System.out.println(Double.NEGATIVE_INFINITY - Double.POSITIVE_INFINITY);
		System.out.println(Double.NEGATIVE_INFINITY * Double.POSITIVE_INFINITY);
		System.out.println(Double.NEGATIVE_INFINITY / Double.POSITIVE_INFINITY);

	}
}
