package sk.itsovy.projectKlaufland.items.food;

import sk.itsovy.projectKlaufland.items.Item;

public abstract class Food extends Item {
   private  int callories;

   public Food(String name, double price, int callories) {
      super(name, price);
      this.callories= callories;
   }


}

