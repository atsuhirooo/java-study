
package ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class DoInOrderAsync {

	public static <T> void doInOrderAcync(Supplier<T> first, BiConsumer<T, Throwable> second,
			Consumer<Throwable> handler) {

		Thread t = new Thread() {
			@Override
			public void run() {
				T result = null;
				Throwable t_ = null;
				try {
					result = first.get();

				} catch (Throwable t) {
					t_ = t;
				} finally {
					second.accept(result, t_);

				}
			}
		};
		t.start();
	}
}
