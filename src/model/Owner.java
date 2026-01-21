package model;

public class Owner {
    private int id;
    private String name;
    private String phone;

    public Owner(int id, String name, String phone) {
        setId(id);
        setName(name);
        setPhone(phone);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("Owner ID must be > 0");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Owner name cannot be empty");
        this.name = name.trim();
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty())
            throw new IllegalArgumentException("Phone cannot be empty");
        this.phone = phone.trim();
    }

    @Override
    public String toString() {
        return "Owner: " + name + " | Phone: " + phone;
    }
}

