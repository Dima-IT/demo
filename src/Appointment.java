import java.time.LocalDateTime;

public class Appointment {

    private int id;
    private Pet pet;
    private Owner owner;
    private String reason;
    private LocalDateTime dateTime;
    private boolean cancelled;

    public Appointment(int id, Pet pet, Owner owner,
                       String reason, LocalDateTime dateTime) {
        this.id = id;
        this.pet = pet;
        this.owner = owner;
        this.reason = reason;
        this.dateTime = dateTime;
        this.cancelled = false;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getReason() {
        return reason;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    // setters
    public void setReason(String reason) {
        this.reason = reason;
    }

    // methods with logic
    public void reschedule(LocalDateTime newDateTime) {
        dateTime = newDateTime;
    }

    public void cancel() {
        cancelled = true;
    }

    @Override
    public String toString() {
        return "Appointment{id=" + id +
                ", pet=" + pet.getName() +
                ", owner=" + owner.getName() +
                ", reason='" + reason + '\'' +
                ", dateTime=" + dateTime +
                ", cancelled=" + cancelled +
                '}';
    }
}
