package menu;

import exception.InvalidInputException;
import model.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private final ArrayList<Pet> pets = new ArrayList<>();
    private final ArrayList<Owner> owners = new ArrayList<>();
    private final ArrayList<Appointment> appointments = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public MenuManager() {

        pets.add(new Dog(1, "Rex", 4, "Aidar", "Labrador"));
        pets.add(new Cat(2, "Murka", 2, "Asel", true));
    }

    @Override
    public void displayMenu() {
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

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();

            try {
                int choice = readIntStrict();

                switch (choice) {
                    case 1: addPet(); break;
                    case 2: addDog(); break;
                    case 3: addCat(); break;
                    case 4: viewAllPets(); break;
                    case 5: polymorphismDemo(); break;
                    case 6: viewDogsOnly(); break;
                    case 7: viewCatsOnly(); break;
                    case 0:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        throw new InvalidInputException("Invalid choice: " + choice);
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                if (running) {
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                }
            }
        }
    }


    private int readIntStrict() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private String readNonEmpty(String field) {
        String s = scanner.nextLine();
        if (s == null || s.trim().isEmpty())
            throw new IllegalArgumentException(field + " cannot be empty");
        return s.trim();
    }

    private boolean readBooleanStrict() {
        String s = scanner.nextLine().trim().toLowerCase();
        if (s.equals("true")) return true;
        if (s.equals("false")) return false;
        throw new IllegalArgumentException("Please type true or false.");
    }


    // ===== ADD METHODS

    private void addPet() {
        System.out.println("\n add pet");
        System.out.print("id: ");
        int id = readIntStrict();
        System.out.print("name:");
        String name = readNonEmpty("Name");
        System.out.print("age: ");
        int age = readIntStrict();
        System.out.print("owner: ");
        String owner = readNonEmpty("Owner");
        Pet pet = new Pet(id, name, age, owner) {
            @Override
            public void makeSound() {
                System.out.println(name + "sound");
            }
            @Override
            public String getType() {
                return "Pet";
            }
        };

        pets.add(pet);
        System.out.println("u add a pet");
    }

    private void addDog() {
        System.out.println("\n--- ADD DOG ---");

        System.out.print("ID: ");
        int id = readIntStrict();

        System.out.print("Name: ");
        String name = readNonEmpty("Name");

        System.out.print("Age: ");
        int age = readIntStrict();

        System.out.print("Owner: ");
        String owner = readNonEmpty("Owner");

        System.out.print("Breed: ");
        String breed = readNonEmpty("Breed");

        Pet dog = new Dog(id, name, age, owner, breed);
        pets.add(dog);

        System.out.println("Dog added!");
    }

    private void addCat() {
        System.out.println("\n--- ADD CAT ---");

        System.out.print("ID: ");
        int id = readIntStrict();

        System.out.print("Name: ");
        String name = readNonEmpty("Name");

        System.out.print("Age: ");
        int age = readIntStrict();

        System.out.print("Owner: ");
        String owner = readNonEmpty("Owner");

        System.out.print("Is indoor? (true/false): ");
        boolean indoor = readBooleanStrict();

        Pet cat = new Cat(id, name, age, owner, indoor);
        pets.add(cat);

        System.out.println("Cat added!");
    }

    // ===== VIEW METHODS

    private void viewAllPets() {
        System.out.println("\n=== ALL PETS ===");

        if (pets.isEmpty()) {
            System.out.println("No pets found.");
            return;
        }

        for (Pet p : pets) {
            System.out.println(p);
        }
    }


    private void polymorphismDemo() {
        System.out.println("\n=== POLYMORPHISM DEMO ===");
        for (Pet p : pets) {
            p.makeSound();
        }
    }

    private void viewDogsOnly() {
        System.out.println("\n=== DOGS ONLY ===");

        int count = 0;

        for (Pet p : pets) {
            if (p instanceof Dog) {
                Dog d = (Dog) p; //
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

    private void viewCatsOnly() {
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
  //








