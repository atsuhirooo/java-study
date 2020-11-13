package ch03.ex18;

import java.util.function.Function;

public class UncheckFunction {

	<T, U> Function<T, U> unchecked(UncheckFunctionInterface<T, U> ufi) {

		return (t) -> {

			try {
				return ufi.apply(t);
			} catch (Exception e) {
				throw new RuntimeException(e);

			} catch (Throwable tr) {

				throw tr;
			}
		};

	}

}
