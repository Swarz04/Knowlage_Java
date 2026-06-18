package lab.e3;

/**
 * Rappresenta un produttore di elementi T, potenzialmente senza fine
 */

public interface Stream<T> {
	/** produce il prossimo elemento*/
	public T next();
}
