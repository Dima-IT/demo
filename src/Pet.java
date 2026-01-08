public class Pet {
    protected int id;
    protected String name;
    protected int age;
    protected String ownerName;

    public Pet(int id, String name, int age, String ownerName) {
        this.id = id;
        setName(name);
        setAge(age);
        this.ownerName = ownerName;
    }

    // Getters & Setters (Encapsulation)
    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
        else
            this.name = "Unknown";
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age >= 0)
            this.age = age;
        else
            this.age = 0;
    }

    public String getOwnerName() { return ownerName; }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }

    public String getType() {
        return "Pet";
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " + name + " (Age: " + age + ", Owner: " + ownerName + ")";
    }
}
