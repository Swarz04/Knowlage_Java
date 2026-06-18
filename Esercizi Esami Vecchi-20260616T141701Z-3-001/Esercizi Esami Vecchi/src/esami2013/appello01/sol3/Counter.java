package esami2013.appello01.sol3;

// A counter interface with the possibility that increment fails

public interface Counter{
	
	void increment() throws IllegalStateException;
	
	public int getValue();
}
