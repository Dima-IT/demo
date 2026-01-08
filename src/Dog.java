public class Dog extends Pet {
    private String breed;

    public Dog(int id, String name, int age, String ownerName, String breed) {
        super(id, name, age, ownerName);
        this.breed = breed;
    }

    public String getBreed() { return breed; }

    public void setBreed(String breed) {
        this.breed = breed;
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
}
