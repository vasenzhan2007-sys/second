package management;

import model.*;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;

public class GymManagement implements Management {
    private ArrayList<Trainer> allTrainer;
    private ArrayList<Membership> allMemberships;
    private Scanner scanner;

    public GymManagement() {
        this.allTrainer = new ArrayList<>();
        this.allMemberships = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        try {
            allTrainer.add(new Personal(1 ,"Aidos", 26, "Male", 5, 20));
            allTrainer.add(new Group(2, "Anel", 20, "Female", 3, 10));
            allMemberships.add(new Membership("Basic", 15000.00, 3));
            allMemberships.add(new Membership("Premium", 30000.00, 6));
            allMemberships.add(new Membership("Basic", 20000.00, 5));
        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing test data: " + e.getMessage());
        }
    }

    @Override
    public void displayManagement() {
        System.out.println("=============================================");
        System.out.println("         GYM MANAGEMENT SYSTEM");
        System.out.println("=============================================");
        System.out.println("1. Add Personal trainer");
        System.out.println("2. Add Group trainer");
        System.out.println("3. View all trainers");
        System.out.println("4. View Personal trainers only");
        System.out.println("5. View Group trainers only");
        System.out.println("6. Make all trainers work (Polymorphism)");
        System.out.println("7. Add Membership");
        System.out.println("8. View all Memberships");
        System.out.println("9. Train Membership");
        System.out.println("0. Exit");
        System.out.println("=============================================");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayManagement();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addPersonal();
                        break;
                    case 2:
                        addGroup();
                        break;
                    case 3:
                        viewTrainers();
                        break;
                    case 4:
                        viewPersonals();
                        break;
                    case 5:
                        viewGroups();
                        break;
                    case 6:
                        Polymorphism();
                        break;
                    case 7:
                        addMembership();
                        break;
                    case 8:
                        viewMemberships();
                        break;
                    case 9:
                        trainMembership();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Thank you for using Gym Management System!");
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice!. Please select 0-9.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a valid number!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void addPersonal() {
        try {
            System.out.println("-----Add Personal trainer-----");
            System.out.println("Enter Personal trainer ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Personal trainer name: ");
            String name = scanner.nextLine();

            System.out.println("Enter Personal trainer age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Personal trainer gender: ");
            String gender = scanner.nextLine();

            System.out.println("Enter Personal trainer experience years: ");
            int experienceYears = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Personal trainer clients: ");
            int personalClients = scanner.nextInt();
            scanner.nextLine();

            Personal personal = new Personal(id, name, age, gender, experienceYears, personalClients);
            allTrainer.add(personal);
            System.out.println("Personal trainer added");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }

    private void addGroup() {
        try {
            System.out.println("-----Add Group trainer-----");
            System.out.println("Enter Group trainer ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Group trainer name: ");
            String name = scanner.nextLine();

            System.out.println("Enter Group trainer age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Group trainer gender: ");
            String gender = scanner.nextLine();

            System.out.println("Enter Group trainer experience years: ");
            int experienceYears = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Group trainer group size: ");
            int groupSize = scanner.nextInt();
            scanner.nextLine();

            Group group = new Group(id, name, age, gender, experienceYears, groupSize);
            allTrainer.add(group);
            System.out.println("Group trainer added!");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewTrainers() {
        System.out.println("=============================================");
        System.out.println("               ALL TRAINERS");
        System.out.println("=============================================");

        if (allTrainer.isEmpty()) {
            System.out.println("No trainers found.");
            return;
        }

        for (int i = 0; i < allTrainer.size(); i++) {
            Trainer t = allTrainer.get(i);
            System.out.print((i + 1) + ". ");

            if (t instanceof Personal) {
                System.out.print("[Personal trainer]");
                Personal personal = (Personal) t;
                if (personal.isPopular()) {
                    System.out.println("POPULAR PERSONAL TRAINER");
                }
            } else if (t instanceof Group) {
                System.out.println("[Group trainer]");
                Group group = (Group) t;
                if (group.isLargeGroup()) {
                    System.out.println("LARGE GROUP TRAINER");
                }
            }
            System.out.println(t.toString());
        }
    }

    private void viewPersonals() {
        System.out.println("=============================================");
        System.out.println("          PERSONAL TRAINERS ONLY");
        System.out.println("=============================================");

        boolean foundPersonal = false;

        for (Trainer t : allTrainer) {
            if (t instanceof Personal) {
                Personal personal = (Personal) t;
                System.out.println(" Clients: " + personal.getPersonalClients());
                if (personal.isPopular()) {
                    System.out.println("Popular personal trainer");
                }
                System.out.println();
                foundPersonal = true;
            }
        }

        if (!foundPersonal) {
            System.out.println("No personal trainers");
        }
    }

    private void viewGroups() {
        System.out.println("=======================================");
        System.out.println("          GROUP TRAINERS ONLY");
        System.out.println("=======================================");

        boolean foundGroup = false;

        for (Trainer t : allTrainer) {
            if (t instanceof Group) {
                Group group = (Group) t;
                System.out.println(group.toString());
                System.out.println(" Group size: " + group.getGroupSize());
                if (group.isLargeGroup()) {
                    System.out.println("LARGE GROUP TRAINER");
                }
                System.out.println();
                foundGroup = true;
            }
        }

        if (!foundGroup) {
            System.out.println("No group trainers found.");
        }
    }

    private void Polymorphism() {
        System.out.println("=============================================");
        System.out.println("    POLYMORPHISM: ALL TRAINERS WORKING");
        System.out.println("=============================================");

        if (allTrainer.isEmpty()) {
            System.out.println("No trainers to demonstrate.");
            return;
        }

        for (Trainer t : allTrainer) {
            t.work();
        }

        System.out.println("As you can see, same method (work()) but different behavior!");
        System.out.println("This is POLYMORPHISM in action!");
    }

    private void addMembership() {
        try {
            System.out.println("-----Add Membership-----");

            System.out.println("Enter Membership type: ");
            String type = scanner.nextLine();

            System.out.println("Enter Membership price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter Membership duration (months): ");
            int durationMonths = scanner.nextInt();
            scanner.nextLine();

            Membership membership = new Membership(type, price, durationMonths);
            allMemberships.add(membership);
            System.out.println("Membership added successfully!");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewMemberships() {
        System.out.println("=====================================");
        System.out.println("          GYM MEMBERSHIPS");
        System.out.println("=====================================");

        if (allMemberships.isEmpty()) {
            System.out.println("No memberships found");
            return;
        }

        for (int i = 0; i < allMemberships.size(); i++) {
            System.out.println((i + 1) + ". " + allMemberships.get(i).toString());
        }
    }

    private void trainMembership() {
        System.out.println("-----Train Memberships-----");

        if (allMemberships.isEmpty()) {
            System.out.println("No Memberships available to train!");
            return;
        }

        System.out.println("Available Memberships: ");
        for (int i = 10; i < allMemberships.size(); i++) {
            System.out.println((i + 1) + ". " + allMemberships.get(i).getType());
        }

        try {
            System.out.print("Select Membership number to train: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 1 || choice > allMemberships.size()) {
                throw new InvalidInputException("Invalid Membership number!");
            }

            Membership membership = allMemberships.get(choice - 1);
            membership.train();
            System.out.println("Train: " + membership.getMembership());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter a valid number!");
            scanner.nextLine();
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}