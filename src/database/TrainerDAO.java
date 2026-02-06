package database;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * StaffDAO - Week 8 Enhanced
 * Complete CRUD operations + Advanced Search
 * - CREATE (INSERT) ✓
 * - READ (SELECT) ✓
 * - UPDATE ✓ NEW!
 * - DELETE ✓ NEW!
 * - SEARCH by name ✓ NEW!
 * - SEARCH by age range ✓ NEW!
 */
public class TrainerDAO {

    // ========================================
    // CREATE - INSERT OPERATIONS (Week 7)
    // ========================================

    /**
     * INSERT Personal into database
     */
    public static boolean insertPersonal(Personal personal) {
        String sql = "INSERT INTO trainer (name, age, gender, staff_type, experience_years, personalClients) " +
                "VALUES (?, ?, ?, 'PERSONAL', ?, NULL)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, personal.getName());
            statement.setInt(2, personal.getAge());
            statement.setString(3, personal.getGender());
            statement.setInt(4, personal.getExperienceYears());

            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("Personal trainer inserted: " + personal.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Insert Personal trainer failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    /**
     * INSERT Group into database
     */
    public static boolean insertGroup(Group group) {
        String sql = "INSERT INTO trainer (name, age, gender, staff_type, experience_years, groupSize) " +
                "VALUES (?, ?, ?, 'GROUP', ?, NULL)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, group.getName());
            statement.setInt(2, group.getAge());
            statement.setString(3, group.getGender());
            statement.setInt(4, group.getGroupSize());

            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("Group trainer inserted: " + group.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Insert Group trainer failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    // ========================================
    // READ - SELECT OPERATIONS (Week 7)
    // ========================================

    /**
     * SELECT ALL trainers
     * @return List of Trainer (Personal and Group objects)
     */
    public static List<Trainer> getAllTrainer() {
        List<Trainer> trainerList = new ArrayList<>();
        String sql = "SELECT * FROM trainer ORDER BY trainer_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return trainerList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Trainer trainer = extractTrainerFromResultSet(resultSet);
                if (trainer != null) {
                    trainerList.add(trainer);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Retrieved " + trainerList.size() + " trainer from database");

        } catch (SQLException e) {
            System.out.println("Select all trainer failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return trainerList;
    }

    /**
     * SELECT trainer by ID
     */
    public static Trainer getTrainerById(int trainerId) {
        String sql = "SELECT * FROM trainer WHERE trainer_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, trainerId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Trainer trainer = extractTrainerFromResultSet(resultSet);

                resultSet.close();
                statement.close();

                if (trainer != null) {
                    System.out.println("Found trainer with ID: " + trainerId);
                }

                return trainer;
            }

            System.out.println("No trainer found with ID: " + trainerId);

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Select by ID failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }

    /**
     * SELECT all Personals
     */
    public static List<Personal> getAllPersonals() {
        List<Personal> personals = new ArrayList<>();
        String sql = "SELECT * FROM trainer WHERE trainer_type = 'PERSONAL' ORDER BY trainer_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return personals;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Trainer trainer = extractTrainerFromResultSet(resultSet);
                if (trainer instanceof Personal) {
                    personals.add((Personal) trainer);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Retrieved " + personals.size() + " personal trainers");

        } catch (SQLException e) {
            System.out.println("Select personal trainers failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return personals;
    }

    /**
     * SELECT all Groups
     */
    public static List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<>();
        String sql = "SELECT * FROM trainer WHERE trainer_type = 'GROUP' ORDER BY trainer_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return groups;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Trainer trainer = extractTrainerFromResultSet(resultSet);
                if (trainer instanceof Group) {
                    groups.add((Group) trainer);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Retrieved " + groups.size() + " group trainers");

        } catch (SQLException e) {
            System.out.println("Select group trainers failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return groups;
    }

    // ========================================
    // WEEK 8: UPDATE OPERATION
    // ========================================

    /**
     * UPDATE Personal in database
     * @param personal Personal object with updated data
     * @return true if successful
     */

    // PERSONAL from DB
    // PERSONAL set change
    // update personal
    public static boolean updatePersonal(Personal personal) {
        String sql = "UPDATE trainer SET name = ?, age = ?, gender = ?, personal_clients = ? " +
                "WHERE trainer_id = ? AND trainer_type = 'PERSONAL'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, personal.getName());
            statement.setInt(2, personal.getAge());
            statement.setString(3, personal.getGender());
            statement.setInt(4, personal.getPersonalClients());
            statement.setInt(5, personal.getId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("Personal trainer updated: " + personal.getName());
                return true;
            } else {
                System.out.println("No personal trainer found with ID: " + personal.getId());
            }

        } catch (SQLException e) {
            System.out.println("Update Personal trainer failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    /**
     * UPDATE Group in database
     * @param group Group object with updated data
     * @return true if successful
     */
    public boolean updateGroup(Group group) {
        String sql = "UPDATE trainer SET name = ?, age = ?, gender = ?, group_size = ? " +
                "WHERE trainer_id = ? AND trainer_type = 'GROUP'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, group.getName());
            statement.setInt(2, group.getAge());
            statement.setString(3, group.getGender());
            statement.setInt(4, group.getGroupSize());
            statement.setInt(5, group.getId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("Group trainer updated: " + group.getName());
                return true;
            } else {
                System.out.println("No group trainer found with ID: " + group.getId());
            }

        } catch (SQLException e) {
            System.out.println("Update Group trainer failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    // ========================================
    // WEEK 8: DELETE OPERATION
    // ========================================

    /**
     * DELETE trainer by ID
     * @param trainerId ID of trainer to delete
     * @return true if successful
     */
    public boolean deleteTrainer(int trainerId) {
        String sql = "DELETE FROM trainer WHERE trainer_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, trainerId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted > 0) {
                System.out.println("Trainer deleted (ID: " + trainerId + ")");
                return true;
            } else {
                System.out.println("No trainer found with ID: " + trainerId);
            }

        } catch (SQLException e) {
            System.out.println("Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    // ========================================
    // WEEK 8: SEARCH BY NAME
    // ========================================

    /**
     * SEARCH trainer by name (partial match, case-insensitive)
     * Example: searchByName("mur") finds "Murat", "Murray", etc.
     * @param name Name or partial name to search
     * @return List of matching trainer
     */
    public static List<Trainer> searchByName(String name) {
        List<Trainer> trainerList = new ArrayList<>();

        // ILIKE for case-insensitive search, % for partial match
        String sql = "SELECT * FROM trainer WHERE name ILIKE ? ORDER BY name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return trainerList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");  // % = wildcard

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Trainer trainer = extractTrainerFromResultSet(resultSet);
                if (trainer != null) {
                    trainerList.add(trainer);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Found " + trainerList.size() + " trainer matching '" + name + "'");

        } catch (SQLException e) {
            System.out.println("Search by name failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return trainerList;
    }

    // ========================================
    // WEEK 8: SEARCH BY SALARY RANGE
    // ========================================

    /**
     * SEARCH trainer by salary range
     * @param minAge Minimum age (inclusive)
     * @param maxAge Maximum age (inclusive)
     * @return List of trainer in age range
     */
    public static List<Trainer> searchByAgeRange(int minAge, int maxAge) {
        List<Trainer> trainerList = new ArrayList<>();

        String sql = "SELECT * FROM trainer WHERE age BETWEEN ? AND ? ORDER BY age DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return trainerList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);
            statement.setInt(2, maxAge);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Trainer trainer = extractTrainerFromResultSet(resultSet);
                if (trainer != null) {
                    trainerList.add(trainer);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Found " + trainerList.size() + " trainer in age range " +
                    minAge + " - " + maxAge);

        } catch (SQLException e) {
            System.out.println("Search by age failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return trainerList;
    }

    /**
     * SEARCH trainer with minimum age
     * @param minAge Minimum age
     * @return List of trainer earning at least minAge
     */
    public static List<Trainer> searchByMinAge(int minAge) {
        List<Trainer> trainerList = new ArrayList<>();

        String sql = "SELECT * FROM trainer WHERE age >= ? ORDER BY age DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return trainerList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Trainer trainer = extractTrainerFromResultSet(resultSet);
                if (trainer != null) {
                    trainerList.add(trainer);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Found " + trainerList.size() + " trainer age >= " + minAge);

        } catch (SQLException e) {
            System.out.println("Search by min age failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return trainerList;
    }

    // ========================================
    // HELPER METHOD
    // ========================================

    /**
     * Extract Trainer object from ResultSet
     * Creates Personal or Group based on trainer_type
     */
    private static Trainer extractTrainerFromResultSet(ResultSet resultSet) throws SQLException {
        int trainerId = resultSet.getInt("trainer_id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String gender = resultSet.getString("gender");
        int experienceYears = resultSet.getInt("experience_years");
        String trainerType = resultSet.getString("trainer_type");

        Trainer trainer = null;


        if ("PERSONAL".equals(trainerType)) {
            int personalClients = resultSet.getInt("personal_clients");
            trainer = new Personal(trainerId, name, age, gender, experienceYears, personalClients);

        } else if ("GROUP".equals(trainerType)) {
            int groupSize = resultSet.getInt("group_size");
            trainer = new Group(trainerId, name, age, gender, experienceYears, groupSize);
        }

        return trainer;
    }

    // ========================================
    // DISPLAY METHODS
    // ========================================

    /**
     * Display all trainer in console
     */
    public static void displayAllTrainer() {
        List<Trainer> trainerList = getAllTrainer();

        System.out.println("\n========================================");
        System.out.println("   ALL TRAINER FROM DATABASE");
        System.out.println("========================================");

        if (trainerList.isEmpty()) {
            System.out.println("No trainers in database.");
        } else {
            for (int i = 0; i < trainerList.size(); i++) {
                Trainer t = trainerList.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + t.getRole() + "] ");
                System.out.println(t.toString());
            }
        }

        System.out.println("========================================\n");
    }

    /**
     * Demonstrate polymorphism with database data
     */
    public static void demonstratePolymorphism() {
        List<Trainer> trainerList = getAllTrainer();

        System.out.println("\n========================================");
        System.out.println("  POLYMORPHISM: Trainer from Database");
        System.out.println("========================================");

        if (trainerList.isEmpty()) {
            System.out.println("No trainer to demonstrate.");
        } else {
            for (Trainer t : trainerList) {
                t.work();  // Polymorphic call!
            }
        }

        System.out.println("========================================\n");
    }
}