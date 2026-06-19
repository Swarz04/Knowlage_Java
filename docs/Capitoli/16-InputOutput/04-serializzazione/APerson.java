import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 52.
 *
 * lastUse è transient, ma readObject assegna una nuova data al momento della
 * deserializzazione. È una serializzazione personalizzata "ad hoc".
 */
public final class APerson implements Serializable {

    private static final long serialVersionUID = -8985026380526620812L;

    private final String name;
    private transient Date lastUse = new Date();

    public APerson(final String name) {
        this.name = name;
    }

    public void used() {
        this.lastUse = new Date();
    }

    @Override
    public String toString() {
        return this.name + ":"
            + (this.lastUse == null ? "null" : this.lastUse.getTime());
    }

    private void writeObject(final ObjectOutputStream output)
            throws IOException {
        /*
         * Salva normalmente tutti i campi non statici e non transient.
         */
        output.defaultWriteObject();
        System.err.println("writing");
    }

    /**
     * È richiamato da ObjectInputStream durante la deserializzazione;
     * svolge un ruolo simile a un costruttore di ripristino.
     */
    private void readObject(final ObjectInputStream input)
            throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        System.err.println("reading");
        this.lastUse = new Date();
    }
}
