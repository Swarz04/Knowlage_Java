/**
 * Sorgente: 06-Interfaces.pdf, pagina 37.
 */
public final class UseDomusController {

    private UseDomusController() {
    }

    public static void main(final String[] args) {
        final DomusController dc = new DomusController(10);

        /*
         * Tutti questi assegnamenti sono validi perché ciascun oggetto
         * implementa Device (principio di sostituibilità).
         */
        dc.installDevice(0, new Lamp());
        dc.installDevice(1, new Lamp());
        dc.installDevice(2, new Lamp());
        dc.installDevice(3, new TV());
        dc.installDevice(4, new TV());
        dc.installDevice(5, new Radio());

        dc.switchAll(true);

        final boolean allOn = dc.isCompletelySwitchedOn();

        // Aggiunta tecnica per rendere visibile il risultato dell'esempio.
        System.out.println("Tutti i dispositivi installati sono accesi: " + allOn);
    }
}
