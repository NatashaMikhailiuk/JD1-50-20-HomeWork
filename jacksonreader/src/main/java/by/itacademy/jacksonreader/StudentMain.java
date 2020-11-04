package by.itacademy.jacksonreader;

import by.itacademy.jacksonreader.entity.Student;
import by.itacademy.jacksonreader.service.collectioncreator.StudentCreator;
import by.itacademy.jacksonreader.service.comparator.StudentMarkComparator;
import by.itacademy.jacksonreader.service.comparator.StudentNameComparator;
import by.itacademy.jacksonreader.utils.ScannerHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentMain {

    private static final String STUDENTS = "students.json";
    private static final String TOP_STUDENTS = "top_students.json";

    public static void main(String[] args) throws IOException {

        int sizeOfStudentList = 100;
        int topNStudentsFromList = 10;
        StudentMarkComparator markComparator = new StudentMarkComparator();
        StudentNameComparator nameComparator = new StudentNameComparator();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        Scanner scanner = new Scanner(System.in);


        List<Student> studentList = Stream
                .generate(StudentCreator::createStudent)
                .limit(sizeOfStudentList)
                .collect(Collectors.toList());

        writer.writeValue(new File(STUDENTS), studentList);
        String path = ScannerHelper.scanFromConsole(scanner,STUDENTS);
        List<Student> list = objectMapper.readValue(new File(path), new TypeReference<List<Student>>() {
        });
        System.out.println(list);

        List<Student> topStudentList = studentList
                .stream()
                .sorted(markComparator)
                .limit(topNStudentsFromList)
                .sorted(nameComparator)
                .collect(Collectors.toList());

        writer.writeValue(new File(TOP_STUDENTS), topStudentList);
        List<Student> topList = objectMapper.readValue(new File(TOP_STUDENTS), new TypeReference<List<Student>>() {
        });
        System.out.println(topList);
    }
}
