package database;

import model.Personal;
import model.Trainer;

public class TestInsert {
    public static void main(String[] args) {
        Trainer trainer = new Personal(0, "Aibek", 23, "Male", 2, 3);

        TrainerDAO dao = new TrainerDAO();

    }
}
