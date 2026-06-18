package esami2013.appello06.sol3;

import java.util.List;

/*
 * This implementation of Stream simply wraps a java.util.List, and produces just all of its elements,
 * orederly.
 */

public class ListStream<X> implements Stream<X>{
	
	private int pos = 0;
	private List<X> list;
	
	public ListStream(List<X> list){
		this.list = list;
	}

	public X getNextElement() throws java.util.NoSuchElementException{
		if (pos >= list.size()){
			throw new java.util.NoSuchElementException("out of range");
		}
		return list.get(pos++);
	}
}
