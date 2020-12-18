
package ch05.ex10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class TimeCalculator {

	public static void main(String[] args) {
		int hour = Integer.parseInt(args[0]);
		int minitus = Integer.parseInt(args[1]);
		String timezone = args.length < 3 ? "America/New_York" : args[2];

		System.out
				.println(calculate(LocalDateTime.now(), Duration.ofMinutes(60 * hour + minitus), ZoneId.of(timezone)));

	}

	public static ZonedDateTime calculate(LocalDateTime start, Duration duration, ZoneId zoneId) {

		LocalDateTime result = start.plusMinutes(duration.toMinutes());
		return result.atZone(zoneId);
	}
}
