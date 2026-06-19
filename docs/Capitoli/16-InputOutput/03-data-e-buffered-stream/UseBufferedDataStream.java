import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 34.
 *
 * Catena dei decoratori:
 * DataOutputStream -> BufferedOutputStream -> FileOutputStream.
 */
public final class UseBufferedDataStream {

    private UseBufferedDataStream() {
    }

    public static void main(final String[] args) throws IOException {
        DataExampleFiles.prepareDirectory();

        try (
            OutputStream file = new FileOutputStream(DataExampleFiles.FILE.toFile());
            OutputStream buffered = new BufferedOutputStream(file);
            DataOutputStream data = new DataOutputStream(buffered)
        ) {
            data.writeBoolean(true);
            data.writeInt(10_000);
            data.writeDouble(5.2);
            /*
             * writeUTF usa il "modified UTF-8" di DataOutput, non un normale
             * file di testo UTF-8.
             */
            data.writeUTF("Prova");
        }

        try (
            InputStream file = new FileInputStream(DataExampleFiles.FILE.toFile());
            InputStream buffered = new BufferedInputStream(file);
            DataInputStream data = new DataInputStream(buffered)
        ) {
            System.out.println(data.readBoolean());
            System.out.println(data.readInt());
            System.out.println(data.readDouble());
            System.out.println(data.readUTF());
        }
    }
}
