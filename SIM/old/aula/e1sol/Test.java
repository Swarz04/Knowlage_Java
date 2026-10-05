package aula.e1sol;

import static org.junit.Assert.*;

import java.util.Arrays;

/*
 * Implementare l'interfaccia fornita PersonArchive, attraverso una classe PersonArchiveImpl
 * con costruttore senza argomenti, in modo che decommentando i 3 test qui sotto si abbia
 * una esecuzione del test JUnit senza errori. 
 */

public class Test {
	
	@org.junit.Test
	public void test() {
		PersonArchive ar = new PersonArchiveImpl();
		ar.addPerson(10,"Mario");
		ar.addPerson(20,"Gino");
		ar.addPerson(30,"Rino");
		assertTrue(ar.hasCode(10));
		assertTrue(ar.hasCode(20));
		assertTrue(ar.hasCode(30));
		assertTrue(!ar.hasCode(11));
		assertTrue(ar.getNameByCode(10).equals("Mario"));
		assertTrue(ar.getNameByCode(11) == null);
		assertTrue(ar.getNames().length == 3);
		assertTrue(Arrays.asList(ar.getNames()).contains("Mario"));
		assertTrue(Arrays.asList(ar.getNames()).contains("Gino"));
		assertTrue(Arrays.asList(ar.getNames()).contains("Rino"));
	}
	
	@org.junit.Test
	public void test2() {
		PersonArchive ar = new PersonArchiveImpl();
		ar.addPerson(10,"Mario");
		ar.addPerson(20,"Gino");
		ar.addPerson(30,"Rino");
		try{
			ar.setLimit(2); 
			fail("limite troppo basso");
		} catch (IllegalArgumentException e){}
		try{
			ar.addPerson(10,"Carlo");
			fail("codice giù usato");
		} catch (IllegalArgumentException e){}
		try{
			ar.addPerson(40,null);
			fail("nome illegale");
		} catch (IllegalArgumentException e){}
	}
	
	@org.junit.Test
	public void test3() {
		PersonArchive ar = new PersonArchiveImpl();
		ar.addPerson(10,"Mario");
		ar.addPerson(20,"Gino");
		ar.addPerson(30,"Rino");
		ar.setLimit(3);
		try{
			ar.addPerson(40,"Carlo"); 
			fail("la persona non può essere inserita!");
		} catch (UnsupportedOperationException e){}
	}

}
