package ch10.ex03;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class DayofWeektest {
	@Test
	public void testELSEIF() {
		assertThat(DayOfWeek.isWorkDayIfElse(DayOfWeek.MONDAY), is(false));

		assertThat(DayOfWeek.isWorkDayIfElse(DayOfWeek.TUESDAY), is(false));
		assertThat(DayOfWeek.isWorkDayIfElse(DayOfWeek.WEDNESDAY), is(false));
		assertThat(DayOfWeek.isWorkDayIfElse(DayOfWeek.THURSDAY), is(false));
		assertThat(DayOfWeek.isWorkDayIfElse(DayOfWeek.FRYDAY), is(false));

		assertThat(DayOfWeek.isWorkDayIfElse(DayOfWeek.SATURDAY), is(true));
		assertThat(DayOfWeek.isWorkDayIfElse(DayOfWeek.SUNDAY), is(true));
	}

}
