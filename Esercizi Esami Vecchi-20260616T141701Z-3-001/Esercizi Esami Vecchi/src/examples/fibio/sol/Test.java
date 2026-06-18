package examples.fibio.sol;

import static org.junit.Assert.*;

public class Test {
	
	/*
	 * Implementare l'interfaccia FibIO con la classe FIbIOonFile,
	 * con un costruttore che accetta una stringa che corrisponde al nome del file ove caricare/salvare.
	 * Si faccia attenzione a aprire/chiudere il file ad ogni operazione di load/save.
	 * Si decida il formato più conveniente per salvare/caricare le informazioni.
	 * Il tutto passi il test qui sotto (da "scommentare")
	 */

	@org.junit.Test
	public void testOK() throws Exception {
		FibIO fib = new FibIOonFile("f1.dat");
		assertEquals(fib.getFib().size(),0);
		fib.computeNewNumbers(5);
		assertEquals(fib.getFib().size(),5);
		assertTrue(fib.getFib().get(0)==1);
		assertTrue(fib.getFib().get(1)==1);
		assertTrue(fib.getFib().get(2)==2);
		assertTrue(fib.getFib().get(3)==3);
		assertTrue(fib.getFib().get(4)==5);
		fib.computeNewNumbers(2);
		assertEquals(fib.getFib().size(),7);
		assertTrue(fib.getFib().get(5)==8);
		assertTrue(fib.getFib().get(6)==13);
		fib.saveFib();
		
		FibIO fib2 = new FibIOonFile("f1.dat");
		fib2.loadFib();
		assertEquals(fib.getFib().size(),7);
		assertTrue(fib.getFib().get(0)==1);
		assertTrue(fib.getFib().get(1)==1);
		assertTrue(fib.getFib().get(2)==2);
		assertTrue(fib.getFib().get(3)==3);
		assertTrue(fib.getFib().get(4)==5);
		assertTrue(fib.getFib().get(5)==8);
		assertTrue(fib.getFib().get(6)==13);
	}	
}