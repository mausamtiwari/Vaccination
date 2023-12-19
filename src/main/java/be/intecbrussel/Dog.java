package be.intecbrussel;

import java.util.Map;

public class Dog extends Animal {
    private boolean hasFoulBreath;


    public Dog(){

    }
    public Dog(Map<Disease, Boolean> isVaccinated, boolean isClean, int age, String name, int animalNumber, boolean hasFoulBreath) {
        super(isVaccinated, isClean, age, name, animalNumber);
        this.hasFoulBreath = hasFoulBreath;
    }

    public void treatAnimal() {
        super.treatAnimal();
    }

    public boolean getHasFoulBreath() {
        return hasFoulBreath;
    }

    public void setHasFoulBreath(boolean hasFoulBreath) {
        this.hasFoulBreath = hasFoulBreath;
    }
}
