package esami2013.appello02.e3;

import java.util.Comparator;
import java.util.Set;


public class EGraphImpl<N, W> extends GraphImpl<N, W> implements EGraph<N, W> {

	@Override
	public Set<N> reachable(final Set<N> s) {
		final Set<N> result = this.neighbours(s);
		result.addAll(s);
		return result.equals(s) ? result : reachable(result);
	}

	@Override
	public Pair<N, W> nearestFrom(final N n, final Comparator<? super W> c) {
		return this.outgoing(n).stream().min((p1,p2)->c.compare(p2.getY(), p1.getY())).orElse(null);
	}

}
