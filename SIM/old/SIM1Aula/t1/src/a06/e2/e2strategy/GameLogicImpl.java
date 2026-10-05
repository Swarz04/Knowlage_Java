package a06.e2.e2strategy;

import java.util.Random;

public class GameLogicImpl implements GameLogic {

    private final int size;
    private final int[][] values;
    private final Random random = new Random();

    public GameLogicImpl(int size) {
        this.size = size;
        this.values = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                values[row][col] = random.nextInt(2) + 1;
            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getValueAt(int row, int col) {
        return values[row][col];
    }

    @Override
    public void fire() {
        for (int col = 0; col < size; col++) {
            for (int row = size - 1; row > 0; row--) {
                int lower = values[row][col];
                int upper = values[row - 1][col];
                if (lower != 0 && lower == upper) {
                    values[row][col] = lower + upper;
                    values[row - 1][col] = 0;
                    applyGravity(col);
                    break;
                }
            }
        }
    }

    @Override
    public boolean hasMoves() {
        for (int col = 0; col < size; col++) {
            for (int row = 1; row < size; row++) {
                int upper = values[row - 1][col];
                if (upper != 0 && upper == values[row][col]) {
                    return true;
                }
            }
        }
        return false;
    }

    private void applyGravity(int col) {
        int[] compacted = new int[size];
        int destinationRow = size - 1;

        for (int row = size - 1; row >= 0; row--) {
            if (values[row][col] != 0) {
                compacted[destinationRow--] = values[row][col];
            }
        }

        for (int row = 0; row < size; row++) {
            values[row][col] = compacted[row];
        }
    }
}
