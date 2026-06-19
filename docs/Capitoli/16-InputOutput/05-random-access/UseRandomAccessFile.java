import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 60.
 *
 * RandomAccessFile mantiene un cursore e permette di spostarlo con seek().
 * Non è una sottoclasse di InputStream/OutputStream, ma implementa le
 * operazioni di DataInput e DataOutput.
 */
public final class UseRandomAccessFile {

    private static final Path DIRECTORY = Path.of(
        System.getProperty("java.io.tmpdir"),
        "oop16-input-output"
    );

    private static final Path FILE = DIRECTORY.resolve("random-access.bin");

    private UseRandomAccessFile() {
    }

    public static void main(final String[] args) throws IOException {
        Files.createDirectories(DIRECTORY);

        try (RandomAccessFile file = new RandomAccessFile(FILE.toFile(), "rw")) {
            /*
             * Aggiunta tecnica: azzera un eventuale file di esecuzioni
             * precedenti, così il risultato rimane riproducibile.
             */
            file.setLength(0);

            for (int i = 0; i < 100_000; i++) {
                System.out.println("writing: " + i);
                file.writeInt(i);
            }

            /*
             * Ogni int occupa 4 byte: l'elemento 23000 inizia a 23000 * 4.
             */
            file.seek(23_000L * Integer.BYTES);
            System.out.println(
                "reading in position 23000*4: " + file.readInt()
            );

            file.setLength(800_000);
            System.out.println("extending the size");

            file.seek(123_000L * Integer.BYTES);
            System.out.println(
                "reading in position 123000*4: " + file.readInt()
            );
        }
    }
}
