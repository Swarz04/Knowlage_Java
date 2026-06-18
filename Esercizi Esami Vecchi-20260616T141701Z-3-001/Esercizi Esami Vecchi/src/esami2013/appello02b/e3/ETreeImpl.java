package esami2013.appello02b.e3;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import esami2013.appello02b.e2.TreeImpl;

public class ETreeImpl<N> extends TreeImpl<N> implements ETree<N> {

	@Override
	public Set<N> descendants(final N node) {
		final Set<N> result = this.children(node);
		for(final N n : result){
			result.addAll(this.descendants(n));
		}
		return result;
	}

	@Override
	public List<N> chainToRoot(N node) {
		final List<N> result = new LinkedList<>();
		
		while(this.father(node) != null){
			result.add(node);
			node = this.father(node);
		}
		result.add(node);
		return result;
	}

}
