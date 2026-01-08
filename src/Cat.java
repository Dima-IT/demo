public class Cat extends Pet {
    private boolean indoor;

    public Cat(int id, String name, int age, String ownerName, boolean indoor) {
        super(id, name, age, ownerName);
        this.indoor = indoor;
    }

    public boolean isIndoor() { return indoor; }

    public void setIndoor(boolean indoor) {
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
}
