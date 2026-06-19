/**
 * Sorgente: 06-Interfaces.pdf, pagina 30.
 *
 * Versione precedente all'uso dell'interfaccia: la stessa logica viene
 * sovraccaricata e duplicata per ogni tipo concreto.
 */
public final class DeviceUtilitiesBefore {

    private DeviceUtilitiesBefore() {
    }

    public static void switchOnIfCurrentlyOff(final Lamp lamp) {
        if (!lamp.isSwitchedOn()) {
            lamp.switchOn();
        }
    }

    public static void switchOnIfCurrentlyOff(final TV tv) {
        if (!tv.isSwitchedOn()) {
            tv.switchOn();
        }
    }

    public static void switchOnIfCurrentlyOff(final Radio radio) {
        if (!radio.isSwitchedOn()) {
            radio.switchOn();
        }
    }
}
