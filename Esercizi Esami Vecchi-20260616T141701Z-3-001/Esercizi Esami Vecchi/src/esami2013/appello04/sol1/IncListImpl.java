package esami2013.appello04.sol1;

import java.util.*;

/*
 * This solution uses a Map<Integer,X> to retrieve elements by index in constant time
 * An additional max element is the next available index 
 */

public class IncListImpl<X> implements IncList<X> {
	
	private Map<Integer,X> map = new HashMap<>();
	private int max = 0;
	
	public IncListImpl(){}
	
	public int addNew(X x){
		if (x==null){
			throw new NullPointerException();
		}
		this.map.put(this.max, x);
		this.max++;
		return this.max-1;
	}
	
	public X getElement(int index){
		return this.map.get(index);
	}
	
	/*
	 * returns the index of an occurrence of X, or -1 if it is not there
	 */
	public int getPosition(X x){
		for (int i: this.map.keySet()){
			if (this.getElement(i).equals(x)){
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * removes the element at that index
	 * throws IllegalArgumentException if no such element exists
	 */
	public void remove(int index){
		if (this.map.containsKey(index)){
			this.map.remove(index);
		} else {
			throw new IllegalArgumentException("Can't remove "+index);
		}
	}
	
	public int size(){
		return this.map.size();
	}
	
	
	public Iterator<Integer> allOccurrences(X x){
		Set<Integer> set = new HashSet<Integer>();
		for (int i: this.map.keySet()){
			if (this.getElement(i).equals(x)){
				set.add(i);
			}
		}
		return set.iterator();
	} 
}
