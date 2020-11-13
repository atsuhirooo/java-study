package ch03.ex01;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DelayedLogger {

	private final Logger logger;

	public DelayedLogger(Logger logger) {
		Objects.requireNonNull(logger, "logger must not be null");
		this.logger = logger;
	}

	public static void info(Logger logger, Supplier<String> message) {
		if (logger.isLoggable(Level.INFO))
			logger.info(message.get());

	}

	public void logIf(Level level, BooleanSupplier condition, Supplier<String> message) {

		if (!logger.isLoggable(level)) {
			return;
		}
		if (condition.getAsBoolean()) {
			logger.log(level, message.get());
		}
	}

	public static void main(String[] args) {
		final Level level = Level.FINEST;

		final Logger logger = Logger.getLogger(DelayedLogger.class.getName());
		logger.setLevel(level);

		// DelayedLogger.info(logger, () -> "aaa" + "bbb");

		final ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(level);
		logger.addHandler(handler);
		logger.setUseParentHandlers(false);

		final DelayedLogger delayedLogger = new DelayedLogger(logger);
		int[] a = new int[11];
		int i = 10;
		delayedLogger.logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10]);
	}
}
