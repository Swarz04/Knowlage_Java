package examples.fib_tmethod.testo;

public class FibGenerator extends AbstractGenerator {

	public FibGenerator(final int first, final int second) {
		super(first, second);
	}

	@Override
	protected int getNextFromThose(final int x, final int y) {
		return x + y;
	}

}
