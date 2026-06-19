import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Supporto portabile per gli esempi delle pagine 67-69.
 */
final class TextExampleFiles {

    static final Path DIRECTORY = Path.of(
        System.getProperty("java.io.tmpdir"),
        "oop16-input-output"
    );

    static final Path FILE = DIRECTORY.resolve("testo.txt");

    private TextExampleFiles() {
    }

    static void prepareDirectory() throws IOException {
        Files.createDirectories(DIRECTORY);
    }
}
