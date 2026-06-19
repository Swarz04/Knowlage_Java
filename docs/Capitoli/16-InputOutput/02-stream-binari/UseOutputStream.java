import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 23.
 */
public final class UseOutputStream {

    private UseOutputStream() {
    }

    public static void main(final String[] args) throws IOException {
        BinaryExampleFiles.prepareDirectory();

        try (OutputStream output =
                new FileOutputStream(BinaryExampleFiles.FILE.toFile())) {
            final Random random = new Random();
            for (int i = 0; i < 100; i++) {
                /*
                 * write(int) usa soltanto gli otto bit meno significativi.
                 */
                output.write(random.nextInt(256));
            }

            final byte[] bytes = {10, 20, 30, 40};
            for (int i = 0; i < 10; i++) {
                output.write(bytes);
            }
        }

        System.out.println("Scritto: " + BinaryExampleFiles.FILE);
    }
}
