import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 43.
 */
public final class UseObjectStream {

    private UseObjectStream() {
    }

    public static void main(final String[] args) throws Exception {
        SerializationExampleFiles.prepareDirectory();

        try (
            OutputStream file =
                new FileOutputStream(SerializationExampleFiles.OBJECTS_FILE.toFile());
            OutputStream buffered = new BufferedOutputStream(file);
            ObjectOutputStream objects = new ObjectOutputStream(buffered)
        ) {
            objects.writeInt(10_000);
            objects.writeDouble(5.2);
            objects.writeObject(new Date());
            objects.writeObject(new Person("Rossi", 1960, false));
        }

        try (
            InputStream file =
                new FileInputStream(SerializationExampleFiles.OBJECTS_FILE.toFile());
            InputStream buffered = new BufferedInputStream(file);
            ObjectInputStream objects = new ObjectInputStream(buffered)
        ) {
            /*
             * Anche qui lettura e scrittura devono rispettare lo stesso ordine.
             * readObject() restituisce Object perché il tipo concreto è
             * registrato dentro lo stream e viene scoperto a runtime.
             */
            System.out.println(objects.readInt());
            System.out.println(objects.readDouble());
            System.out.println(objects.readObject());
            System.out.println(objects.readObject());
        }
    }
}
