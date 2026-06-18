package esami2013.appello02b.sol3;

import java.util.*;

public class ETreeImpl<N> extends TreeImpl<N> implements ETree<N> {
	
	@Override
	public Set<N> descendants(N node) {
		Set<N> descendants = new HashSet<N>();
		for (N son: children(node)){
			descendants.add(son);
			descendants.addAll(descendants(son));
		}
		return descendants;
	}

	
	@Override
	public List<N> chainToRoot(N node) {
		List<N> list = new ArrayList<>();
		list.add(node);
		while (father(node)!=null){
			list.add(node = father(node));
		}
		return list;
	}
}
