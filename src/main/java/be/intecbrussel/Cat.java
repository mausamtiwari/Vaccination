package be.intecbrussel;

import java.util.Map;

public class Cat extends Animal {
    private boolean hasLongNails;

    public Cat(Map<Disease, Boolean> isVaccinated, boolean isClean, int age, String name, int animalNumber, boolean hasLongNails) {
        super(isVaccinated, isClean, age, name, animalNumber);
        this.hasLongNails = hasLongNails;
    }

    @Override
    public void treatAnimal() {
        super.treatAnimal();
        hasLongNails = false;
    }


    public boolean getHasLongNails() {
        return hasLongNails;
    }

    public void setHasLongNails(boolean hasLongNails) {
        this.hasLongNails = hasLongNails;
    }
}
