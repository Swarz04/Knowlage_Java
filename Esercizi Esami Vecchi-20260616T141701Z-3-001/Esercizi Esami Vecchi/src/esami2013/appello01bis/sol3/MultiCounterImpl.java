package esami2013.appello01bis.sol3;

public class MultiCounterImpl implements MultiCounter{
	
	private Counter c;
	
	public MultiCounterImpl(Counter c){
		this.c = c;
	}

	@Override
	public void increment() {
		this.c.increment();
	}

	@Override
	public int getValue() {
		return this.c.getValue();
	}
	
	@Override
	public void multiIncrement(int n){
		for (;n>0;n--){
			this.c.increment();
		}
	}
	
}
