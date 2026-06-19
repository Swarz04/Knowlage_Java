import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 24.
 *
 * Variante con oggetto File e gestione locale di IOException.
 */
public final class UseOutputStream2 {

    private UseOutputStream2() {
    }

    public static void main(final String[] args) {
        try {
            BinaryExampleFiles.prepareDirectory();

            try (OutputStream output =
                    new FileOutputStream(new File(BinaryExampleFiles.FILE.toString()))) {
                final Random random = new Random();
                for (int i = 0; i < 100; i++) {
                    output.write(random.nextInt(256));
                }

                final byte[] bytes = {10, 20, 30, 40};
                for (int i = 0; i < 10; i++) {
                    output.write(bytes);
                }
            }
        } catch (final IOException exception) {
            System.out.println("Something went wrong: " + exception.getMessage());
        }
    }
}
