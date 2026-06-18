package esami2013.appello03.sol3;

import static org.junit.Assert.*;

public class Test {

	/*
	 * Si fornisce l'interfaccia ISumMatrix, con un metodo per calcolare la somma delgi elementi di una matrice
	 * Realizzare una classe MultiThreadedSumMatrix, con costrutto che accetta un intero positivo 'n', che implementa 
	 * tale funzionalità in modo "multi-threaded", con 'n' Worker che si dividano il compito in modo sufficientemente 
	 * omogeneo -- non è necessario che l'ammontare dei compiti dei singoli Worker siano esattamente equivalenti.  
	 * Si faccia stampare (su System.out) ad ogni Worker una indicazione di che porzione del lavoro svolge. 
	 * 
	 * All'esecuzione del test qui sotto, le due chiamate dovranno dare lo
	 * stesso output, ad eccezione ovviamente dei tempi.
	 */
	
	@org.junit.Test
	public void testBasic(){
		double[][] matrix = new double[100][100];
		for (double[] d: matrix){
			for (int i=0;i<100;i++){
				d[i]=i;
			}
		}
		// 495000 è la somma degli elementi di questa matrice
		System.out.println("Trying with 3 threads");
		assertEquals(new MultiThreadedSumMatrix(3).sum(matrix),495000,0.01);
		System.out.println("Trying with 7 threads");
		assertEquals(new MultiThreadedSumMatrix(7).sum(matrix),495000,0.01);
		System.out.println("Trying with 10 threads");
		assertEquals(new MultiThreadedSumMatrix(10).sum(matrix),495000,0.01);
	}

}
