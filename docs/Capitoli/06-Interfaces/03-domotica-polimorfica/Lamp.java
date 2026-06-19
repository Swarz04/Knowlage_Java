/**
 * Sorgente: pagine 8-9 e adattamento "implements Device" di pagina 26.
 *
 * Una Lamp è sia del tipo concreto Lamp sia del tipo astratto Device.
 */
public class Lamp implements Device {

    private static final int LEVELS = 10;
    private static final double DELTA = 0.1;

    private int intensity;
    private boolean switchedOn;

    public Lamp() {
        this.switchedOn = false;
        this.intensity = 0;
    }

    /*
     * public è obbligatorio: non è possibile implementare un metodo public
     * dell'interfaccia riducendone la visibilità.
     */
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

    private void correctIntensity() {
        if (this.intensity < 0) {
            this.intensity = 0;
        } else if (this.intensity > LEVELS) {
            this.intensity = LEVELS;
        }
    }

    public void setIntensity(final double value) {
        this.intensity = Math.round((float) (value / DELTA));
        this.correctIntensity();
    }

    public void dim() {
        this.intensity--;
        this.correctIntensity();
    }

    public void brighten() {
        this.intensity++;
        this.correctIntensity();
    }

    public double getIntensity() {
        return this.intensity * DELTA;
    }

    @Override
    public String toString() {
        return "Lamp[on=" + this.switchedOn
            + ", intensity=" + this.getIntensity() + "]";
    }
}
