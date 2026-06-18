package examples.fib_tmethod.sol;


public class FibGenerator extends LastTwoBasedGenerator{
	
	
	public FibGenerator(int n1, int n2){
		super(n1,n2);
	}

	@Override
	protected int generateNext() {
		return this.getLast() + this.getPrev();
	}

}
