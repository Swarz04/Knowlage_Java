package esami2013.appello01bis.sol1;

import static org.junit.Assert.*;
import java.util.*;

/*
 * Implementare l'interfaccia Multiset<X> fornita, con una classe MultisetImpl<X> con costruttore vuoto.
 * Le descrizioni in Multiset e il Test qui sotto dovrebbero fornire tutte le indicazioni necessarie.
 * Si noti che Multiset deve trattare due elementi come uguali allo stesso modo in cui lo deve fare la 
 * classe java.util.Set, o una qualunque altra collezione/mappa del Collection Framework.
 * Si ponga attenzione a trovare il modo più opportuno per rappresentare lo stato della classe Multiset<X>
 * Il tutto, passi il test qui sotto riportato (da "scommentare").
 */

public class Test {
	
	@org.junit.Test
	public void test() throws Exception{
		Multiset<String> m = new MultisetImpl<>();
		m.add("a");
		m.add("a");
		m.add("a");
		m.add("b");
		m.add("c");
		m.add("c");
		// multiset [a,a,a,b,c,c]
		assertEquals(m.countElements("a"),3);
		assertEquals(m.countElements("b"),1);
		assertEquals(m.countElements("c"),2);
		assertEquals(m.countElements("d"),0);
		assertEquals(m.size(),6);
		m.remove("a");
		// multiset [a,a,b,c,c]
		assertEquals(m.countElements("a"),2);
		assertEquals(m.countElements("b"),1);
		assertEquals(m.countElements("c"),2);
		assertEquals(m.countElements("d"),0);
		assertEquals(m.size(),5);
		try{
			m.remove("d");
			fail("This cannot be removed!");
		} catch (IllegalArgumentException e){}
		assertEquals(m.countElements("a"),2);
		assertEquals(m.countElements("b"),1);
		assertEquals(m.countElements("c"),2);
		assertEquals(m.countElements("d"),0);
		assertEquals(m.size(),5);
		Set<String> set = m.set();
		assertEquals(set.size(),3);
		assertTrue(set.contains("a"));
		assertTrue(set.contains("b"));
		assertTrue(set.contains("c"));
		Multiset<String> m2 = new MultisetImpl<>();
		m2.add("a");
		m2.add("b");
		m2.add("c");
		m2.add("c");
		// multiset [a,b,c,c]
		assertTrue(m.contains(m2));
		assertFalse(m2.contains(m)); // m2 non contiene m, perché non abbastanza elementi "a" 
	}
	
	
	
}
