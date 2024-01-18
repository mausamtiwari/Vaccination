package be.intecbrussel.VaccinateAnimals.service;

public class Cat extends Animal {
    private boolean hasLongNails;

    // No args constructor.
    public Cat() {

    }

    // All args constructor. Calls constructor from super class Animal.
    public Cat(boolean isClean, int age, String name, int animalNumber, boolean hasLongNails) {
        super(isClean, age, name, animalNumber);
        this.hasLongNails = hasLongNails;
    }


    // Getters and setters.

    public boolean getHasLongNails() {
        return hasLongNails;
    }

    public void setHasLongNails(boolean hasLongNails) {
        this.hasLongNails = hasLongNails;
    }

    // Overridden from superclass.
    @Override
    public void treatAnimal() {
        super.treatAnimal();
        this.setHasLongNails(false);
    }
}
