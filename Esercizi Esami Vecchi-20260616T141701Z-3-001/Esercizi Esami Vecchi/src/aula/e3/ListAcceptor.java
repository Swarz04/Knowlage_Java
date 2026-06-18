package aula.e3;

import java.util.Iterator;
import java.util.List;

public class ListAcceptor<X> implements Acceptor<X> {

	private final Iterator<X> listIterator;
	private boolean lastAnswer = true;
	
	public ListAcceptor(final List<X> list) {
		this.listIterator = list.iterator();
	}
	
	@Override
	public boolean accept(final X x) {
		if(lastAnswer == true){
			this.lastAnswer = listIterator.hasNext() ? listIterator.next().equals(x) : false;
		}
		return this.lastAnswer;
	}

}
