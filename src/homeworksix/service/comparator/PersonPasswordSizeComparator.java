package homeworksix.service.comparator;

import homeworksix.entity.Person;

import java.util.Comparator;

public class PersonPasswordSizeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getPassword().length() - o2.getPassword().length();
    }
}
