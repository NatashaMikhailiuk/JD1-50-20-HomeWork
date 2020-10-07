package homeworksix.service.comparator;

import homeworksix.entity.Person;

import java.util.Comparator;

public class PersonPasswordAndNickComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int passwordComparisonResult = o1.getPassword().length() - o2.getPassword().length();
        if (passwordComparisonResult != 0) {
            return passwordComparisonResult;
        }
        return o1.getNick().compareTo(o2.getNick());
    }
}
