package esami2013.appello02b.sol3;

import java.util.*;

/* It adds few methods to a Tree
 */

public interface ETree<N> extends Tree<N>{
	/*
	 * Extracting all the descendants of a node (children, children of children,..)
	 */
	Set<N> descendants(N node);
	
	/*
	 * Given a node of the tree, return the list of nodes connecting it (included) with the root (included).
	 */
	List<N> chainToRoot(N node);
	
}
