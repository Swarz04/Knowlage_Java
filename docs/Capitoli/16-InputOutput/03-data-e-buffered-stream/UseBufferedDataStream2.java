import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Sorgente: 16-InputOutput.pdf, pagina 35.
 *
 * Stesso comportamento di UseBufferedDataStream, con constructor chaining.
 * È più compatto, ma rende meno visibili i singoli strati della decorazione.
 */
public final class UseBufferedDataStream2 {

    private UseBufferedDataStream2() {
    }

    public static void main(final String[] args) throws IOException {
        DataExampleFiles.prepareDirectory();

        try (
            DataOutputStream data = new DataOutputStream(
                new BufferedOutputStream(
                    new FileOutputStream(DataExampleFiles.FILE.toFile())
                )
            )
        ) {
            data.writeBoolean(true);
            data.writeInt(10_000);
            data.writeDouble(5.2);
            data.writeUTF("Prova");
        }

        try (
            DataInputStream data = new DataInputStream(
                new BufferedInputStream(
                    new FileInputStream(DataExampleFiles.FILE.toFile())
                )
            )
        ) {
            System.out.println(data.readBoolean());
            System.out.println(data.readInt());
            System.out.println(data.readDouble());
            System.out.println(data.readUTF());
        }
    }
}
