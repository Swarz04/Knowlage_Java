package examples.campionato.sol;

import static org.junit.Assert.*;


/*
 * Si fornisce una implementazione CampionatoImpl dell'interfaccia Campionata fornita e 
 * documentata nel suo sorgente.
 * Tale classe non abbia costruttori e soddisfi i test qui sotto (da commentare)
 */

public class Test {
	
	@org.junit.Test
	public void testOK() {
		Campionato c = new CampionatoImpl();
		c.addSquadra("INT", "Internazionale");
		c.addSquadra("JUV", "Juventus");
		c.addSquadra("MIL", "Milan");
		c.addSquadra("ROM", "Roma");
		c.iniziaCampionato();
		c.addRisultato("INT", "JUV", "1"); // int3, juv0, mil0, rom0
		c.addRisultato("MIL", "ROM", "X"); // int3, juv0, mil1, rom1
		c.addRisultato("INT", "MIL", "1"); // int6, juv0, mil1, rom1
		c.addRisultato("JUV", "ROM", "2"); // int6, juv0, mil1, rom4
		java.util.List<Pair<String,Integer>> list = c.getClassifica();
		System.out.println(list);
		assertEquals(list.get(0).getFirst(),"Internazionale");
		assertTrue(list.get(0).getSecond()==6);
		assertEquals(list.get(1).getFirst(),"Roma");
		assertTrue(list.get(1).getSecond()==4);
		assertEquals(list.get(2).getFirst(),"Milan");
		assertTrue(list.get(2).getSecond()==1);
		assertEquals(list.get(3).getFirst(),"Juventus");
		assertTrue(list.get(3).getSecond()==0);
		assertEquals(list.size(),4);
	}
	
	@org.junit.Test
	public void testErrori() {
		Campionato c = new CampionatoImpl();
		try{
			c.addSquadra("IN", "Internazionale");
			fail("3 charcters in short name");
		} catch (IllegalArgumentException e){}
		c.addSquadra("INT", "Internazionale");
		c.addSquadra("JUV", "Juventus");
		try{
			c.addSquadra("JUV", "Juve");
			fail("name already used");
		} catch (IllegalArgumentException e){}
		try{
			c.addRisultato("INT", "JUV","1");
			fail("campionato not started yet");
		} catch (UnsupportedOperationException e){}
		c.iniziaCampionato();
		try{
			c.addSquadra("MIL", "Milan");
			fail("cannot add a team after league has started");
		} catch (UnsupportedOperationException e){}
		try{
			c.addRisultato("INT", "ROM","1");
			fail("team does not exist");
		} catch (IllegalArgumentException e){}
		try{
			c.addRisultato("INT", "JUV","3");
			fail("result not understood");
		} catch (IllegalArgumentException e){}
	}
	
	
	
}
