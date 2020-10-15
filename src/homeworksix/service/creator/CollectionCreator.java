package homeworksix.service.creator;

import homeworkfour.taskstring.NumberUtils;
import homeworksix.entity.Animal;
import homeworksix.entity.Person;
import homeworksix.utils.creator.FieldsCreator;
import java.util.Collection;
import java.util.Random;

public class CollectionCreator {
    private int sizeOfCollection;
    private final NumberUtils timeFormat = new NumberUtils();

    public CollectionCreator(int sizeOfCollection) {
        this.sizeOfCollection = sizeOfCollection;
    }

    public CollectionCreator() {

    }

    public long createAnimalListCollection(int sizeOfCollection, Collection<Animal> list) {
        long startTimeOperation = System.currentTimeMillis();
        for (int i = 0; i < sizeOfCollection; i++) {
            Animal animal = new Animal();
            animal.setAge(new FieldsCreator().createAge());
            animal.setName(new FieldsCreator().createNameForPetFromTheListOfNames());
            list.add(animal);
        }
        long finishTimeOperation = System.currentTimeMillis();
        System.out.println("Operation \"createAnimals\" takes -       "
                + timeFormat.toHoursMinuteSecondMillisecond((finishTimeOperation - startTimeOperation), true)
                + " milliseconds");
        return (finishTimeOperation - startTimeOperation);
    }

    public void createPersonListCollection(int sizeOfCollection, Collection<Person> list) {
        long startTimeOperation = System.currentTimeMillis();
        for (int i = 0; i < sizeOfCollection; i++) {
            Person person = new Person();
            person.setNick(new FieldsCreator().createNickFromListOfNames());
            person.setPassword(new FieldsCreator().createPassword(new Random().nextInt(10)));
            list.add(person);
        }
        long finishTimeOperation = System.currentTimeMillis();
        System.out.println("Operation \"createPersons\" takes -        "
                + timeFormat.toHoursMinuteSecondMillisecond((finishTimeOperation - startTimeOperation), true)
                + " milliseconds");
    }
}
