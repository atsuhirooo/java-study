package ch14.ex04;

public final class SharedValue {

	private static int value = 0;

	public static void add() {
		synchronized (SharedValue.class) {
			value++;
			System.out.println(Thread.currentThread().getName() + " " + value);
		}
	}

	public static void main(String[] args) {
		SharedValue sv = new SharedValue();
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					sv.add();
				}
			}
		};
		new Thread(r).start();
		new Thread(r).start();
	}

}
