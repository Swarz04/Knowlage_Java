package aula.e3sol;

import java.util.*;

public class ListAcceptor<X> implements Acceptor<X> {

	private Iterator<X> iterator;
	
	public ListAcceptor(List<X> list){
		this.iterator = list.iterator();
	}
	// torna false se il valore non è stato accettato
	public boolean accept(X x){
		if (!this.iterator.hasNext()){
			return false;
		}
		return this.iterator.next() == x;
	}
}
