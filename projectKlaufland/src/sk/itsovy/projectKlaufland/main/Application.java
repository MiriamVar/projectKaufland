package sk.itsovy.projectKlaufland.main;

import sk.itsovy.projectKlaufland.Exepction.BillException;
import sk.itsovy.projectKlaufland.bill.Bill;
import sk.itsovy.projectKlaufland.items.Category;
import sk.itsovy.projectKlaufland.items.Goods;
import sk.itsovy.projectKlaufland.items.Item;
import sk.itsovy.projectKlaufland.items.drink.Bottle;
import sk.itsovy.projectKlaufland.items.drink.Draft;
import sk.itsovy.projectKlaufland.items.food.Fruit;
import sk.itsovy.projectKlaufland.items.food.Pastry;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.SQLException;

public class Application {

    private static Application app= new Application();

    //konstruktor private
    private Application(){

    }

    public static Application getInstance(){
        return app;
    }

    public void example() throws BillException, IOException, SQLException, TransformerException, ParserConfigurationException {
        Bill bill = new Bill();
//        bill.print();
        Bottle milk = new Bottle("Milk 1,5%", 0.59,4);
        bill.addItem(milk);

        Item pizza = new Pastry("Hawai", 1.10,280,2);
        bill.addItem(pizza);

        Fruit apple = new Fruit("Red apple", 0.59,.370);
        bill.addItem(apple);

        Goods pencil = new Goods("Pencil 0.5",0.60,1, Category.SCHOOL);
        bill.addItem(pencil);

        Draft vinea = new Draft("Rose vinea",1.20,true,0.3);
        bill.addItem(vinea);

        Item pizza2 = new Pastry("Hawai", 1.10,280,2);
        bill.addItem(pizza2);

        Draft beer = new Draft("Birell", 0.98,true,0.5);
        bill.addItem(beer);
        bill.removeItem(beer);
        bill.print();
        System.out.println("Total items: "+bill.getCount());
        System.out.println("Total price: "+bill.getFinalPrice());

        System.out.println("Price in USD: " + bill.getTotalPriceUSD());

        XML totalBill = new XML();
        totalBill.createXML(bill);
        bill.end();
    }
}
