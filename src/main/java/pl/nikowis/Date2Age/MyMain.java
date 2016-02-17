package pl.nikowis.Date2Age;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;

public class MyMain {
	public static int getInput(String what){
		int input=0;
		String in="";
		System.out.println("Input "+what + " : ");
		try {
			in= new BufferedReader(new InputStreamReader(System.in)).readLine();
			input = Integer.parseInt(in);
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return input;
	}
	public static void main(String[] args) {
		int day=0;
		int month=0;
		int year=0;
		
		day = getInput("day");
		month = getInput("month");
		year=getInput("year");
		
		day = getInput("day");
		//Converter converter = new Converter());

	}

}
