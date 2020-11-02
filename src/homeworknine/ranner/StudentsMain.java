package homeworknine.ranner;

import homeworknine.entity.Student;
import homeworknine.service.collectioncreator.StudentCreator;
import homeworknine.service.comparator.StudentMarkComparator;
import homeworknine.service.comparator.StudentNameComparator;
import homeworknine.utils.ScannerHelper;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentsMain {
    private static final String FILENAME_TXT = "students.txt";
    private static final String FILENAME_TOP_TXT = "topStudents.txt";
    private static final String FILENAME_BIN = "students.bin";
    private static final String FILENAME_TOP_BIN = "topStudents.bin";

    public static void main(String[] args) {
        String path;
        int topNStudentsFromList;
        StudentMarkComparator markComparator = new StudentMarkComparator();
        StudentNameComparator nameComparator = new StudentNameComparator();
        Scanner scanner = new Scanner(System.in);

        int sizeOfStudentList = 10_000;
        List<Student> studentList = Stream
                .generate(StudentCreator::createStudent)
                .limit(sizeOfStudentList)
                .collect(Collectors.toList());

        writeToTxtFile(studentList, FILENAME_TXT);
        writeToFileBin(studentList, FILENAME_BIN);

        path = ScannerHelper.scanFromConsole(scanner, FILENAME_BIN);
        readFromFile(path);

        topNStudentsFromList = 100;
        List<Student> topStudentList = studentList
                .stream()
                .sorted(markComparator)
                .limit(topNStudentsFromList)
                .sorted(nameComparator)
                .collect(Collectors.toList());

        writeToTxtFile(topStudentList, FILENAME_TOP_TXT);
        writeToFileBin(topStudentList, FILENAME_TOP_BIN);
    }

    private static void writeToTxtFile(List<Student> list, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(String.valueOf(list));
            writer.close();
        } catch (IOException ex) {
            System.out.println("Some problem with writing to file: " + ex.getMessage());
        }
    }

    private static void writeToFileBin(List<Student> list, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (Exception ex) {
            System.out.println("Some problem with writing to file: " + ex.getMessage());
        }
    }

    private static void readFromFile(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
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
