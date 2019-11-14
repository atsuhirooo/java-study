package ch10.ex03;

public enum DayOfWeek {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRYDAY, SATURDAY;

	public static boolean isWorkDayIfElse(DayOfWeek dow) {
		if (dow == DayOfWeek.MONDAY) {

			return true;
		} else if (dow == DayOfWeek.TUESDAY) {
			return true;
		} else if (dow == DayOfWeek.WEDNESDAY) {
			return true;
		} else if (dow == DayOfWeek.THURSDAY) {
			return true;
		} else if (dow == DayOfWeek.FRYDAY) {
			return true;
		} else if (dow == DayOfWeek.SATURDAY) {
			return false;
		} else if (dow == DayOfWeek.SUNDAY) {
			return false;
		} else {
			new AssertionError("");
			return true;
		}

	}

	public static boolean isWorkDaySW(DayOfWeek dow) {
		switch (dow) {
		case MONDAY:
			return true;
		case TUESDAY:
			return true;
		case WEDNESDAY:
			return true;
		case THURSDAY:
			return true;
		case FRYDAY:
			return true;
		case SATURDAY:
			return false;
		case SUNDAY:
			return false;
		default:
			new AssertionError("");
			return false;
		}

	}

}
