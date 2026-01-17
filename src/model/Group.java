package model;

public class Group extends Trainer {
    private int groupSize;

    public Group (String name, int age, String gender, int experienceYears, int groupSize) {
        super (name, age, gender, experienceYears);
        setGroupSize(groupSize);
    }

    public int getGroupSize() { return groupSize; }

    public void setGroupSize(int groupSize) {
        if (groupSize < 0) {
            throw new IllegalArgumentException("model.Group size cannot be negative");
        }
        this.groupSize = groupSize;
    }

    @Override
    public void work() {
        System.out.println("model.Group trainer " + name + " is leading " + groupSize + " groups.");
    }

    @Override
    public String getRole() {
        return "model.Group trainer";
    }

    public void leadGroup (int groupID) {
        System.out.println("model.Group trainer " + name + " is leading #" + groupID + "group");
    }
    public boolean isLargeGroup() {
        return groupSize > 15;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: model.Group trainer");
        System.out.println("model.Group size: " + groupSize);
        if (isLargeGroup()) {
            System.out.println("LARGE GROUP TRAINER");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | model.Group size " + groupSize;
    }
}
