package esami2013.appello01.e3;

public class LimitCounterImpl extends AbstractCounter implements LimitCounter {
	
	private static final int DEFAULT_LIMIT = 5;
	
	private int limit;
	
	public LimitCounterImpl(final int count, final int limite){
		super(count);
		this.limit = limite;
	}
	
	public LimitCounterImpl(){
		this(0,DEFAULT_LIMIT);
	}
	
	@Override
	public void setLimit(final int n) {
		this.limit = n;
	}

	@Override
	protected void canIncrement() throws IllegalStateException {
		if(this.getValue() == this.limit){
			throw new IllegalStateException();
		}
	}

}
