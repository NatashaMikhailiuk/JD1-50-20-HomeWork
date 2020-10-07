package homeworksix.service;

import homeworksix.entity.Animal;
import homeworksix.service.cleaner.CollectionCleaner;
import homeworksix.service.comparator.AnimalAgeAndNameComparator;
import homeworksix.service.creator.CollectionCreator;
import homeworksix.service.iterator.CollectionIterator;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AnimalService {

    private final CollectionCreator creator;
    private final CollectionIterator iterators;
    private final CollectionCleaner cleaner;

    public AnimalService(CollectionCreator creator, CollectionIterator iterators, CollectionCleaner cleaner) {
        this.creator = creator;
        this.iterators = iterators;
        this.cleaner = cleaner;
    }

    public void listService(int size, List<Animal> animals) {
        creator.createAnimalListCollection(size, animals);
        iterators.iteratorWithFor(animals);
        iterators.iterator(animals);
        Collections.sort(animals, new AnimalAgeAndNameComparator());
        // doesn't enough memory to use bubbleMethodSort on my PC
//        new Sorter<Animal>().bubbleMethodSort(animals, new AnimalAgeAndNameComparator());
        cleaner.removeAll(animals);
    }

    public void setService(int size, Set<Animal> animals) {
        creator.createAnimalListCollection(size, animals);
        iterators.iteratorWithFor(animals);
        iterators.iterator(animals);
        Set<Animal> sortedAnimals = new TreeSet<>(new AnimalAgeAndNameComparator());
        sortedAnimals.addAll(animals);
        cleaner.removeAll(sortedAnimals);
    }
}
