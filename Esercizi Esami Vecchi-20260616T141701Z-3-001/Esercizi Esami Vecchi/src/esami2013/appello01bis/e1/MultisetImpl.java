package esami2013.appello01bis.e1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MultisetImpl<X> implements Multiset<X> {

	private final Map<X, Integer> map = new HashMap<>();

	@Override
	public void add(final X x) {
		map.compute(x, (k, v) -> v == null ? 1 : v + 1);
	}

	@Override
	public void remove(final X x) {
		if (map.containsKey(x)) {
			if (map.get(x) > 1) {
				map.compute(x, (k, v) -> v = v - 1);
			} else {
				map.remove(x);
			}
		} else {
			throw new IllegalArgumentException(
					"The map doesn't contain the key");
		}
	}

	@Override
	public int countElements(final X x) {
		final Integer count = map.get(x);
		return count == null ? 0 : count;
	}

	@Override
	public int size() {
		return map.entrySet().stream().mapToInt(e -> e.getValue()).sum();
	}

	@Override
	public Set<X> set() {
		return map.keySet();
	}

	@Override
	public boolean contains(final Multiset<X> m) {

		for (final X x : this.set()) {
			if (this.countElements(x) < m.countElements(x)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return map.toString();
	}

}
