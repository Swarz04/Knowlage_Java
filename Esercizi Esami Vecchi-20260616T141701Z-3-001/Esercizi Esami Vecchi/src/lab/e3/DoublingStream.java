package lab.e3;

/**
 * E' uno stream che produce valori raddoppiati ogni volta, rispetto
 * al valore iniziale fornito al costruttore.
 */

public class DoublingStream implements Stream<Integer>{
	
	private int current;

	public DoublingStream(int initial) {
		super();
		this.current = initial;
	}
	
	public Integer next(){
		int val = this.current;
		this.current = this.current * 2;
		return val;
	}
}
