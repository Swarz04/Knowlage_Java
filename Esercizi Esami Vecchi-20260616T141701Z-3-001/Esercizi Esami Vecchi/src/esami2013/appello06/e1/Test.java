package esami2013.appello06.e1;

import static org.junit.Assert.*;

import static esami2013.appello06.e1.Month.*;

/*
 * Si consideri l'enumeratrion Month fornita, utile per costruire il concetto di giorno (del calendario), ossia
 * per sapere quanti giorni ha un certo mese.
 * Implementare quindi l'interfaccia Day attraverso una class DayImpl che accetti nel costruttore 3 elementi:
 * un intero (numero del giorno nel mese, compreso fra 1 e 31), il mese (tramite l'enumerazione MONTH), e l'anno (un int).
 * Si consideri il test qui sotto (da "scommentare") come riferimento.
 */

public class Test {

	@org.junit.Test
	public void test() {
		
		Day d1 = new DayImpl(28, JANUARY, 2012);
		Day d2 = new DayImpl(29, JANUARY, 2012);
		Day d3 = new DayImpl(30, JANUARY, 2012);
		Day d4 = new DayImpl(31, JANUARY, 2012);
		Day d5 = new DayImpl(1, FEBRUARY, 2012);

		Day d6 = new DayImpl(31, DECEMBER, 2000);
		Day d7 = new DayImpl(1, JANUARY, 2001);

		assertEquals(d1.getDay(),28);
		assertEquals(d1.getMonth(),JANUARY);
		assertEquals(d1.getYear(),2012);
		
		assertNotEquals(d1, d2);
		assertNotEquals(d1, d3);

		assertEquals(d1.next(), d2); // test sul prossimo (next) giorno
		assertEquals(d4.next(), d5);

		assertTrue(d6.compareTo(d7) < 0);
		assertTrue(d7.compareTo(d7) == 0);
		assertTrue(d7.compareTo(d6) > 0);

		try {
			new DayImpl(0, JANUARY, 2012);
			fail("Day 0");
		} catch (IllegalArgumentException e) {
		}
		try {
			new DayImpl(30, FEBRUARY, 2012);
			fail("Day 30");
		} catch (IllegalArgumentException e) {
		}
		
	}
}
