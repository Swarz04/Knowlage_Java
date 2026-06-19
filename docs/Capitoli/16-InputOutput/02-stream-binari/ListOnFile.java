import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 25.
 *
 * Esempio di codifica manuale: ogni Byte della lista occupa un byte nel file.
 */
public final class ListOnFile {

    private ListOnFile() {
    }

    public static void main(final String[] args) throws IOException {
        BinaryExampleFiles.prepareDirectory();

        final List<Byte> list = new ArrayList<>(20);
        final byte[] array = new byte[20];
        new Random().nextBytes(array);
        for (final byte value : array) {
            list.add(value);
        }
        System.out.println("Prima: " + list);

        try (OutputStream file =
                new FileOutputStream(BinaryExampleFiles.FILE.toFile())) {
            for (final byte value : list) {
                file.write(value);
            }
        }

        try (InputStream file =
                new FileInputStream(BinaryExampleFiles.FILE.toFile())) {
            final List<Byte> loaded = new ArrayList<>();
            int value;
            while ((value = file.read()) != -1) {
                /*
                 * read() produce 0..255; il cast ricostruisce il byte signed
                 * originale nell'intervallo -128..127.
                 */
                loaded.add((byte) value);
            }
            System.out.println("Dopo: " + loaded);
        }
    }
}
