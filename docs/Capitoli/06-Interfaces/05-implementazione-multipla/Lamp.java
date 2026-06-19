/**
 * Sorgente: 06-Interfaces.pdf, pagina 48.
 *
 * La slide lascia i corpi come "...". Questa ricostruzione minima riprende
 * la logica della Lamp delle pagine 8-9 per mostrare concretamente che una
 * sola classe può rispettare contemporaneamente due contratti.
 */
public class Lamp implements Device, Luminous {

    private static final int MIN_INTENSITY = 0;
    private static final int MAX_INTENSITY = 10;

    private boolean switchedOn;
    private int intensity;

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
    public void dim() {
        if (this.intensity > MIN_INTENSITY) {
            this.intensity--;
        }
    }

    @Override
    public void bright() {
        if (this.intensity < MAX_INTENSITY) {
            this.intensity++;
        }
    }

    public int getIntensityLevel() {
        return this.intensity;
    }
}
