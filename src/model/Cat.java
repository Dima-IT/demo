package model;

public class Cat extends Pet implements Treatable {
    private Boolean indoor;

    public Cat(int id, String name, int age, String ownerName, boolean indoor) {
        super(id, name, age, ownerName);
        setIndoor(indoor);
    }

    public boolean isIndoor() { return indoor != null && indoor; }

    public void setIndoor(Boolean indoor) {
        if (indoor == null) throw new IllegalArgumentException("Indoor value cannot be null");
        this.indoor = indoor;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }

    @Override
    public String getType() {
        return "Cat";
    }

    public void scratch() {
        System.out.println(name + " is scratching the sofa!");
    }

    @Override
    public String getCareInstructions() {
        return "Clean litter box, provide scratching post, routine checkups.";
    }
}

