import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Supporto tecnico portabile per gli esempi delle pagine 21-25.
 */
final class BinaryExampleFiles {

    static final Path DIRECTORY = Path.of(
        System.getProperty("java.io.tmpdir"),
        "oop16-input-output"
    );

    static final Path FILE = DIRECTORY.resolve("stream.bin");

    private BinaryExampleFiles() {
    }

    static Path prepareDirectory() throws IOException {
        return Files.createDirectories(DIRECTORY);
    }
}
