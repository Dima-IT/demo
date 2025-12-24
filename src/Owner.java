public class Owner {

    private String name;
    private String phone;
    private int pets;
    private boolean vip;

    public Owner(String name, String phone, int pets, boolean vip) {
        this.name = name;
        this.phone = phone;
        this.pets = pets;
        this.vip = vip;
    }

    public String getName() {
        return name;
    }

    public void addPet() {
        pets++;
        System.out.println(name + " has " + pets + " pets now.");
    }
}

