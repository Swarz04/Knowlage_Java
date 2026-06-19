import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Supporto portabile per gli esempi delle pagine 32-35.
 */
final class DataExampleFiles {

    static final Path DIRECTORY = Path.of(
        System.getProperty("java.io.tmpdir"),
        "oop16-input-output"
    );

    static final Path FILE = DIRECTORY.resolve("data-stream.bin");

    private DataExampleFiles() {
    }

    static void prepareDirectory() throws IOException {
        Files.createDirectories(DIRECTORY);
    }
}
