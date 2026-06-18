package esami2013.appello01.sol3;

import static org.junit.Assert.*;

/*
 * Sono fornite l'interfaccia Counter e una sua implementazione astratta AbstractCounter
 * che usa un template method per lasciare all'implementatore finale il compito di stabilire 
 * una politica per intercettare eventuali fallimenti nell'incremento (per esempio per raggiunto limite).
 * Quindi, lo studente estenda AbstractCounter (riusando tutto il codice possibile) attraverso una classe 
 * LimitCounterImpl che implementa anche l'interfaccia LimitCounter, da usare per creare contatori che raggiunto il 
 * limite facciano generare l'eccezione al metodo increment. Tale contatore parta da 0 e abbia limite 5 se 
 * non altrimenti specificato (attraverso il metodo setLimit)
 * Si consideri il test qui sotto (da scommentare) come riferimento.
 * 
 */

public class Test {
	
	@org.junit.Test
	public void test() throws Exception{
		LimitCounter lc = new LimitCounterImpl();
		assertEquals(lc.getValue(),0);
		lc.increment();
		lc.increment();
		lc.increment();
		assertEquals(lc.getValue(),3);
		lc.increment();
		lc.increment();
		try{
			lc.increment();
			fail("Limit exceded");
		} catch (IllegalStateException e){}
		assertEquals(lc.getValue(),5);
		lc.setLimit(7);
		lc.increment();
		lc.increment();
		assertEquals(lc.getValue(),7);
		try{
			lc.increment();
			fail("Limit exceded");
		} catch (IllegalStateException e){}
		assertEquals(lc.getValue(),7);
	}
	
}
