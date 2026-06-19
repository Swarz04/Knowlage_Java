/**
 * Sorgente: 06-Interfaces.pdf, pagine 10-12 e UML a pagina 17.
 *
 * Esempio di composizione: TwoLampsDevice "ha" esattamente due Lamp.
 * Il codice riusa Lamp invece di duplicarne campi e logica (principio DRY).
 */
public class TwoLampsDevice {

    /*
     * final rende immutabili i riferimenti: dopo il costruttore non potranno
     * indicare lampade diverse. Le Lamp restano però oggetti mutabili.
     */
    private final Lamp l1;
    private final Lamp l2;

    public TwoLampsDevice() {
        this.l1 = new Lamp();
        this.l2 = new Lamp();
    }

    /**
     * Il getter espone il riferimento all'oggetto interno, non una copia.
     * Il client può quindi modificare direttamente la prima Lamp.
     */
    public Lamp getFirst() {
        return this.l1;
    }

    public Lamp getSecond() {
        return this.l2;
    }

    /**
     * Delegazione: il dispositivo realizza l'operazione inoltrando il lavoro
     * alle due Lamp che lo compongono.
     */
    public void switchOnBoth() {
        this.l1.switchOn();
        this.l2.switchOn();
    }

    public void switchOffBoth() {
        this.l1.switchOff();
        this.l2.switchOff();
    }

    public void ecoMode() {
        this.l1.switchOff();
        this.l2.switchOn();
        this.l2.setIntensity(0.5);
    }

    @Override
    public String toString() {
        return "TwoLampsDevice[l1=" + this.l1 + ", l2=" + this.l2 + "]";
    }
}
