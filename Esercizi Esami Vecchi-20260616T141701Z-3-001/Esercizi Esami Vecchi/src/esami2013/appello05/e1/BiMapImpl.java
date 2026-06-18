package esami2013.appello05.e1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class BiMapImpl<X, Y> implements BiMap<X, Y> {

	private final Map<X,Y> XtoY = new HashMap<>();
	private final Map<Y,X> YtoX = new HashMap<>();
	
	@Override
	public void put(final X x, final Y y) {
		Objects.requireNonNull(x);
		Objects.requireNonNull(y);
		
		if(YtoX.containsKey(y) || XtoY.containsKey(x)){
			throw new IllegalArgumentException();
		}else{
			XtoY.put(x, y);
			YtoX.put(y, x);
		}
	}

	@Override
	public X getX(final Y y) {
		return YtoX.get(y);
	}

	@Override
	public Y getY(final X x) {
		return XtoY.get(x);
	}

	@Override
	public boolean hasXY(final X x, final Y y) {
		return XtoY.containsKey(x) && YtoX.containsKey(y);
	}

	@Override
	public void remove(final X x, final Y y) {
		if(this.hasXY(x, y)){
			XtoY.remove(x);
			YtoX.remove(y);
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public int size() {
		return XtoY.size();
	}

	@Override
	public Set<X> allX() {
		return XtoY.keySet();
	}

	@Override
	public Set<Y> allY() {
		return YtoX.keySet();
	}

}
