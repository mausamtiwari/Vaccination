package be.intecbrussel.VaccinateAnimals;

import be.intecbrussel.VaccinateAnimals.service.*;

import java.util.ArrayList;
import java.util.List;


public class VaccinationApp {
    public static void main(String[] args) {
        // AnimalShelter initialised.
        AnimalShelter animalShelter = new AnimalShelter();
        List<Animal> animals = new ArrayList<>();

        /*animalShelter.addAnimal(new Dog(false, 7, "Mat", 1, true));
        animalShelter.addAnimal(new Dog(false, 2, "Max", 2, true));
        animalShelter.addAnimal(new Dog(false, 5, "Charlie", 3, false));
        animalShelter.addAnimal(new Cat(false, 1, "Tiger", 4, true));
        animalShelter.addAnimal(new Cat(false, 2, "Tom", 5, false));
        animalShelter.addAnimal(new Cat(false, 3, "Whiskers", 6, true));
        animalShelter.addAnimal(new Monkey(false, 4, "Banana", 7, false));
        animalShelter.addAnimal(new Monkey(false, 2, "Bongo", 8, true));
        animalShelter.addAnimal(new Monkey(false, 5, "Cheeky", 9, true));
        animalShelter.addAnimal(new Monkey(false, 5, "Chimp", 10, true));*/

        Animal dog1 = new Dog(false, 7, "Mat", 1, true);
        Animal dog2 = new Dog(false, 2, "Max", 2, true);
        Animal dog3 = new Dog(false, 5, "Charlie", 3, true);
        Animal cat1 = new Cat(false, 1, "Tiger", 4, true);
        Animal cat2 = new Cat(false, 2, "Tom", 5, true);
        Animal cat3 = new Cat(false, 3, "Whiskers", 6, true);
        Animal monkey1 = new Monkey(false, 4, "Banana", 7, true);
        Animal monkey2 = new Monkey(false, 2, "Bongo", 8, true);
        Animal monkey3 = new Monkey(false, 5, "Cheeky", 9, true);
        Animal monkey4 = new Monkey(false, 5, "Chimp", 10, true);

        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);
        animals.add(cat1);
        animals.add(cat2);
        animals.add(cat3);
        animals.add(monkey1);
        animals.add(monkey2);
        animals.add(monkey3);
        animals.add(monkey4);


        for (Animal animal : animals) {
            animalShelter.addAnimal(animal);
        }


        System.out.println("************************* The list of animals **************************");
        animalShelter.printAnimals();
        System.out.println();

        System.out.println("************* Sorted animals according to the animalNumber *************");
        animalShelter.sortAnimals();
        System.out.println();

        System.out.println("************************* Animals sorted by name ***********************");
        animalShelter.sortAnimalsByName();
        System.out.println();

        System.out.println("************************* Animals sorted by age ************************");
        animalShelter.sortAnimalsByAge();
        System.out.println();

        dog1.vaccinateAnimal(Disease.POLIO);
        cat1.vaccinateAnimal(Disease.FLUE);
        monkey2.vaccinateAnimal(Disease.FLUE);
        cat3.vaccinateAnimal(Disease.FLUE);
        dog3.vaccinateAnimal(Disease.POLIO);


        animalShelter.printAnimalsNotVaccinated(Disease.POLIO);
        System.out.println();

        animalShelter.printAnimalsNotVaccinated(Disease.FLUE);
        System.out.println();

        animalShelter.printAnimalsVaccinated(Disease.FLUE);
        System.out.println();

        animalShelter.printAnimalsVaccinated(Disease.POLIO);
        System.out.println();


        System.out.println("************************* Search animal by number **********************");
        animalShelter.findAnimal(2);
        System.out.println();

        System.out.println("************************* Search animal by name ************************");
        animalShelter.findAnimal("Tom");
        System.out.println();

        System.out.println("************************* Treat animal by number ***********************");
        animalShelter.treatAnimal(10);
        System.out.println();

        System.out.println("************************* Treat animal by name *************************");
        animalShelter.treatAnimal("Max");
        System.out.println();

        System.out.println("************************** Treat all animals ***************************");
        animalShelter.treatAllAnimals();
        System.out.println();

        System.out.println("**************************** Oldest animal *****************************");
        System.out.println("The oldest animal is: " + animalShelter.findOldestAnimal().getName());
        System.out.println();

        int animalCount = animalShelter.countAnimals();
        System.out.println("Total number of animals: " + animalCount);
    }
}

