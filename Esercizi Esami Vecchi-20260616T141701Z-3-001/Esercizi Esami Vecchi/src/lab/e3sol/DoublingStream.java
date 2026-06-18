package lab.e3sol;

/*
 * E' uno stream che produce valori raddoppiati ogni volta, rispetto
 * al valore iniziale fornito al costruttore.
 */

public class DoublingStream extends AbstractIterativeStream<Integer> {
	
	public DoublingStream(Integer initial) {
		super(initial);
	}
		
	protected Integer iterate(){
		return this.current * 2;
	}
}
