package learningjava8.datetimeapi;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * This class demonstrates date Time API
 * @author arunveer singh
 *
 */
public class TestDateTimeApi {
	
	public static void main(String [] args) {
		
		LocalDate localDate = LocalDate.of(2014, Month.FEBRUARY, 28);
		
		System.out.println(localDate);
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		System.out.println(today.getChronology().getCalendarType());//ISO8601
		System.out.println(today.get(ChronoField.YEAR_OF_ERA));
		
		LocalDate dateX = LocalDate.of(2014, 1, 1); // This is cool - months range from 1-12 and not 0-11
		LocalTime timeX = LocalTime.of(13,45,20);
		
		LocalDate date = LocalDate.parse("2014-03-18");
		LocalTime time = LocalTime.parse("13:45:20");
		
		LocalDateTime dateTime = LocalDateTime.of(dateX, timeX);
		System.out.println(dateTime);
		
		// 2014-03-18T13:45:20
		LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		LocalDateTime dt3 = date.atTime(13, 45, 20);
		LocalDateTime dt4 = date.atTime(time);
		LocalDateTime dt5 = time.atDate(date);

		Instant.now();
		
		long oldTypeDate = new Date().getTime();
		System.out.println("--------------------------------");
		System.out.println(Instant.ofEpochSecond(oldTypeDate));
		System.out.println(Instant.ofEpochSecond(oldTypeDate, 0));
		System.out.println(Instant.ofEpochSecond(oldTypeDate, 1_000_000_000));
		System.out.println(Instant.ofEpochSecond(oldTypeDate, -1_000_000_000));
		System.out.println(Instant.ofEpochSecond(oldTypeDate, 1_999_999_999));
		
		
		
		Duration d1 = Duration.between(time, timeX);
		Duration d3 = Duration.between(dateTime, timeX);
		Duration d2 = Duration.between(Instant.ofEpochSecond(oldTypeDate), Instant.ofEpochSecond(oldTypeDate));
		
		d1.negated();
	}

}
