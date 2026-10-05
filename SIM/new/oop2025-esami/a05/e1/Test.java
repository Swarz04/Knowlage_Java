package a05.e1;

import static org.junit.Assert.*;

public class Test {

	/*
	 * Implementare l'interfaccia SignalGeneratorFactory come indicato nel metodo init qui sotto. 
	 * Realizza una factory per dei generatori periodici (ossia ripetitivi) di sequenze di elementi. 
	 * Si leggano i commenti all'interfaccia fornita e specialmente i test qui sotto per i dettagli.
	 * 
	 * Sono considerati opzionali ai fini della possibilità di correggere
	 * l'esercizio, ma concorrono comunque al raggiungimento della totalità del
	 * punteggio:
	 * 
	 * - far passare tutti i test (ossia, nella parte obbligatoria è sufficiente 
	 * che passino tutti i test tranne uno a piacimento)
	 * - la buona progettazione della soluzione, utilizzando soluzioni progettuali che portino a
	 * codice succinto che evita ripetizioni e sprechi di memoria.
	 * 
	 * Si tolga il commento dal metodo init.
	 * 
	 * Indicazioni di punteggio:
	 * - correttezza della parte obbligatoria (e assenza di difetti al codice): 10 punti
	 * - correttezza della parte opzionale: 2 punti (ulteriore metodo della factory)
	 * - qualità della soluzione: 5 punti (per buon design)
	 */

	private SignalGeneratorFactory factory;

	@org.junit.Before
	public void init() {
		// this.factory = new SignalGeneratorFactoryImpl();
	}

	// utility che estrae il prossimo elemento da un generatore
	public static <E> E extractNext(SignalGenerator<E> generator){
		E current = generator.get();
		generator.advance();
		return current;
	}

	@org.junit.Test
	public void testSwitchTwoElements() {
		var generator = factory.switchTwo("A", 2, "B", 3);
		// attraverso l'uso di get() e advance()
		// si noti che chiamare get() più volte senza advance() non cambia l'elemento corrente
		assertEquals("A", generator.get());
		assertEquals("A", generator.get());
		assertEquals("A", generator.get());
		generator.advance();
		assertEquals("A", generator.get());
		assertEquals("A", generator.get());
		generator.advance();
		assertEquals("B", generator.get());
		assertEquals("B", generator.get());
		generator.advance();
		assertEquals("B", generator.get());
		generator.advance();
		assertEquals("B", generator.get());
		generator.advance();
		assertEquals("A", generator.get());
		generator.advance();
		assertEquals("A", generator.get());
		generator.advance();
		assertEquals("B", generator.get());
		generator.advance();
		generator.advance();
		assertEquals("B", generator.get());
		generator.advance();
		assertEquals("A", generator.get());	

		generator = factory.switchTwo("A", 2, "B", 3);
		// attraverso l'uso di extractNext(), più conciso, si ottiene lo stesso risultato
		assertEquals("A", extractNext(generator));
		assertEquals("A", extractNext(generator));
		assertEquals("B", extractNext(generator));
		assertEquals("B", extractNext(generator));
		assertEquals("B", extractNext(generator));
		assertEquals("A", extractNext(generator));
		assertEquals("A", extractNext(generator));
		assertEquals("B", extractNext(generator));
		assertEquals("B", extractNext(generator));
		assertEquals("B", extractNext(generator));
		assertEquals("A", extractNext(generator));
	}

	@org.junit.Test
	public void testIncreasing() {
		var generator = factory.increasing(5, 7);
		assertEquals(5, extractNext(generator).intValue());
		assertEquals(6, extractNext(generator).intValue());
		assertEquals(7, extractNext(generator).intValue());
		assertEquals(8, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(10, extractNext(generator).intValue());
		assertEquals(11, extractNext(generator).intValue());
		assertEquals(5, extractNext(generator).intValue());
		assertEquals(6, extractNext(generator).intValue());
		assertEquals(7, extractNext(generator).intValue());
	}

	@org.junit.Test
	public void testIncreasingBounded() {
		var generator = factory.increasingBounded(5, 9, 7);
		assertEquals(5, extractNext(generator).intValue());
		assertEquals(6, extractNext(generator).intValue());
		assertEquals(7, extractNext(generator).intValue());
		assertEquals(8, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(5, extractNext(generator).intValue());
		assertEquals(6, extractNext(generator).intValue());
		assertEquals(7, extractNext(generator).intValue());
		assertEquals(8, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(5, extractNext(generator).intValue());
		assertEquals(6, extractNext(generator).intValue());
		assertEquals(7, extractNext(generator).intValue());
	}

	@org.junit.Test
	public void testIncreasingSlowed() {
		var generator = factory.increasingSlowed(5, 7);
		assertEquals(5, extractNext(generator).intValue());
		assertEquals(5, extractNext(generator).intValue());
		assertEquals(6, extractNext(generator).intValue());
		assertEquals(6, extractNext(generator).intValue());
		assertEquals(7, extractNext(generator).intValue());
		assertEquals(7, extractNext(generator).intValue());
		assertEquals(8, extractNext(generator).intValue());
		assertEquals(8, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(10, extractNext(generator).intValue());
		assertEquals(10, extractNext(generator).intValue());		
		assertEquals(11, extractNext(generator).intValue());
		assertEquals(11, extractNext(generator).intValue());
		assertEquals(5, extractNext(generator).intValue());
		assertEquals(5, extractNext(generator).intValue());
	}

	@org.junit.Test
	public void testIncreasingSlowedAndBounded() {
		var generator = factory.increasingSlowedAndBounded(5, 9, 7);
		assertEquals(5, extractNext(generator).intValue());
		assertEquals(5, extractNext(generator).intValue());
		assertEquals(6, extractNext(generator).intValue());
		assertEquals(6, extractNext(generator).intValue());
		assertEquals(7, extractNext(generator).intValue());
		assertEquals(7, extractNext(generator).intValue());
		assertEquals(8, extractNext(generator).intValue());
		assertEquals(8, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());		
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(9, extractNext(generator).intValue());
		assertEquals(5, extractNext(generator).intValue());
		assertEquals(5, extractNext(generator).intValue());
	}


}	