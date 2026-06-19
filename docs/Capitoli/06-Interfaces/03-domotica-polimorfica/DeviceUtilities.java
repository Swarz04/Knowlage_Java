/**
 * Sorgente: 06-Interfaces.pdf, pagine 31 e 43.
 *
 * Una sola funzione lavora con ogni Device presente o futuro.
 */
public final class DeviceUtilities {

    private DeviceUtilities() {
    }

    public static void switchOnIfCurrentlyOff(final Device device) {
        /*
         * Il tipo statico del parametro è Device. Il corpo concretamente
         * eseguito da queste chiamate viene scelto a runtime (late binding).
         */
        if (!device.isSwitchedOn()) {
            device.switchOn();
        }
    }
}
