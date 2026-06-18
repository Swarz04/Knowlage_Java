package lab.e1sol;

public interface Time extends Comparable<Time>{

	// returns an element in between 0 and 23
	public int getHour();
	
	// returns an element in between 0 and 59
	public int getMinute();
	
	// takes a positivi/negative number of minutes
	// returns a new Time object representing the shifted time
	// gives Exception if it escapes current day
	public Time shiftMinutes(int nMinute) throws IncorrectTimeException;
	
	// Inherited from Comparable<Time>
	public int compareTo(Time o);
}
