package examples.thread_scalar.sol;

public interface ScalarProductExecutor {
	
	/*
	 * Compute the scalar product of the two vectors.
	 * A simple reference implementation called Simple is provided as an inner static class 
	 */
	double scalarProduct(double[] v1, double[] v2);
	
	class Simple implements ScalarProductExecutor{

		public double scalarProduct(double[] v1, double[] v2) {
			double s = 0;

			for (int i = 0; i < v1.length; i++){
				s+=v1[i]*v2[i];
			}
			return s;
		}
	}

}
