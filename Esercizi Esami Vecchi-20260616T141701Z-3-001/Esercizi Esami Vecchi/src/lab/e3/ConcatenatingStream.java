package lab.e3;

public class ConcatenatingStream implements Stream<String> {

	private final StringBuilder current;
	private final String toConcat;
	
	public ConcatenatingStream(final String start, final String toConcat){
		this.current = new StringBuilder(start);
		this.toConcat = toConcat;
	}
	
	@Override
	public String next() {
		final String tmp = this.current.toString();
		this.current.append(toConcat);
		return tmp;
	}

}
