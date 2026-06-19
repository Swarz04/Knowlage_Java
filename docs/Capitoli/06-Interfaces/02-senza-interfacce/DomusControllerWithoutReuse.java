/**
 * Frammento schematico da 06-Interfaces.pdf, pagina 21.
 *
 * ATTENZIONE: il PDF presenta intenzionalmente soltanto uno schema e non
 * fornisce le definizioni di Lamp, TV, AirConditioner e Radio in questa
 * versione. Il file è quindi conservato come frammento NON AUTONOMO.
 *
 * Il problema progettuale mostrato è la duplicazione: switchAll deve avere
 * un ciclo quasi identico per ogni tipo concreto di dispositivo.
 */
public class DomusControllerWithoutReuse {

    private Lamp[] lamps;
    private TV[] tvs;
    private AirConditioner[] airs;
    private Radio[] radios;

    public void switchAll(final boolean on) {
        for (final Lamp lamp : this.lamps) {
            if (lamp != null) {
                if (on) {
                    lamp.switchOn();
                } else {
                    lamp.switchOff();
                }
            }
        }

        for (final TV tv : this.tvs) {
            if (tv != null) {
                if (on) {
                    tv.switchOn();
                } else {
                    tv.switchOff();
                }
            }
        }

        /*
         * Nel PDF seguono altri cicli analoghi per airs e radios.
         * Non vengono inventati qui: l'ellissi della slide evidenzia proprio
         * la scarsa riusabilità di questa soluzione.
         */
    }
}
