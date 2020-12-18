
package ch05.ex11;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class TimeCalculator {

	public static void main(String[] args) {
		int hour_src = Integer.parseInt(args[0]);
		int minitus_src = Integer.parseInt(args[1]);
		String timezone_src = args[2];

		int hour_dst = Integer.parseInt(args[3]);
		int minitus_dst = Integer.parseInt(args[4]);
		String timezone_dst = args[5];
		System.out.println(calculate(ZonedDateTime.of(2020, 1, 1, hour_dst, minitus_dst, 0, 0, ZoneId.of(timezone_dst)),
				ZonedDateTime.of(2020, 1, 1, hour_dst, minitus_src, 0, 0, ZoneId.of(timezone_src))));

	}

	public static Duration calculate(ZonedDateTime src, ZonedDateTime dst) {

		return Duration.between(dst.toInstant(), src.toInstant());
	}
}