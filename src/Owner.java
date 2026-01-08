public class Owner {
    private int id;
    private String name;
    private String phone;

    public Owner(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Owner: " + name + " | Phone: " + phone;
    }
}
