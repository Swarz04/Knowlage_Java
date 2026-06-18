package esami2013.appello02.sol2;

import java.util.*;

public class GraphImpl<N,W> implements Graph<N,W> {
	
	private Set<N> nodes = new HashSet<>();
	private Map<Pair<N,N>,W> edges = new HashMap<>();
	
	public GraphImpl(){}

	private void checkNull(Object o){
		if (o == null){
			throw new NullPointerException();
		}
	}
	private void checkNode(N n){
		checkNull(n);
		if (!hasNode(n)){
			throw new IllegalArgumentException();
		}
	}
	@Override
	public void addNode(N n) {
		checkNull(n);
		if (hasNode(n)){
			throw new IllegalArgumentException();
		}
		this.nodes.add(n);
	}

	@Override
	public void removeNode(N n) {
		checkNode(n);
		for (Pair<N,N> p: edges.keySet()){
			if (p.getX().equals(n) || p.getY().equals(n)){
				throw new IllegalArgumentException();
			}
		}
		this.nodes.remove(n);
		
	}

	@Override
	public boolean hasNode(N n) {
		checkNull(n);
		return this.nodes.contains(n);
	}
	

	@Override
	public void addEdge(N n1, N n2, W w) {
		checkNode(n1);
		checkNode(n2);
		checkNull(w);
		if (this.weight(n1,n2)!=null){
			throw new IllegalArgumentException();
		}
		this.edges.put(new Pair<>(n1,n2), w);
	}

	@Override
	public void removeEdge(N n1, N n2) {
		checkNode(n1);
		checkNode(n2);
		this.edges.remove(new Pair<>(n1,n2));
	}

	@Override
	public W weight(N n1, N n2) {
		checkNode(n1);
		checkNode(n2);
		return this.edges.get(new Pair<>(n1,n2));
	}

	@Override
	public Set<N> allNodes() {
		return new HashSet<N>(this.nodes);
	}

	@Override
	public Set<Pair<N, W>> outgoing(N n) {
		checkNode(n);
		Set<Pair<N,W>> set = new HashSet<>();
		for (Pair<N,N> p: this.edges.keySet()){
			if (p.getX().equals(n)){
				set.add(new Pair<>(p.getY(),this.edges.get(p)));
			}
		}
		return set;
	}
	
	@Override
	public Set<N> neighbours(N n) {
		checkNode(n);
		Set<N> set = new HashSet<>();
		for (Pair<N,N> p: this.edges.keySet()){
			if (p.getX().equals(n)){
				set.add(p.getY());
			}
		}
		return set;
	}
	
	@Override
	public Set<N> neighbours(Set<N> s) {
		checkNull(s);
		Set<N> set = new HashSet<>();
		for (N n: s){
			set.addAll(neighbours(n));
		}
		return set;
	}

}
