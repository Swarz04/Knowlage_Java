package esami2013.appello02b.sol2;

import java.util.*;

/* It models a tree, where each node can have 0,1,2,.. or more children (without any order in them).
 * Each method needs non-null arguments unless differently specified, or it throws a NullPointerException.
 * Operations working on nodes that should exist, throws a IllegalArgumentException if those nodes do not exist.
 */

public interface Tree<N> {

	/*
	 * Adds a node specifying its father.
	 * Father can be null only if no other nodes exist in the tree, which is used to specify the root 
	 */
	void addNode(N node, N father);
	
	/*
	 * Returns the size of the tree 
	 */
	int size();
	
	/*
	 * Returns the father of a node, or null if it is the root. 
	 */
	N father(N node);
	
	/*
	 * Looking for the presence of a node
	 */
	boolean hasNode(N node);
	
	/*
	 * An iterator over all nodes
	 */
	Set<N> nodes();
	
	/*
	 * Extracting the children of a node
	 */
	Set<N> children(N node);
	
	/*
	 * Remove a non-root node, causing its children to be become children of its father.
	 */
	void removeNode(N node);
	
}
