package aula.e3;

public interface Acceptor<X> {

	/*
	 *  torna false se il valore non è stato accettato
	 *  da lì in poi tornerà sempre false 
	 */
	boolean accept(X x);
	
}
