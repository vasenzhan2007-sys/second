public class Trainer {
    protected String name;
    protected int age;
    protected String gender;
    protected int experienceYears;

    public Trainer (String name, int age, String gender, int experienceYears){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.experienceYears = experienceYears;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public int getExperienceYears() { return experienceYears; }

    public void setName (String name) { this.name = name; }
    public void setAge (int age) {
        if (age >= 0) this.age = age;
    }
    public void setGender (String gender) { this.gender = gender; }
    public void setExperienceYears (int experienceYears) {
        if (experienceYears >= 0) this.experienceYears = experienceYears;
    }

    public void work() {
        System.out.println(name + "is training gym members");
    }
    public String getRole() {
        return "Trainer";
    }
    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    @Override
    public String toString() {
        return "[" + getRole() + "]" + name + " (Age: " + age + ", Gender: " + gender + ", Experience: " + experienceYears + " years)";
    }
}
