import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 69.
 *
 * System.in è un InputStream; System.out è un PrintStream.
 */
public final class SystemInOut {

    private SystemInOut() {
    }

    public static void main(final String[] args) throws Exception {
        TextExampleFiles.prepareDirectory();

        final InputStream input = System.in;
        final BufferedReader reader =
            new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));

        /*
         * Non chiudiamo reader: chiuderlo chiuderebbe anche System.in,
         * risorsa globale della JVM.
         */
        System.out.println(reader.readLine());

        final PrintStream output = System.out;
        output.println("Un comando noto");
        output.format(
            "Altro comando noto... %d %f %s%n",
            10,
            20.2,
            "prova"
        );

        try (
            PrintStream fileOutput = new PrintStream(
                TextExampleFiles.FILE.toFile(),
                StandardCharsets.UTF_8
            )
        ) {
            fileOutput.println("prova");
            fileOutput.print(10);
            fileOutput.println();
        }
    }
}
