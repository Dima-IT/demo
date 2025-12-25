public class Pet {

    private int id;
    private String name;
    private String species;
    private int age;

    public Pet(int id, String name, String species, int age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    // setters
    public void setAge(int age) {
        this.age = age;
    }

    // methods with logic (как в Main)
    public boolean isAdult() {
        return age >= 2;
    }

    public void celebrateBirthday() {
        age++;
    }

    @Override
    public String toString() {
        return "Pet{id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                '}';
    }
}
