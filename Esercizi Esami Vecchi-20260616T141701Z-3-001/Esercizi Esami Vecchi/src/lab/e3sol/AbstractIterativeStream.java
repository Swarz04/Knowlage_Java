package lab.e3sol;

public abstract class AbstractIterativeStream<T> implements Stream<T>{
	
	protected T current;

	public AbstractIterativeStream(T initial) {
		super();
		this.current = initial;
	}
	
	public T next(){
		T val = this.current;
		this.current = this.iterate();
		return val;
	}
	
	abstract protected T iterate();
}
