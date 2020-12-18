package ch05.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Friday13 {

	public static void main(String[] args) {
		LocalDate start = LocalDate.of(2001, 1, 1);
		LocalDate end = LocalDate.of(2101, 1, 1);
		long daysum = start.until(end, ChronoUnit.DAYS);

		System.out.println(daysum);

		for (int i = 0; i < daysum; i++) {
			if (start.getDayOfWeek().equals(DayOfWeek.FRIDAY) && start.getDayOfMonth() == 13) {
				System.out.println(start);

			}
			start = start.plusDays(1);

		}

	}

}
