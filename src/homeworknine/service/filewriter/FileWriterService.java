package homeworknine.service.filewriter;

import homeworknine.entity.Student;

import java.io.*;
import java.util.List;

public class FileWriterService {

    private List<Student> studentList;
    private String fileNameTxt;
    private String fileNameBin;

    public FileWriterService(List<Student> studentList, String fileNameTxt, String fileNameBin) {
        this.studentList = studentList;
        this.fileNameTxt = fileNameTxt;
        this.fileNameBin = fileNameBin;
    }

    public void writeToTxtFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameTxt))) {
            writer.write(String.valueOf(studentList));
        } catch (IOException ex) {
            System.out.println("Some problem with writing to file: " + ex.getMessage());
        }
    }

    public void writeToFileBin() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileNameBin))) {
            oos.writeObject(studentList);
        } catch (Exception ex) {
            System.out.println("Some problem with writing to file: " + ex.getMessage());
        }
    }
}
