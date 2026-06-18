package examples.thread_scalar.testo;

public class MultiThreadedScalarProductExecutor implements
		ScalarProductExecutor {

	private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

	@Override
	public double scalarProduct(final double[] v1, final double[] v2) {
		if (v1.length != v2.length) {
			throw new IllegalArgumentException(
					"I vettori devono avere lunghezza uguale");
		}

		final int numCellePerWorker = v1.length % NUM_THREADS == 0 ? v1.length
				/ NUM_THREADS : v1.length / NUM_THREADS + 1;

		final Worker[] w = new Worker[NUM_THREADS];

		for (int i = 0; i < NUM_THREADS; i++) {
			w[i] = new Worker(i * numCellePerWorker, (i + 1)
					* numCellePerWorker, v1, v2);
			w[i].start();
		}

		double result = 0;

		for (final Worker wk : w) {
			try {
				wk.join();
			} catch (InterruptedException e) {
				System.err.println(e.toString() + " thread not joined");
			}
			result += wk.getResult();
		}

		return result;
	}

	private static class Worker extends Thread {

		private final int start;
		private final int stop;
		private final double[] firstVector;
		private final double[] secondVector;
		private double result;

		public Worker(final int startIndex, final int stopIndex,
				final double[] vector1, final double[] vector2) {
			this.start = startIndex;
			this.stop = stopIndex;
			this.firstVector = vector1;
			this.secondVector = vector2;
		}

		@Override
		public void run() {
			System.out.println("Working from [" + start + "] to ["
					+ (stop > firstVector.length ? firstVector.length : stop)
					+ "]");
			for (int i = start; i < stop && i < this.firstVector.length; i++) {
				result += this.firstVector[i] * this.secondVector[i];
			}
		}

		public double getResult() {
			return this.result;
		}

	}

}
