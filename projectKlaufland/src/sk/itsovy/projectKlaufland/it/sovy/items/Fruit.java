package sk.itsovy.projectKlaufland.it.sovy.items;

public class Fruit extends Food{
    private double weight;

    public Fruit(String name, double price, int callories, double weight) {
        super(name, price, callories);
        this.weight = weight;
    }

    @Override
    public double getTotalPrice() {
        return weight*getPrice();
    }

    @Override
    public String getName() {
        return getName();
    }

    public double getWeight() {
        return weight;
    }
}
