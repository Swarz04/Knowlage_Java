package esami2013.appello03.sol3;

/* This is a standard implementation of the calculation */

public class MultiThreadedSumMatrix implements ISumMatrix {
	
	private final int nthread;
	
	public MultiThreadedSumMatrix(int nthread) {
		super();
		this.nthread = nthread;
	}

	private class Worker extends Thread {

		private final double[][] matrix;
		private int startpos;
		private int nelem;
		private double res;

		public Worker(final double[][] matrix,int startpos,int nelem) {
			this.matrix = matrix;
			this.startpos = startpos;
			this.nelem = nelem;
		}

		@Override
		public void run() {
			System.out.println("Working from row "+startpos+" to row "+(startpos+nelem-1));
			for (int i=startpos;i<matrix.length && i<startpos+nelem;i++){
				for (double d: this.matrix[i]){
					this.res += d;
				}
			}
		}
		
		public double getResult(){
			return this.res;
		}

	}
	
	public double sum(final double[][] m) {
		double res = 0;
		Worker[] w = new Worker[nthread];
		int start = 0;
		int size = m.length % nthread == 0 ? m.length/nthread : m.length/nthread +1; 
		for (int j = 0; j < nthread; j++) {
			w[j] = new Worker(m,start,size);
			w[j].start();
			start = start+size;
		}
		for (Worker worker: w) {
			try {
				worker.join();
			} catch (InterruptedException e) {}
			res += worker.getResult();
		}
		return res;
	}
}
