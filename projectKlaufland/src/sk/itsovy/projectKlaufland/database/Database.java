package sk.itsovy.projectKlaufland.database;

import sk.itsovy.projectKlaufland.bill.Bill;

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
        try{
            con.setAutoCommit(false);
            PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setDouble(1,bill.getFinalPrice());
            statement.setDate(2,new java.sql.Date(bill.getDate().getTime()));
            statement.setTime(3,new java.sql.Time(bill.getDate().getTime()));

            statement.executeUpdate();
            con.commit();
            con.close();

        }  catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        }

    }
}
