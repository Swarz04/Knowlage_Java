package lab.e1;

public class TimeImpl implements Time {

	private static final int MINUTES_IN_HOUR = 60;
	private static final int HOURS_IN_DAY = 24;

	private final int minutes;

	public TimeImpl(final int hours, final int minutes)
			throws IncorrectTimeException {
		if (hours > 23 || hours < 0 || minutes > 59 || minutes < 0) {
			throw new IncorrectTimeException();
		}
		this.minutes = minutes + hours * 60;
	}

	@Override
	public int getHour() {
		return this.minutes / MINUTES_IN_HOUR;
	}

	@Override
	public int getMinute() {
		return this.minutes % MINUTES_IN_HOUR;
	}

	@Override
	public Time shiftMinutes(final int nMinute) throws IncorrectTimeException {
		final int newMinutes = this.minutes + nMinute;
		if (newMinutes >= MINUTES_IN_HOUR * HOURS_IN_DAY || newMinutes < 0) {
			throw new IncorrectTimeException();
		}
		return new TimeImpl(newMinutes / MINUTES_IN_HOUR, newMinutes
				% MINUTES_IN_HOUR);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + minutes;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TimeImpl other = (TimeImpl) obj;
		if (minutes != other.minutes)
			return false;
		return true;
	}

	@Override
	public int compareTo(final Time o) {
		return this.minutes - (o.getMinute() + o.getHour() * MINUTES_IN_HOUR);
	}

}
