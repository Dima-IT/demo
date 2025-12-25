import java.time.LocalDateTime;

public class Main {

  public static void main(String[] args) {

    // ===== OWNER =====
    Owner owner = new Owner();
    owner.setId(1);
    owner.setName("Nikita");
    owner.setPhone("555-123");
    owner.setNumberOfPets(1);

    System.out.println("OWNER INFO:");
    System.out.println(owner);
    System.out.println("Owner ID: " + owner.getId());
    System.out.println("Owner Name: " + owner.getName());
    System.out.println("Owner Phone: " + owner.getPhone());
    System.out.println("Pets count: " + owner.getNumberOfPets());

    owner.addPet();
    System.out.println("After addPet(): " + owner);
    System.out.println("Has many pets: " + owner.hasManyPets());

    System.out.println("\n----------------------\n");

    // ===== PET =====
    Pet pet = new Pet();
    pet.setId(1);
    pet.setName("Barsik");
    pet.setSpecies("Dog");
    pet.setAge(2);

    System.out.println("PET INFO:");
    System.out.println(pet);
    System.out.println("Pet ID: " + pet.getId());
    System.out.println("Pet Name: " + pet.getName());
    System.out.println("Pet Species: " + pet.getSpecies());
    System.out.println("Pet Age: " + pet.getAge());

    System.out.println("Is adult: " + pet.isAdult());
    pet.celebrateBirthday();
    System.out.println("After birthday: " + pet);

    System.out.println("\n----------------------\n");

    // ===== APPOINTMENT =====
    Appointment appointment = new Appointment();
    appointment.setId(1);
    appointment.setPet(pet);
    appointment.setOwner(owner);
    appointment.setReason("Checkup");
    appointment.setDateTime(LocalDateTime.of(2024, 3, 10, 14, 30));
    appointment.setCancelled(false);

    System.out.println("APPOINTMENT INFO:");
    System.out.println(appointment);
    System.out.println("Appointment ID: " + appointment.getId());
    System.out.println("Reason: " + appointment.getReason());
    System.out.println("DateTime: " + appointment.getDateTime());
    System.out.println("Cancelled: " + appointment.isCancelled());

    appointment.reschedule(LocalDateTime.of(2024, 3, 15, 16, 0));
    System.out.println("After reschedule: " + appointment);

    appointment.cancel();
    System.out.println("After cancel: " + appointment);

    System.out.println("\n=== PROGRAM FINISHED ===");
  }
}
