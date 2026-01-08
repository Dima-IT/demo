import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    ArrayList<Pet> pets = new ArrayList<>();

    // Polymorphism (Upcasting)
    pets.add(new Dog(1, "Rex", 4, "Aidar", "Labrador"));
    pets.add(new Cat(2, "Murka", 2, "Asel", true));
    pets.add(new Dog(3, "Bolt", 5, "Timur", "Shepherd"));

    System.out.println("=== ALL PETS (Polymorphism) ===");
    for (Pet p : pets) {
      System.out.println(p);
      p.makeSound();   // polymorphism
    }

    System.out.println("\n=== DOWNCASTING DEMO ===");
    for (Pet p : pets) {
      if (p instanceof Dog) {
        Dog d = (Dog) p;   // Downcasting
        d.fetch();
      }
      else if (p instanceof Cat) {
        Cat c = (Cat) p;
        c.scratch();
      }
    }

    Owner o1 = new Owner(1, "Aidar", "+77011234567");
    Appointment a1 = new Appointment(1, "Rex", "10-06-2026");

    System.out.println("\n" + o1);
    System.out.println(a1);
  }
}
