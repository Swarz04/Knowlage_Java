package a05.sol1;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * SignalGeneratorFactoryImpl
 */
public class SignalGeneratorFactoryImpl implements SignalGeneratorFactory {

    private <E> SignalGenerator<E> fromStream(Supplier<Stream<E>> streamSupplier) {
        return new SignalGenerator<>() {

            private Iterator<E> iterator = Stream.generate(streamSupplier).flatMap(s -> s).iterator();
            private E current = iterator.next();

            @Override
            public void advance() {
                this.current = iterator.next();
            }

            @Override
            public E get() {
                return this.current;
            }
        };
    }
    

    @Override
    public <E> SignalGenerator<E> switchTwo(E e1, int n1, E e2, int n2) {
        return fromStream(() ->switchTwoStream(e1, n1, e2, n2));
    }


    private <E> Stream<E> switchTwoStream(E e1, int n1, E e2, int n2) {
        return Stream.concat(
                Stream.generate(() -> e1).limit(n1),
                Stream.generate(() -> e2).limit(n2)
        );
    }

    private Stream<Integer> bounded(int bound, Stream<Integer> stream) {
        return stream.map(i -> i >= bound ? bound : i);
    }

     private <E>Stream<E> slowed(Stream<E> stream) {
        return stream.flatMap(i -> Stream.of(i, i));
    }


    @Override
    public SignalGenerator<Integer> increasing(int start, int n) {
        return fromStream(() -> increasingStream(start, n));
    }


    private Stream<Integer> increasingStream(int start, int n) {
        return Stream.iterate(start, i -> i + 1).limit(n);
    }

    @Override
    public SignalGenerator<Integer> increasingBounded(int start, int bound, int n) {
        return fromStream(() -> bounded(bound, increasingStream(start, n)));
    }


    @Override
    public SignalGenerator<Integer> increasingSlowed(int start, int n) {
        return fromStream(() -> slowed(increasingStream(start, n)));
    }


    @Override
    public SignalGenerator<Integer> increasingSlowedAndBounded(int start, int bound, int n) {
        return fromStream(() -> bounded(bound, slowed(increasingStream(start, n))));
    }



}
