package esami2013.appello02.sol3;

import static org.junit.Assert.*;

import java.util.*;

/*
 * Da realizzare se svolto l'esercizio n.2
 * Implementare l'interfaccia EGraph<N,W> che estende Graph<N,W> dell'esercizio precedente. Lo si faccia
 * tramite una classe EGraphImpl che estende la GraphImpl già realizzata e che ne riusa tutto il possibile.
 * Il tutto, passi il test qui sotto riportato (da "scommentare").
 */

public class Test {
	
	private EGraph<String,Double> create(){
		EGraph<String,Double> g = new EGraphImpl<String,Double>();
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
	public void testMethods() throws Exception{
		EGraph<String,Double> g = create();
		// test reachable
		Set<String> set = new HashSet<>();
		set.add("a");
		assertEquals(g.reachable(set),g.allNodes()); // a,b,c,d,e
		Set<String> set2 = new HashSet<>();
		set2.add("b");
		set2.add("c");
		assertEquals(g.reachable(set2).size(),3); // b,c,d
		assertTrue(g.reachable(set2).contains("b")); 
		assertTrue(g.reachable(set2).contains("c"));
		assertTrue(g.reachable(set2).contains("d"));
		// test nearestFrom
		Comparator<? super Double> c = new Comparator<Double>(){
			public int compare(Double arg0, Double arg1) {
				return (int)Math.signum(arg1-arg0);
			}
		};
		assertEquals(g.nearestFrom("a", c),new Pair<>("b",1.0));
	}
	
	@org.junit.Test
	public void testSomeErrors() throws Exception{
		Comparator<? super Double> c = new Comparator<Double>(){
			public int compare(Double arg0, Double arg1) {
				return (int)Math.signum(arg1-arg0);
			}
		};
		EGraph<String,Double> g = create();
		try{
			g.reachable(null);
			fail("Node can't be null");
		} catch (NullPointerException e){}
		try{
			g.nearestFrom(null,c);
			fail("Node can't be null");
		} catch (NullPointerException e){}
		try{
			g.nearestFrom("a",null);
			fail("Comparator can't be null");
		} catch (NullPointerException e){}
		try{
			Set<String> s = new HashSet<>(Arrays.asList(new String[]{"a","h"}));
			g.reachable(s);
			fail("Node does not exist");
		} catch (IllegalArgumentException e){}
		try{
			g.nearestFrom("h",c);
			fail("Node does not exist");
		} catch (IllegalArgumentException e){}
	}
	
}