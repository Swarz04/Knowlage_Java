package esami2013.appello01bis.e3;

public class MultiCounterImpl implements MultiCounter {

	private final Counter normalCounter;
	
	public MultiCounterImpl(Counter c){
		this.normalCounter = c;
	}
	
	@Override
	public void increment() {
		normalCounter.increment();
	}

	@Override
	public int getValue() {
		return normalCounter.getValue();
	}

	@Override
	public void multiIncrement(final int n){
		if(n<0){
			throw new IllegalArgumentException();
		}
		
		for(int i=n;i>0;i--){
			this.normalCounter.increment();
		}
	}

}
