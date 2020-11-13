package ch03.ex18;

@FunctionalInterface
public interface UncheckFunctionInterface<T, R> {
	public R apply(T t) throws Exception;
}
