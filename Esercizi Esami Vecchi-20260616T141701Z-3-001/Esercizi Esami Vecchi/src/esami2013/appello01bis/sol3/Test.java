package esami2013.appello01bis.sol3;

import static org.junit.Assert.*;

/*
 * Sono fornite l'interfaccia Counter e una sua implementazione standard CounterImpl.
 * Lo studente implementi l'interfaccia MultiCounter mediante un decoratore per un oggetto del
 * tipo Counter (ossia un suo wrapper).
 * Si consideri il test qui sotto (da scommentare) come riferimento.
 * 
 */

public class Test {
	
	@org.junit.Test
	public void test() throws Exception{
		Counter c = new CounterImpl(0);
		// MultiCounter prende in ingresso il Counter che "decòra"
		MultiCounter mc = new MultiCounterImpl(c);
		assertEquals(mc.getValue(),0);
		mc.increment();
		mc.increment();
		mc.increment();
		assertEquals(mc.getValue(),3); // 3 incrementi
		assertEquals(c.getValue(),3);  // stesso effetto se controlliamo via c
		mc.multiIncrement(3);		   // 3 incrementi in un colpo solo	
		assertEquals(mc.getValue(),6);
		assertEquals(c.getValue(),6);
		c.increment();
		assertEquals(mc.getValue(),7);
		assertEquals(c.getValue(),7);
	}
}
