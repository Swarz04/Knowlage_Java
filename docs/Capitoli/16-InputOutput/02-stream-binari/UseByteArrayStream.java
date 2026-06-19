import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 18.
 *
 * ByteArrayInputStream adatta un byte[] all'astrazione InputStream.
 */
public final class UseByteArrayStream {

    private UseByteArrayStream() {
    }

    public static void main(final String[] args) throws IOException {
        final byte[] bytes = {10, 20, -1, 40, -58};
        final InputStream input = new ByteArrayInputStream(bytes);

        try {
            int value;
            while ((value = input.read()) != -1) {
                /*
                 * read() restituisce int tra 0 e 255; -1 è riservato all'EOF.
                 * Perciò il byte Java -1 viene letto come 255 e -58 come 198.
                 */
                System.out.println(value);
            }
        } finally {
            input.close();
        }
    }
}
