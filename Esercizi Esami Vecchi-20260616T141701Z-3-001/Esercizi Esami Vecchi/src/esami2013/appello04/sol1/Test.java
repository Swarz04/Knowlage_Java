package esami2013.appello04.sol1;

import static org.junit.Assert.*;

import java.util.*;

/*
 * Data l'interfaccia IncList<X>, implementarla con una classe IncListImpl<X> con costruttore vuoto
 * che fornisca una lista inizialmente vuota. Si costruisca una implementazione che consenta una 
 * implementazione tempo-costante del metodo getElement, e una occupazione in spazio lineare nel numero
 * di elementi presenti nella lista.
 * Si consideri il test qui sotto (da "scommentare") come riferimento.
 */

public class Test {
	
	@org.junit.Test
	public void test(){
		IncList<String> list = new IncListImpl<>();
		// Testing size and addnew
		assertEquals(list.size(),0);
		assertEquals(list.addNew("a"),0);
		assertEquals(list.addNew("b"),1);
		assertEquals(list.addNew("c"),2);
		assertEquals(list.addNew("a"),3);
		assertEquals(list.size(),4);
		// Testing remove
		list.remove(2); // 2 is removed, it won't be used again
		assertEquals(list.size(),3);
		assertEquals(list.addNew("d"),4); // we give "d" 4, incrementally
		assertEquals(list.size(),4);
		for (int i=0;i<10000;i++){
			list.remove(list.addNew("z")); // many add-remove..
		}
		assertEquals(list.size(),4);
		// Testing getElement
		assertEquals(list.getElement(0),"a");
		assertEquals(list.getElement(1),"b");
		assertNull(list.getElement(2));
		assertEquals(list.getElement(3),"a");
		assertEquals(list.getElement(4),"d");
		// Testing getPosition
		assertEquals(list.getPosition("b"),1);
		assertEquals(list.getPosition("c"),-1);
		assertEquals(list.getPosition("d"),4);
		assertTrue(Arrays.asList(0,3).contains(list.getPosition("a"))); // a assigned to 0 or 3
		// Testing allOccurrences
		Set<Integer> set = new HashSet<>();
		Iterator<Integer> it = list.allOccurrences("a");
		while (it.hasNext()){
			set.add(it.next());
		}
		assertEquals(set.size(),2);
		assertTrue(set.contains(0));
		assertTrue(set.contains(3));
		// Testing some Exceptions
		try{
			list.remove(100);
			fail("Can't remove 100!!");
		} catch(IllegalArgumentException e){}
		try{
			list.addNew(null);
			fail("Can't add a null");
		} catch(NullPointerException e){}
	}
	
}
