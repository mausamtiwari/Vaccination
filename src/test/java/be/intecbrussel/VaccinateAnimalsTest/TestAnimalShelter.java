package be.intecbrussel.VaccinateAnimalsTest;

import be.intecbrussel.VaccinateAnimals.service.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AnimalShelterTest {

    private AnimalShelter animalShelter;

    {
        animalShelter = new AnimalShelter();
    }

    @Test
    void testAnimalShelterSize() {
        assertEquals(0, animalShelter.animalShelterSize());

        Animal dog1 = new Dog(false, 7, "Mat", 1, true);
        Animal dog2 = new Dog(false, 2, "Max", 2, true);
        Animal dog3 = new Dog(false, 5, "Charlie", 3, true);
        animalShelter.addAnimal(dog1);
        animalShelter.addAnimal(dog2);
        animalShelter.addAnimal(dog3);

        assertEquals(3, animalShelter.animalShelterSize());
    }

    @Test
    void testAddAnimal() {

        Animal dog1 = new Dog(false, 7, "Mat", 1, true);
        Animal dog2 = new Dog(false, 2, "Max", 2, true);
        Animal dog3 = new Dog(false, 5, "Charlie", 3, true);
        animalShelter.addAnimal(dog1);
        animalShelter.addAnimal(dog2);
        animalShelter.addAnimal(dog3);

        assertEquals(3, animalShelter.animalShelterSize());
        assertTrue(animalShelter.findAnimal(1).isPresent());
        assertTrue(animalShelter.findAnimal(2).isPresent());
        assertTrue(animalShelter.findAnimal(3).isPresent());
        assertFalse(animalShelter.findAnimal(4).isPresent());
    }

    @Test
    void testSortAnimals() {
        Animal dog1 = new Dog(false, 5, "Charlie", 1, true);
        Animal dog2 = new Dog(false, 3, "Buddy", 2, false);
        Animal cat = new Cat(false, 2, "Whiskers", 3, true);

        animalShelter.addAnimal(dog1);
        animalShelter.addAnimal(dog2);
        animalShelter.addAnimal(cat);

        animalShelter.sortAnimals();

        assertEquals(dog1, animalShelter.findAnimal(1).orElse(null));
        assertEquals(dog2, animalShelter.findAnimal(2).orElse(null));
        assertEquals(cat, animalShelter.findAnimal(3).orElse(null));
    }

    @Test
    void testSortAnimalsByName() {
        Animal dog1 = new Dog(false, 5, "Charlie", 1, true);
        Animal cat1 = new Cat(false, 3, "Buddy", 2, false);
        Animal cat2 = new Cat(false, 2, "Whiskers", 3, true);

        animalShelter.addAnimal(dog1);
        animalShelter.addAnimal(cat1);
        animalShelter.addAnimal(cat2);

        animalShelter.sortAnimalsByName();

        assertEquals(cat1, animalShelter.findAnimal(2).orElse(null));
        assertEquals(dog1, animalShelter.findAnimal(1).orElse(null));
        assertEquals(cat2, animalShelter.findAnimal(3).orElse(null));
    }

    @Test
    void testSortAnimalsByAge() {
        Animal dog = new Dog(false, 5, "Charlie", 1, true);
        Animal cat1 = new Cat(false, 3, "Buddy", 2, false);
        Animal cat2 = new Cat(false, 2, "Whiskers", 3, true);

        animalShelter.addAnimal(dog);
        animalShelter.addAnimal(cat1);
        animalShelter.addAnimal(cat2);

        animalShelter.sortAnimalsByAge();

        assertEquals(cat2, animalShelter.findAnimal(3).orElse(null));
        assertEquals(cat1, animalShelter.findAnimal(2).orElse(null));
        assertEquals(dog, animalShelter.findAnimal(1).orElse(null));
    }

    @Test
    void testPrintAnimalsNotVaccinated() {
        Animal dog = new Dog(false, 5, "Charlie", 1, true);
        Animal cat = new Cat(false, 3, "Buddy", 2, false);

        animalShelter.addAnimal(dog);
        animalShelter.addAnimal(cat);

        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));

        animalShelter.printAnimalsNotVaccinated(Disease.POLIO);

        String expectedOutput = "***************** Animals not vaccinated for POLIO ********************\n" +
                "isClean=false, age=5, name='Charlie', animalNumber=1\n" +
                "isClean=false, age=3, name='Buddy', animalNumber=2\n";

        assertEquals(expectedOutput.trim(), outPut.toString().trim());
    }

    @Test
    void testPrintAnimalsVaccinated() {

        // TODO result not obtained. animalShelter.printAnimalsVaccinated(Disease.FLUE) is null.
        Animal dog = new Dog(false, 1, "Charlie", 1, true);
        Animal cat = new Cat(false, 3, "Whiskers", 6, true);


        animalShelter.addAnimal(dog);
        animalShelter.addAnimal(cat);


        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));

        animalShelter.printAnimalsVaccinated(Disease.FLUE);

        String expectedOutput = "***************** Animals vaccinated for FLUE ********************\n" +
                "isClean=true, age=1, name='Tiger', animalNumber=4\n" +
                "isClean=true, age=3, name='Whiskers', animalNumber=6\n";


        assertEquals(expectedOutput.trim(), outPut.toString().trim());
    }

    @Test
    void testFindAnimalByNumber() {
        Animal monkey1 = new Monkey(false, 4, "Banana", 1, true);
        Animal monkey2 = new Monkey(false, 2, "Bongo", 2, true);
        Animal monkey3 = new Monkey(false, 5, "Cheeky", 3, true);
        Animal monkey4 = new Monkey(false, 5, "Chimp", 4, true);

        animalShelter.addAnimal(monkey1);
        animalShelter.addAnimal(monkey2);
        animalShelter.addAnimal(monkey3);
        animalShelter.addAnimal(monkey4);

        Optional<Animal> foundAnimal4 = animalShelter.findAnimal(4);
        Optional<Animal> foundAnimal2 = animalShelter.findAnimal(2);
        Optional<Animal> foundAnimal1 = animalShelter.findAnimal(1);

        assertTrue(foundAnimal4.isPresent());
        assertEquals(monkey4, foundAnimal4.get());

        assertTrue(foundAnimal2.isPresent());
        assertEquals(monkey2, foundAnimal2.get());

        assertTrue(foundAnimal1.isPresent());
        assertEquals(monkey1, foundAnimal1.get());
    }

    @Test
    void testFindAnimalByName() {
        Animal dog = new Dog(false, 5, "Charlie", 1, true);
        Animal cat = new Cat(false, 3, "Buddy", 2, false);

        animalShelter.addAnimal(dog);
        animalShelter.addAnimal(cat);

        Optional<Animal> foundAnimal = animalShelter.findAnimal("Buddy");

        assertTrue(foundAnimal.isPresent());
        assertEquals(cat, foundAnimal.get());
    }

    @Test
    void testTreatAnimalByNumber() {
        Animal dog = new Dog(false, 5, "Charlie", 1, true);

        animalShelter.addAnimal(dog);

        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));

        animalShelter.treatAnimal(1);

        String expectedOutput = "Searching for animal with animal number : 1\n" +
                "Animal found: isClean=false, age=5, name='Charlie', animalNumber=1\n" +
                "Animal with number 1 is being treated.\n" +
                "isClean=true, age=5, name='Charlie', animalNumber=1\n";

        assertEquals(expectedOutput, outPut.toString());
    }

    @Test
    void testTreatAnimalByName() {
        Animal dog = new Dog(false, 5, "Max", 1, true);

        animalShelter.addAnimal(dog);

        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));

        animalShelter.treatAnimal("Max");

        String expectedOutput = "Searching for animal with name : Max\n" +
                "Animal found: isClean=false, age=5, name='Max', animalNumber=1\n" +
                "Animal with name Max is being treated.\n" +
                "isClean=true, age=5, name='Max', animalNumber=1\n";

        assertEquals(expectedOutput, outPut.toString());
    }

    @Test
    void testTreatAllAnimals() {
        Animal dog = new Dog(false, 5, "Charlie", 1, true);
        Animal cat = new Cat(false, 3, "Buddy", 2, false);

        animalShelter.addAnimal(dog);
        animalShelter.addAnimal(cat);

        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));

        animalShelter.treatAllAnimals();

        String expectedOutput = "isClean=true, age=5, name='Charlie', animalNumber=1\n" +
                "isClean=true, age=3, name='Buddy', animalNumber=2\n";
        assertEquals(expectedOutput, outPut.toString());
    }

    @Test
    void testFindOldestAnimal() {
        Animal dog = new Dog(false, 5, "Charlie", 1, true);
        Animal cat = new Cat(false, 3, "Buddy", 2, false);

        animalShelter.addAnimal(dog);
        animalShelter.addAnimal(cat);

        assertEquals(dog, animalShelter.findOldestAnimal());
    }

    @Test
    void testCountAnimals() {
        Animal dog = new Dog(false, 5, "Charlie", 1, true);
        Animal cat = new Cat(false, 3, "Buddy", 2, false);

        animalShelter.addAnimal(dog);
        animalShelter.addAnimal(cat);

        assertEquals(2, animalShelter.countAnimals());
    }
}


