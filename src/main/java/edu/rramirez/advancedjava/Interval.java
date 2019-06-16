package edu.rramirez.advancedjava;
import java.util.Calendar;

/**
 * Interval - it uses to determine the interval between quotes
 *
 * @author Ramon Ramirez
 */
public enum Interval {

	HOURLY(Calendar.HOUR_OF_DAY),
	DAILY(Calendar.DAY_OF_YEAR),
	WEEKLY( Calendar.WEEK_OF_MONTH),
	MONTHLY( Calendar.MONTH);
	
	private int frequency;
	
	Interval( int value ){
		
		frequency = value;
	}
	
	public int getFrequency() {
		
		return frequency;
	}
}