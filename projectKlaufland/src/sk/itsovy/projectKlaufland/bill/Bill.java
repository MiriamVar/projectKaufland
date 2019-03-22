package sk.itsovy.projectKlaufland.bill;

import sk.itsovy.projectKlaufland.it.sovy.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Item> list;

    public Bill() {
        this.list = new ArrayList<>();
    }

    public void addItem(Item item){
        list.add(item);
    }

    public void removeItem(Item item){
        list.remove(item);
    }

    public double getFinalPrice(){
        throw new UnsupportedOperationException("Method does not exists yet");
    }
}
