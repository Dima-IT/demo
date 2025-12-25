import java.time.LocalDateTime;

public class Appointment {

    private int id;
    private Pet pet;
    private Owner owner;
    private String reason;
    private LocalDateTime dateTime;
    private boolean cancelled;

    // Default constructor
    public Appointment() {
    }

    // Constructor with all fields
    public Appointment(int id, Pet pet, Owner owner,
                       String reason, LocalDateTime dateTime, boolean cancelled) {
        this.id = id;
        this.pet = pet;
        this.owner = owner;
        this.reason = reason;
        this.dateTime = dateTime;
        this.cancelled = cancelled;
    }

    // Getters (for EVERY field)
    public int getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    // Setters (for EVERY field)
    public void setId(int id) {
        this.id = id;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    // Additional methods with logic
    public void reschedule(LocalDateTime newDateTime) {
        this.dateTime = newDateTime;
    }

    public void cancel() {
        this.cancelled = true;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", pet=" + pet.getName() +
                ", owner=" + owner.getName() +
                ", reason='" + reason + '\'' +
                ", dateTime=" + dateTime +
                ", cancelled=" + cancelled +
                '}';
    }
}

