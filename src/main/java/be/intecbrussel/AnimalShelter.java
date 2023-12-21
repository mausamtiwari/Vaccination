package be.intecbrussel;

import java.util.*;


public class AnimalShelter {

    private List<Animal> animals;
    private int animalId;

    // No args constructor
    public AnimalShelter() {
        // Instantiated list of Animal and set the animalId to 1.
        this.animals = new ArrayList<>();
        this.animalId = 1;
    }

    // Prints the elements of Animal list.
    public void printAnimals() {
        animals.forEach(animal -> System.out.println(animal.toString()));
    }

    // Sorts the animals according to animalNumber.
    public void sortAnimals() {
        animals.stream()
                .sorted(Comparator.comparing(Animal::getAnimalNumber))
                .forEach(System.out::println);
    }

    // Sorts the animals according to their name.
    public void sortAnimalsByName() {
        animals.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .forEach(System.out::println);
    }

    // Sorts the animal according to their age.
    public void sortAnimalsByAge() {
        animals.stream()
                .sorted(Comparator.comparing(Animal::getAge))
                .forEach(System.out::println);
    }

    // Prints the list of animals which are not vaccinated for a specified disease.
    public void printAnimalsNotVaccinated(Disease disease) {
        System.out.println("***************** Animals not vaccinated for " + disease + " ********************");
        animals.stream()
                .filter(animal -> Boolean.FALSE.equals(animal.getIsVaccinated().get(disease)))
                .forEach(System.out::println);
    }

    // Finds the animal by animalNumber.
    public Optional<Animal> findAnimal(int animalNumber) {
        return animals.stream()
                .filter(animal -> animal.getAnimalNumber() == animalNumber)
                .findFirst();
    }

    // Finds the animal by name.
    public Optional<Animal> findAnimal(String name) {
        return animals.stream()
                .filter(animal -> Objects.equals(animal.getName(), name))
                .findFirst();
    }

    // Treats animal by animalNumber.
    public void treatAnimal(int animalNumber) throws AnimalNotFoundException {
        Optional<Animal> optionalAnimal = findAnimal(animalNumber);
        if (optionalAnimal.isPresent()) {
            Animal animal = optionalAnimal.get();
            animal.treatAnimal();
        } else {
            throw new AnimalNotFoundException("Animal not found with number: " + animalNumber);

        }
        optionalAnimal.ifPresent(System.out::println);
    }

    // Treats animal by name.
    public void treatAnimal(String name) throws AnimalNotFoundException {
        Optional<Animal> optionalAnimal = findAnimal(name);
        if (optionalAnimal.isPresent()) {
            Animal animal = optionalAnimal.get();
            animal.treatAnimal();
        } else {
            throw new AnimalNotFoundException("Animal not found with name: " + name);
        }
        optionalAnimal.ifPresent(System.out::println);
    }

    // Treats all animals.
    public void treatAllAnimals() {
        animals.forEach(animal -> {
            animal.treatAnimal();
            System.out.println(animal);
        });
    }

    // Finds the oldest animal.
    public Optional<Animal> findOldestAnimal() {
        return animals.stream()
                .max(Comparator.comparingInt(Animal::getAge));
    }

    // Counts the total number of animals.
    public int countAnimals() {
        return animals.size();
    }

    // Adds animals to the list.
    public void addAnimal(Animal animal) {
        animal.setAnimalNumber(animalId);
        animals.add(animal);
        animalId++;
    }

    // Exception handeling if animal is not found.
    public static class AnimalNotFoundException extends Exception {
        public AnimalNotFoundException(String message) {
            super(message);
        }
    }
}
