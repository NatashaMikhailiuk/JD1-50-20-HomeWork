package homeworksix.service.comparator;

import homeworksix.entity.Animal;

import java.util.Comparator;

public class AnimalAgeAndNameComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        int ageComparisonResult = o1.getAge() - o2.getAge();
        if (ageComparisonResult != 0) {
            return ageComparisonResult;
        }
        return o1.getName().compareTo(o2.getName());
    }
}
