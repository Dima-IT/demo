package model;

public abstract class Pet {
    protected int id;
    protected String name;
    protected int age;
    protected String ownerName;

    public Pet(int id, String name, int age, String ownerName) {
        setId(id);
        setName(name);
        setAge(age);
        setOwnerName(ownerName);
    }


    public abstract void makeSound();
    public abstract String getType();

    // ===== Getters =====
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getOwnerName() { return ownerName; }

    // ===== Setters (MUST throw exceptions) =====

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be > 0");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name.trim();
    }

    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty())
            throw new IllegalArgumentException("Owner name cannot be empty");
        this.ownerName = ownerName.trim();
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " + name + " (Age: " + age + ", Owner: " + ownerName + ")";
    }
}
