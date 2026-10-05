package a06.e2;

import javax.swing.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {

    private final int size;
    private final List<JButton> cells = new ArrayList<>();
    private final Random random = new Random();
    private final JButton fire = new JButton("Fire");

    public GUI(int size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*size, 100*size);
        this.size = size;

        JPanel main = new JPanel(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(main);
        main.add(BorderLayout.CENTER, panel);
        main.add(BorderLayout.SOUTH, fire);
        fire.addActionListener(e -> collasso());

        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                int value = random.nextInt(2) + 1;
                JButton jb = new JButton(Integer.toString(value));
                cells.add(jb);
                panel.add(jb);
            }
        }
        fire.setEnabled(esisteCoppia());
        this.setVisible(true);
    }

    private boolean esisteCoppia() {
    for (int colonna = 0; colonna < size; colonna++) {
        for (int riga = 1; riga < size; riga++) {
            String sopra = cells.get((riga - 1) * size + colonna).getText();
            String sotto = cells.get(riga * size + colonna).getText();

            if (!sopra.isBlank() && sopra.equals(sotto)) {
                return true;
            }
        }
    }
    return false;
}

    private void gravita(int colonna) {
    List<String> valori = new ArrayList<>();

    for (int riga = size - 1; riga >= 0; riga--) {
        String testo = cells.get(riga * size + colonna).getText();
        if (!testo.isBlank()) {
            valori.add(testo);
        }
    }

    for (int riga = 0; riga < size; riga++) {
        cells.get(riga * size + colonna).setText("");
    }

    for (int i = 0; i < valori.size(); i++) {
        int rigaDestinazione = size - 1 - i;
        cells.get(rigaDestinazione * size + colonna).setText(valori.get(i));
    }
}

    private void collasso() {
    for (int colonna = 0; colonna < size; colonna++) {
        for (int riga = size - 1; riga > 0; riga--) {
            JButton basso = cells.get(riga * size + colonna);
            JButton alto = cells.get((riga - 1) * size + colonna);

            String testoBasso = basso.getText();
            String testoAlto = alto.getText();

            // Le celle vuote vanno saltate.
            if (testoBasso.isBlank() || testoAlto.isBlank()) {
                continue;
            }

            int valoreBasso = Integer.parseInt(testoBasso);
            int valoreAlto = Integer.parseInt(testoAlto);

            if (valoreBasso == valoreAlto) {
                basso.setText(Integer.toString(valoreBasso + valoreAlto));
                alto.setText("");
                gravita(colonna);
                break; // una sola fusione in questa colonna
            }
        }
    }
    fire.setEnabled(esisteCoppia());
}


}
