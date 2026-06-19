/**
 * Sorgente: 06-Interfaces.pdf, pagine 43-44.
 *
 * La slide 44 mostra il concetto in forma di frammento. Per renderlo un
 * programma Java autonomo sono stati:
 * - aggiunti public ai metodi che implementano I;
 * - inseriti gli statement client in main;
 * - corretto il refuso "implememts" in "implements".
 */
interface I {

    void m();
}

class C1 implements I {

    @Override
    public void m() {
        System.out.println("I'm an instance of C1");
    }
}

class C2 implements I {

    @Override
    public void m() {
        System.out.println("I'm an instance of C2");
    }

    public static void m2() {
        System.out.println("I'm a static method of C2");
    }
}

public final class BindingDemo {

    private BindingDemo() {
    }

    public static void main(final String[] args) {
        /*
         * Il tipo statico di i è I, noto al compilatore.
         * Il tipo runtime sarà C1 oppure C2.
         */
        final I i = Math.random() > 0.5 ? new C1() : new C2();

        /*
         * Late/dynamic binding: il metodo d'istanza da eseguire viene scelto
         * usando la classe runtime dell'oggetto riferito da i.
         */
        i.m();

        /*
         * Early/static binding: m2 appartiene alla classe C2, non a un
         * oggetto, quindi la destinazione della chiamata è già determinata.
         */
        C2.m2();
    }
}
