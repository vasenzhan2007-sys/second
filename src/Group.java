public class Group extends Trainer {
    private int groupSize;

    public Group (String name, int age, String gender, int experienceYears, int groupSize) {
        super (name, age, gender, experienceYears);
        this.groupSize = groupSize;
    }

    public int getGroupSize() { return groupSize; }
    public void setGroupSize(int groupSize) {
        if (groupSize >= 0) this.groupSize = groupSize;
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
}
