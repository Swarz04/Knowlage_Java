import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 67.
 *
 * FileReader/FileWriter usano la codifica predefinita della JVM.
 * BufferedReader aggiunge readLine(); BufferedWriter aggiunge buffering e
 * newLine(), che usa il separatore di riga della piattaforma.
 */
public final class UseReadersWriters {

    private UseReadersWriters() {
    }

    public static void main(final String[] args) throws Exception {
        TextExampleFiles.prepareDirectory();

        try (
            BufferedWriter writer =
                new BufferedWriter(new FileWriter(TextExampleFiles.FILE.toFile()))
        ) {
            writer.write("Prova");
            writer.newLine();
            writer.write("di file");
            writer.newLine();
        }

        try (
            BufferedReader reader =
                new BufferedReader(new FileReader(TextExampleFiles.FILE.toFile()))
        ) {
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
            /*
             * readLine() restituisce null quando non esistono altre righe.
             */
            System.out.println(reader.readLine());
        }

        try (
            BufferedReader reader =
                new BufferedReader(new FileReader(TextExampleFiles.FILE.toFile()))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
