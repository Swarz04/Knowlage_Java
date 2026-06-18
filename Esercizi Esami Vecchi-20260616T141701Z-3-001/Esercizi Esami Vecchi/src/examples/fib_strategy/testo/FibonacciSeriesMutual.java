package examples.fib_strategy.testo;

public class FibonacciSeriesMutual implements GenerationStrategy {

	@Override
	public int getNextFromThose(int x, int y) {
		final double tmp;
		tmp = 1/(1/(double)x+1/(double)y);
		return (int)tmp;
	}

}
