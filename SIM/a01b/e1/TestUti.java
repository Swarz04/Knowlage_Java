
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class TestUti {
    public static void main(String[] args) {

        List<Integer> l1 = List.of(1, 2, 3);
        List<Integer> l2 = List.of(4, 5, 6);

        Iterator<Integer> i1 = l1.iterator();
        Iterator<Integer> i2 = l2.iterator();

        System.out.println("Iterator 1: " + l1);
        System.out.println("Iterator 2: " + l2);

        BiFunction<Iterator<Integer>, Iterator<Integer>, Collection<Integer>> function =
            (it1, it2) -> {
                List<Integer> risultato = new ArrayList<>();

                it1.forEachRemaining(risultato::add);
                it2.forEachRemaining(risultato::add);

                return risultato;
            };

        List<Integer> cache = new ArrayList<>();

        cache.addAll(function.apply(i1, i2));

        System.out.println("Cache: " + cache);
        System.out.println("Dimensione: " + cache.size());
        System.out.println("Contiene 3: " + cache.contains(3));
        System.out.println(Stream.of(i1, i2).filter(Iterator::hasNext).map(Iterator::next).toList());
    }
}
