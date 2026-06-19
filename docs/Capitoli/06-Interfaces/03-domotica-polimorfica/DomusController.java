/**
 * Sorgente: 06-Interfaces.pdf, pagine 33-35.
 *
 * Il controllore dipende dall'astrazione Device anziché dalle classi
 * concrete Lamp, TV e Radio. Per questo può gestirle nello stesso array
 * ed è aperto a future implementazioni del contratto.
 */
public class DomusController {

    /*
     * Ogni cella può contenere null oppure un oggetto di qualsiasi classe
     * che implementi Device.
     */
    private final Device[] devices;

    public DomusController(final int size) {
        this.devices = new Device[size];
    }

    public void installDevice(final int position, final Device dev) {
        this.devices[position] = dev;
    }

    public void removeDevice(final int position) {
        this.devices[position] = null;
    }

    public Device getDevice(final int position) {
        return this.devices[position];
    }

    public void switchAll(final boolean on) {
        for (final Device dev : this.devices) {
            if (dev != null) {
                /*
                 * Delegazione polimorfica: a runtime Java eseguirà il metodo
                 * della classe concreta dell'oggetto (Lamp, TV, Radio...).
                 */
                if (on) {
                    dev.switchOn();
                } else {
                    dev.switchOff();
                }
            }
        }
    }

    public boolean isCompletelySwitchedOn() {
        for (final Device dev : this.devices) {
            if (dev != null && !dev.isSwitchedOn()) {
                return false;
            }
        }
        /*
         * Se non è installato alcun dispositivo il risultato è true:
         * non esiste infatti un dispositivo installato che sia spento.
         */
        return true;
    }
}
