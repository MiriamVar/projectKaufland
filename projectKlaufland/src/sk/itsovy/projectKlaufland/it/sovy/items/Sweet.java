package sk.itsovy.projectKlaufland.it.sovy.items;

import sk.itsovy.projectKlaufland.it.sovy.items.Piece;

public class Sweet extends Food implements Piece {
    private int amount;

    public Sweet(String name, double price, int callories, int amount) {
        super(name, price, callories);
        this.amount = amount;
    }

    @Override
    public double getTotalPrice() {
        return amount*getPrice();
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
