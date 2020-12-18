package ch05.ex02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LeapYearTest{

	public static void main(String[] args) {
		LocalDate programmerday = LocalDate.of(2000, 2, 29).plus(1, ChronoUnit.YEARS);
		System.out.println(programmerday);
		programmerday = LocalDate.of(2000, 2, 29).plus(4, ChronoUnit.YEARS);
		System.out.println(programmerday);

		programmerday = LocalDate.of(2000, 2, 29).plus(1, ChronoUnit.YEARS).plus(1, ChronoUnit.YEARS)
				.plus(1, ChronoUnit.YEARS).plus(1, ChronoUnit.YEARS);
		System.out.println(programmerday);

	}

}
