/**
 * Pagine di riferimento: 24, 26, 27, 31 e 37.
 *
 * Il PDF dichiara e usa Radio come implementazione di Device, ma ne omette
 * il corpo con "...". Questa è un'aggiunta tecnica minima per rendere
 * autonomo l'esempio di UseDomusController: viene modellato soltanto lo
 * stato richiesto dal contratto Device.
 */
public class Radio implements Device {

    private boolean switchedOn;

    @Override
    public void switchOn() {
        this.switchedOn = true;
    }

    @Override
    public void switchOff() {
        this.switchedOn = false;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.switchedOn;
    }

    @Override
    public String toString() {
        return "Radio[on=" + this.switchedOn + "]";
    }
}
