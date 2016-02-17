package pl.nikowis.Date2Age;

import java.util.Calendar;

public class Converter {
	private Calendar birthDate;
	private Calendar now;
	
	public Converter(Calendar cal){
		this.birthDate=cal;
		now = Calendar.getInstance();
	}
	
	public int getYearAge() {
		int yearAge = now.get(Calendar.YEAR)-birthDate.get(Calendar.YEAR);
		return yearAge;
	}
	
	public int getDayAge() {
		
		return 0;
	}
}
