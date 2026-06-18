package esami2013.appello01.e1.sol1;

import java.util.*;

// Soluzione alternativa

public class RelationImplAlternate<X,Y> implements Relation<X,Y>{

	private static class Entry<X,Y>{
		private X x;
		private Y y;
		public Entry(X x, Y y) {
			super();
			this.x = x;
			this.y = y;
		}
		public X getX() {
			return x;
		}
		public Y getY() {
			return y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((x == null) ? 0 : x.hashCode());
			result = prime * result + ((y == null) ? 0 : y.hashCode());
			return result;
		}
		@SuppressWarnings("rawtypes")
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (x == null) {
				if (other.x != null)
					return false;
			} else if (!x.equals(other.x))
				return false;
			if (y == null) {
				if (other.y != null)
					return false;
			} else if (!y.equals(other.y))
				return false;
			return true;
		}
	}

	private Set<Entry<X,Y>> set = new HashSet<>();

	private void checkXY(X x,Y y){
		if (x==null || y==null){
			throw new NullPointerException();
		}
	}

	@Override
	public void set(X x, Y y) {
		this.checkXY(x,y);
		this.set.add(new Entry<>(x,y));
	}

	@Override
	public void unset(X x, Y y) {
		this.checkXY(x,y);
		this.set.remove(new Entry<>(x,y));
	}

	@Override
	public boolean holds(X x, Y y) {
		this.checkXY(x,y);
		return this.set.contains(new Entry<>(x,y));
	}

	@Override
	public int size() {
		return this.set.size();

	}

	@Override
	public Set<Y> relatedTo(X x) {
		Set<Y> s = new HashSet<>();
		for (Entry<X,Y> e: this.set){
			if (e.getX().equals(x)){
				s.add(e.getY());
			}
		}
		return s;
	}
}
