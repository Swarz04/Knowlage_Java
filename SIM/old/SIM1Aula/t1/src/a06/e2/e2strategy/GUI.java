package a06.e2.e2strategy;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GUI extends JFrame {

    private final GameLogic logic;
    private final JButton[][] cells;
    private final JButton fire = new JButton("Fire");

    public GUI(GameLogic logic) {
        this.logic = logic;
        int size = logic.getSize();
        this.cells = new JButton[size][size];

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100 * size, 100 * size);

        JPanel main = new JPanel(new BorderLayout());
        JPanel grid = new JPanel(new GridLayout(size, size));
        this.getContentPane().add(main);
        main.add(BorderLayout.CENTER, grid);
        main.add(BorderLayout.SOUTH, fire);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                JButton cell = new JButton();
                cells[row][col] = cell;
                grid.add(cell);
            }
        }

        fire.addActionListener(e -> {
            logic.fire();
            updateView();
            fire.setEnabled(logic.hasMoves());
        });

        updateView();
        fire.setEnabled(logic.hasMoves());
        this.setVisible(true);
    }

    private void updateView() {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                int value = logic.getValueAt(row, col);
                cells[row][col].setText(value == 0 ? "" : Integer.toString(value));
            }
        }
    }
}
