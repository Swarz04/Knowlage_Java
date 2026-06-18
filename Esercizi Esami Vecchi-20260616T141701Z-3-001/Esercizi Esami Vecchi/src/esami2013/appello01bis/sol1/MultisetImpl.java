package esami2013.appello01bis.sol1;

import java.util.*;

/*
 * It models a binary relation (possibly non symmetrical), with elements of type X and of type Y
 */
public class MultisetImpl<X> implements Multiset<X>{
	
	private Map<X,Integer> map = new HashMap<>();
	private int size = 0;
	
	@Override
	public void add(X x){
		this.map.put(x, this.countElements(x)+1);
		this.size++;
	}
	
	// throws IllegalArgumentException
	@Override
	public void remove(X x){
		int i = countElements(x);
		if (i==0){
			throw new IllegalArgumentException("There is no such element");
		}
		this.map.put(x, this.countElements(x)-1);
		this.size--;
	}
	
	// 0 if not there
	@Override
	public int countElements(X x){
		Integer i = this.map.get(x);
		return i == null ? 0 : i;
	}
	
	// how many elements
	@Override
	public int size(){
		return this.size;
	}
	
	// Given x, it orderly iterates over all y in relation with x
	@Override
	public Set<X> set(){
		return this.map.keySet();
	}

	@Override
	public boolean contains(Multiset<X> m) {
		for (X x: m.set()){
			if (m.countElements(x) > this.countElements(x)){
				return false;
			}
		}
		return true;
	}
	
	
}
