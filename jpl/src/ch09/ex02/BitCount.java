package ch09.ex02;

public class BitCount {

	public static void main(String[] args) {
		System.out.println(count(15));

	}

	static int count(int num) {
		int count = 0;
		while (num != 0) {
			int masked = num & 1;
			if (masked == 1) {
				count++;

			}
			num = num >>> 1;

		}
		return count;
	}
}
