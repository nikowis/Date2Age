package pl.nikowis.Date2Age;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.Test;

public class ConverterTest {
	Converter converter;
	
	@Test
	public void converterTodayDateGiven2Years(){
		converter =  new Converter(new GregorianCalendar(Locale.FRANCE));
		int year = converter.getYearAge();
		assertEquals(0, year);
	}
	
	@Test
	public void converterFutureDateGiven2Years(){
		converter = new Converter(new GregorianCalendar(9999, 10,14));
		
	}
	
//	@Test
//	public void converterTodayDateGiven2Days(){
//		converter =  new Converter(new Date());
//		int day = converter.getDayAge();
//		assertEquals(0, day);
//	}
}
