package a01a.e2;

import java.util.HashSet;
import java.util.Set;

public class LogicImpl implements Logic {
    
    private final Set<Pair<Integer, Integer>> selected = new HashSet<>();
    private boolean over = false;

    @Override
    public boolean hit(int x, int y) {
        // Ignora i click a gioco finito o su celle già selezionate
        if (over || selected.contains(new Pair<>(x, y))) {
            return false;
        }
        
        selected.add(new Pair<>(x, y));
        
        long rowCount = selected.stream().filter(p -> p.getY().equals(y)).count();
        long colCount = selected.stream().filter(p -> p.getX().equals(x)).count();
        
        if (rowCount == 5 && colCount == 5) {
            over = true;
            return true; // Triggera l'evento di vittoria
        }
        
        return false;
    }

    @Override
    public boolean isOver() {
        return over;
    }

    @Override
    public boolean isSelected(int x, int y) {
        return selected.contains(new Pair<>(x, y));
    }
}