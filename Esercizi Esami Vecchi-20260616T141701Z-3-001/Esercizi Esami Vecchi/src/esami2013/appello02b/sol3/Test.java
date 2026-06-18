package esami2013.appello02b.sol3;

import static org.junit.Assert.*;
import java.util.*;

/*
 * Da realizzare se svolto l'esercizio n.2
 * Implementare l'interfaccia ETree<N> che estende Tree<N> dell'esercizio precedente. Lo si faccia
 * tramite una classe ETreeImpl che estende la TreeImpl già realizzata e che ne riusa tutto il possibile.
 * Il tutto, passi il test qui sotto riportato (da "scommentare").
 */

public class Test {
	
	@org.junit.Test
	public void testBasic() throws Exception{
		ETree<String> tree = new ETreeImpl<String>();
		// Building the tree
		tree.addNode("a", null);
		tree.addNode("b", "a");
		tree.addNode("c", "a");
		tree.addNode("d", "a");
		tree.addNode("e", "d");
		tree.addNode("f", "d");
		tree.addNode("g", "f");
		// Testing descendants
		assertEquals(tree.descendants("d").size(),3);
		assertTrue(tree.descendants("d").contains("e"));
		assertTrue(tree.descendants("d").contains("f"));
		assertTrue(tree.descendants("d").contains("g"));
		assertEquals(tree.descendants("a"),new HashSet<>(Arrays.asList(new String[]{"b","c","d","e","f","g"})));
		// Testing chain
		List<String> chain = tree.chainToRoot("g");
		assertEquals(chain.size(),4);
		assertArrayEquals(chain.toArray(),new Object[]{"g","f","d","a"});
	}
	
	@org.junit.Test
	public void testSomeErrors() throws Exception{
		ETree<String> tree = new ETreeImpl<String>();
		// Building the tree
		tree.addNode("a", null);
		tree.addNode("b", "a");
		tree.addNode("c", "a");
		tree.addNode("d", "a");
		tree.addNode("e", "d");
		tree.addNode("f", "d");
		tree.addNode("g", "f");
		// Testing descendants
		try{
			tree.descendants(null);
			fail("Null node");
		} catch (NullPointerException e){}
		try{
			tree.descendants("i");
			fail("i does not exist");
		} catch (IllegalArgumentException e){}
		// Testing chain
		try{
			tree.chainToRoot(null);
			fail("Null node");
		} catch (NullPointerException e){}
		try{
			tree.chainToRoot("i");
			fail("i does not exist");
		} catch (IllegalArgumentException e){}
	}
}