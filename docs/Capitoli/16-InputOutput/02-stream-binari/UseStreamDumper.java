import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 21.
 *
 * Lo stesso StreamDumper riceve uno stream da memoria, uno da file e una
 * sottoclasse anonima costruita ad hoc.
 */
public final class UseStreamDumper {

    private UseStreamDumper() {
    }

    public static void main(final String[] args) throws IOException {
        BinaryExampleFiles.prepareDirectory();

        /*
         * Aggiunta tecnica: garantisce che il file esista anche se questo
         * esempio viene avviato prima di UseOutputStream.
         */
        if (!BinaryExampleFiles.FILE.toFile().exists()) {
            java.nio.file.Files.write(BinaryExampleFiles.FILE, new byte[] {1, 2, 3});
        }

        final byte[] bytes = {10, 20, 30};

        try (
            InputStream input = new ByteArrayInputStream(bytes);
            InputStream input2 = new FileInputStream(BinaryExampleFiles.FILE.toFile());
            InputStream input3 = new InputStream() {
                private int count = 100;
                private final Random random = new Random();

                @Override
                public int read() {
                    return this.count-- > 0 ? this.random.nextInt(256) : -1;
                }
            }
        ) {
            StreamDumper.dump(input);
            System.out.println();
            StreamDumper.dump(input2);
            System.out.println();
            StreamDumper.dump(input3);
            System.out.println();
        }
    }
}
