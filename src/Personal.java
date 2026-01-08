public class Personal extends Trainer {
    private int personalClients;

    public Personal (String name, int age, String gender, int experienceYears, int personalClients) {
        super (name, age, gender,experienceYears);
        this.personalClients = personalClients;
    }

    public int getPersonalClients() { return personalClients; }
    public void setPersonalClients (int personalClients) { this.personalClients = personalClients; }

    @Override
    public void work() {
        System.out.println("Personal trainer " + name + " is training " + personalClients + " clients individually.");
    }

    @Override
    public String getRole() {
        return "Personal trainer";
    }

    public void trainMember (String memberName) {
        System.out.println("Personal trainer " + name + " is training: " + memberName);
    }
    public boolean isPopular() {
        return personalClients >= 10;
    }

    @Override
    public String toString() {
        return super.toString() + " | Personal clients: " + personalClients;
    }
}
