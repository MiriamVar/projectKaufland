package sk.itsovy.projectKlaufland.items.drink;

import sk.itsovy.projectKlaufland.items.Item;

public abstract class Drink extends Item {
    private boolean sweet;

    public Drink(String name, double price, boolean sweet) {
        super(name, price);  //super musi byt prvy
        this.sweet=sweet;
    }

    public boolean isSweet() {
        return sweet;
    }


}
