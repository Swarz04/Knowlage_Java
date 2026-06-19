import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 19.
 *
 * try-with-resources chiude automaticamente ogni risorsa AutoCloseable,
 * anche quando il blocco termina per un'eccezione.
 */
public final class UseTryWithResources {

    private UseTryWithResources() {
    }

    public static void main(final String[] args) throws IOException {
        final byte[] bytes = {10, 20, 30, 40, 50};

        try (InputStream input = new ByteArrayInputStream(bytes)) {
            int value;
            while ((value = input.read()) != -1) {
                System.out.println(value);
            }
        }
    }
}
