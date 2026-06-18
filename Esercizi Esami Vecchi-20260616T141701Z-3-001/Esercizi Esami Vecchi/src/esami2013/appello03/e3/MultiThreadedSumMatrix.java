package esami2013.appello03.e3;

public class MultiThreadedSumMatrix implements ISumMatrix {

	private final int numWorkers;

	public MultiThreadedSumMatrix(final int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		this.numWorkers = n;
	}

	@Override
	public double sum(final double[][] matrix) {

		final int rowPerWorker = matrix.length % this.numWorkers == 0 ? matrix.length
				/ this.numWorkers
				: matrix.length / this.numWorkers + 1;

		final Worker[] WArray = new Worker[this.numWorkers];
		double finalResult = 0;

		int k = 0;
		for (int i = 0; i < matrix.length; i += rowPerWorker) {
			WArray[k] = new Worker(matrix, i, i + rowPerWorker);
			WArray[k].start();
			try {
				WArray[k++].join();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		}

		for (int i = 0; i < this.numWorkers; i++) {
			finalResult += WArray[i].getSum();
		}

		return finalResult;
	}

	private static class Worker extends Thread {

		private final double[][] matrix;
		private final int start;
		private final int stop;
		private double result;

		public Worker(final double[][] matrix, final int rowStart,
				final int rowStop) {
			this.matrix = matrix;
			this.start = rowStart;
			this.stop = rowStop;
		}

		@Override
		public void run() {
			System.out.println("Worker [" + start + ".."
					+ (stop > matrix.length ? matrix.length : stop) + "]");
			for (int i = start; i < stop && i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					this.result += matrix[i][j];
				}
			}
		}

		public double getSum() {
			return this.result;
		}

	}

}
