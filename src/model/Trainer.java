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
