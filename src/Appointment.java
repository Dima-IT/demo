public class Appointment {
    private int id;
    private String petName;
    private String date;

    public Appointment(int id, String petName, String date) {
        this.id = id;
        this.petName = petName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment #" + id + " for " + petName + " on " + date;
    }
}
