package aula.e3;

public class SequenceAcceptor<X> implements Acceptor<X> {

	private final Acceptor<X> firstAcceptor;
	private final Acceptor<X> secondAcceptor;
	
	public SequenceAcceptor(final Acceptor<X> ac1, final Acceptor<X> ac2){
		this.firstAcceptor = ac1;
		this.secondAcceptor = ac2;
	}
	
	@Override
	public boolean accept(final X x) {
		return this.firstAcceptor.accept(x) ? true : this.secondAcceptor.accept(x);
	}

}
