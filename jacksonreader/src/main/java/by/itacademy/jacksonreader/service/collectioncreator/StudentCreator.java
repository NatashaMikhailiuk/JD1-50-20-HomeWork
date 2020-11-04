package by.itacademy.jacksonreader.service.collectioncreator;


import by.itacademy.jacksonreader.entity.Student;
import by.itacademy.jacksonreader.utils.DataCreator;

public class StudentCreator {

    private static final DataCreator CREATOR = new DataCreator();


    public static <T> Student createStudent() {
        Student student = new Student();
        student.setName(CREATOR.createNameAndMiddleName());
        student.setMiddleName(CREATOR.createNameAndMiddleName());
        student.setSurname(CREATOR.createSurnameFromTheListOfLetters(1, 3));
        student.createFullName(student.getName(), student.getMiddleName(), student.getSurname());
        student.setMark(CREATOR.createMark());
        return student;
    }
}
