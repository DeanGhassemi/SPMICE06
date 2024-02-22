package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	
	@Test
	void testGetMilliSecondsGood() {
		int milli = Time.getMilliseconds("05:05:05:990");
		assertTrue("The milliseconds were not calculated properly ", milli==990);
		//fail("Not yet implemented");
	}
	@Test
	void testGetMilliSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {Time.getMilliseconds("10:00:00");});
		//fail("Not yet implemented");
	}
	@Test
	void testGetMilliSecondsBoundary() {
		int milli = Time.getMilliseconds("23:59:59:999");
		assertTrue("The milliseconds were not calculated properly ", milli==999);
		//fail("Not yet implemented");
	}
	
	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05:000");
		assertTrue("The seconds were not calculated properly ", seconds==18305);
		//fail("Not yet implemented");
	}
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {Time.getTotalSeconds("10:00");});
		//fail("Not yet implemented");
	}
	@Test
	void testGetTotalSecondsBoundary() {
		int seconds = Time.getTotalSeconds("23:59:59:000");
		assertTrue("The seconds were not calculated properly ", seconds==86399);
		//fail("Not yet implemented");
	}
	
	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("05:05:05:005");
		assertTrue("The seconds were not calculated properly ", seconds==05);
	}
	@Test
	void testGetSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {Time.getSeconds("10:00");});
	}
	@Test
	void testGetSecondsBoundary() {
		int seconds = Time.getSeconds("23:59:59:599");
		assertTrue("The seconds were not calculated properly ", seconds==59);
	}
	
	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("05:05:05:005");
		assertTrue("The minutes were not calculated properly ", minutes==05);	}
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {Time.getTotalMinutes("10:6");});
	}
	@Test
	void testGetTotalMinutesBoundary() {
		int minutes = Time.getTotalMinutes("05:59:05:000");
		assertTrue("The minutes were not calculated properly ", minutes==59);	}
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00:000", "05:15:15:000",
	"05:59:50:009" })
	void testGetTotalHoursGood(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly",
		hours ==5);
	}
	@Test
	void testGetTotalHoursBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {Time.getTotalHours("2");});
	}
	@Test
	void testGetTotalHoursBoundary() {
		int hours = Time.getTotalHours("23:59:59:000");
		assertTrue("The hours were not calculated properly ", hours==23);
		//fail("Not yet implemented");
	}
}
