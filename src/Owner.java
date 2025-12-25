public class Owner {

    private int id;
    private String name;
    private String phone;
    private int numberOfPets;

    // Default constructor
    public Owner() {
    }

    // Constructor with all fields
    public Owner(int id, String name, String phone, int numberOfPets) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.numberOfPets = numberOfPets;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getNumberOfPets() {
        return numberOfPets;
    }

    // Setters (for EVERY field)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNumberOfPets(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }

    // Additional methods with logic
    public void addPet() {
        this.numberOfPets++;
    }

    public boolean hasManyPets() {
        return this.numberOfPets >= 3;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfPets=" + numberOfPets +
                '}';
    }
}
