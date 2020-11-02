package homeworknine.service.collectioncreator;

import homeworknine.entity.Student;
import homeworknine.utils.DataCreator;

public class StudentCreator {

    private static final DataCreator CREATOR = new DataCreator();


    public static <T> Student createStudent() {
        Student student = new Student();
        student.setName(CREATOR.createNameAndMiddleName());
        student.setMiddleName(CREATOR.createNameAndMiddleName());
        student.setSurname(CREATOR.createSurnameFromTheListOfLetters(1, 3));
        student.setMark(CREATOR.createMark());
        return student;
    }
}
