package esami2013.appello02.e2;

import static org.junit.Assert.*;

import java.util.*;

/*
 * Implementare l'interfaccia Graph<N,W> con una classe GraphImpl<N,W> con costruttore vuoto.
 * Nello scegliere la struttura dati più opportuna si ottimizzino (per evitare penalizzazioni nel punteggio) i primi 
 * 6 metodi di Graph (che devono essere tutti eseguiti in tempo costante) -- quindi, scelta la struttura dati, gli 
 * altri metodi semplicemente siano realizzati senza ovvie penalizzazioni in performance.  
 * Si consiglia di implementare i metodi nell'ordine proposto, e si fornisce la classe Pair che potrebbe essere utile 
 * (ma non è detto che lo sia).
 * Il tutto, passi il test qui sotto riportato (da "scommentare").
 */

public class Test {
	
	// metodo usato nei test più sotto
	private Graph<String,Double> create(){
		Graph<String,Double> g = new GraphImpl<String,Double>();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		g.addEdge("a","b",1.0);
		g.addEdge("b","c",1.0);
		g.addEdge("c","d",1.0);
		g.addEdge("a","d",1.5);
		g.addEdge("a","e",3.0); // Grafo finale: a->b->c->d, a->d, a->e
		return g;
	}
	
	@org.junit.Test
	public void testObservations(){
		Graph<String,Double> g = create();
		// test weight and hasNode
		assertTrue(g.hasNode("a"));
		assertTrue(g.hasNode("b"));
		assertTrue(g.hasNode("e"));
		assertFalse(g.hasNode("h"));
		assertTrue(g.weight("a", "b")==1.0);
		assertTrue(g.weight("b", "c")==1.0);
		assertTrue(g.weight("a", "e")==3.0);
		assertTrue(g.weight("a", "c")==null);
		// test allNodes
		assertEquals(g.allNodes().size(),5);
		assertTrue(g.allNodes().containsAll(Arrays.asList(new String[]{"a","b","c","d","e"})));
		// test outgoing
		assertEquals(g.outgoing("a").size(),3); // b,d,e
		assertTrue(g.outgoing("a").contains(new Pair<>("b",1.0)));
		assertTrue(g.outgoing("a").contains(new Pair<>("e",3.0)));
		assertTrue(g.outgoing("a").contains(new Pair<>("d",1.5)));
		assertEquals(g.outgoing("e").size(),0);
		// test neighbours
		assertEquals(g.neighbours("a").size(),3); // b,d,e
		assertTrue(g.neighbours("a").containsAll(Arrays.asList(new String[]{"b","d","e"})));
		assertTrue(g.neighbours("b").containsAll(Arrays.asList(new String[]{"c"})));
		assertEquals(g.neighbours("e").size(),0);
		Set<String> s = new HashSet<>();
		s.add("b");
		s.add("c");
		assertEquals(g.neighbours(s).size(),2); // c,d
	}
	
	@org.junit.Test
	public void testRemovals() throws Exception{
		Graph<String,Double> g = create();
		g.removeEdge("a", "b");
		assertTrue(g.weight("a", "b")==null);
		assertTrue(g.weight("b", "c")==1.0);
		assertTrue(g.weight("a", "e")==3.0);
		assertTrue(g.weight("a", "c")==null);
		g.removeEdge("a", "e");
		assertNull(g.weight("a", "e"));
		g.removeNode("e");
		assertTrue(g.hasNode("a"));
		assertTrue(g.hasNode("b"));
		assertTrue(g.hasNode("c"));
		assertTrue(g.hasNode("d"));
		assertFalse(g.hasNode("e"));
	}
	
	@org.junit.Test
	public void testSomeErrors() throws Exception{
		Graph<String,Double> g = create();
		try{
			g.hasNode(null);
			fail("Node can't be null");
		} catch (NullPointerException e){}
		try{
			g.addNode(null);
			fail("Node can't be null");
		} catch (NullPointerException e){}
		try{
			g.removeNode(null);
			fail("Node can't be null");
		} catch (NullPointerException e){}
		try{
			g.addEdge(null,"a",1.0);
			fail("Node can't be null");
		} catch (NullPointerException e){}
		try{
			g.addEdge("a",null,1.0);
			fail("Node can't be null");
		} catch (NullPointerException e){}
		try{
			g.addEdge("a","b",null);
			fail("Weight can't be null");
		} catch (NullPointerException e){}
		try{
			g.weight(null,"a");
			fail("Node can't be null");
		} catch (NullPointerException e){}
		try{
			g.weight("a",null);
			fail("Node can't be null");
		} catch (NullPointerException e){}
		try{
			g.outgoing(null);
			fail("Node can't be null");
		} catch (NullPointerException e){}
		try{
			g.neighbours((String)null);
			fail("Node can't be null");
		} catch (NullPointerException e){}
		try{
			g.addNode("a");
			fail("Node already there");
		} catch (IllegalArgumentException e){}
		try{
			g.addEdge("h","a",1.0);
			fail("Node does not exist");
		} catch (IllegalArgumentException e){}
		try{
			g.weight("h","a");
			fail("Node does not exist");
		} catch (IllegalArgumentException e){}
		try{
			g.outgoing("h");
			fail("Node does not exist");
		} catch (IllegalArgumentException e){}
		try{
			g.neighbours("h");
			fail("Node does not exist");
		} catch (IllegalArgumentException e){}
		try{
			Set<String> s = new HashSet<>(Arrays.asList(new String[]{"a","h"}));
			g.neighbours(s);
			fail("Node does not exist");
		} catch (IllegalArgumentException e){}
		
	}
	
}