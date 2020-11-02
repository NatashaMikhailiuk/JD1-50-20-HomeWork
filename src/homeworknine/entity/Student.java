package homeworknine.entity;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private String name;
    private String middleName;
    private String surname;
    private int mark;

    public Student(String name, String middleName, String surname, int mark) {
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.mark = mark;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return mark == student.mark &&
                Objects.equals(name, student.name) &&
                Objects.equals(middleName, student.middleName) &&
                Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, middleName, surname, mark);
    }

    @Override
    public String toString() {
        return
                "name: " + name +
                        ", middleName: " + middleName +
                        ", surname: " + surname +
                        ", mark: " + mark + System.lineSeparator();
    }

    public String createFullName(String name, String middleName, String surname) {
        return name + " " + middleName + " " + surname;
    }
}
