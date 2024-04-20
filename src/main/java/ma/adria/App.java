package ma.adria;

import ma.adria.listener.Listener;
import ma.adria.notifier.Notifier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/pisteAudit";

        Connection lConn = DriverManager.getConnection(url, "postgres", "maroc123");
//        Connection nConn = DriverManager.getConnection(url, "postgres", "maroc123");


        Listener listener = new Listener(lConn);
//        Notifier notifier = new Notifier(nConn);
        listener.start();
//        notifier.start();
    }
}
