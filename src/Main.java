import management.Management;
import management.GymManagement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Management management = new GymManagement();
        management.run();
    }
}
