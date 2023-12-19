package be.intecbrussel;

import java.util.Map;

public class Monkey extends Animal{
    private boolean isHyperActive;

    public Monkey(){

    }
    public Monkey(Map<Disease, Boolean> isVaccinated, boolean isClean, int age, String name, int animalNumber, boolean isHyperActive) {
        super(isVaccinated, isClean, age, name, animalNumber);
        this.isHyperActive = isHyperActive;
    }

    public void treatAnimal() {
        super.treatAnimal();
    }


    public boolean getHyperActive() {
        return isHyperActive;
    }

    public void setHyperActive(boolean hyperActive) {
        isHyperActive = hyperActive;
    }
}
