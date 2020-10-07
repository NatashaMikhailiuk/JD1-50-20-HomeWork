package homeworksix.service;

import homeworksix.entity.Person;
import homeworksix.service.cleaner.CollectionCleaner;
import homeworksix.service.comparator.PersonPasswordAndNickComparator;
import homeworksix.service.creator.CollectionCreator;
import homeworksix.service.iterator.CollectionIterator;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PersonService {

    private final CollectionCreator creator;
    private final CollectionIterator iterators;
    private final CollectionCleaner cleaner;

    public PersonService(CollectionCreator creator, CollectionIterator iterators, CollectionCleaner cleaner) {
        this.creator = creator;
        this.iterators = iterators;
        this.cleaner = cleaner;
    }

    public void listService(int size, List<Person> persons) {
        creator.createPersonListCollection(size, persons);
        iterators.iteratorWithFor(persons);
        iterators.iterator(persons);
        Collections.sort(persons, new PersonPasswordAndNickComparator());
        // doesn't enough memory to use bubbleMethodSort on my PC
//        new Sorter<Person>().bubbleMethodSort(persons, new PersonPasswordAndNickComparator());
        cleaner.removeAll(persons);
    }

    public void setService(int size, Set<Person> persons) {
        creator.createPersonListCollection(size, persons);
        iterators.iteratorWithFor(persons);
        iterators.iterator(persons);
        Set<Person> sortedPersons = new TreeSet<>(new PersonPasswordAndNickComparator());
        sortedPersons.addAll(persons);
        cleaner.removeAll(sortedPersons);
    }
}
