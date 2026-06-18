package examples.thread_scalar.sol;

public class Test {
	
	/* Si fornisce l'interfaccia ScalarProductExecutor, con un metodo per calcolare il 
	 * prodotto scalare fra due vettori, e una inner class d'esempio che la implementa
	 * in modo "mono-threaded". Realizzare una nuova implementazione MultiThreadedScalarProductExecutor
	 * che invece lo implementa in modo "multi-threaded", con dei Worker che si dividono il compito.
	 * Scegliere internamente il numero di thread che si ritiene più opportuno utilizzare, ma la 
	 * sia semplicemente modificabile per usarne un numero qualsivoglia.
	 * All'esecuzione del test qui sotto, le due chiamate dovranno dare lo stesso output.
	 * Si faccia anche sì che come effetto della seconda chiamata, ogni Worker emetta una stampa
	 * quando ha terminato il lavoro, indicando qualche informazione utile a capire che parte di lavoro
	 * ha svolto.
	 */

	public static void main(String[] args) {
		int size = 100;
		double[] v1 = new double[size];
		double[] v2 = new double[size];
		for (int i=0; i<size;i++){
			v1[i] = 10;
			v2[i] = i;
		}
		System.out.println(new ScalarProductExecutor.Simple().scalarProduct(v1, v2));
		System.out.println(new MultiThreadedScalarProductExecutor().scalarProduct(v1, v2));
		
	}
}
