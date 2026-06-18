package aula.e3sol;

public class SequenceAcceptor<X> implements Acceptor<X> {

	private Acceptor<X> one;
	private Acceptor<X> two;
	
	public SequenceAcceptor(Acceptor<X> one, Acceptor<X> two){
		this.one = one;
		this.two = two;
	}
	// torna false se il valore non è stato accettato
	public boolean accept(X x){
		return this.one.accept(x) || this.two.accept(x);
	}
}
