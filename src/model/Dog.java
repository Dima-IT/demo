package model;

public class Dog extends Pet implements Treatable {
    private String breed;

    public Dog(int id, String name, int age, String ownerName, String breed) {
        super(id, name, age, ownerName);
        setBreed(breed);
    }

    public String getBreed() { return breed; }

    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty())
            throw new IllegalArgumentException("Breed cannot be empty");
        this.breed = breed.trim();
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    @Override
    public String getType() {
        return "Dog";
    }

    public void fetch() {
        System.out.println(name + " is fetching a ball!");
    }

    @Override
    public String getCareInstructions() {
        return "Walk daily, fresh water, and regular vaccinations.";
    }

}
