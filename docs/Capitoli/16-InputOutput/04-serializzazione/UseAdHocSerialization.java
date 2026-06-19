import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 53.
 */
public final class UseAdHocSerialization {

    private UseAdHocSerialization() {
    }

    public static void main(final String[] args) throws Exception {
        SerializationExampleFiles.prepareDirectory();

        try (
            ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(SerializationExampleFiles.AD_HOC_FILE.toFile())
            )
        ) {
            final APerson person = new APerson("Rossi");
            person.used();
            System.out.println(person);
            output.writeObject(person);
        }

        System.out.println("Ri-carico l'oggetto...");

        try (
            ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(SerializationExampleFiles.AD_HOC_FILE.toFile())
            )
        ) {
            final APerson loaded = (APerson) input.readObject();
            System.out.println(loaded);
        }
    }
}
