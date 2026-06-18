package esami2013.appello06.e1;

/**
 * An interface modelling the concept of a specific day of the calendar, e.g. 1/1/2014
 * When implementing it, be sure to implement method equals as well!
 */

public interface Day extends Comparable<Day>{

	/**
	 * Returns a number between 1 and 31, namely: which day is this in its month?
	 */
	int getDay();
	
	/**
	 * Returns the month of this day
	 */
	Month getMonth();

	/**
	 * Returns the year of this day
	 */
	int getYear();
	
	/**
	 * Returns the day following this
	 */
	Day next();
	
	/**
	 * The method adhering to interface Comparable
	 * Recall it yields a negative (<), 0 (=), or a positive (>)
	 */
	int compareTo(Day d);
	
	/**
	 * Recall to override this method from java.lang.Object
	 */
	boolean equals(Object o);
	
}
