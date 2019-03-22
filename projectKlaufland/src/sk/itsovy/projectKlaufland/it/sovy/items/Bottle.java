package sk.itsovy.projectKlaufland.it.sovy.items;

import sk.itsovy.projectKlaufland.it.sovy.items.Piece;

public class Bottle extends Drink implements Piece {
    private int amount;

    public Bottle(String name, double price, boolean sweet, int amount) {
        super(name, price, sweet);
        this.amount=amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public double getTotalPrice() {
        return amount*getPrice();
    }

    @Override
    public String getName() {
        return getName();
    }
}
