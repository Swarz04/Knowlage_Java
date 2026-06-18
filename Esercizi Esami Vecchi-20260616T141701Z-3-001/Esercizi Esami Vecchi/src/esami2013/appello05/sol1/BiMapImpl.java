package esami2013.appello05.sol1;

import java.util.*;

/*
 * This solution uses two maps, from x to y and from y to x
 * This allows to access both directions in constant time
 */

public class BiMapImpl<X,Y> implements BiMap<X,Y> {
	
	private Map<X,Y> mapx = new HashMap<>();
	private Map<Y,X> mapy = new HashMap<>();
	
	public BiMapImpl(){}

	@Override
	public void put(X x, Y y) {
		if (x==null || y==null){
			throw new NullPointerException();
		}
		if (getX(y)!=null || getY(x)!=null){
			throw new IllegalArgumentException();
		}
		this.mapx.put(x, y);
		this.mapy.put(y, x);
	}

	@Override
	public X getX(Y y) {
		return this.mapy.get(y);
	}

	@Override
	public Y getY(X x) {
		return this.mapx.get(x);
	}

	@Override
	public boolean hasXY(X x, Y y) {
		Y y2 = this.mapx.get(x);
		return y2 != null && y2.equals(y);
	}

	@Override
	public void remove(X x, Y y) {
		if (!hasXY(x,y)){
			throw new IllegalArgumentException();
		}
		this.mapx.remove(x);
		this.mapy.remove(y);
	}

	@Override
	public int size() {
		return this.mapx.size();
	}

	@Override
	public Set<X> allX() {
		return this.mapx.keySet();
	}

	@Override
	public Set<Y> allY() {
		return this.mapy.keySet();
	}

}
