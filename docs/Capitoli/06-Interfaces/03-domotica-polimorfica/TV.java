/**
 * Sorgente: 06-Interfaces.pdf, pagina 36.
 *
 * TV realizza lo stesso contratto di Lamp con una propria implementazione.
 * DomusController non deve conoscere questi dettagli.
 */
public class TV implements Device {

    private boolean switchedOn;

    public TV() {
        this.switchedOn = false;
    }

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
        return "I'm a TV";
    }
}
