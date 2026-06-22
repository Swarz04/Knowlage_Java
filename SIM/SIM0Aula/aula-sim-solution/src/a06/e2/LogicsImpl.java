package a06.e2;

import java.util.*;

public class LogicsImpl implements Logics {
    private final int size;
    private final List<Position> selected = new ArrayList<>();
    private int counter = 0;

    public LogicsImpl(int size) {
        this.size = size;
    }

    @Override
    public boolean selection(int x, int y) {
        if (x != 0 && x != this.size - 1 && y != 0 && y != this.size - 1){
            this.selected.add(new Position(x, y-1));
            this.selected.add(new Position(x, y+1));
            return true;
        }
        return false;
    }

    @Override
    public Position advance() {
        if (this.selected.size() == this.counter){
            return null;
        }
        var p = this.selected.get(this.counter);
        this.counter++;
        return p;
    }

}
