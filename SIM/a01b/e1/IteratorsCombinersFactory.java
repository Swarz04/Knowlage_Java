import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import java.util.*;


public class IteratorsCombinersFactory implements IteratorsCombiners {

    public <X, Y, Z> Iterator<Z> genericCombiner(
        Iterator<X> i1,
        Iterator<Y> i2,
        BiFunction<Iterator<X>, Iterator<Y>, List<Z>> function) {

        return new Iterator<>() {
            List<Z> cache = new LinkedList<>();

            @Override
            public boolean hasNext() {
                checkCache();
                return !cache.isEmpty();
            }

            private void checkCache() {
                if (cache.isEmpty()) {
                    cache.addAll(function.apply(i1,i2));
                }
            }

            @Override
            public Z next() {
                checkCache();
                System.out.println("Cache: " + cache);
                return cache.remove(0);
            }
        };
    }

    public <X> Iterator<X> alternate(Iterator<X> i1, Iterator<X> i2) {
        return genericCombiner(i1, i2, (it1, it2) ->  Stream.of(i1, i2)
        .filter(Iterator::hasNext)
        .map(Iterator::next)
        .toList()
    );
    };


    public <X> Iterator<X> seq(Iterator<X> i1, Iterator<X> i2) {
        return genericCombiner(i1, i2, (it1, it2) ->
        it1.hasNext() ? //se i1 ha un elemento successivo, restituisco una lista con quell'elemento
        List.of(it1.next()) :
        it2.hasNext() ? //se i1 non ha un elemento successivo, ma i2 sì, restituisco una lista con quell'elemento
        List.of(it2.next()) :
        List.of() //altrimenti lista vuota
    );
    };

    public <X, Y, Z> Iterator<Z> genericMap2(Iterator<X> i1, Iterator<Y> i2, BiFunction<X, Y, Z> function) {
        return genericCombiner(i1, i2, (it1, it2) -> it1.hasNext() && it2.hasNext() ?
        List.of(function.apply( it1.next(), it2.next() )) :
        Collections.emptyList() //altrimenti lista vuota
        );
    }
    public <X> Iterator<X> map2(Iterator<X> i1, Iterator<X> i2, BinaryOperator<X> operation) {
        return genericMap2(i1, i2, operation);
    }

    public <X, Y, Z> Iterator<Pair<X, Y>> zip(Iterator<X> i1, Iterator<Y> i2) {
        return genericMap2(i1, i2,Pair::new);
    }

}
