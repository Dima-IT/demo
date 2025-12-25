public class Owner {

    private int id;
    private String name;
    private String phone;
    private int numberOfPets;

    public Owner(int id, String name, String phone, int numberOfPets) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.numberOfPets = numberOfPets;
    }

    // getters
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

    // setters
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // methods with logic (как в Main)
    public void addPet() {
        numberOfPets++;
    }

    public boolean hasManyPets() {
        return numberOfPets >= 3;
    }

    @Override
    public String toString() {
        return "Owner{id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfPets=" + numberOfPets +
                '}';
    }
}
