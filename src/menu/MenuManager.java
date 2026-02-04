package menu;

import database.PetDAO;
import exception.InvalidInputException;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    // ===== OLD (Week 5–6)
    private final ArrayList<Pet> pets = new ArrayList<>();
    private final ArrayList<Owner> owners = new ArrayList<>();
    private final ArrayList<Appointment> appointments = new ArrayList<>();

    // ===== NEW (Week 8)
    private final PetDAO petDAO = new PetDAO();
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

        System.out.println("-------- WEEK 8 (DATABASE) --------");
        System.out.println("8. Update Pet");
        System.out.println("9. Delete Pet");
        System.out.println("10. Search Pet by Name");
        System.out.println("11. Search Pet by Age Range");
        System.out.println("12. High-Age Pets (Age >= X)");

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
                    case 1 -> addPet();
                    case 2 -> addDog();
                    case 3 -> addCat();
                    case 4 -> viewAllPets();
                    case 5 -> polymorphismDemo();
                    case 6 -> viewDogsOnly();
                    case 7 -> viewCatsOnly();

                    // ===== WEEK 8
                    case 8 -> updatePetDB();
                    case 9 -> deletePetDB();
                    case 10 -> searchPetByName();
                    case 11 -> searchPetByAgeRange();
                    case 12 -> searchHighAgePets();

                    case 0 -> {
                        running = false;
                        System.out.println("Goodbye!");
                    }

                    default -> throw new InvalidInputException("Invalid choice: " + choice);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    // ================= INPUT HELPERS =================

    private int readIntStrict() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private String readNonEmpty(String field) {
        String s = scanner.nextLine().trim();
        if (s.isEmpty())
            throw new IllegalArgumentException(field + " cannot be empty");
        return s;
    }

    // ================= OLD PET METHODS =================

    private void addPet() {
        System.out.print("ID: ");
        int id = readIntStrict();
        System.out.print("Name: ");
        String name = readNonEmpty("Name");
        System.out.print("Age: ");
        int age = readIntStrict();
        System.out.print("Owner: ");
        String owner = readNonEmpty("Owner");

        Pet pet = new Pet(id, name, age, owner) {
            @Override
            public void makeSound() {
                System.out.println(name + " makes sound");
            }

            @Override
            public String getType() {
                return "Pet";
            }
        };

        pets.add(pet);
        System.out.println("Pet added (memory).");
    }

    private void addDog() {
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

        pets.add(new Dog(id, name, age, owner, breed));
        System.out.println("Dog added.");
    }

    private void addCat() {
        System.out.print("ID: ");
        int id = readIntStrict();
        System.out.print("Name: ");
        String name = readNonEmpty("Name");
        System.out.print("Age: ");
        int age = readIntStrict();
        System.out.print("Owner: ");
        String owner = readNonEmpty("Owner");
        System.out.print("Is indoor (true/false): ");
        boolean indoor = Boolean.parseBoolean(scanner.nextLine());

        pets.add(new Cat(id, name, age, owner, indoor));
        System.out.println("Cat added.");
    }

    private void viewAllPets() {
        if (pets.isEmpty()) {
            System.out.println("No pets.");
            return;
        }
        for (Pet p : pets) System.out.println(p);
    }

    private void polymorphismDemo() {
        for (Pet p : pets) p.makeSound();
    }

    private void viewDogsOnly() {
        for (Pet p : pets)
            if (p instanceof Dog d)
                System.out.println(d.getName() + " | Breed: " + d.getBreed());
    }

    private void viewCatsOnly() {
        for (Pet p : pets)
            if (p instanceof Cat c)
                System.out.println(c.getName() + " | Indoor: " + c.isIndoor());
    }

    // ================= WEEK 8 (PetDAO) =================

    private void updatePetDB() {
        System.out.print("Pet ID: ");
        int id = readIntStrict();

        System.out.print("New name: ");
        String name = readNonEmpty("Name");

        System.out.print("New age: ");
        int age = readIntStrict();

        System.out.print("New type: ");
        String type = readNonEmpty("Type");

        if (petDAO.updatePet(id, name, age, type)) {
            System.out.println("Pet updated in database.");
        } else {
            System.out.println("Pet not found.");
        }
    }

    private void deletePetDB() {
        System.out.print("Pet ID to delete: ");
        int id = readIntStrict();

        if (petDAO.deletePet(id)) {
            System.out.println("Pet deleted from database.");
        } else {
            System.out.println("Pet not found.");
        }
    }

    private void searchPetByName() {
        System.out.print("Enter name: ");
        String name = readNonEmpty("Name");
        petDAO.searchByName(name);
    }

    private void searchPetByAgeRange() {
        System.out.print("Min age: ");
        int min = readIntStrict();
        System.out.print("Max age: ");
        int max = readIntStrict();

        petDAO.searchByAgeRange(min, max);
    }

    private void searchHighAgePets() {
        System.out.print("Minimum age: ");
        int min = readIntStrict();
        petDAO.searchByMinAge(min);
    }
}
