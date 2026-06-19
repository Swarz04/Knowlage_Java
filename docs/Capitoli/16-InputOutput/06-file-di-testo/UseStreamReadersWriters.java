import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 68.
 *
 * InputStreamReader e OutputStreamWriter sono ponti tra stream di byte e
 * stream di caratteri. Qui la codifica UTF-16 è indicata esplicitamente.
 */
public final class UseStreamReadersWriters {

    private UseStreamReadersWriters() {
    }

    public static void main(final String[] args) throws Exception {
        TextExampleFiles.prepareDirectory();

        try (
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(TextExampleFiles.FILE.toFile()),
                    StandardCharsets.UTF_16
                )
            )
        ) {
            writer.write("Prova");
            writer.newLine();
            writer.write("di file");
            writer.newLine();
        }

        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(TextExampleFiles.FILE.toFile()),
                    StandardCharsets.UTF_16
                )
            )
        ) {
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
        }
    }
}
