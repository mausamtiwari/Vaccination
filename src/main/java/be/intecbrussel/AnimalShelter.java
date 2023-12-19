package be.intecbrussel;

import java.util.*;



public class AnimalShelter {
    private List<Animal> animals;
    private int animalId;

    public AnimalShelter() {
        this.animals = new ArrayList<>();
        this.animalId = 1;
    }

    public void printAnimals() {
        animals.forEach(animal -> System.out.println(animal.toString()));
    }

    public void sortAnimals() {
        animals.stream()
                .sorted(Comparator.comparing(Animal::getAnimalNumber))
                .forEach(System.out::println);
    }

    public void sortAnimalsByName() {
        animals.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .forEach(System.out::println);
    }

    public void sortAnimalsByAge() {
        animals.stream()
                .sorted(Comparator.comparing(Animal::getAge))
                .forEach(System.out::println);
    }

    public void printAnimalsNotVaccinated(Disease disease) {
        System.out.println("Animals not vaccinated for " + disease + ":");
        animals.stream()
                .filter(animal -> Boolean.FALSE.equals(animal.getIsVaccinated().get(disease)))
                .forEach(System.out::println);
    }

    public Optional<Animal> findAnimal(int animalNumber) {
        return animals.stream()
                .filter(animal -> animal.getAnimalNumber() == animalNumber)
                .findFirst();
    }

    public Optional<Animal> findAnimal(String name) {
        return animals.stream()
                .filter(animal -> Objects.equals(animal.getName(), name))
                .findFirst();
    }

    public void treatAnimal(int animalNumber) throws AnimalNotFoundException {
        Optional<Animal> optionalAnimal = findAnimal(animalNumber);
        if (optionalAnimal.isPresent()) {
            Animal animal = optionalAnimal.get();
            animal.treatAnimal();
        } else {
            throw new AnimalNotFoundException("Animal not found with number: " + animalNumber);
        }
    }

    public void treatAnimal(String name) throws AnimalNotFoundException {
        Optional<Animal> optionalAnimal = findAnimal(name);
        if (optionalAnimal.isPresent()) {
            Animal animal = optionalAnimal.get();
            animal.treatAnimal();
        } else {
            throw new AnimalNotFoundException("Animal not found with name: " + name);
        }
    }

    public void treatAllAnimals() {
        animals.forEach(Animal::treatAnimal);
    }

    public Optional<Animal> findOldestAnimal() {
        return animals.stream()
                .max(Comparator.comparingInt(Animal::getAge));
    }

    public int countAnimals() {
        return animals.size();
    }

    public void addAnimal(Animal animal) {
        animal.setAnimalNumber(animalId);
        animals.add(animal);
        animalId++;
    }

    public static class AnimalNotFoundException extends Exception {
        public AnimalNotFoundException(String message) {
            super(message);
        }
    }
}
