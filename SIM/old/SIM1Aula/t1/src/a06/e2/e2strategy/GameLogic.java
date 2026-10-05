package a06.e2.e2strategy;

public interface GameLogic {
    int getSize();
    int getValueAt(int row, int col);
    void fire();
    boolean hasMoves();
}
