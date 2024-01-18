package be.intecbrussel.VaccinateAnimals;

public class Monkey extends Animal {
    private boolean isHyperActive;

    // No args constructor
    public Monkey() {

    }

    // All args constructor. Calls constructor from super class Animal.
    public Monkey( boolean isClean, int age, String name, int animalNumber, boolean isHyperActive) {
        super( isClean, age, name, animalNumber);
        this.isHyperActive = isHyperActive;
    }




    // Getters and setters
    public boolean getIsHyperActive() {
        return isHyperActive;
    }

    public void setHyperActive(boolean hyperActive) {
        isHyperActive = hyperActive;
    }


    // Overridden from super class.
    @Override
    public void treatAnimal() {
        super.treatAnimal();
        this.setHyperActive(false);
    }
}
