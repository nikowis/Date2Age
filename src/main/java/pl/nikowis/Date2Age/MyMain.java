package pl.nikowis.Date2Age;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;

public class MyMain {
	
	public static int getInput(String what){
		int input=0;
		String in="";
		System.out.println("Input "+what + " : ");
		try {
			in= new BufferedReader(new InputStreamReader(System.in)).readLine();
			input = Integer.parseInt(in);
		} catch (Exception e1) {
			System.out.println("Wrong input or system error...");
			System.exit(0);
		}
		return input;
	}
	
	public static void main(String[] args) {
		int day=0;
		int month=0;
		int year=0;
		Converter converter=null;
		day = getInput("day");
		month = getInput("month")-1;
		year=getInput("year");
		
		try {
			converter = new Converter(new GregorianCalendar(year, month, day));
		} catch (IOException e) {
			System.out.println("Future dates not approved...");
			System.exit(0);
		}
		
		System.out.println("Your age is " + converter.getYearAge());
		System.out.println("Your day age is " + converter.getDayAge());
		System.out.println("Your minute age is " + converter.getMinuteAge());
		System.out.println("Your seconds age is " + converter.getSecondAge());
	}

}
