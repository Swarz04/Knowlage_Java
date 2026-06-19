import java.io.IOException;
import java.io.InputStream;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 20.
 *
 * Utility polimorfica: lavora con qualunque sottoclasse di InputStream.
 * Non chiude lo stream perché la risorsa appartiene al chiamante.
 */
public final class StreamDumper {

    private StreamDumper() {
    }

    public static void dump(final InputStream input) throws IOException {
        for (int value; (value = input.read()) != -1;) {
            System.out.print(value + "\t");
        }
    }
}
