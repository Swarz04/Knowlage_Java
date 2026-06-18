package esami2013.appello04.e1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class IncListImpl<X> implements IncList<X> {

	private final Map<Integer,X> map = new HashMap<>();
	private int counter;
	
	@Override
	public int addNew(final X x) {
		Objects.requireNonNull(x);
		
		map.put(counter, x);
		
		return this.counter++;
	}

	@Override
	public X getElement(final int index) {
		return map.get(index);
	}

	@Override
	public int getPosition(final X x) {
		return map.entrySet().stream().filter(e->e.getValue().equals(x)).map(e->e.getKey()).findAny().orElse(-1);
	}

	@Override
	public void remove(final int index) {
		if(map.containsKey(index)){
			map.remove(index);
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Iterator<Integer> allOccurrences(final X x) {
		return map.entrySet().stream().filter(e->e.getValue().equals(x)).map(e->e.getKey()).collect(Collectors.toList()).iterator();
	}

}
