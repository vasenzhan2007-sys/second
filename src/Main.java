import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static ArrayList<Trainer> trainers = new ArrayList<>();
    private static ArrayList<Personal> personals = new ArrayList<>();
    private static ArrayList<Group> groups = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===Gym Management System=== ");
        System.out.println();

        trainers.add(new Trainer("Almas", 26, "Male", 5));
        trainers.add(new Trainer("Merey", 30, "Female", 7));
        personals.add(new Personal("Azamat", 25, "Male", 2, 6));
        groups.add(new Group("Aizada", 32, "Female", 6, 15));

        boolean run = true;
        while (run){
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    addTrainer();
                    break;
                case 2:
                    addPersonal();
                    break;
                case 3:
                    addGroup();
                    break;
                case 4:
                    viewTrainers();
                    break;
                case 5:
                    workTrainer();
                    break;
                case 6:
                    viewPersonals();
                    break;
                case 7:
                    viewGroups();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid number");
            }

            if (run) {
                System.out.println("Press to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    private static void displayMenu(){
        System.out.println("================================");
        System.out.println("     GYM MANAGEMENT SYSTEM");
        System.out.println("================================");
        System.out.println("1. Add Trainer");
        System.out.println("2. Add Personal trainer");
        System.out.println("3. Add Group trainer");
        System.out.println("4. View all Trainers");
        System.out.println("5. Make all Trainers work");
        System.out.println("6. View Personal trainers only");
        System.out.println("7. View Group trainers only");
        System.out.println("0. Exit");
        System.out.println("=================================");
        System.out.println("Enter your choice: ");
    }

    private static void addTrainer() {
        System.out.println("------ADD TRAINER------");
        System.out.println("Enter trainer name: ");
        String name = scanner.nextLine();

        System.out.println("Enter trainer age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter trainer gender: ");
        String gender = scanner.nextLine();

        System.out.println("Enter trainer experience years: ");
        int experienceYears = scanner.nextInt();
        scanner.nextLine();

        Trainer trainer = new Trainer(name, age, gender, experienceYears);
        trainers.add(trainer);

        System.out.println("Trainer added successfully!");
    }

    private static void addPersonal(){
        System.out.println("------ADD PERSONAL TRAINER------");
        System.out.println("Enter personal trainer name: ");
        String name = scanner.nextLine();

        System.out.println("Enter personal trainer age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter personal trainer gender: ");
        String gender = scanner.nextLine();

        System.out.println("Enter personal trainer experience years: ");
        int experienceYears = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter personal trainer clients: ");
        int personalClients = scanner.nextInt();
        scanner.nextLine();

        Trainer trainer = new Personal(name, age, gender, experienceYears, personalClients);
        trainers.add(trainer);

        System.out.println("Personal trainer added successfully!");
    }

    private static void addGroup() {
        System.out.println("------ADD GROUP TRAINER------");
        System.out.println("Enter group trainer name: ");
        String name = scanner.nextLine();

        System.out.println("Enter group trainer age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter group trainer gender: ");
        String gender = scanner.nextLine();

        System.out.println("Enter group trainer experience years: ");
        int experienceYears = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter group trainer group size: ");
        int groupSize = scanner.nextInt();
        scanner.nextLine();

        Trainer trainer = new Group(name, age, gender,experienceYears,groupSize);
        trainers.add(trainer);

        System.out.println("Group trainer added successfully!");
    }

    private static void viewTrainers() {
        System.out.println("===========================");
        System.out.println("     VIEW ALL TRAINERS");
        System.out.println("===========================");

        if (trainers.isEmpty()) {
            System.out.println("No trainers found");
            return;
        }

        System.out.println("Total trainers: " + trainers.size());
        System.out.println();

        for (int i = 0; i < trainers.size(); i++) {
            Trainer t = trainers.get(i);

            System.out.println((i + 1) + ". " + t);

            if (t instanceof Personal) {
                Personal personal = (Personal) t;
                if (personal.isPopular()) {
                    System.out.println(" Popular personal trainer!");
                }
            } else if (t instanceof  Group) {
                Group group = (Group) t;
                if (group.isLargeGroup()) {
                    System.out.println("Large Group trainer!");
                }
            }
            System.out.println();
        }
    }

    private static void workTrainer() {
        System.out.println("====================================");
        System.out.println("    POLYMORPHISM DEMONSTRATION");
        System.out.println("====================================");
        System.out.println("Calling work() on all trainers: ");
        System.out.println();

        for (Trainer t : trainers) {
            t.work();
        }

        System.out.println();
        System.out.println("Notice: Same method name (work), different output!");
        System.out.println("This is POLYMORPHISM in action!");
    }

    private static void viewPersonals() {
        System.out.println("===================================");
        System.out.println("       PERSONAL TRAINERS ONLY");
        System.out.println("===================================");

        int personalCount = 0;

        for (Personal p : personals) {
            if (p instanceof Personal) {
                Personal personal = (Personal) p;
                personalCount++;

                System.out.println(personalCount + ". " + personal.getName());
                System.out.println(" Age: " + personal.getAge());
                System.out.println("Experience years: " + personal.getExperienceYears());

                if (personal.isPopular()) {
                    System.out.println("Popular Personal trainer");
                }
                System.out.println();
            }
        }
        if (personalCount == 0) {
            System.out.println("No personal trainers found.");
        }
    }

    private static void viewGroups() {
        System.out.println("===================================");
        System.out.println("       GROUP TRAINERS ONLY");
        System.out.println("===================================");

        int groupCount = 0;

        for (Group g : groups) {
            if (g instanceof Group) {
                Group group = (Group) g;
                groupCount++;

                System.out.println(groupCount + ". " + group.getName());
                System.out.println(" Age: " + group.getAge());
                System.out.println("Experience years: " + group.getExperienceYears());

                if (group.isLargeGroup()) {
                    System.out.println("Large group trainer");
                }
                System.out.println();
            }
        }
        if (groupCount == 0) {
            System.out.println("No personal trainers found.");
        }
    }
}


