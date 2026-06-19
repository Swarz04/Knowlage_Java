/**
 * Sorgente: 06-Interfaces.pdf, pagina 18 e UML a pagina 19.
 *
 * Composizione con molteplicità 0..N: l'array stabilisce il numero massimo
 * di posizioni, mentre null indica che una posizione non ospita una Lamp.
 */
public class LampsRow {

    private final Lamp[] row;

    public LampsRow(final int size) {
        /*
         * new Lamp[size] crea l'array, non le Lamp.
         * Tutte le celle contengono inizialmente null.
         */
        this.row = new Lamp[size];
    }

    public void installLamp(final int position, final Lamp lamp) {
        this.row[position] = lamp;
    }

    public void removeLamp(final int position) {
        this.row[position] = null;
    }

    public void switchAll(final boolean on) {
        for (final Lamp lamp : this.row) {
            /*
             * Il controllo è indispensabile: invocare un metodo tramite null
             * produrrebbe una NullPointerException.
             */
            if (lamp != null) {
                if (on) {
                    lamp.switchOn();
                } else {
                    lamp.switchOff();
                }
            }
        }
    }

    public Lamp getLamp(final int position) {
        return this.row[position];
    }

    public boolean isInstalled(final int position) {
        return this.row[position] != null;
    }
}
