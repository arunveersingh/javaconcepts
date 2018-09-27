package learningjava8.datetimeapi;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class TestDateManipulation {

	public static void main(String[] args) {

		LocalDate date1 = LocalDate.of(2018, Month.SEPTEMBER, 1);
		LocalDate date2 = date1.withYear(2019);

		LocalDate date3 = date2.plusDays(30);
		LocalDate date4 = date2.plusDays(31);

		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);
		System.out.println(date4);

		// -----------------------------------------------

		LocalDate date = date1.with(temporal -> {
			DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
			int dayToAdd = 1;
			if (dow == DayOfWeek.FRIDAY)
				dayToAdd = 3;
			else if (dow == DayOfWeek.SATURDAY)
				dayToAdd = 2;
			return temporal.plus(dayToAdd, ChronoUnit.DAYS);
		});

		// -----------------------------------------------

		TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(temporal -> {
			DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
			int dayToAdd = 1;
			if (dow == DayOfWeek.FRIDAY)
				dayToAdd = 3;
			if (dow == DayOfWeek.SATURDAY)
				dayToAdd = 2;
			return temporal.plus(dayToAdd, ChronoUnit.DAYS);
		});

		date = date.with(nextWorkingDay);

		// ---------------------------------------------
		
		ZoneId romeZone = ZoneId.of("Asia/Calcutta");
		System.out.println(romeZone.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH));;
		
		LocalDate date11 = LocalDate.of(2014, Month.MARCH, 18);
		ZonedDateTime zdt1 = date11.atStartOfDay(romeZone);

		LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
		ZonedDateTime zdt2 = dateTime.atZone(romeZone);

		Instant instant = Instant.now();
		ZonedDateTime zdt3 = instant.atZone(romeZone);
		
		// ---------------------------------------------
		
		
		

	}

}
