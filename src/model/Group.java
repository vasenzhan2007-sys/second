package model;

public class Group extends Trainer {
    private int groupSize;

    public Group (int id, String name, int age, String gender, int experienceYears, int groupSize) {
        super (id, name, age, gender, experienceYears);
        setGroupSize(groupSize);
    }

    public int getGroupSize() { return groupSize; }

    public void setGroupSize(int groupSize) {
        if (groupSize < 0) {
            throw new IllegalArgumentException("Group size cannot be negative");
        }
        this.groupSize = groupSize;
    }

    @Override
    public void work() {
        System.out.println("Group trainer " + name + " is leading " + groupSize + " groups.");
    }

    @Override
    public String getRole() {
        return "Group trainer";
    }

    public void leadGroup (int groupID) {
        System.out.println("Group trainer " + name + " is leading #" + groupID + "group");
    }
    public boolean isLargeGroup() {
        return groupSize > 15;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: model.Group trainer");
        System.out.println("Group size: " + groupSize);
        if (isLargeGroup()) {
            System.out.println("LARGE GROUP TRAINER");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Group size: " + groupSize;
    }
}
