package esami2013.appello01.e1.sol1;

import java.util.*;

public class RelationImpl<X,Y> implements Relation<X,Y>{

	private Map<X,Set<Y>> map = new HashMap<>();
	private int size = 0;

	private void checkXY(X x,Y y){
		if (x==null || y==null){
			throw new NullPointerException();
		}
	}

	@Override
	public void set(X x, Y y) {
		this.checkXY(x, y);
		Set<Y> s = this.map.get(x);
		if (s==null){
			this.map.put(x, s = new HashSet<>());
		}
		if (!s.contains(y)){
			s.add(y);
			this.size++;
		}
	}

	@Override
	public void unset(X x, Y y) {
		if (this.holds(x,y)){
			this.map.get(x).remove(y);
			this.size--;
		}
	}

	@Override
	public boolean holds(X x, Y y) {
		this.checkXY(x, y);
		Set<Y> s = this.map.get(x);
		return s!=null && this.map.get(x).contains(y);
	}

	@Override
	public int size() {
		return this.size;

	}

	@Override
	public Set<Y> relatedTo(X x) {
		Set<Y> s = this.map.get(x);
		return s == null ? new HashSet<Y>() : s;
	}

}
