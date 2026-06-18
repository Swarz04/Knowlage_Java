package esami2013.appello01bis.sol3;


public class CounterImpl implements Counter{
	
	protected int count;
	
	public CounterImpl(int count){
		this.count = count;
	}
	
	@Override
	public void increment(){
		this.count++;
	}
	
	@Override
	public int getValue(){
		return this.count;
	}
}
