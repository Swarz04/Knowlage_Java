import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 32.
 *
 * DataInputStream e DataOutputStream decorano stream di byte aggiungendo
 * codifica e decodifica dei tipi primitivi e delle stringhe writeUTF.
 */
public final class UseDataStream {

    private UseDataStream() {
    }

    public static void main(final String[] args) throws IOException {
        DataExampleFiles.prepareDirectory();

        try (
            OutputStream file = new FileOutputStream(DataExampleFiles.FILE.toFile());
            DataOutputStream data = new DataOutputStream(file)
        ) {
            data.writeBoolean(true);
            data.writeInt(10_000);
            data.writeUTF("Ciao");
            data.writeDouble(5.2);
        }

        try (
            InputStream file = new FileInputStream(DataExampleFiles.FILE.toFile());
            DataInputStream data = new DataInputStream(file)
        ) {
            /*
             * Tipo e ordine di lettura devono corrispondere esattamente
             * all'ordine di scrittura: il file non contiene nomi dei campi.
             */
            System.out.println(data.readBoolean());
            System.out.println(data.readInt());
            System.out.println(data.readUTF());
            System.out.println(data.readDouble());
        }
    }
}
