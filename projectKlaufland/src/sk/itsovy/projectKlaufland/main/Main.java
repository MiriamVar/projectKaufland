package sk.itsovy.projectKlaufland.main;

import sk.itsovy.projectKlaufland.Exepction.BillException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws BillException, IOException, SQLException, TransformerException, ParserConfigurationException {

        Application app =  Application.getInstance();
        app.example();

    }
}
