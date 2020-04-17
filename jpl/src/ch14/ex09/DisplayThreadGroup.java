package ch14.ex09;

public class DisplayThreadGroup {

	private static final Runnable runnable = new Runnable() {
		@Override
		public void run() {
			int count = 0;
			for (;;) {
			}

		}
	};

	public static void main(String[] args) throws InterruptedException {

		ThreadGroup tg1 = new ThreadGroup("tg1");
		ThreadGroup tg2 = new ThreadGroup(tg1, "tg2");
		ThreadGroup tg3 = new ThreadGroup(tg2, "tg3");
		ThreadGroup tg4 = new ThreadGroup(tg2, "tg4");

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (;;) {
						display(tg1, 0);
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		}).start();

		for (;;) {
			new Thread(tg1, runnable, "thread 1").start();
			new Thread(tg2, runnable, "thread 2").start();
			new Thread(tg3, runnable, "thread 3").start();
			new Thread(tg4, runnable, "thread 4").start();

			Thread.sleep(5000);
		}
	}

	private static void display(final ThreadGroup threadGroup, int indent) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < indent; i++) {
			sb.append('	');
		}
		System.out.print(sb.toString() + "ThreadGroup name: " + threadGroup.getName());
		Thread[] threads = new Thread[threadGroup.activeCount()];
		int threadsNum = threadGroup.enumerate(threads, false);
		System.out.print(" has {");
		for (int i = 0; i < threadsNum; i++) {
			System.out.print("Thread name: " + threads[i].getName() + ", ");
		}
		System.out.println("}");

		ThreadGroup[] threadGroups = new ThreadGroup[threadGroup.activeGroupCount()];
		int threadGroupNum = threadGroup.enumerate(threadGroups, false);
		for (int i = 0; i < threadGroupNum; i++) {
			display(threadGroups[i], indent + 1);
		}
	}
}
