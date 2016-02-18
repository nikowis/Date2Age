package pl.nikowis.Date2Age;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.junit.Test;

public class ConverterTest {
	Converter converter;
	
	@Test
	public void todayDateGiven2Years() throws IOException{
		converter =  new Converter(new GregorianCalendar(Locale.FRANCE));
		int year = converter.getYearAge();
		assertEquals(0, year);
	}
	
	@Test(expected = IOException.class)
	public void futureDateGiven2Years() throws IOException{
		converter = new Converter(new GregorianCalendar(9999, 10,1));
	}
	
	@Test
	public void lastDayOfYearDateGiven2Years(){
		Calendar curr =new GregorianCalendar();
		Calendar past = new GregorianCalendar(1990, 11,31);
		try {
			converter = new Converter(past);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		int years = converter.getYearAge();
		
		int years2 = curr.get(Calendar.YEAR)-1990;
		if(curr.get(Calendar.DAY_OF_YEAR)<past.get(Calendar.DAY_OF_YEAR))
			years2--;
		assertEquals(years2, years);
	}
	
	@Test
	public void firstDayOfYearDateGiven2Years(){
		try {
			converter = new Converter(new GregorianCalendar(1990, 0,1));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		int years = converter.getYearAge();
		assertEquals(new GregorianCalendar().get(Calendar.YEAR)-1990, years);
	}
	
	@Test
	public void todayDateGiven2Days(){
		try {
			converter =  new Converter(new GregorianCalendar());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		int day = converter.getDayAge();
		assertEquals(0, day);
	}

	@Test(expected = IOException.class)
	public void futureDateGiven2Days() throws IOException{
		converter = new Converter(new GregorianCalendar(9999, 10,1));
	}
	
	@Test
	public void currentMonthsDateGiven2Days(){
		int days;
		Calendar cal1 = new GregorianCalendar();
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		try {
			converter = new Converter(cal1);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		days = converter.getDayAge();
		Calendar cal2 = new GregorianCalendar();
		int days2=cal2.get(Calendar.DAY_OF_MONTH)-cal1.get(Calendar.DAY_OF_MONTH);
		assertEquals(days2, days);
	}
	
	@Test
	public void lastYearsDateGiven2Days(){
		int days;
		Calendar curr = new GregorianCalendar();
		Calendar past = new GregorianCalendar(curr.get(Calendar.YEAR)-1,10,20);

		try {
			converter = new Converter(past);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		days = converter.getDayAge();
		int days2=curr.get(Calendar.DAY_OF_YEAR)+365-past.get(Calendar.DAY_OF_YEAR);
		if((past.get(Calendar.YEAR)%4==0 && past.get(Calendar.YEAR)%100!=0 )|| past.get(Calendar.YEAR)%400==0)
			days2++;
		assertEquals(days2, days);
	}
	
	@Test
	public void leapYearsIncluded2Days(){
		Calendar past = new GregorianCalendar(2010,0,1);
		Calendar curr = new GregorianCalendar();
		try {
			converter = new Converter(past);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		int days = converter.getDayAge();
		int days2= curr.get(Calendar.DAY_OF_YEAR) + (curr.get(Calendar.YEAR)-past.get(Calendar.YEAR))*365-past.get(Calendar.DAY_OF_YEAR);
		assertTrue(days > days2);
	}
	
	@Test
	public void todayDateGiven2Hours(){
		try {
			converter = new Converter(new GregorianCalendar());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		int hours = converter.getHourAge();
		assertEquals(0, hours);
	}
	
	@Test
	public void todayDateGiven2Minutes(){
		try {
			converter = new Converter(new GregorianCalendar());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		int minutes = converter.getMinuteAge();
		assertEquals(0, minutes);
	}
	
	@Test
	public void todayDateGiven2Seconds(){
		try {
			converter = new Converter(new GregorianCalendar());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		int seconds = converter.getSecondAge();
		assertEquals(0,seconds);
	}
	
}
