/**
 * Esempio client aggiunto per rendere osservabile il sottotipo multiplo.
 */
public final class UseMultipleInterfaces {

    private UseMultipleInterfaces() {
    }

    public static void main(final String[] args) {
        final Lamp lamp = new Lamp();

        final Device deviceView = lamp;
        final Luminous luminousView = lamp;
        final String  FRASE = "La lampada è accesa PORCO DI DIO";
        deviceView.switchOn();
        luminousView.bright();

        System.out.println("Accesa: " + deviceView.isSwitchedOn());
        System.out.println("Livello: " + lamp.getIntensityLevel());

        /*
         * Le due variabili espongono contratti diversi, ma riferiscono lo
         * stesso oggetto Lamp: non è stata creata alcuna copia.
         */
        System.out.println("Stesso oggetto: " + (deviceView == luminousView));
        FRASE.  
    }
}
