package examples.fib_strategy.testo;

public class FibonacciSeries implements GenerationStrategy {

	@Override
	public int getNextFromThose(int x, int y) {
		return x+y;
	}
}
