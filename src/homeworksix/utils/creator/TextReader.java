package homeworksix.utils.creator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {

    public static String readAllBytesJava7(String file) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(file)));
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, file: " + file + " not found" + "" +
                    "\n" + "Please, put file in this location");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Sorry, error reading file: " + file);
            System.exit(1);
        }
        return content;
    }
}
