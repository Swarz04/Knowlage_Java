package a01a.e2;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<Pair<Integer, Integer>, JButton> cells = new HashMap<>();
    private final Logic logic;
    
    public GUI(int size) {
        this.logic = new LogicImpl();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100 * size, 100 * size);
        
        JPanel panel = new JPanel(new GridLayout(size, size));
        this.getContentPane().add(panel);
                
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final int x = j; 
                final int y = i; 
                final JButton jb = new JButton("");
                
                jb.addActionListener(e -> {
                    // 2.4 - Se il gioco è finito, qualsiasi click chiude l'app
                    if (logic.isOver()) {
                        System.exit(0);
                    }
                    
                    // Protezione visiva: non fare nulla se la cella ha già "*"
                    if (logic.isSelected(x, y)) {
                        return;
                    }
                    
                    // 1 - Compare l'asterisco
                    jb.setText("*");
                    
                    // Condizione di innesco finale
                    if (logic.hit(x, y)) {
                        
                        // 2.2 - Numera e disabilita la riga (da sx a dx)
                        int rCount = 0;
                        for (int c = 0; c < size; c++) {
                            if (c != x && logic.isSelected(c, y)) {
                                JButton b = cells.get(new Pair<>(c, y));
                                b.setText(String.valueOf(rCount++));
                                b.setEnabled(false);
                            }
                        }
                        
                        // 2.3 - Numera e disabilita la colonna (dall'alto al basso)
                        int cCount = 0;
                        for (int r = 0; r < size; r++) {
                            if (r != y && logic.isSelected(x, r)) {
                                JButton b = cells.get(new Pair<>(x, r));
                                b.setText(String.valueOf(cCount++));
                                b.setEnabled(false);
                            }
                        }
                    }
                });
                
                this.cells.put(new Pair<>(x, y), jb);
                panel.add(jb);
            }
        }
        this.setVisible(true);
    }
}