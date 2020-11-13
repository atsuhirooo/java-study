
package ch03.ex17;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class DoInOrderAsync {

	public static <T> void doInOrderAcync(Supplier<T> first, BiConsumer<T, Throwable> second,
			Consumer<Throwable> handler) {

		Thread t1 = new Thread() {
			@Override
			public void run() {
				T result = null;
				Throwable t_ = null;
				try {
					result = first.get();

				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		t1.start();

		Thread t2 = new Thread() {
			@Override
			public void run() {
				T result = null;

				try {
					result = first.get();

				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		t2.start();
	}
}
