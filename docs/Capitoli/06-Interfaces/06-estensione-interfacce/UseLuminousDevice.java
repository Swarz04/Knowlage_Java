/**
 * Esempio client aggiunto per mostrare che un LuminousDevice espone sia
 * le operazioni di Device sia quelle di Luminous.
 */
public final class UseLuminousDevice {

    private UseLuminousDevice() {
    }

    public static void main(final String[] args) {
        final LuminousDevice device = new Lamp();
        final LuminousDevice device2 = new Lamp();
        device.switchOn();
        device.bright();

        System.out.println("Accesa: " + device.isSwitchedOn());
        System.out.println("Classe runtime: "
            + device.getClass().getSimpleName());
        System.out.println("Nome classe: " + device.getClass().getSimpleName());
        System.out.println("Nome classe: " + device.getClass());
        System.out.println("Nome classe: " + device.toString());
        System.out.println("Nome classe: " + device2.toString());
    }
}
