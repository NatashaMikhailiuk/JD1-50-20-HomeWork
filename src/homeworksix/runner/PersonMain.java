package homeworksix.runner;

import homeworksix.entity.Person;
import homeworksix.service.PersonService;
import homeworksix.service.cleaner.CollectionCleaner;
import homeworksix.service.comparator.PersonPasswordAndNickComparator;
import homeworksix.service.creator.CollectionCreator;
import homeworksix.service.iterator.CollectionIterator;

import java.util.*;

public class PersonMain {
    public static void main(String[] args) {
        int sizeOfCollection = 100000;

        CollectionCreator creator = new CollectionCreator();
        CollectionIterator<Person> iterator = new CollectionIterator<>();
        CollectionCleaner<Person> cleaner = new CollectionCleaner<>();

        PersonService personService = new PersonService(creator, iterator, cleaner);

        List<Person> persons = new LinkedList<>();
        System.out.println("LinkedList");
        personService.listService(sizeOfCollection, persons);

        persons = new ArrayList<>();
        System.out.println("ArrayList");
        personService.listService(sizeOfCollection, persons);

        Set<Person> distinctPersons = new HashSet<>();
        System.out.println("HashSet");
        personService.setService(sizeOfCollection, distinctPersons);

        distinctPersons = new TreeSet<>(new PersonPasswordAndNickComparator());
        System.out.println("TreeSet");
        personService.setService(sizeOfCollection, distinctPersons);
    }
}
