package esami2013.appello02.sol3;

import java.util.*;

public class EGraphImpl<N,W> extends GraphImpl<N,W> implements EGraph<N,W> {
	
	public EGraphImpl(){}

	@Override
	public Set<N> reachable(Set<N> set) {
		Set<N> ss = neighbours(set);
		ss.addAll(set);
		return ss.equals(set) ? ss : reachable(ss);
	}

	@Override
	public Pair<N, W> nearestFrom(N n, Comparator<? super W> c) {
		Pair<N,W> min = null;
		for (Pair<N,W> p: this.outgoing(n)){
			if (min == null || c.compare(min.getY(),p.getY())<0){
				min = p;
			}
		}
		return min;
	}
}
