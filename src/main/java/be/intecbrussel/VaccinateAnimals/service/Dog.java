package be.intecbrussel.VaccinateAnimals.service;

public class Dog extends Animal {
    private boolean hasFoulBreath;

    // No args constructor.
    public Dog() {

    }

    // All args constructor. Calls constructor from super class Animal.
    public Dog( boolean isClean, int age, String name, int animalNumber, boolean hasFoulBreath) {
        super( isClean, age, name, animalNumber);
        this.hasFoulBreath = hasFoulBreath;
    }

    // Getters and setters.
    public boolean getHasFoulBreath() {
        return hasFoulBreath;
    }

    public void setHasFoulBreath(boolean hasFoulBreath) {
        this.hasFoulBreath = hasFoulBreath;
    }

    @Override
    public void treatAnimal() {
        super.treatAnimal();
        this.setHasFoulBreath(false);
    }

}
