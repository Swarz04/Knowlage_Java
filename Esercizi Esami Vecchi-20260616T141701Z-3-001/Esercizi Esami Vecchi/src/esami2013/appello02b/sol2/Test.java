package esami2013.appello02b.sol2;

import static org.junit.Assert.*;

/*
 * Implementare l'interfaccia Tree<N> con una classe TreeImpl<N> con costruttore vuoto.
 * Nello scegliere la struttura dati più opportuna si ottimizzino (per evitare penalizzazioni) i metodi
 * addNode, father, e hasNode (che devono essere eseguiti in tempo costante) -- gli altri metodi vengano quindi realizzati
 * nel modo più performante possibile con la struttura dati già scelta.
 * Si consiglia di implementare i metodi nell'ordine proposto.
 * Il tutto, passi il test qui sotto riportato (da "scommentare").
 */

public class Test {
	
	@org.junit.Test
	public void testBasic() throws Exception{
		Tree<String> tree = new TreeImpl<String>();
		// Building the tree
		tree.addNode("a", null); // a is the root
		tree.addNode("b", "a");  // b,c,d are children of a
		tree.addNode("c", "a");
		tree.addNode("d", "a");
		tree.addNode("e", "d");  // e children of d
		tree.addNode("f", "d");  // f children of d
		tree.addNode("g", "f");  // g children of f
		assertEquals(tree.size(),7);
		// Testing hasNode
		assertTrue(tree.hasNode("a"));
		assertTrue(tree.hasNode("d"));
		assertTrue(tree.hasNode("f"));
		assertFalse(tree.hasNode("h"));
		// Testing father
		assertNull(tree.father("a"));
		assertEquals(tree.father("b"),"a");
		assertEquals(tree.father("d"),"a");
		assertEquals(tree.father("f"),"d");
		assertNotEquals(tree.father("a"),"f");
		// Testing children
		assertTrue(tree.children("a").contains("b"));
		assertTrue(tree.children("a").contains("c"));
		assertTrue(tree.children("a").contains("d"));
		assertTrue(tree.children("d").contains("e"));
		assertEquals(tree.children("a").size(),3);
		assertEquals(tree.children("b").size(),0);
		assertEquals(tree.children("c").size(),0);
		assertEquals(tree.children("d").size(),2);
		assertEquals(tree.children("e").size(),0);
		assertEquals(tree.children("f").size(),1);
		assertEquals(tree.children("g").size(),0);
		// Testing removals
		tree.removeNode("g");
		assertFalse(tree.children("f").contains("g"));
		assertFalse(tree.hasNode("g"));
		tree.removeNode("d"); // the tree now is: a->e a->f a->b a->c
		assertEquals(tree.size(),5);
		assertTrue(tree.children("a").contains("e"));
		assertTrue(tree.children("a").contains("f"));
		assertTrue(tree.children("a").contains("b"));
		assertTrue(tree.children("a").contains("c"));
	}
	
	@org.junit.Test
	public void testSomeErrors() throws Exception{
		Tree<String> tree = new TreeImpl<String>();
		// Building the tree
		tree.addNode("a", null);
		tree.addNode("b", "a");
		tree.addNode("c", "a");
		tree.addNode("d", "a");
		tree.addNode("e", "d");
		tree.addNode("f", "d");
		tree.addNode("g", "f");
		try{
			tree.addNode("h",null);
			fail("Cannot have two roots");
		} catch (NullPointerException e){}
		try{
			tree.addNode(null,"a");
			fail("Null node");
		} catch (NullPointerException e){}
		try{
			tree.addNode("h","i");
			fail("i does not exist");
		} catch (IllegalArgumentException e){}
		assertEquals(tree.size(),7);
		// Testing father
		try{
			tree.father(null);
			fail("Null node");
		} catch (NullPointerException e){}
		try{
			tree.father("i");
			fail("i does not exist");
		} catch (IllegalArgumentException e){}
		// Testing children
		try{
			tree.children(null);
			fail("Null node");
		} catch (NullPointerException e){}
		try{
			tree.children("i");
			fail("i does not exist");
		} catch (IllegalArgumentException e){}
		// Testing removals
		try{
			tree.removeNode(null);
			fail("Null node");
		} catch (NullPointerException e){}
		try{
			tree.removeNode("i");
			fail("i does not exist");
		} catch (IllegalArgumentException e){}
		try{
			tree.removeNode("a");
			fail("cannot remove root");
		} catch (IllegalArgumentException e){}
	}
}