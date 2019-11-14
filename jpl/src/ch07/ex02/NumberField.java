package ch07.ex02;

public class NumberField {

	static byte b = 0;
	static short s = 0;
	static char c = 0;
	static int i = 0;
	static long l = 0L;

	static float f = 0.0f;
	static double d = 0.0;

	public static void main(String[] args) {

		System.out.println("byte");
		b = 0;
		System.out.println(b);

		System.out.println("short");
		s = 0;
		System.out.println(s);

		System.out.println("long");
		l = 0; // int
		System.out.println(l);

		System.out.println("float");
		f = 0; // int
		System.out.println(f);
		f = 2147483647; // int型最大値
		System.out.println(f);
		f = -2147483648; // int型の最小値
		System.out.println(f);
		f = 0L; // long
		System.out.println(f);
		f = 9223372036854775807L; // long型最大値
		System.out.println(f);
		f = -9223372036854775808L; // long型最小値
		System.out.println(f);

		System.out.println("double");
		d = 0; // int
		System.out.println(d);
		d = 2147483647; // int型最大値
		System.out.println(d);
		d = -2147483648; // int型の最小値
		System.out.println(d);
		d = 0L; // long
		System.out.println(d);
		d = 9223372036854775807L; // long型最大値
		System.out.println(d);
		d = -9223372036854775808L; // long型最小値
		System.out.println(d);
		d = 0.0f; // float
		System.out.println(d);
		d = 3.4028235E38f; // float型最大値
		System.out.println(d);
		d = 1.4E-45f; // float型最小値

	}

}
