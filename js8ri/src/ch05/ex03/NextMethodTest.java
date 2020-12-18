package ch05.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

public class NextMethodTest {

	public static void main(String[] args) {
		LocalDate friday = LocalDate.of(2020, 12, 18);
		System.out.println(friday.with(next(w -> w.getDayOfWeek().getValue() < 6)));

	}

	public static TemporalAdjuster next(Predicate<LocalDate> f) {

		return w -> {

			LocalDate result = (LocalDate) w;

			do {
				result = result.plusDays(1);
			} while (!f.test((LocalDate) result));
			return result;
		};
	}

}
