package a05.sol1;

/**
 * A generator of an infinite sequence of elements
 */
public interface SignalGenerator<E> {

    /** 
     * @return the element currently produced (an operation without side effects)
     */
    E get();

    /**
     * advances the generator to the next element
     */
    void advance();
}
