package ch01.ex07;

public final class SequentialRunner {

	public static void main(String[] args) {
		final Runnable runnable = andThen(() -> System.out.println("first run"),
				() -> System.out.println("second run"));
		runnable.run();
	}

	public static Runnable andThen(Runnable first, Runnable second) {

		return () -> {
			first.run();
			second.run();
		};
	}
}
