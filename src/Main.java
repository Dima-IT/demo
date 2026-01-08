import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  private static ArrayList<Pet> pets = new ArrayList<>();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    // Test data
    pets.add(new Dog(1, "Rex", 4, "Aidar", "Labrador"));
    pets.add(new Cat(2, "Murka", 2, "Asel", true));

    boolean running = true;

    while (running) {
      showMenu();
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          addPet();
          break;
        case 2:
          addDog();
          break;
        case 3:
          addCat();
          break;
        case 4:
          viewAllPets();
          break;
        case 5:
          polymorphismDemo();
          break;
        case 6:
          viewDogsOnly();
          break;
        case 7:
          viewCatsOnly();
          break;
        case 0:
          running = false;
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid choice!");
      }

      if (running) {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
      }
    }
  }

  // ===== MENU =====
  private static void showMenu() {
    System.out.println("\n==============================");
    System.out.println("     VET CLINIC SYSTEM");
    System.out.println("==============================");
    System.out.println("1. Add Pet (General)");
    System.out.println("2. Add Dog");
    System.out.println("3. Add Cat");
    System.out.println("4. View All Pets");
    System.out.println("5. Polymorphism Demo");
    System.out.println("6. View Dogs Only");
    System.out.println("7. View Cats Only");
    System.out.println("0. Exit");
    System.out.print("Enter choice: ");
  }

  // ===== ADD METHODS =====

  private static void addPet() {
    System.out.println("\n--- ADD PET ---");

    System.out.print("ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Name: ");
    String name = scanner.nextLine();

    System.out.print("Age: ");
    int age = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Owner: ");
    String owner = scanner.nextLine();

    Pet pet = new Pet(id, name, age, owner);
    pets.add(pet);

    System.out.println("Pet added!");
  }

  private static void addDog() {
    System.out.println("\n--- ADD DOG ---");

    System.out.print("ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Name: ");
    String name = scanner.nextLine();

    System.out.print("Age: ");
    int age = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Owner: ");
    String owner = scanner.nextLine();

    System.out.print("Breed: ");
    String breed = scanner.nextLine();

    Pet dog = new Dog(id, name, age, owner, breed);  // Polymorphism
    pets.add(dog);

    System.out.println("Dog added!");
  }

  private static void addCat() {
    System.out.println("\n--- ADD CAT ---");

    System.out.print("ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Name: ");
    String name = scanner.nextLine();

    System.out.print("Age: ");
    int age = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Owner: ");
    String owner = scanner.nextLine();

    System.out.print("Is indoor? (true/false): ");
    boolean indoor = scanner.nextBoolean();
    scanner.nextLine();

    Pet cat = new Cat(id, name, age, owner, indoor);
    pets.add(cat);

    System.out.println("Cat added!");
  }

  // ===== VIEW METHODS =====

  private static void viewAllPets() {
    System.out.println("\n=== ALL PETS ===");

    if (pets.isEmpty()) {
      System.out.println("No pets found.");
      return;
    }

    for (Pet p : pets) {
      System.out.println(p);
    }
  }

  private static void polymorphismDemo() {
    System.out.println("\n=== POLYMORPHISM DEMO ===");

    for (Pet p : pets) {
      p.makeSound();   // polymorphism
    }
  }



  private static void viewDogsOnly() {
    System.out.println("\n=== DOGS ONLY ===");

    int count = 0;

    for (Pet p : pets) {
      if (p instanceof Dog) {
        Dog d = (Dog) p;
        count++;

        System.out.println(count + ". " + d.getName());
        System.out.println("   Breed: " + d.getBreed());
        System.out.println("   Age: " + d.getAge());
        System.out.println();
      }
    }

    if (count == 0) {
      System.out.println("No dogs found.");
    }
  }

  private static void viewCatsOnly() {
    System.out.println("\n=== CATS ONLY ===");

    int count = 0;

    for (Pet p : pets) {
      if (p instanceof Cat) {
        Cat c = (Cat) p;
        count++;

        System.out.println(count + ". " + c.getName());
        System.out.println("   Indoor: " + c.isIndoor());
        System.out.println("   Age: " + c.getAge());
        System.out.println();
      }
    }

    if (count == 0) {
      System.out.println("No cats found.");
    }
  }
}
