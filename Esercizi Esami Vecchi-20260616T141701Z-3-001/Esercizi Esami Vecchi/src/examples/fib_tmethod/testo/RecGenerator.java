package examples.fib_tmethod.testo;

public class RecGenerator extends AbstractGenerator {

	public RecGenerator(final int first, final int second) {
		super(first, second);
	}

	@Override
	protected int getNextFromThose(final int x, final int y) {
		final double result = 1/(1/(double)x+1/(double)y);
		return (int)result;
	}

}
