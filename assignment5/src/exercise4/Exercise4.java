package exercise4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;

public class Exercise4 {

	public static void main(String[] args) {
		question5(1994);
		question6(2019, 3);
		question7("2019-12-13");
		question7("2019-11-13");
	}

	private static void question5(int year) {
		System.out.println("Question 5:");
		System.out.println(year);

		for (int monthCounter = 1; monthCounter <= 12; monthCounter++) {
			YearMonth yearMonth = YearMonth.of(year, monthCounter);
			System.out.println(yearMonth.getMonth() + ": " + yearMonth.lengthOfMonth());
		}

		System.out.println();
	}

	private static void question6(int year, int month) {
		System.out.println("Question 6:");
		LocalDate startOfMonth = LocalDate.of(year, month, 1);
		LocalDate mondayCounter = startOfMonth.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

		while (month == mondayCounter.getMonthValue()) {
			System.out.println(mondayCounter.getDayOfWeek() + " " + mondayCounter);
			mondayCounter = mondayCounter.plusWeeks(1);
		}
		System.out.println();
	}

	private static void question7(String date) {
		System.out.println("Question 7:");
		LocalDate dateObject = LocalDate.parse(date);

		System.out.println(dateObject.getDayOfWeek() + " " + dateObject);
		if (dateObject.getDayOfMonth() == 13 && dateObject.getDayOfWeek() == DayOfWeek.FRIDAY) {
			System.out.println("Your provided date is a Friday the 13th.");
		} else {
			System.out.println("Your provided date is not Friday the 13th.");
		}
		System.out.println();
	}

}

