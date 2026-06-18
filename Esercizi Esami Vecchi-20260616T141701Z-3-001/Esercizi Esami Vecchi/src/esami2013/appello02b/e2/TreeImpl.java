package esami2013.appello02b.e2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class TreeImpl<N> implements Tree<N> {

	private final Map<N, List<N>> treeMap = new HashMap<>();

	@Override
	public void addNode(final N node, final N father) {
		Objects.requireNonNull(node);
		if (treeMap.isEmpty() && father != null) {
			throw new IllegalArgumentException();
		} else if (!treeMap.isEmpty()) {
			if (!this.hasNode(father)) {
				throw new IllegalArgumentException();
			}
		}

		treeMap.compute(node, (k, v) -> {
			v = new LinkedList<>();
			v.add(father);
			if (father != null) {
				treeMap.get(father).add(node);
			}
			return v;
		});

	}

	@Override
	public int size() {
		return treeMap.size();
	}

	@Override
	public N father(final N node) {
		if (this.hasNode(node)) {
			return treeMap.get(node).get(0);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public boolean hasNode(final N node) {
		Objects.requireNonNull(node);
		return treeMap.containsKey(node);
	}

	@Override
	public Set<N> nodes() {
		return treeMap.keySet();
	}

	@Override
	public Set<N> children(final N node) {
		if (this.hasNode(node)) {
			return new HashSet<>(treeMap.get(node).subList(1,
					treeMap.get(node).size()));
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void removeNode(final N node) {
		if (this.hasNode(node) && treeMap.get(node).get(0) != null) {
			final List<N> tempList = treeMap.get(node);
			treeMap.get(tempList.get(0)).remove(node);
			treeMap.get(tempList.get(0)).addAll(
					tempList.subList(1, tempList.size()));
			treeMap.remove(node);
		} else {
			throw new IllegalArgumentException();
		}
	}

}
