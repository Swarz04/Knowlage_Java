package examples.fib_tmethod.testo;

import static org.junit.Assert.*;

/*
 * Si fornisce l'interfaccia Generator per estrarre sequenze di interi, elemento per elemento, array per array, o lista 
 * per lista (e potendo "skippare" elementi).
 * Si realizzino due specializzazioni che supportano il concetto di serie di Fibonacci e di serie di Fibonacci reciproca,
 * nelle classi FibGenerator e RecGenerator entrambe con costruttore che prende in ingresso due interi corrispondenti
 * ai primi due elementi della serie.
 * Si noti che la serie Fibonacci reciproca, con elementi iniziali 100 e 100, aggiunge un elemento ottenuto dalla media
 * armonica fra i due precedenti (1/(1/n1+1/n2)) -- che sarebbe 100,100,50,33,19,12,...
 * Come buona pratica OO, si fattorizzino tutte le proprietà comuni di queste due classi in una classe astratta, e
 * si usi ove possibile il pattern Template Method.
 * Il tutto passi i test qui sotto (da scommentare).
 */

public class Test {
	
	@org.junit.Test
	public void testFibNext() {
		Generator g = new FibGenerator(1,1);
		assertEquals(g.getNext(),1);
		assertEquals(g.getNext(),1);
		assertEquals(g.getNext(),2);
		assertEquals(g.getNext(),3);
		assertEquals(g.getNext(),5);
		g.skip(2); // skipping 8 and 13
		assertEquals(g.getNext(),21);
		assertEquals(g.getNext(),34);
	}
	
	@org.junit.Test
	public void testFibArray() {
		Generator g = new FibGenerator(1,1);
		int[] ar = new int[10];
		int[] ar2 = new int[]{1,1,2,3,5,8,13,21,34,55};
		assertSame(g.getNextArray(ar),ar); // returning the input
		assertArrayEquals(ar,ar2);
		assertArrayEquals(g.getNextArray(new int[2]),new int[]{89,89+55});
	}
	
	@org.junit.Test
	public void testFibList() {
		Generator g = new FibGenerator(1,1);
		java.util.Iterator<Integer> it = g.getNextList(5).iterator();
		assertTrue(it.next()==1);
		assertTrue(it.next()==1);
		assertTrue(it.next()==2);
		assertTrue(it.next()==3);
		assertTrue(it.next()==5);
		assertFalse(it.hasNext());
		it = g.getNextList(2).iterator();
		assertTrue(it.next()==8);
		assertTrue(it.next()==13);
		assertFalse(it.hasNext());
	}
	
	@org.junit.Test
	public void testRecNext() {
		Generator g = new RecGenerator(100,100); //100,100,50,33,19,12,7,4,...
		assertEquals(g.getNext(),100);
		assertEquals(g.getNext(),100);
		assertEquals(g.getNext(),50);
		g.skip(1); // skipping 33
		assertArrayEquals(g.getNextArray(new int[2]),new int[]{19,12});
		java.util.Iterator<Integer> it = g.getNextList(2).iterator();
		assertTrue(it.next()==7);
		assertTrue(it.next()==4);
		assertFalse(it.hasNext());
	}
	
}