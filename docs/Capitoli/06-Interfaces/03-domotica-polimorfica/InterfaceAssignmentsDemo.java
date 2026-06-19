/**
 * Sorgente: 06-Interfaces.pdf, pagina 29.
 *
 * Mostra la differenza tra tipo statico della variabile e classe concreta
 * dell'oggetto a cui essa fa riferimento.
 */
public final class InterfaceAssignmentsDemo {

    private InterfaceAssignmentsDemo() {
    }

    public static void main(final String[] args) {
        final Lamp lamp = new Lamp();
        lamp.switchOn();
        final boolean b = lamp.isSwitchedOn();

        Device dev;
        dev = new Lamp();
        dev.switchOn();
        final boolean b2 = dev.isSwitchedOn();

        final Device dev2 = new Lamp();

        /*
         * Vietato: un'interfaccia non descrive come costruire un oggetto.
         * Device dev3 = new Device();
         */

        System.out.println("Lamp accesa: " + b);
        System.out.println("Device accesa: " + b2);
        System.out.println("Classe runtime di dev2: "
            + dev2.getClass().getSimpleName());
    }
}
