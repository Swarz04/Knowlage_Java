package esami2013.appello02.sol3;

import java.util.*;

/* It models a directed graph, in which each node is of type N,
 * edges have a weight W, and any ordered pair of nodes has at most
 * one edge.
 * Each method needs non-null arguments, or it throws a NullPointerException.
 * Operations working on nodes that should exist, throws an IllegalArgumentException if those nodes do not exist.
 */

public interface Graph<N,W> {

	/*
	 * Adds a node to the graph (initially without any edge).
	 * The node should not be already there, otherwise IllegalArgumentException is thrown 
	 */
	void addNode(N n);
	
	/*
	 * Removes a node.
	 * Nothing happens if the node is not there.
	 * throws an IllegalArgumentException if the node has either incoming or outgoing edges 
	 */
	void removeNode(N n);
	
	/*
	 * Checks for the presence of a node.
	 */
	boolean hasNode(N n);
	
	/*
	 * Adds an edge between an ordered pair of nodes, with given non-null weight.
	 * An edge between those two nodes should not be already there, otherwise IllegalArgumentException is thrown 
	 */
	void addEdge(N n1, N n2, W w);
	
	/*
	 * Removes the edge between an ordered pair of nodes.
	 * Nothing happens if the edge is not there 
	 */
	void removeEdge(N n1, N n2);
	
	/*
	 * Return the weight of the edge between the ordered pair of nodes.
	 * Returns null if one such edge does not exist 
	 */
	W weight(N n1, N n2); 
	
	/*
	 * Returns the set of all nodes of the graph
	 */
	Set<N> allNodes();
	
	/*
	 * Returns the set of all edges starting from node n: for each, it gives target node and weight
	 */
	Set<Pair<N,W>> outgoing(N n);
	
	/*
	 * Returns the set of neighbours of n (namely, the same nodes returned by method outgoing). 
	 * Note that n does not belong to this set, in general.
	 */
	Set<N> neighbours(N n);
	
	/*
	 * Returns the set of neighbours of all nodes in s.
	 */
	Set<N> neighbours(Set<N> s);
}
