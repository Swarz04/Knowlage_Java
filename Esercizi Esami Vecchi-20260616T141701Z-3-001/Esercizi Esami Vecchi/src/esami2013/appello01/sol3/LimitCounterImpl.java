package esami2013.appello01.sol3;

public class LimitCounterImpl extends AbstractCounter implements LimitCounter{

	private int limit = 5;
	
	public LimitCounterImpl(){
		super(0);
	}
	
	@Override
	public void setLimit(int n) {
		this.limit = n;
		
	}

	@Override
	protected void canIncrement() throws IllegalStateException {
		if (this.getValue() >= this.limit){
			throw new IllegalStateException();
		}
	}
}
