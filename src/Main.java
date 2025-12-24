public class Main {

  public static void main(String[] args) {

    Pet pet = new Pet("Barsik", 4, "Dog", true);
    Owner owner = new Owner("Madik", "555-123", 1, false);
    Visit visit = new Visit("12.06.2025", "Check-up", 40);

    System.out.println("Pet: " + pet.getName());
    System.out.println("Owner: " + owner.getName());

    pet.heal();
    owner.addPet();
    visit.finishVisit();
  }
}



