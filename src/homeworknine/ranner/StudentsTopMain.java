package homeworknine.ranner;


import homeworknine.utils.ScannerHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentsTopMain {

    private static final String FILENAME_TOP_TXT = "topStudents.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int lastNStudents;

        String pathToFile = ScannerHelper.scanFromConsole(scanner, FILENAME_TOP_TXT);
        List<String> topStudentsList = new ArrayList<>();
        Path path = Paths.get(pathToFile);

        try (Stream<String> stringStream = Files.newBufferedReader(path).lines()) {

            topStudentsList = stringStream.collect(Collectors.toList());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("TOP Students from the file: ");
        for (String student : topStudentsList) {
            System.out.println(student);
        }

        lastNStudents = 10;
        System.out.println("Last " + lastNStudents + " students from the file: ");
        topStudentsList.stream()
                .skip(topStudentsList.size() - 1 - lastNStudents)
                .forEach(System.out::println);
    }
}
