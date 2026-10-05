package a05.sol2;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class LogicImpl implements Logic {

    private final int size;
    private Set<Position> positions = new HashSet<>();
    private boolean isOver = false;

    public LogicImpl(int size) {
        this.size = size;
    }

    @Override
    public boolean hit(Position pos) {
        var center = centerOf(pos);
        if (center.isPresent()){
            this.positions.remove(center.get());
            this.isOver = true;
            return true;
        }
        for (int i=0; i < size; i++){
            for (int j=0; j< size; j++){
                var p2 = new Position(i,j);
                if (isSelected(p2) && isInStar(pos, p2)){
                    return false;
                }
            }
        }
        this.positions.add(pos);
        return true;
    }

    private Optional<Position> centerOf(Position pos){
        return this.positions.stream().filter(p -> isInStar(p, pos)).findAny();
    }

    @Override
    public boolean isSelected(Position pos) {
        return this.centerOf(pos).isPresent();
    }

    private boolean isInStar(Position center, Position p) {
        return (center.x() - center.y() == p.x() - p.y() || center.x() + center.y() == p.x() + p.y()) && 
                Math.abs(center.y() - p.y()) <= 2 && Math.abs(center.x() - p.x()) <= 2;
    }

    @Override
    public boolean isOver() {
        return this.isOver;
    }

}
