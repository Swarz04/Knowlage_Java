import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 50.
 */
public final class UseTransient {

    private UseTransient() {
    }

    public static void main(final String[] args) throws Exception {
        SerializationExampleFiles.prepareDirectory();

        try (
            ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(SerializationExampleFiles.TRANSIENT_FILE.toFile())
            )
        ) {
            final CPerson person = new CPerson("Rossi", 1960, false);
            System.out.println("Prima stampa: " + person);
            System.out.println("Seconda stampa: " + person);

            /*
             * La slide crea un secondo oggetto per la scrittura: la sua cache
             * è null e, essendo transient, non viene salvata.
             */
            output.writeObject(new CPerson("Rossi", 1960, false));
        }

        System.out.println("Ri-carico l'oggetto...");

        try (
            ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(SerializationExampleFiles.TRANSIENT_FILE.toFile())
            )
        ) {
            final CPerson loaded = (CPerson) input.readObject();
            System.out.println("Prima stampa: " + loaded);
            System.out.println("Seconda stampa: " + loaded);
        }
    }
}
