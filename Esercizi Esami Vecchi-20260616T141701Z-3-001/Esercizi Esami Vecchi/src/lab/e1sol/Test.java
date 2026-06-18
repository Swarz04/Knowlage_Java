package lab.e1sol;

import static org.junit.Assert.*;

/*
 * Implementare l'interfaccia Time fornita che modella un'ora del giorno (da 00:00 a 23:59), 
 * con una classe TimeImpl che abbia un costruttore che prende l'indicazione di ore e minuti,
 * e che lanci una eccezione IncorrectTimeException (fornita) se l'orario non è corretto.
 * L'implementazione soddisfi i seguenti test (da scommentare) 
 */

@SuppressWarnings("unused")
public class Test {
	
	@org.junit.Test
	public void test() throws Exception{
		Time t = new TimeImpl(20,30); // ore 20:30
		assertEquals(t.getHour(),20);
		assertEquals(t.getMinute(),30);
		assertTrue(t.shiftMinutes(15).compareTo(new TimeImpl(20,45)) == 0);
		assertTrue(t.shiftMinutes(60).compareTo(new TimeImpl(21,30)) == 0);
		assertTrue(t.shiftMinutes(-31).compareTo(new TimeImpl(19,59)) == 0);
		assertTrue(t.compareTo(new TimeImpl(22,30)) < 0);
		assertTrue(t.compareTo(new TimeImpl(18,45)) > 0);
	}
	
	@org.junit.Test
	public void test2() throws Exception{
		Time t = new TimeImpl(0,0);
		Time t2 = new TimeImpl(23,59);
		assertTrue(t.shiftMinutes(610).compareTo(new TimeImpl(10,10)) == 0);
	}
	
	
	@org.junit.Test
	public void test3() throws Exception{
		try {
			Time t = new TimeImpl(-1,15); 
			fail("out of range");
		} catch (IncorrectTimeException e) {}
		try {
			Time t = new TimeImpl(0,60); 
			fail("out of range");
		} catch (IncorrectTimeException e) {}
		try {
			Time t = new TimeImpl(0,0).shiftMinutes(-1); 
			fail("out of range");
		} catch (IncorrectTimeException e) {}
		try {
			Time t = new TimeImpl(23,59).shiftMinutes(1); 
			fail("out of range");
		} catch (IncorrectTimeException e) {}
	}
}
