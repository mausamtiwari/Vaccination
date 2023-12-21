package be.intecbrussel;

import java.util.Map;

public class Monkey extends Animal {
    private boolean isHyperActive;

    // No args constructor
    public Monkey() {

    }

    // All args constructor. Calls constructor from super class Animal.
    public Monkey(Map<Disease, Boolean> isVaccinated, boolean isClean, int age, String name, int animalNumber, boolean isHyperActive) {
        super(isVaccinated, isClean, age, name, animalNumber);
        this.isHyperActive = isHyperActive;
    }

    // Overridden from super class.
    @Override
    public void treatAnimal() {
        super.treatAnimal();
        Monkey monkey = new Monkey();
        monkey.setHyperActive(false);
    }


    // Getters and setters
    public boolean getIsHyperActive() {
        return isHyperActive;
    }

    public void setHyperActive(boolean hyperActive) {
        isHyperActive = hyperActive;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "isHyperActive=" + isHyperActive +
                "} " + super.toString();
    }
}
