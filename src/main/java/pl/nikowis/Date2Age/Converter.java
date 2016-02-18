package pl.nikowis.Date2Age;

import java.io.IOException;
import java.util.Calendar;

public class Converter {
	private Calendar birthDate;
	private Calendar now;
	
	public Converter(Calendar cal)throws IOException{
		this.birthDate=cal;
		now = Calendar.getInstance();
		if(birthDate.get(Calendar.YEAR) > now.get(Calendar.YEAR))
			throw new IOException();
	}
	
	public int getYearAge() {
		int yearAge = now.get(Calendar.YEAR)-birthDate.get(Calendar.YEAR);
		if(now.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR))
			yearAge--;
		return yearAge;
	}
	
	public int getDayAge() {
		int dayAge=0;
		int curYear = now.get(Calendar.YEAR);
		int birthYear = birthDate.get(Calendar.YEAR);
		if(curYear==birthYear){
			dayAge+= now.get(Calendar.DAY_OF_YEAR)-birthDate.get(Calendar.DAY_OF_YEAR);
			return dayAge;
		}
		dayAge+=now.get(Calendar.DAY_OF_YEAR);
		curYear--;
		while(curYear>birthYear){
			dayAge+=365;
			if((curYear%4==0&&curYear%100!=0) || curYear%400==0)
				dayAge++;
			curYear--;
		}
		dayAge+=365-birthDate.get(Calendar.DAY_OF_YEAR);
		
		return dayAge;
	}
	
	public int getHourAge(){
		int days = this.getDayAge();
		return days*24;
	}
	
	public int getMinuteAge(){
		int minutes = this.getHourAge();
		return minutes*60;
	}
	
	public int getSecondAge(){
		int seconds = this.getMinuteAge();
		return seconds*60;
	}

}
