package examples.fib_tmethod.sol;

public class RecGenerator extends LastTwoBasedGenerator{
	
	
	public RecGenerator(int n1, int n2){
		super(n1,n2);
	}

	@Override
	protected int generateNext() {
		return (int)(1.0/(1.0/this.getLast() + 1.0/this.getPrev()));
	}
		

}
