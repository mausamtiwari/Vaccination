package be.intecbrussel;

import java.util.Map;

public class Dog extends Animal {
    private boolean hasFoulBreath;

    // No args constructor.
    public Dog() {

    }

    // All args constructor. Calls constructor from super class Animal.
    public Dog(Map<Disease, Boolean> isVaccinated, boolean isClean, int age, String name, int animalNumber, boolean hasFoulBreath) {
        super(isVaccinated, isClean, age, name, animalNumber);
        this.hasFoulBreath = hasFoulBreath;
    }


    // Overridden from superclass.
    @Override
    public void treatAnimal() {
        super.treatAnimal();
        Dog dog = new Dog();
        dog.setHasFoulBreath(false);
    }

    // Getters and setters.
    public boolean getHasFoulBreath() {
        return hasFoulBreath;
    }

    public void setHasFoulBreath(boolean hasFoulBreath) {
        this.hasFoulBreath = hasFoulBreath;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "hasFoulBreath=" + hasFoulBreath +
                "} " + super.toString();
    }
}
