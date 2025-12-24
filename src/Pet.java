public class Pet {

    private String name;
    private int age;
    private String type;
    private boolean sick;

    public Pet(String name, int age, String type, boolean sick) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.sick = sick;
    }

    public String getName() {
        return name;
    }

    public boolean isSick() {
        return sick;
    }

    public void heal() {
        sick = false;
        System.out.println(name + " is healthy now.");
    }
}

