package a06.e2;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private final Map<JButton, Position> cells = new HashMap<>();
    private final Logics logics;
    
    public GUI(int size) {
        this.logics = new LogicsImpl(size);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70 * size, 70 * size);
    
        JPanel mainPanel = new JPanel(new BorderLayout()); 
        JPanel panel = new JPanel(new GridLayout(size, size));
        this.getContentPane().add(mainPanel);
        mainPanel.add(BorderLayout.CENTER, panel);
        JButton advanceButton = new JButton("ADVANCE");
        mainPanel.add(BorderLayout.SOUTH, advanceButton);
        advanceButton.addActionListener(e -> {
            this.cells.keySet().forEach(jb -> jb.setEnabled(false));
            Position p = this.logics.advance();
            if (p == null){
                System.exit(0);
            }
            for (var entry: cells.entrySet()){
                if (entry.getValue().equals(p)){
                    entry.getKey().setText("*");
                }
            }
        });
        

        ActionListener al = e -> {
            var jb = (JButton) e.getSource();
            boolean b = this.logics.selection(cells.get(jb).x(), cells.get(jb).y());
            if (b){
                jb.setText("o");
            }
        };

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final JButton jb = new JButton();
                this.cells.put(jb, new Position(j, i));
                jb.addActionListener(al);
                panel.add(jb);
            }
        }
        this.setVisible(true);
    }
}
