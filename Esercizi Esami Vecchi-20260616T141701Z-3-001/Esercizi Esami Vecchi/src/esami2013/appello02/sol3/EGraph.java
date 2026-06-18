package esami2013.appello02.sol3;

import java.util.*;

/* It adds few methods to a Graph
 */

public interface EGraph<N,W> extends Graph<N,W>{

	/*
	 * Returns the set of nodes reachable in 0,1,2, or more steps from those in s.
	 * Simply defined by the recursive application of method neighbours in Graph.
	 */
	Set<N> reachable(Set<N> s);
	
	/*
	 * Returns the nearest node to n, namely, the one connected to n by an edge with minimum weight.
	 * It uses a custom comparator for weights.
	 */
	Pair<N,W> nearestFrom(N n, Comparator<? super W> c);
}
