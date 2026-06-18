package esami2013.appello01.e1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class RelationImpl<X, Y> implements Relation<X, Y> {

	private final Map<X, Set<Y>> relationMap = new HashMap<>();

	@Override
	public void set(X x, Y y) {
		Objects.requireNonNull(x);
		Objects.requireNonNull(y);

		if (!this.relationMap.containsKey(x)) {
			this.relationMap.put(x, new HashSet<>(Arrays.asList(y)));
		} else if (!this.relationMap.get(x).contains(y)) {
			this.relationMap.get(x).add(y);
		}
	}

	@Override
	public void unset(X x, Y y) {
		Objects.requireNonNull(x);
		Objects.requireNonNull(y);

		if (this.holds(x, y)) {
			this.relationMap.get(x).remove(y);
		}
	}

	@Override
	public boolean holds(X x, Y y) {
		Objects.requireNonNull(x);
		Objects.requireNonNull(y);

		return this.relationMap.containsKey(x)
				&& this.relationMap.get(x).contains(y);
	}

	@Override
	public int size() {
		return (int) this.relationMap.entrySet().stream()
				.flatMap(e -> e.getValue().stream()).count();
	}

	@Override
	public Set<Y> relatedTo(X x) {
		Objects.requireNonNull(x);
		
		if(this.relationMap.containsKey(x)){
			return this.relationMap.get(x);
		}else{
			return new HashSet<>();
		}
	}

}
