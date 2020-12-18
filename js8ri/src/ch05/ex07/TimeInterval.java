
package ch05.ex07;

import java.time.LocalDateTime;

public final class TimeInterval {

	private final LocalDateTime start;
	private final LocalDateTime end;

	public TimeInterval(LocalDateTime start, LocalDateTime end) {

		this.start = start;
		this.end = end;
	}

	public boolean isOverlap(TimeInterval timeInterval) {

		if (start.isAfter(timeInterval.end)) {
			return false;
		}

		if (end.isBefore(timeInterval.start)) {
			return false;
		}

		return true;
	}

	public final LocalDateTime getStart() {
		return start;
	}

	public final LocalDateTime getEnd() {
		return end;
	}

	public static void main(String[] args) {

		LocalDateTime start = LocalDateTime.of(2020, 12, 18, 12, 0);
		LocalDateTime end = LocalDateTime.of(2020, 12, 18, 13, 0);

		TimeInterval interval1 = new TimeInterval(start, end);

		start = LocalDateTime.of(2020, 12, 18, 12, 30);
		end = LocalDateTime.of(2020, 12, 18, 13, 30);

		TimeInterval interval2 = new TimeInterval(start, end);

		System.out.println(interval1.isOverlap(interval2));

	}
}
