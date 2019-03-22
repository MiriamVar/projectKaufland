package sk.itsovy.projectKlaufland.it.sovy.items;

import sk.itsovy.projectKlaufland.it.sovy.items.Item;

public abstract class Drink extends Item {
    private boolean sweet;

    public Drink(String name, double price, boolean sweet) {
        super(name, price);
        this.sweet=sweet;
    }

    public boolean isSweet() {
        return sweet;
    }


}
