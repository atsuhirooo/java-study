package ch17.ex01;

public class MemProfiler {

	private static final int NUM = 10000000;

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println("起動直後: " + rt.freeMemory());

		String[] strArray = new String[NUM];
		for (int i = 0; i < NUM; i++) {
			strArray[i] = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		}
		System.out.println("オブジェクト作成後: " + rt.freeMemory());

		for (int i = 0; i < NUM; i++) {
			strArray[i] = null;
		}
		System.gc();
		System.out.println("gc呼び出し後: " + rt.freeMemory());
	}
}
