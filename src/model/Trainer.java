package model;

public abstract class Trainer {
    protected int id;
    protected String name;
    protected int age;
    protected String gender;
    protected int experienceYears;

    public Trainer (int id, String name, int age, String gender, int experienceYears){
        setId(id);
        setName(name);
        setAge(age);
        setGender(gender);
        setExperienceYears(experienceYears);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age;}
    public String getGender() { return gender; }
    public int getExperienceYears() { return experienceYears; }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("Name must be at least 2 characters");
        }
        this.name = name;
    }

    public void setAge (int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
        this.age = age;
    }

    public void setGender (String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Gender cannot be empty");
        }
        this.gender = gender;
    }

    public void setExperienceYears (int experienceYears) {
        if (experienceYears <= 0) {
            throw new IllegalArgumentException("Experience years must be positive");
        }
        this.experienceYears = experienceYears;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Experience " + experienceYears + " years");
    }

    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    public abstract void work();
    public abstract String getRole();

    @Override
    public String toString() {
        return "[" + getRole() + "]" + name + " (ID: " + id + ") - " + age + " years old, " + gender + ", " + experienceYears + " experience years";
    }
}




//public class GymManagement implements Management {
//    private Scanner scanner;
//    private TrainerDAO trainerDAO;
//
//    public GymManagement() {
//        this.scanner = new Scanner(System.in);
//        this.trainerDAO = new TrainerDAO();
//
//        System.out.println("\n╔════════════════════════════════════════╗");
//        System.out.println("║  GYM MANAGEMENT SYSTEM v2.0    ║");
//        System.out.println("║  Week 8: Fully Database-Driven 🗄️     ║");
//        System.out.println("╚════════════════════════════════════════╝");
//        System.out.println("All data is stored in PostgreSQL");
//        System.out.println("No in-memory ArrayLists");
//        System.out.println("Complete CRUD operations");
//    }
//
//    @Override
//    public void displayManagement() {
//        System.out.println("\n╔════════════════════════════════════════╗");
//        System.out.println("║         MAIN MENU - Week 8            ║");
//        System.out.println("╚════════════════════════════════════════╝");
//        System.out.println("┌─ GYM MANAGEMENT ─────────────────────┐");
//        System.out.println("│ 1. Add Personal                      │");
//        System.out.println("│ 2. Add Group                         │");
//        System.out.println("│ 3. View All Trainer                  │");
//        System.out.println("│ 4. View Personals Only               │");
//        System.out.println("│ 5. View Groups Only                  │");
//        System.out.println("│ 6. Update Trainer                    │");
//        System.out.println("│ 7. Delete Trainer                    │");
//        System.out.println("├─ SEARCH & FILTER ────────────────────┤");
//        System.out.println("│ 8. Search by Name                    │");
//        System.out.println("│ 9. Search by Age Range               │");
//        System.out.println("│10. Old Trainer                       │");
//        System.out.println("├─ DEMO & OTHER ───────────────────────┤");
//        System.out.println("│11. Polymorphism Demo                 │");
//        System.out.println("│ 0. Exit                              │");
//        System.out.println("└──────────────────────────────────────┘");
//    }
//
//    @Override
//    public void run() {
//        boolean running = true;
//
//        while (running) {
//            displayManagement();
//            System.out.print("\nEnter your choice: ");
//
//            try {
//                int choice = scanner.nextInt();
//                scanner.nextLine();
//
//                switch (choice) {
//                    case 1:
//                        addPersonal();
//                        break;
//                    case 2:
//                        addGroup();
//                        break;
//                    case 3:
//                        viewAllTrainers();
//                        break;
//                    case 4:
//                        viewPersonals();
//                        break;
//                    case 5:
//                        viewGroups();
//                        break;
//                    case 6:
//                        updateTrainer();
//                        break;
//                    case 7:
//                        deleteTrainer();
//                        break;
//                    case 8:
//                        searchByName();
//                        break;
//                    case 9:
//                        searchByAgeRange();
//                        break;
//                    case 10:
//                        searchOldTrainer();
//                        break;
//                    case 11:
//                        demonstratePolymorphism();
//                        break;
//                    case 0:
//                        running = false;
//                        System.out.println("\n╔════════════════════════════════════════╗");
//                        System.out.println("║  Thank you for using our system!      ║");
//                        System.out.println("║  Goodbye!                             ║");
//                        System.out.println("╚════════════════════════════════════════╝");
//                        break;
//                    default:
//                        System.out.println("Invalid choice! Please select 0-11.");
//                }
//
//                if (choice != 0) {
//                    pressEnterToContinue();
//                }
//
//            } catch (java.util.InputMismatchException e) {
//                System.out.println(" Error: Please enter a valid number!");
//                scanner.nextLine();
//                pressEnterToContinue();
//            } catch (Exception e) {
//                System.out.println(" Error: " + e.getMessage());
//                scanner.nextLine();
//                pressEnterToContinue();
//            }
//        }
//
//        scanner.close();
//    }
//
//    // ========================================
//    // CREATE OPERATIONS
//    // ========================================
//
//    private void addPersonal() {
//        try {
//            System.out.println("\n┌─ ADD Personal Trainer ─────────────────────────────┐");
//
//            System.out.print("│ Enter Personal TRainer ID: ");
//            int id = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.print("│ Enter Name: ");
//            String name = scanner.nextLine();
//
//            System.out.print("│ Enter Age: ");
//            int age = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.println("| Enter Gender: ");
//            String gender = scanner.nextLine();
//
//            System.out.print("│ Enter Experience (years): ");
//            int experience = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.print("│ Enter Personal clients: ");
//            int personalClients = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.println("└────────────────────────────────────────┘");
//
//            Personal personal = new Personal(id, name, age, gender, experience, personalClients);
//            TrainerDAO.insertPersonal(personal);
//
//        } catch (java.util.InputMismatchException e) {
//            System.out.println("Error: Invalid input type!");
//            scanner.nextLine();
//        } catch (IllegalArgumentException e) {
//            System.out.println("Validation Error: " + e.getMessage());
//        }
//    }
//
//    private void addGroup() {
//        try {
//            System.out.println("\n┌─ ADD GROUP Trainer ───────────────────────────┐");
//
//            System.out.print("│ Enter Group Trainer ID: ");
//            int id = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.print("│ Enter Name: ");
//            String name = scanner.nextLine();
//
//            System.out.print("│ Enter Age: ");
//            int age = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.println("| Enter gender: ");
//            String gender = scanner.nextLine();
//
//            System.out.print("│ Enter Experience (years): ");
//            int experience = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.print("│ Enter Group size: ");
//            int groupSize = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.println("└────────────────────────────────────────┘");
//
//            Group group = new Group(id, name, age, gender,  experience, groupSize);
//            TrainerDAO.insertGroup(group);
//
//        } catch (java.util.InputMismatchException e) {
//            System.out.println("Error: Invalid input type!");
//            scanner.nextLine();
//        } catch (IllegalArgumentException e) {
//            System.out.println("Validation Error: " + e.getMessage());
//        }
//    }
//
//    // ========================================
//    // READ OPERATIONS
//    // ========================================
//
//    private void viewAllTrainers() {
//        TrainerDAO.displayAllTrainer();
//    }
//
//    private void viewPersonals() {
//        List<Personal> personals = TrainerDAO.getAllPersonals();
//
//        System.out.println("\n╔════════════════════════════════════════╗");
//        System.out.println("║         PERSONAL TRAINERS ONLY             ║");
//        System.out.println("╚════════════════════════════════════════╝");
//
//        if (personals.isEmpty()) {
//            System.out.println("No personal trainers in database.");
//        } else {
//            for (int i = 0; i < personals.size(); i++) {
//                Personal personal = personals.get(i);
//                System.out.println((i + 1) + ". " + personal.toString());
//                System.out.println("   Personal clients: " + personal.getPersonalClients());
//                if (personal.isPopular()) {
//                    System.out.println(" POPULAT PERSONAL TRAINER ");
//                }
//                System.out.println();
//            }
//            System.out.println("Total Personal trainers: " + personals.size());
//        }
//    }
//
//    private void viewGroups() {
//        List<Group> groups = TrainerDAO.getAllGroups();
//
//        System.out.println("\n╔════════════════════════════════════════╗");
//        System.out.println("║        GROUP TRAINERS ONLY                ║");
//        System.out.println("╚════════════════════════════════════════╝");
//
//        if (groups.isEmpty()) {
//            System.out.println("📭 No group trainers in database.");
//        } else {
//            for (int i = 0; i < groups.size(); i++) {
//                Group group = groups.get(i);
//                System.out.println((i + 1) + ". " + group.toString());
//                System.out.println("   Group size: " + group.getGroupSize());
//                if (group.isLargeGroup()) {
//                    System.out.println(" LARGE GROUP ");
//                }
//                System.out.println();
//            }
//            System.out.println("Total Group trainers: " + groups.size());
//        }
//    }
//
//    // ========================================
//    // UPDATE OPERATION (Week 8)
//    // ========================================
//
//    private void updateTrainer() {
//        System.out.println("\n┌─ UPDATE TRAINER ─────────────────────────┐");
//        System.out.print("│ Enter Trainer ID to update: ");
//
//        try {
//            int trainerId = scanner.nextInt();
//            scanner.nextLine();
//
//            String gender = scanner.nextLine();
//
//            // First, get existing trainer from database
//            Trainer existingTrainer = TrainerDAO.getTrainerById(trainerId);
//
//            if (existingTrainer == null) {
//                System.out.println("No trainer found with ID: " + trainerId);
//                return;
//            }
//
//            // Display current info
//            System.out.println("│ Current Info:");
//            System.out.println("│ " + existingTrainer.toString());
//            System.out.println("└────────────────────────────────────────┘");
//
//            // Get new values
//            System.out.println("\n┌─ ENTER NEW VALUES ─────────────────────┐");
//            System.out.println("│ (Press Enter to keep current value)   │");
//
//            System.out.print("│ New Name [" + existingTrainer.getName() + "]: ");
//            String newName = scanner.nextLine();
//            if (newName.trim().isEmpty()) {
//                newName = existingTrainer.getName();
//            }
//
//            System.out.print("│ New Age [" + existingTrainer.getAge() + "]: ");
//            String ageInput = scanner.nextLine();
//            int newAge = ageInput.trim().isEmpty() ?
//                    existingTrainer.getAge() : Integer.parseInt(ageInput);
//
//            System.out.print("│ New Experience [" + existingTrainer.getExperienceYears() + "]: ");
//            String expInput = scanner.nextLine();
//            int newExperience = expInput.trim().isEmpty() ?
//                    existingTrainer.getExperienceYears() : Integer.parseInt(expInput);
//
//            int newPersonalClients = 0;
//            if (existingTrainer instanceof Personal) {
//                Personal personal = (Personal) existingTrainer;
//                System.out.print("│ New Personal Clients [" + personal.getPersonalClients() + "]: ");
//                String personalClientsInput = scanner.nextLine();
//                newPersonalClients = personalClientsInput.trim().isEmpty() ?
//                        personal.getPersonalClients() : Integer.parseInt(personalClientsInput);
//
//                Personal updatedPersonal = new Personal(trainerId, newName, newAge, gender, newExperience, newPersonalClients);
//                TrainerDAO.updatePersonal(updatedPersonal);
//
//            } else if (existingTrainer instanceof Group) {
//                Group group = (Group) existingTrainer;
//                System.out.print("│ New Group size [" + group.getGroupSize() + "]: ");
//                String groupSizeInput = scanner.nextLine();
//                int newGroupSize = groupSizeInput.trim().isEmpty() ?
//                        group.getGroupSize() : Integer.parseInt(groupSizeInput);
//
//                Group updatedGroup = new Group(trainerId, newName, newAge, gender, newExperience, newGroupSize);
//                trainerDAO.updateGroup(updatedGroup);
//            }
//
//            System.out.println("└────────────────────────────────────────┘");
//
//        } catch (NumberFormatException e) {
//            System.out.println("Error: Invalid number format!");
//        } catch (IllegalArgumentException e) {
//            System.out.println(" Validation Error: " + e.getMessage());
//        }
//    }
//
//    // ========================================
//    // DELETE OPERATION (Week 8)
//    // ========================================
//
//    private void deleteTrainer() {
//        System.out.println("\n┌─ DELETE TRAINER ─────────────────────────┐");
//        System.out.print("│ Enter Trainer ID to delete: ");
//
//        try {
//            int trainerId = scanner.nextInt();
//            scanner.nextLine();
//
//            // First, show who will be deleted
//            Trainer trainer = TrainerDAO.getTrainerById(trainerId);
//
//            if (trainer == null) {
//                System.out.println("No trainer found with ID: " + trainerId);
//                return;
//            }
//
//            System.out.println("│ trainer to delete:");
//            System.out.println("│ " + trainer.toString());
//            System.out.println("└────────────────────────────────────────┘");
//
//            System.out.print("⚠Are you sure? (yes/no): ");
//            String confirmation = scanner.nextLine();
//
//            if (confirmation.equalsIgnoreCase("yes")) {
//                trainerDAO.deleteTrainer(trainerId);
//            } else {
//                System.out.println("Deletion cancelled.");
//            }
//
//        } catch (java.util.InputMismatchException e) {
//            System.out.println("Error: Invalid input!");
//            scanner.nextLine();
//        }
//    }
//
//    // ========================================
//    // SEARCH OPERATIONS (Week 8)
//    // ========================================
//
//    private void searchByName() {
//        System.out.println("\n┌─ SEARCH BY NAME ───────────────────────┐");
//        System.out.print("│ Enter name to search: ");
//        String name = scanner.nextLine();
//        System.out.println("└────────────────────────────────────────┘");
//
//        List<Trainer> results = TrainerDAO.searchByName(name);
//
//        displaySearchResults(results, "Search: '" + name + "'");
//    }
//
//    private void searchByAgeRange() {
//        try {
//            System.out.println("\n┌─ SEARCH BY AGE RANGE ───────────────┐");
//            System.out.print("│ Enter minimum age: ");
//            int minAge = scanner.nextInt();
//
//            System.out.print("│ Enter maximum age: ");
//            int maxAge = scanner.nextInt();
//            scanner.nextLine();
//            System.out.println("└────────────────────────────────────────┘");
//
//            List<Trainer> results = TrainerDAO.searchByAgeRange(minAge, maxAge);
//
//            displaySearchResults(results, "Age: " + minAge + " - " + maxAge + " KZT");
//
//        } catch (java.util.InputMismatchException e) {
//            System.out.println("Error: Invalid number!");
//            scanner.nextLine();
//        }
//    }
//
//    private void searchOldTrainer() {
//        try {
//            System.out.println("\n┌─ OLD TRAINER   ──────────────────────┐");
//            System.out.print("│ Enter minimum age: ");
//            int minAge = scanner.nextInt();
//            scanner.nextLine();
//            System.out.println("└────────────────────────────────────────┘");
//
//            List<Trainer> results = TrainerDAO.searchByMinAge(minAge);
//
//            displaySearchResults(results, "Age >= " + minAge + " years");
//
//        } catch (java.util.InputMismatchException e) {
//            System.out.println("Error: Invalid number!");
//            scanner.nextLine();
//        }
//    }
//
//    private void displaySearchResults(List<Trainer> results, String criteria) {
//        System.out.println("\n╔════════════════════════════════════════╗");
//        System.out.println("║         SEARCH RESULTS                ║");
//        System.out.println("╚════════════════════════════════════════╝");
//        System.out.println("Criteria: " + criteria);
//        System.out.println("─────────────────────────────────────────");
//
//        if (results.isEmpty()) {
//            System.out.println("No trainer found matching criteria.");
//        } else {
//            for (int i = 0; i < results.size(); i++) {
//                Trainer t = results.get(i);
//                System.out.print((i + 1) + ". ");
//                System.out.print("[" + t.getRole() + "] ");
//                System.out.println(t.toString());
//            }
//            System.out.println("─────────────────────────────────────────");
//            System.out.println("Total Results: " + results.size());
//        }
//    }
//
//    // ========================================
//    // POLYMORPHISM DEMO
//    // ========================================
//
//    private void demonstratePolymorphism() {
//        TrainerDAO.demonstratePolymorphism();
//    }
//
//    // ========================================
//    // HELPER METHOD
//    // ========================================
//
//    private void pressEnterToContinue() {
//        System.out.println("\n[Press Enter to continue...]");
//        scanner.nextLine();
//    }