package lab.e1sol;

public class TimeImpl implements Time{
	
	private static final int MINUTES = 60;
	private static final int MINUTES_TIMES_HOURS = 24*MINUTES;
	private final int minutes;
	
	public TimeImpl(int hour,int minute) throws IncorrectTimeException{
		this(hour * MINUTES + minute);
		if (minute < 0 || minute >= MINUTES){
			throw new IncorrectTimeException();
		}
	}
	
	private TimeImpl(int minutes) throws IncorrectTimeException{
		this.minutes = minutes;
		if (this.minutes < 0 || this.minutes >= MINUTES_TIMES_HOURS){
			throw new IncorrectTimeException();
		}
	}
	
	@Override
	public int compareTo(Time o) {
		return this.minutes - o.getMinute() - o.getHour()*MINUTES;
	}

	@Override
	public int getHour() {
		return this.minutes / MINUTES;
	}

	@Override
	public int getMinute() {
		return this.minutes % MINUTES;
	}

	@Override
	public Time shiftMinutes(int nMinute) throws IncorrectTimeException {
		return new TimeImpl(this.minutes + nMinute);
	}	
	
}
