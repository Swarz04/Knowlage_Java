package esami2013.appello02b.sol2;

import java.util.*;

public class TreeImpl<N> implements Tree<N> {
	
	private Map<N,N> fatherMap = new HashMap<>();

	private void checkNull(N node){
		if (node == null){
			throw new NullPointerException();
		}
	}
	
	private void checkExist(N node){
		if (!fatherMap.containsKey(node)){
			throw new IllegalArgumentException("Node "+node+" does not exist");
		}
	}
	
	@Override
	public void addNode(N node, N father){
		checkNull(node);
		if (father == null && fatherMap.size()!=0){
			throw new NullPointerException("There is already a root");
		} 
		if (father != null){
			checkExist(father);
		}
		this.fatherMap.put(node, father);
	}
	
	

	@Override
	public int size() {
		return fatherMap.size();
	}

	@Override
	public N father(N node) {
		checkNull(node);
		checkExist(node);
		return fatherMap.get(node);
	}


	@Override
	public boolean hasNode(N node) {
		checkNull(node);
		return this.fatherMap.containsKey(node);
	}

	@Override
	public Set<N> nodes() {
		return fatherMap.keySet();
	}

	@Override
	public Set<N> children(N node) {
		checkNull(node);
		checkExist(node);
		Set<N> sons = new HashSet<N>();
		for (N n: fatherMap.keySet()){
			if (fatherMap.get(n)!=null && fatherMap.get(n).equals(node)){
				sons.add(n);
			}
		}
		return sons;
	}

	@Override
	public void removeNode(N node) {
		checkNull(node);
		checkExist(node);
		if (father(node)==null){
			throw new IllegalArgumentException("cannot remove root");
		}
		Set<N> sons = children(node);
		N father = father(node);
		for (N son: sons){
			fatherMap.remove(son);
			fatherMap.put(son,father);
		}
		fatherMap.remove(node);
	}
}
