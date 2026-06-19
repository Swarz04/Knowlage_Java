/**
 * Sorgente: 06-Interfaces.pdf, pagine 8-9.
 *
 * Una Lamp incapsula due aspetti del proprio stato:
 * - se è accesa;
 * - l'intensità, memorizzata come livello intero tra 0 e LEVELS.
 *
 * L'intensità pubblica è invece un double tra 0.0 e 1.0. Questa scelta
 * separa la rappresentazione interna dall'interfaccia offerta ai client.
 */
public class Lamp {

    private static final int LEVELS = 10;
    private static final double DELTA = 0.1;

    private int intensity;
    private boolean switchedOn;

    public Lamp() {
        this.switchedOn = false;
        this.intensity = 0;
    }

    public void switchOn() {
        this.switchedOn = true;
    }

    public void switchOff() {
        this.switchedOn = false;
    }

    public boolean isSwitchedOn() {
        return this.switchedOn;
    }

    /**
     * Mantiene l'invariante 0 <= intensity <= LEVELS.
     * È private perché serve soltanto all'implementazione della classe.
     */
    private void correctIntensity() {
        if (this.intensity < 0) {
            this.intensity = 0;
        } else if (this.intensity > LEVELS) {
            this.intensity = LEVELS;
        }
    }

    /**
     * Converte il valore pubblico nel livello discreto usato internamente.
     * Math.round evita che piccoli errori floating-point scelgano il livello
     * immediatamente inferiore.
     */
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

    /**
     * Aggiunta tecnica: nella pagina 9 il corpo di toString() è tagliato
     * dal bordo della slide. Questa implementazione minima non è presentata
     * come trascrizione letterale, ma rende leggibili gli esempi autonomi.
     */
    @Override
    public String toString() {
        return "Lamp[switchedOn=" + this.switchedOn
            + ", intensity=" + this.getIntensity() + "]";
    }
}
