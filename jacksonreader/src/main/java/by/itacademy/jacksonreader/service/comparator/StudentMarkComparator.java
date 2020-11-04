package by.itacademy.jacksonreader.service.comparator;


import by.itacademy.jacksonreader.entity.Student;

import java.util.Comparator;

public class StudentMarkComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getMark() - o1.getMark();
    }
}
