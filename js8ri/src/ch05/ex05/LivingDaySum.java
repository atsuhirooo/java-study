package ch05.ex05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class LivingDaySum {

	public static void main(String[] args) {

		final int year = Integer.parseInt(args[0]);
		final int month = Integer.parseInt(args[1]);
		final int day = Integer.parseInt(args[2]);

		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(year, month, day);

		System.out.println(birthday.until(today, ChronoUnit.DAYS));

	}

}
