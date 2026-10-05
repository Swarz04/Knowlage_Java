package a05.e1;


/**
 * A factory of SignalGenerators of various types
 */
public interface SignalGeneratorFactory {

    /**
     * @param <E>
     * @param e1
     * @param n1
     * @param e2    
     * @param n2        
     *  
     * @return a generator that switches between two elements, producing n1 of the first, then n2 of the second, then again n1 of the first, and so on.
     * e.g. switchTwo("A", 2, "B", 3) produces: A, A, B, B, B, A, A, B, B, B, ...
     */
    <E> SignalGenerator<E> switchTwo(E e1, int n1, E e2, int n2);

    /**
     * @param start
     * @param n
     * @return a generator that produces an increasing sequence of integers, starting from start, producing n elements in total.
     * e.g. increasing(5, 7) produces: 5, 6, 7, 8, 9, 10, 11, 5, 6, 7, 8, 9, 10, 11, ...
     */
    SignalGenerator<Integer> increasing(int start, int n);

    /**
     * @param start
     * @param bound
     * @param n
     * @return a generator that produces an increasing sequence of integers, starting from start, producing n elements in total, but never exceeding bound.
     * e.g. increasingBounded(5, 9, 7) produces: 5, 6, 7, 8, 9, 9, 9, 5, 6, 7, 8, 9, 9, 9, ...
     */
    SignalGenerator<Integer> increasingBounded(int start, int bound, int n);

    /**
     * @param start
     * @param n
     * @return a generator that produces an increasing sequence of integers, starting from start, producing n elements in total, but each element is repeated twice.
     * e.g. increasingSlowed(5, 7) produces: 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, ...
     */
    SignalGenerator<Integer> increasingSlowed(int start, int n);

    /**
     * @param start
     * @param bound
     * @param n
     * @return a generator that produces an increasing sequence of integers, starting from start, producing n elements in total, but each element is repeated twice and never exceeds bound.
     * e.g. increasingSlowedAndBounded(5, 9, 7) produces: 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9, 9, 5, 5, 6, 6, ...
     */
    SignalGenerator<Integer> increasingSlowedAndBounded(int start, int bound, int n);

}
