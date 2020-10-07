package homeworksix.runner;

import homeworksix.entity.Animal;
import homeworksix.service.AnimalService;
import homeworksix.service.comparator.AnimalAgeAndNameComparator;
import homeworksix.service.creator.CollectionCreator;
import homeworksix.service.cleaner.CollectionCleaner;
import homeworksix.service.iterator.CollectionIterator;

import java.util.*;

public class AnimalMain {
    public static void main(String[] args) {
        int sizeOfCollection = 100000;

        CollectionCreator creator = new CollectionCreator();
        CollectionIterator iterator = new CollectionIterator();
        CollectionCleaner cleaner = new CollectionCleaner();

        AnimalService animalService = new AnimalService(creator, iterator, cleaner);

        List<Animal> animals = new LinkedList<>();
        System.out.println("LinkedList");
        animalService.listService(sizeOfCollection, animals);

        animals = new ArrayList<>();
        System.out.println("ArrayList");
        animalService.listService(sizeOfCollection, animals);

        Set<Animal> distinctAnimals = new HashSet<>();
        System.out.println("HashSet");
        animalService.setService(sizeOfCollection, distinctAnimals);

        distinctAnimals = new TreeSet<>(new AnimalAgeAndNameComparator());
        System.out.println("TreeSet");
        animalService.setService(sizeOfCollection, distinctAnimals);
    }
}

