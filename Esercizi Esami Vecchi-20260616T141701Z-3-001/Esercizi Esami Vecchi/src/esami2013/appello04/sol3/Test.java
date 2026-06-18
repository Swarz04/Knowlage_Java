package esami2013.appello04.sol3;

import static org.junit.Assert.*;
import java.util.Arrays;

import java.io.*;

/*
 * Aiutandosi con la classe PermUtilities, implementare l'interfaccia PermutationsStore attraverso una classe 
 * PermutationsStoreImpl, con costruttore che accetta una stringa che rappresenta il nome del file che dovrà 
 * contenere lo "store" dei dati.
 * Si assume che lo store possa essere molto grande e quindi non stare in memoria, quindi è molto importante che 
 * le permutazioni vengano scritte su file mano a mano, e che l'accesso all'i-esima permutazione avvenga senza dover
 * caricare tutte le permutazioni in memoria prima.
 * Si consideri il test qui sotto (da scommentare) come riferimento. 
 */

public class Test {
	
	@org.junit.Test
	public void test() throws IOException {
		PermutationsStore p = new PermutationsStoreImpl("data.dat");
		assertEquals(p.storePermutations(3),6);
		assertTrue(Arrays.equals(p.getPermutation(0),new int[]{0, 1, 2}));
		assertTrue(Arrays.equals(p.getPermutation(1),new int[]{0, 2, 1}));
		assertTrue(Arrays.equals(p.getPermutation(2),new int[]{1, 0, 2}));
		assertTrue(Arrays.equals(p.getPermutation(3),new int[]{1, 2, 0}));
		assertTrue(Arrays.equals(p.getPermutation(4),new int[]{2, 0, 1}));
		assertTrue(Arrays.equals(p.getPermutation(5),new int[]{2, 1, 0}));
		assertEquals(p.storePermutations(6),720);
		assertTrue(Arrays.equals(p.getPermutation(0),new int[]{0, 1, 2, 3, 4, 5}));
		assertTrue(Arrays.equals(p.getPermutation(200),new int[]{1, 4, 2, 3, 0, 5}));
		assertTrue(Arrays.equals(p.getPermutation(719),new int[]{5, 4, 3, 2, 1, 0}));
		try{
			p.getPermutation(720);
			fail("Out of bounds!");
		} catch (IndexOutOfBoundsException e){}
	}
	
}

