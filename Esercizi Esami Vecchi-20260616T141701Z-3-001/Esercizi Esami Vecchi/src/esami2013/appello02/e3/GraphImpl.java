package esami2013.appello02.e3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphImpl<N, W> implements Graph<N, W> {

	private final Map<N, Map<N, W>> map = new HashMap<>();

	@Override
	public void addNode(final N n) {
		Objects.requireNonNull(n);

		if (map.containsKey(n)) {
			throw new IllegalArgumentException();
		} else {
			map.put(n, new HashMap<>());
		}
	}

	@Override
	public void removeNode(final N n) {
		Objects.requireNonNull(n);
		
		if(map.containsKey(n)){
			if(map.get(n).isEmpty()){
				map.remove(n);
			}else{
				throw new IllegalArgumentException();
			}
		}
	}

	@Override
	public boolean hasNode(final N n) {
		Objects.requireNonNull(n);
		return map.containsKey(n);
	}

	@Override
	public void addEdge(final N n1, final N n2, final W w) {
		Objects.requireNonNull(n1);
		Objects.requireNonNull(n2);
		Objects.requireNonNull(w);
		
		if(map.containsKey(n1) && map.containsKey(n2) && !map.get(n1).containsKey(n2)){
			map.get(n1).put(n2, w);
		}else{
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public void removeEdge(final N n1, final N n2) {
		Objects.requireNonNull(n1);
		Objects.requireNonNull(n2);
		
		this.throwExceptionIfHasntNode(n1);
		this.throwExceptionIfHasntNode(n2);
		
		if(map.get(n1).containsKey(n2)){
			map.get(n1).remove(n2);
		}
	}

	@Override
	public W weight(final N n1, final N n2) {
		Objects.requireNonNull(n1);
		Objects.requireNonNull(n2);
		
		this.throwExceptionIfHasntNode(n1);
		this.throwExceptionIfHasntNode(n2);
		
		if(map.get(n1).containsKey(n2)){
			return map.get(n1).get(n2);
		}else{
			return null;
		}
	}

	@Override
	public Set<N> allNodes() {
		return map.keySet();
	}

	@Override
	public Set<Pair<N, W>> outgoing(final N n) {
		Objects.requireNonNull(n);
		
		this.throwExceptionIfHasntNode(n);
		
		return map.get(n).entrySet().stream().map(e->new Pair<>(e.getKey(),e.getValue())).collect(Collectors.toSet());
	}

	@Override
	public Set<N> neighbours(final N n) {
		Objects.requireNonNull(n);
		
		this.throwExceptionIfHasntNode(n);
		
		return map.get(n).entrySet().stream().map(e->e.getKey()).collect(Collectors.toSet());
	}

	@Override
	public Set<N> neighbours(final Set<N> s) {
		Objects.requireNonNull(s);
		
		return s.stream().flatMap(setEntry->this.neighbours(setEntry).stream()).collect(Collectors.toSet());
	}
	
	private boolean throwExceptionIfHasntNode(final N n){
		if(map.containsKey(n)){
			return true;
		}else{
			throw new IllegalArgumentException();
		}
	}
}
