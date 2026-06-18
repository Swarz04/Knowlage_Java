package esami2013.appello01.e1.sol1;

import static org.junit.Assert.*;
import java.util.*;

/*
 * Implementare l'interfaccia Relation<X,Y> fornita con una classe RelationImpl<X,Y> con costruttore vuoto.
 * Si noti che una relazione binaria su X e Y è di fatto un sottoinsieme del prodotto cartesiano fra X e Y,
 * ossia è un insieme di coppie x,y -- ciò suggerisce una implementazione possibile,
 * non necessariamente la migliore.
 * Il tutto, passi il test qui sotto riportato (da "scommentare").
 */

public class Test {

	@org.junit.Test
	public void test() throws Exception{
		Relation<String,Integer> r = new RelationImpl<>();
		// verifica che le operazioni base funzionano bene..
		r.set(">7",8); // setta ">7" essere in relazione con 8
		r.set(">7",9); // ... e in modo simile per gli altri..
		r.set("<4",3);
		r.set("<4",2);
		r.set("<4",1);
		r.set("<4",0);
		r.set("pari",0);
		r.set("pari",2);
		r.set("pari",4);
		r.set("pari",6);
		r.set("pari",8);
		r.set("pari",9);
		assertEquals(r.size(),12); // 12 coppie inserite fin qui..
		r.set("pari",9);
		r.set("pari",9);
		r.set("pari",9);
		assertEquals(r.size(),12); // aggiunte di relazioni già esistenti non creano effetti
		r.unset("pari",9);
		assertEquals(r.size(),11); // ho rimosso una relazione..
		r.unset("pari",9);
		r.unset("pari",9);
		assertEquals(r.size(),11); // nessun effetto a rimuovere relazioni inesistenti
		assertTrue(r.holds("pari",0)); 		// ora svolgo vari test di relazione..
		assertTrue(r.holds("pari",8));
		assertTrue(r.holds("<4",2));
		assertFalse(r.holds("pari",10));
		assertFalse(r.holds("dispari",10));
		Set<Integer> set = r.relatedTo(">7"); // tutti gli elementi in relazione con ">7"
		assertTrue(set.contains(8));
		assertTrue(set.contains(9));
		assertEquals(set.size(),2); // il set ha esattamente quei due elementi
		Set<Integer> set2 = r.relatedTo("pippo"); // tutti gli elementi in relazione con ">7"
		assertEquals(set2.size(),0); // set vuoto
		// Test eccezioni NullPointerException
		try {
			r.set(null, 9);
			fail("null");
		} catch (NullPointerException e){}
		try {
			r.unset("pari", null);
			fail("null");
		} catch (NullPointerException e){}
		try {
			r.set("pari", null);
			fail("null");
		} catch (NullPointerException e){}
		try {
			r.holds("pari", null);
			fail("null");
		} catch (NullPointerException e){}
		try {
			r.holds(null, 10);
			fail("null");
		} catch (NullPointerException e){}
	}
}
