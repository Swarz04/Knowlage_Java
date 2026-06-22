package a06.e1;

import java.util.List;
import java.util.stream.Stream;

public class CirclerFactoryImpl implements CirclerFactory{

    @Override
    public <T> Circler<T> leftToRight() {
        return new Circler<>(){
            private List<T> elements;
            private int counter = 0;

            @Override
            public void setSource(List<T> elements) {
                this.elements = elements;
                this.counter = 0;
            }

            @Override
            public T produceOne() {
                T t = this.elements.get(counter % this.elements.size());
                this.counter++;
                return t;
            }

            @Override
            public List<T> produceMany(int n) {
                return Stream.generate(() ->  produceOne()).limit(n).toList();
            }

        };
    }

    @Override
    public <T> Circler<T> alternate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alternate'");
    }

    @Override
    public <T> Circler<T> stayToLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stayToLast'");
    }

    @Override
    public <T> Circler<T> leftToRightSkipOne() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leftToRightSkipOne'");
    }

    @Override
    public <T> Circler<T> alternateSkipOne() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alternateSkipOne'");
    }

    @Override
    public <T> Circler<T> stayToLastSkipOne() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stayToLastSkipOne'");
    }

}
