package be.intecbrussel;

import java.util.Map;

public class Animal implements Vaccinateable, Treatable {

    private Map<Disease, Boolean> isVaccinated;
    private Boolean isClean;
    private int age;
    private String name;
    private int animalNumber;


    // Treats animal. Sets isClean to true.
    @Override
    public void treatAnimal() {
        this.isClean = true;
    }

    // Vaccinates animal. Sets Vaccination for a specified disease to true.
    @Override
    public void vaccinateAnimal(Disease disease) {
        isVaccinated.put(disease, true);
    }

    // No args constructor.
    public Animal() {

    }

    // All args constructor.
    public Animal(Map<Disease, Boolean> isVaccinated, Boolean isClean, int age, String name, int animalNumber) {
        this.isVaccinated = isVaccinated;
        this.isClean = isClean;
        this.age = age;
        this.name = name;
        this.animalNumber = animalNumber;
    }

    // getters and setters
    public Map<Disease, Boolean> getIsVaccinated() {
        return isVaccinated;
    }

    public void setIsVaccinated(Map<Disease, Boolean> isVaccinated) {
        this.isVaccinated = isVaccinated;
    }

    public Boolean getIsClean() {
        return isClean;
    }

    public void setClean(Boolean clean) {
        isClean = clean;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnimalNumber() {
        return animalNumber;
    }

    public void setAnimalNumber(int animalNumber) {
        this.animalNumber = animalNumber;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "isVaccinated=" + isVaccinated +
                ", isClean=" + isClean +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", animalNumber=" + animalNumber +
                '}';
    }

}
