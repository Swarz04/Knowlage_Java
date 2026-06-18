package esami2013.appello06.e1;

public class DayImpl implements Day {

	private final int giorno;
	private final Month mese;
	private final int anno;

	public DayImpl(final int giorno, final Month mese, final int anno) {
		if (mese.getDays(anno) < giorno || giorno <= 0) {
			throw new IllegalArgumentException();
		}
		this.giorno = giorno;
		this.anno = anno;
		this.mese = mese;
	}

	@Override
	public int getDay() {
		return this.giorno;
	}

	@Override
	public Month getMonth() {
		return this.mese;
	}

	@Override
	public int getYear() {
		return this.anno;
	}

	@Override
	public Day next() {
		final boolean lastDay = this.giorno == this.mese.getDays(this.anno);
		return new DayImpl(lastDay ? 1 : this.giorno + 1,
				lastDay ? (this.mese == Month.DECEMBER ? Month.JANUARY : Month
						.values()[this.mese.ordinal() + 1]) : this.mese,
				lastDay && this.mese == Month.DECEMBER ? this.anno + 1
						: this.anno);
	}

	@Override
	public int compareTo(final Day d) {
		return this.anno == d.getYear() ? (this.mese.ordinal() == d.getMonth()
				.ordinal() ? this.giorno - d.getDay() : this.mese.ordinal()
				- d.getMonth().ordinal()) : this.anno - d.getYear();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		result = prime * result + giorno;
		result = prime * result + ((mese == null) ? 0 : mese.hashCode());
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
		DayImpl other = (DayImpl) obj;
		if (anno != other.anno)
			return false;
		if (giorno != other.giorno)
			return false;
		if (mese != other.mese)
			return false;
		return true;
	}

}
