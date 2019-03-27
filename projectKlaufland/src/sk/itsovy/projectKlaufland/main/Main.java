package sk.itsovy.projectKlaufland.main;

import sk.itsovy.projectKlaufland.Exepction.BillException;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws BillException, IOException, SQLException {

        Application app =  Application.getInstance();
        app.example();

    }
}
