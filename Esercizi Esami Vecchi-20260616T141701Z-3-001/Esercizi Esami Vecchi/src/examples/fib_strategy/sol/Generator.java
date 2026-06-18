package examples.fib_strategy.sol;

public interface Generator {
	
	// produce il prossimo intero
	int getNext();

	// salta i prossimi n interi
	void skip(int n);
	
	// produce il prossimo array di interi, riempiendo e ritornando quello in input
	int[] getNextArray(int[] array);
	
	// produce una lista con i prossimi 'size' interi
	public java.util.List<Integer> getNextList(int size);
	
}
