package homeworknine.service.filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileReaderService {

    private final String fileNameBin;

    public FileReaderService(String fileNameBin) {
        this.fileNameBin = fileNameBin;
    }

    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileNameBin));) {
            System.out.println(ois.readObject());
        } catch (FileNotFoundException ex) {
            System.out.println("Some problem with reading(FileNotFoundException): " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Some problem with reading(IOException): " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Some problem with reading(ClassNotFoundException): " + ex.getMessage());
        }
    }
}
