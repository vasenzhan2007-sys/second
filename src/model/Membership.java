package model;

public class Membership implements Training {
    private String type;
    private double price;
    private int durationMonth;

    public Membership(String type, double price, int durationMonth) {
        setType(type);
        setPrice(price);
        setDurationMonth(durationMonth);
    }

    public String getType() { return type; }
    public double getPrice() { return price; }
    public int getDurationMonth() {return durationMonth; }

    public void setType (String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be empty");
        }
        this.type = type;
    }

    public void setPrice (double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (price == 0) {
            throw new IllegalArgumentException("Price cannot be zero");
        }
        this.price = price;
    }

    public void setDurationMonth (int durationMonth) {
        if (durationMonth <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.durationMonth = durationMonth;
    }

    @Override
    public void train() {
        System.out.println("Training " + type + " memberships");
        System.out.println("Price: " + price + "KZT");
        System.out.println("Duration: " + durationMonth + " months");
        System.out.println(type + " membership is ready to serve!");
    }

    @Override
    public String getMembership() {
        return "Trainer for " + type + " management";
    }

    public void displayInfo() {
        System.out.println("Type: " + type);
        System.out.println("Price: " + price + " KZT");
        System.out.println("Duration: " + durationMonth + " months");
    }

    @Override
    public String toString() {
        return type + " membership - " + price + " KZT (" + durationMonth + "months)";
    }
}
