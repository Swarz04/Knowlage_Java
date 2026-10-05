package a06.e2;

import javax.swing.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Simple Swing grid that shows the coordinates of each clicked cell.
 */
public class GUI extends JFrame {

    private final int size;
    private final Map<JButton, Position> cells = new HashMap<>();
    private final List<Position> selected = new ArrayList<>();
    private int advanceStep = 0;
    private boolean started = false;

    /**
     * Builds a square board with the specified number of rows and columns.
     *
     * @param size the dimension of the grid
     */
    public GUI(int size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70 * size, 70 * size);
        this.size = size;

        JPanel panel = new JPanel(new GridLayout(size, size));
        this.getContentPane().add(panel);

        /* 2 - alla prima pressione di "ADVANCE" tutti i pulsanti in griglia si disattivano*/


        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        JButton advance = new JButton("ADVANCE");
        this.getContentPane().add(advance, BorderLayout.SOUTH);

        advance.addActionListener(e -> this.advance());

        ActionListener al = e -> {
        JButton jb = (JButton) e.getSource();
            if (posValid(jb)) {
                jb.setText("o");
                this.selected.add(this.cells.get(jb));
            }
        };


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final JButton jb = new JButton();
                this.cells.put(jb, new Position(j, i));
                jb.setText("");
                jb.addActionListener(al);
                panel.add(jb);
            }
        }
        this.setVisible(true);

    }

        /*
        * 0 - alla partenza tutte le celle della griglia sono vuote
        *
        * 1 - l'utente seleziona clickando un certo numero di caselle (ognuna riporterà un "o"), che non
        * devono stare nel bordo e non devono essere tra loro adiacenti (se lo fa, il click viene ignorato)
        */

        private boolean posValid(final JButton jb) {

            Position p = this.cells.get(jb);
            if (p.x() == 0 || p.x() == size - 1 ||
                    p.y() == 0 || p.y() == size - 1) {
                System.out.println("Cella " + p + " non valida: e' sul bordo.");
                return false;
            }

            boolean vicinoAUnaSelezionata = this.cells.entrySet().stream()
                    .filter(e -> e.getKey().getText().equals("o"))
                    .map(Map.Entry::getValue)
                    .anyMatch(q -> {
                        int distanzaX = Math.abs(p.x() - q.x());
                        int distanzaY = Math.abs(p.y() - q.y());
                        boolean adiacente = distanzaX <= 1 && distanzaY <= 1;

                        System.out.printf(
                                "Confronto %s con %s: dx=%d, dy=%d, adiacente=%b%n",
                                p, q, distanzaX, distanzaY, adiacente);
                        return adiacente;
                    });

            boolean valida = !vicinoAUnaSelezionata;
            System.out.println("Cella " + p + (valida ? " valida." : " non valida: adiacente a un 'o'."));
            return valida;
        }
    /* 2 - alla prima pressione di "ADVANCE" tutti i pulsanti in griglia si disattivano
     * 3 - ad ogni pressione del pulsante "ADVANCE" (anche alla prima) appare un "*" secondo questo ordine:
     * -- cella sopra al primo "o" che fu selezionato,
     * -- cella sotto al primo "o" che fu selezionato,
     * Quindi significa 2 advance step per ogni cella data da SIZE
     * -- cella sopra al secondo "o" che fu selezionato,
     * -- cella sotto al secondo "o" che fu selezionato,
     * -- e così via...
    */
   private void advance() {
    // Prima pressione: blocca tutti i pulsanti della griglia
    if (!this.started) {
        this.started = true;
        this.cells.keySet().forEach(button -> button.setEnabled(false));
    }

    // Dopo aver mostrato tutte le stelle, chiudi alla pressione successiva
    if (this.advanceStep == this.selected.size() * 2) {
        this.dispose(); // chiude la finestra
        return;
    }

    Position circle = this.selected.get(this.advanceStep / 2);

    // step pari: sopra; step dispari: sotto
    int deltaY = this.advanceStep % 2 == 0 ? -1 : 1;
    Position starPosition = new Position(circle.x(), circle.y() + deltaY);

    JButton target = this.cells.entrySet().stream()
            .filter(e -> e.getValue().equals(starPosition))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElseThrow();

    target.setText("*");
    this.advanceStep++;
    }
}
