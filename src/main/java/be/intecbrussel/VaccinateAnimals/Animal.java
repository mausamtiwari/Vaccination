package be.intecbrussel.VaccinateAnimals;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public abstract class Animal implements Vaccinateable, Treatable {

    private Map<Disease, Boolean> isVaccinated = new HashMap<>();
    private Boolean isClean;
    private int age;
    private String name;
    private int animalNumber;



    // No args constructor.
    public Animal() {
        this(false, 0, "DEFAULT_ANIMAL_NAME", -1);
    }

    // All args constructor.
    public Animal( Boolean isClean, int age, String name, int animalNumber) {
        this.isClean = isClean;
        this.age = age;
        this.name = name;
        this.animalNumber = animalNumber;
        Stream.of(Disease.values()).forEach((key-> isVaccinated.put(key,false)));
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


    // Treats animal. Sets isClean to true.
    @Override
    public void treatAnimal() {
        this.isClean = true;
    }

    // Vaccinates animal. Sets Vaccination for a specified disease to true.
    @Override
    public void vaccinateAnimal(Disease disease) {
        isVaccinated.replace(disease, true);
        this.isClean = true;
    }


    @Override
    public String toString() {
        return "isClean=" + isClean +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", animalNumber=" + animalNumber ;
    }

}
