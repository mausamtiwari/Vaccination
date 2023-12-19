package be.intecbrussel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class VaccinationApp {
    public static void main(String[] args) throws AnimalShelter.AnimalNotFoundException {
        AnimalShelter animalShelter = new AnimalShelter();

        // Dog 1
        Map<Disease, Boolean> dog1Vaccinations = new LinkedHashMap<>();
        dog1Vaccinations.put(Disease.FLUE, true);
        dog1Vaccinations.put(Disease.CHICKENPOCKS, false);
        dog1Vaccinations.put(Disease.POLIO, true);
        dog1Vaccinations.put(Disease.HEPATITISA, false);
        animalShelter.addAnimal(new Dog(dog1Vaccinations, false, 3, "Grot", 1, false));

        // Dog 2
        Map<Disease, Boolean> dog2Vaccinations = new LinkedHashMap<>();
        dog2Vaccinations.put(Disease.FLUE, true);
        dog2Vaccinations.put(Disease.CHICKENPOCKS, true);
        dog2Vaccinations.put(Disease.POLIO, false);
        dog2Vaccinations.put(Disease.HEPATITISA, true);
        animalShelter.addAnimal(new Dog(dog2Vaccinations, true, 2, "Max", 2, true));

        // Dog 3
        Map<Disease, Boolean> dog3Vaccinations = new LinkedHashMap<>();
        dog3Vaccinations.put(Disease.FLUE, false);
        dog3Vaccinations.put(Disease.CHICKENPOCKS, true);
        dog3Vaccinations.put(Disease.POLIO, false);
        dog3Vaccinations.put(Disease.HEPATITISA, true);
        animalShelter.addAnimal(new Dog(dog3Vaccinations, true, 5, "Charlie", 3, false));

        // Cat 1
        Map<Disease, Boolean> cat1Vaccinations = new LinkedHashMap<>();
        cat1Vaccinations.put(Disease.FLUE, true);
        cat1Vaccinations.put(Disease.CHICKENPOCKS, false);
        cat1Vaccinations.put(Disease.POLIO, false);
        cat1Vaccinations.put(Disease.HEPATITISA, true);
        animalShelter.addAnimal(new Cat(cat1Vaccinations, true, 1, "Tiger", 4, true));

        // Cat 2
        Map<Disease, Boolean> cat2Vaccinations = new LinkedHashMap<>();
        cat2Vaccinations.put(Disease.FLUE, false);
        cat2Vaccinations.put(Disease.CHICKENPOCKS, true);
        cat2Vaccinations.put(Disease.POLIO, false);
        cat2Vaccinations.put(Disease.HEPATITISA, false);
        animalShelter.addAnimal(new Cat(cat2Vaccinations, false, 2, "Tom", 5, false));

        // Cat 3
        Map<Disease, Boolean> cat3Vaccinations = new LinkedHashMap<>();
        cat3Vaccinations.put(Disease.FLUE, true);
        cat3Vaccinations.put(Disease.CHICKENPOCKS, true);
        cat3Vaccinations.put(Disease.POLIO, true);
        cat3Vaccinations.put(Disease.HEPATITISA, true);
        animalShelter.addAnimal(new Cat(cat3Vaccinations, true, 3, "Whiskers", 6, true));

        // Monkey 1
        Map<Disease, Boolean> monkey1Vaccinations = new LinkedHashMap<>();
        monkey1Vaccinations.put(Disease.FLUE, false);
        monkey1Vaccinations.put(Disease.CHICKENPOCKS, false);
        monkey1Vaccinations.put(Disease.POLIO, false);
        monkey1Vaccinations.put(Disease.HEPATITISA, true);
        animalShelter.addAnimal(new Monkey(monkey1Vaccinations, true, 4, "Banana", 7, false));

        // Monkey 2
        Map<Disease, Boolean> monkey2Vaccinations = new LinkedHashMap<>();
        monkey2Vaccinations.put(Disease.FLUE, true);
        monkey2Vaccinations.put(Disease.CHICKENPOCKS, true);
        monkey2Vaccinations.put(Disease.POLIO, false);
        monkey2Vaccinations.put(Disease.HEPATITISA, false);
        animalShelter.addAnimal(new Monkey(monkey2Vaccinations, false, 2, "Bongo", 8, true));

        // Monkey 3
        Map<Disease, Boolean> monkey3Vaccinations = new LinkedHashMap<>();
        monkey3Vaccinations.put(Disease.FLUE, true);
        monkey3Vaccinations.put(Disease.CHICKENPOCKS, false);
        monkey3Vaccinations.put(Disease.POLIO, true);
        monkey3Vaccinations.put(Disease.HEPATITISA, true);
        animalShelter.addAnimal(new Monkey(monkey3Vaccinations, false, 5, "Cheeky", 9, true));

        // Monkey 4
        Map<Disease, Boolean> monkey4Vaccinations = new LinkedHashMap<>();
        monkey4Vaccinations.put(Disease.FLUE, false);
        monkey4Vaccinations.put(Disease.CHICKENPOCKS, true);
        monkey4Vaccinations.put(Disease.POLIO, false);
        monkey4Vaccinations.put(Disease.HEPATITISA, false);
        animalShelter.addAnimal(new Monkey(monkey4Vaccinations, false, 5, "Chimp", 10, true));


        System.out.println("All the animals are: ");
        animalShelter.printAnimals();
        System.out.println();

        System.out.println("Sorted animals are: ");
        animalShelter.sortAnimals();
        System.out.println();

        System.out.println("Animals sorted by name: ");
        animalShelter.sortAnimalsByName();
        System.out.println();

        System.out.println("Animals sorted by age: ");
        animalShelter.sortAnimalsByAge();
        System.out.println();


        animalShelter.printAnimalsNotVaccinated(Disease.POLIO);
        System.out.println();

        System.out.println("Animal found by number");
        Optional<Animal> foundAnimalByNumber = animalShelter.findAnimal(2);
        foundAnimalByNumber.ifPresent(System.out::println);
        System.out.println();

        System.out.println("Animal found by name");
        Optional<Animal> foundAnimalByNAme = animalShelter.findAnimal("Chimp");
        foundAnimalByNAme.ifPresent(System.out::println);
        System.out.println();

        System.out.println("Treat animal by number");
        animalShelter.treatAnimal(10);
        System.out.println();

        System.out.println("Treat animal by name");
        animalShelter.treatAnimal("Max");
        System.out.println();

        System.out.println("Treat all animals");
        animalShelter.treatAllAnimals();
        System.out.println();

        System.out.println("Oldest animal");
        Optional<Animal> oldestAnimal = animalShelter.findOldestAnimal();
        oldestAnimal.ifPresent(System.out::println);
        System.out.println();

        int animalCount = animalShelter.countAnimals();
        System.out.println("Total number of animals: " + animalCount);
    }
}
