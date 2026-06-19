import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Supporto portabile per gli esempi di serializzazione.
 */
final class SerializationExampleFiles {

    static final Path DIRECTORY = Path.of(
        System.getProperty("java.io.tmpdir"),
        "oop16-input-output"
    );

    static final Path OBJECTS_FILE = DIRECTORY.resolve("objects.bin");
    static final Path TRANSIENT_FILE = DIRECTORY.resolve("transient.bin");
    static final Path AD_HOC_FILE = DIRECTORY.resolve("ad-hoc.bin");

    private SerializationExampleFiles() {
    }

    static void prepareDirectory() throws IOException {
        Files.createDirectories(DIRECTORY);
    }
}
