package esami2013.appello03.sol2;

import static org.junit.Assert.*;
import java.util.*;

/*
 * Data la classe astratta PairIterable<X>, estenderla creando la classe (non astratta) PairIterableImpl<X>.
 * Ricordandosi che tali classi implementano java.util.Iterable, e sono quindi utilizzabili nel for-each,
 * la classe da realizzare sarà da utilizzare per iterare a due a due (quindi tornando dei Pair<X,X>) gli elementi forniti
 * da un Iterable di input al costruttore.
 * Se tale Iterable di input fornisse un numero dispari di elementi, l'ultimo non venga considerato.
 * Si consideri il test qui sotto (da scommentare) come riferimento.
 * Si cerchi ove possibile di non creare strutture dati superflue e non strettamente necessarie --
 * anche se inefficienze non precluderanno la sufficienza dell'esercizio.
 * Si faccia l'ipotesi semplificativa che una volta creata una istanza di PairIterableImpl, il contenuto
 * dell'Iterable in input non cambi.
 */

public class Test {
	
	@org.junit.Test
	public void test(){
		List<Integer> l = Arrays.asList(10,20,30,40,50,60,70,80);
		List<Pair<Integer,Integer>> lp = new ArrayList<>();
		// Itero l coppie a coppie, tramite la PairIterableImpl da realizzare
		for (Pair<Integer,Integer> pair: new PairIterableImpl<>(l)){
			// inserisco ogni coppia in una nuova lista lp
			lp.add(pair);
		}
		System.out.println(lp); // [Pair [x=10, y=20], Pair [x=30, y=40], Pair [x=50, y=60], Pair [x=70, y=80]]
		// verifico se lp contiene le 4 coppie
		assertEquals(lp.size(),4);
		assertEquals(lp.get(0),new Pair<>(10,20));
		assertEquals(lp.get(1),new Pair<>(30,40));
		assertEquals(lp.get(2),new Pair<>(50,60));
		assertEquals(lp.get(3),new Pair<>(70,80));
		
		// Stesso test, ma ora sun numero dispari di elementi
		// L'ultimo va ignorato
		List<Integer> l2 = Arrays.asList(10,20,30,40,50,60,70);
		List<Pair<Integer,Integer>> lp2 = new ArrayList<>();
		for (Pair<Integer,Integer> pair: new PairIterableImpl<>(l2)){
			lp2.add(pair);
		}
		System.out.println(lp2);  // [Pair [x=10, y=20], Pair [x=30, y=40], Pair [x=50, y=60]]
		assertEquals(lp2.size(),3);
		assertEquals(lp2.get(0),new Pair<>(10,20));
		assertEquals(lp2.get(1),new Pair<>(30,40));
		assertEquals(lp2.get(2),new Pair<>(50,60));
		
	}
	
}
