package sk.itsovy.projectKlaufland.database;

import sk.itsovy.projectKlaufland.bill.Bill;
import sk.itsovy.projectKlaufland.items.Item;
import sk.itsovy.projectKlaufland.items.Piece;
import sk.itsovy.projectKlaufland.items.drink.DraftInterface;
import sk.itsovy.projectKlaufland.items.food.Fruit;

import java.sql.*;

//import static Globals.driver;
import static sk.itsovy.projectKlaufland.main.Globals.userName;
import static sk.itsovy.projectKlaufland.main.Globals.url;
import static sk.itsovy.projectKlaufland.main.Globals.password;

public class Database {

    private static Database db = new Database();

    private Database() {
    }

    public static Database getInstanceDB(){
        return db;
    }

    private Connection getConnection(){
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Is connection");
            connection = DriverManager.getConnection(url,userName,password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public void insertNewBill(Bill bill) throws SQLException {
        Connection con = getConnection();
        String query = "insert into bill(totalPrice,date, time) values(?,?,?)";
        String query2 = "insert into item(orderId,name,price,count,unit) values(?,?,?,?,?)";
        try {
            con.setAutoCommit(false);
            PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setDouble(1, bill.getFinalPrice());
            statement.setDate(2, new java.sql.Date(bill.getDate().getTime()));
            statement.setTime(3, new java.sql.Time(bill.getDate().getTime()));

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                while (generatedKeys.next()) {
//                    System.out.println(generatedKeys.getLong(1));
////                    user.setId(generatedKeys.getLong(1));
//                }
                if (generatedKeys.next()){
                    for (Item item : bill.getList()) {
                        PreparedStatement statement2 = con.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
                        statement2.setDouble(1, generatedKeys.getLong(1));
                        statement2.setString(2, item.getName());
                        statement2.setDouble(3, item.getPrice());

                        if (item instanceof DraftInterface) {
                            statement2.setDouble(4, ((DraftInterface) item).getVolume());
                            statement2.setString(5, "l");
                        } else if (item instanceof Fruit) {
                            statement2.setDouble(4, ((Fruit) item).getWeight());
                            statement2.setString(5, "kg");
                        } else if (item instanceof Piece) {
                            statement2.setDouble(4, ((Piece) item).getAmount());
                            statement2.setString(5, "pcs");
                        }

                        statement2.executeUpdate();

                    }
                }
                else {
                    throw new SQLException("Creating bill failed, no ID obtained.");
                }

            }
            con.commit();
            con.close();
        }
            catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        }

    }
}
