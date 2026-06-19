import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Sorgente: 16-InputOutput.pdf, pagine 11-12.
 *
 * File non rappresenta il contenuto del file: rappresenta un path nel file
 * system e permette di interrogarne proprietà e metadati.
 */
public final class UseFile {

    public static final String SEP = File.separator;

    /*
     * Nelle slide il path è costruito sotto user.home.
     * Modifica tecnica: usiamo java.io.tmpdir per rendere l'esempio portabile
     * e non creare cartelle permanenti nella home dell'utente.
     */
    public static final String FILE_NAME = Path.of(
        System.getProperty("java.io.tmpdir"),
        "oop16-input-output",
        "prova.bin"
    ).toString();

    private UseFile() {
    }

    /**
     * Reflection: seleziona i metodi pubblici senza parametri il cui nome
     * sembra essere un accessore. L'ordine restituito non è garantito.
     *
     * final Class<?> type = tipo di cui vogliamo gli accessori
     */
    private static Iterable<Method> accessors(final Class<?> type) {
        final Collection<Method> list = new ArrayList<>();
        for (final Method method : type.getMethods()) { //type.getMethods() recupera tramite reflection tutti i metodi public
            if (method.getParameterTypes().length == 0
                && method.getName().matches("has.*|is.*|get.*|can.*")) {
                list.add(method);
            }
        }
        return list;
    }

    public static void main(final String[] args) throws Exception {
        final File file = new File(args.length == 0 ? FILE_NAME : args[0]);
        System.out.println("accessors of " + File.class.getMethods().length + " methods: " + accessors(File.class).size());
        for (final Method method : accessors(File.class)) {
            System.out.println(method.getName() + " " + method.invoke(file));
        }
    }
}
