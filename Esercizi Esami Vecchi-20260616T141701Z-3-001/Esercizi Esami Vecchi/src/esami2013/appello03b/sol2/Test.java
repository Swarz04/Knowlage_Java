package esami2013.appello03b.sol2;

import static org.junit.Assert.*;
import java.util.*;

/*
 * Data la classe astratta CartesianIterable<X,Y>, estenderla creando la classe (non astratta) CartesianIterableImpl<X,Y>.
 * Ricordandosi che tali classi implementano java.util.Iterable, e sono quindi utilizzabili nel for-each,
 * la classe da realizzare sarà da utilizzare per iterare su tutte le coppie ordinate di elementi provenienti dalle due
 * liste in ingresso.
 * Si consideri il test qui sotto (da scommentare) come riferimento.
 * Una parte della difficoltà dell'esercizio consta nell'evitare la creazione di strutture dati
 * superflue, che comporterebbe un calo del punteggio, ma non la sua sufficienza.
 * Si faccia l'ipotesi semplificativa che una volta creata una istanza di CartesianIterableImpl, il contenuto
 * dei due Iterable in input non cambi.
 */

public class Test {
	
	@org.junit.Test
	public void test(){
		List<Integer> l = Arrays.asList(10,20,30,40);
		List<String> l2 = Arrays.asList("a","b","c");
		List<Pair<Integer,String>> lp = new ArrayList<>();
		// Itero sul prodotto cartesiano di l e l2
		for (Pair<Integer,String> pair: new CartesianIterableImpl<>(l,l2)){
			// Ogni coppia ritrovato la inserisco in lp
			lp.add(pair);
		}
		// Verifico che lp sia corretta
		System.out.println(lp);
		assertEquals(lp.size(),12); // vi sono 3x4 elementi..
		assertEquals(lp.get(0),new Pair<>(10,"a"));
		assertEquals(lp.get(1),new Pair<>(10,"b"));
		assertEquals(lp.get(2),new Pair<>(10,"c"));
		assertEquals(lp.get(3),new Pair<>(20,"a"));
		assertEquals(lp.get(4),new Pair<>(20,"b"));
		assertEquals(lp.get(5),new Pair<>(20,"c"));
		assertEquals(lp.get(6),new Pair<>(30,"a"));
		assertEquals(lp.get(7),new Pair<>(30,"b"));
		assertEquals(lp.get(8),new Pair<>(30,"c"));
		assertEquals(lp.get(9),new Pair<>(40,"a"));
		assertEquals(lp.get(10),new Pair<>(40,"b"));
		assertEquals(lp.get(11),new Pair<>(40,"c"));
	}
	
}
