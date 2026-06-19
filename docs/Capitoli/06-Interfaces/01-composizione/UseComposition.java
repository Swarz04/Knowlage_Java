/**
 * Esempio eseguibile aggiunto per collegare i sorgenti delle pagine 8-19.
 * Non è una trascrizione di una specifica slide.
 */
public final class UseComposition {

    private UseComposition() {
    }

    public static void main(final String[] args) {
        final TwoLampsDevice device = new TwoLampsDevice();
        device.switchOnBoth();
        device.ecoMode();
        System.out.println(device);

        final LampsRow row = new LampsRow(3);
        row.installLamp(0, new Lamp());
        row.installLamp(2, new Lamp());
        row.switchAll(true);

        System.out.println("Lampada in posizione 0 accesa: "
            + row.getLamp(0).isSwitchedOn());
        System.out.println("Posizione 1 occupata: " + row.isInstalled(1));
    }
}
