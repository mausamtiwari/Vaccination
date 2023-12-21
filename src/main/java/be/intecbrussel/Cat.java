package be.intecbrussel;

import java.util.Map;

public class Cat extends Animal {
    private boolean hasLongNails;

    // No args constructor.
    public Cat() {

    }

    // All args constructor. Calls constructor from super class Animal.
    public Cat(Map<Disease, Boolean> isVaccinated, boolean isClean, int age, String name, int animalNumber, boolean hasLongNails) {
        super(isVaccinated, isClean, age, name, animalNumber);
        this.hasLongNails = hasLongNails;
    }

    // Overridden from superclass.
    @Override
    public void treatAnimal() {
        super.treatAnimal();
        Cat cat = new Cat();
        cat.setHasLongNails(false);
    }

    // Getters and setters.

    public boolean getHasLongNails() {
        return hasLongNails;
    }

    public void setHasLongNails(boolean hasLongNails) {
        this.hasLongNails = hasLongNails;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "hasLongNails=" + hasLongNails +
                "} " + super.toString();
    }
}
