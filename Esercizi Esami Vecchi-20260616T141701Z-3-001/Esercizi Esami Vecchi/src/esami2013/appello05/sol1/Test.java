package esami2013.appello05.sol1;

import static org.junit.Assert.*;

import java.util.*;

/*
 * Data l'interfaccia BiMap<X,Y>, implementarla con una classe BiMapImpl<X,Y> con costruttore vuoto. 
 * Circa un terzo del punteggio verrà attribuito considerando se i metodi put, getX, getY, hasXY e remove 
 * saranno eseguiti in tempo costante.
 * Si consideri il test qui sotto (da "scommentare") come riferimento.
 */

public class Test {
	
	@org.junit.Test
	public void test(){
		BiMap<Integer,String> bm = new BiMapImpl<>();
		
		// Testing put and size
		bm.put(1, "1");
		bm.put(2, "2");
		bm.put(3, "3"); // Mappa 1-"1", 2-"2", 3-"3"
		assertEquals(bm.size(),3);
		
		// Testing remove
		bm.remove(2,"2"); // Mappa 1-"1", 3-"3"
		assertEquals(bm.size(),2);
		
		// Testing getters
		assertEquals(bm.getX("1"),new Integer(1));
		assertEquals(bm.getX("3"),new Integer(3));
		assertNull(bm.getX("2"));
		assertEquals(bm.getY(1),"1");
		assertEquals(bm.getY(3),"3");
		assertNull(bm.getY(2));
		assertTrue(bm.hasXY(1,"1"));
		assertTrue(bm.hasXY(3,"3"));
		assertFalse(bm.hasXY(2,"2"));
		
		// Testing set construction
		Set<Integer> s1 = bm.allX();
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(3));
		assertTrue(s1.size()==2);
		Set<String> s2 = bm.allY();
		assertTrue(s2.contains("1"));
		assertTrue(s2.contains("3"));
		assertTrue(s2.size()==2);
		
		// Testing the relevant errors
		try{
			bm.put(4, null);
			fail("Can't be null");
		} catch(NullPointerException e){}
		try{
			bm.put(null, "4");
			fail("Can't be null");
		} catch(NullPointerException e){}
		try{
			bm.put(3, "4");
			fail("X already there");
		} catch(IllegalArgumentException e){}
		try{
			bm.put(4, "3");
			fail("Y already there");
		} catch(IllegalArgumentException e){}
		try{
			bm.remove(1,"2");
			fail("XY not already there");
		} catch(IllegalArgumentException e){}
	}
}
