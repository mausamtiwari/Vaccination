package be.intecbrussel.VaccinateAnimals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;


public class AnimalShelter {

    private List<Animal> animals = new ArrayList<>();
    private int animalId = 1;

    // No args constructor
    public AnimalShelter() {

    }

    public int animalShelterSize() {
        return animals.size();
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

        animals.stream()
                .filter(animal -> FALSE.equals(animal.getIsVaccinated().get(disease)))
                .forEach(System.out::println);
    }


    // Prints the list of animals which are vaccinated for a specified disease.
    public void printAnimalsVaccinated(Disease disease) {

        animals.stream()
                .filter(animal -> !FALSE.equals(animal.getIsVaccinated().get(disease)))
                .forEach(System.out::println);
    }


    // Finds the animal by animalNumber.
    public Optional<Animal> findAnimal(int animalNumber) {
        System.out.println("Searching for animal with animal number : " + animalNumber);
        Optional<Animal> foundByAnimalNumber = animals.stream()
                .filter(animal -> animal.getAnimalNumber() == animalNumber)
                .findFirst();

        foundByAnimalNumber.ifPresent(animal ->
                System.out.println("Animal found: " + animal)
        );

        if (foundByAnimalNumber.isEmpty()) {
            System.out.println("Animal with number " + animalNumber + " was not found.");
        }

        return foundByAnimalNumber;
    }


    // Treats animal by animalNumber.
    public void treatAnimal(int animalNumber) {
        Optional<Animal> animalFoundByNumber = findAnimal(animalNumber);
        if (animalFoundByNumber.isPresent()) {
            Animal animal = animalFoundByNumber.get();
            System.out.println("Animal with number " + animalNumber + " is being treated.");
            animal.treatAnimal();
        } else {
            System.out.println("Animal with number " + animalNumber + " not found.");
        }
        animalFoundByNumber.ifPresent(System.out::println);
    }


    // Finds the animal by name.
    public Optional<Animal> findAnimal(String name) {
        System.out.println("Searching for animal with name : " + name);

        Optional<Animal> foundByAnimalName = animals.stream()
                .filter(animal -> animal.getName().equals(name))
                .findFirst();

        foundByAnimalName.ifPresent(animal ->
                System.out.println("Animal found: " + animal)
        );

        if (foundByAnimalName.isEmpty()) {
            System.out.println("Animal with name " + name + " was not found.");
        }

        return foundByAnimalName;
    }


    // Treats animal by name.
    public void treatAnimal(String name) {
        Optional<Animal> animalFoundByName = findAnimal(name);
        if (animalFoundByName.isPresent()) {
            Animal animal = animalFoundByName.get();
            System.out.println("Animal with name " + name + " is being treated.");
            animal.treatAnimal();
        } else {
            System.out.println("Animal with name " + name + " not found.");
        }
        animalFoundByName.ifPresent(System.out::println);
    }


    // Treats all animals.
    public void treatAllAnimals() {
        animals.forEach(animal -> {
            animal.treatAnimal();
            System.out.println(animal);
        });
    }


    // Finds the oldest animal.
    public Animal findOldestAnimal() {
        return animals.stream()
                .max(Comparator.comparingInt(Animal::getAge))
                .orElse(null);
    }


    // Counts the total number of animals.
    public int countAnimals() {
        return animals.size();
    }


    // Adds animals to the list.
    public void addAnimal(Animal animal) {
        animals.add(animal);
        animal.setAnimalNumber(animalId);
        animalId += 1;
    }


    @Override
    public String toString() {
        return animals.toString();
    }
}
