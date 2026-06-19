import java.io.Serializable;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 42.
 *
 * Serializable è un'interfaccia marker: non dichiara metodi, ma comunica
 * a ObjectOutputStream che gli oggetti della classe possono essere salvati.
 */
public final class Person implements Serializable {

    private static final long serialVersionUID = 567742502623265945L;

    private final String name;
    private final int birthYear;
    private final boolean married;

    public Person(
        final String name,
        final int birthYear,
        final boolean married
    ) {
        this.name = name;
        this.birthYear = birthYear;
        this.married = married;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.birthYear + ":"
            + (this.married ? "spos" : "non-spos");
    }
}
