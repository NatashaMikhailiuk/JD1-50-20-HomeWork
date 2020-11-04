package homeworknine.ranner;

import homeworknine.entity.Student;
import homeworknine.service.collectioncreator.StudentCreator;
import homeworknine.service.comparator.StudentMarkComparator;
import homeworknine.service.comparator.StudentNameComparator;
import homeworknine.service.filereader.FileReaderService;
import homeworknine.service.filewriter.FileWriterService;
import homeworknine.utils.ScannerHelper;

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
        int sizeOfStudentList;
        StudentMarkComparator markComparator = new StudentMarkComparator();
        StudentNameComparator nameComparator = new StudentNameComparator();
        Scanner scanner = new Scanner(System.in);
        FileWriterService writer;
        FileReaderService read;


        sizeOfStudentList = 10_000;
        List<Student> studentList = Stream
                .generate(StudentCreator::createStudent)
                .limit(sizeOfStudentList)
                .collect(Collectors.toList());

        writer = new FileWriterService(studentList, FILENAME_TXT, FILENAME_BIN);
        writer.writeToTxtFile();
        writer.writeToFileBin();

        path = ScannerHelper.scanFromConsole(scanner, FILENAME_BIN);
        read = new FileReaderService(path);
        read.readFromFile();

        topNStudentsFromList = 100;
        List<Student> topStudentList = studentList
                .stream()
                .sorted(markComparator)
                .limit(topNStudentsFromList)
                .sorted(nameComparator)
                .collect(Collectors.toList());

        writer = new FileWriterService(topStudentList, FILENAME_TOP_TXT, FILENAME_TOP_BIN);
        writer.writeToTxtFile();
        writer.writeToFileBin();
    }
}
