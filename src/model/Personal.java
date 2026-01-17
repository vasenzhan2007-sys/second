package model;

public class Personal extends Trainer {
    private int personalClients;

    public Personal (String name, int age, String gender, int experienceYears, int personalClients) {
        super(name, age, gender,experienceYears);
        setPersonalClients(personalClients);
    }

    public int getPersonalClients() { return personalClients; }

    public void setPersonalClients(int personalClients) {
        if (personalClients < 0) {
            throw new IllegalArgumentException("model.Personal clients cannot be negative");
        }
        this.personalClients = personalClients;
    }

    @Override
    public void work() {
        System.out.println("model.Personal trainer " + name + " is training " + personalClients + " clients individually.");
    }

    @Override
    public String getRole() {
        return "model.Personal trainer";
    }

    public void trainMember (String memberName) {
        System.out.println("model.Personal trainer " + name + " is training: " + memberName);
    }

    public boolean isPopular() {
        return personalClients >= 10;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: model.Personal trainer");
        System.out.println("model.Personal clients: " + personalClients);
        if (isPopular()) {
            System.out.println("POPULAR PERSONAL TRAINER");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | model.Personal clients: " + personalClients;
    }
}
