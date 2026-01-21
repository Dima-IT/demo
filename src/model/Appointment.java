package model;

public class Appointment {
    private int id;
    private String petName;
    private String date;

    public Appointment(int id, String petName, String date) {
        setId(id);
        setPetName(petName);
        setDate(date);
    }

    public int getId() { return id; }
    public String getPetName() { return petName; }
    public String getDate() { return date; }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("Appointment ID must be > 0");
        this.id = id;
    }

    public void setPetName(String petName) {
        if (petName == null || petName.trim().isEmpty())
            throw new IllegalArgumentException("Pet name cannot be empty");
        this.petName = petName.trim();
    }

    public void setDate(String date) {
        if (date == null || date.trim().isEmpty())
            throw new IllegalArgumentException("Date cannot be empty");
        this.date = date.trim();
    }

    @Override
    public String toString() {
        return "Appointment #" + id + " for " + petName + " on " + date;
    }
}
