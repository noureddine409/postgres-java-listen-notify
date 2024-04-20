package ma.adria.listener;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Listener extends Thread {
    private org.postgresql.PGConnection pgconn;

    public Listener(Connection conn) throws SQLException {
        this.pgconn = conn.unwrap(org.postgresql.PGConnection.class);
        Statement stmt = conn.createStatement();
        stmt.execute("LISTEN new_audit_logs_row");
        stmt.close();
    }

    public void run() {
        try {
            while (true) {
                org.postgresql.PGNotification notifications[] = pgconn.getNotifications();


                if (notifications != null) {
                    for (int i = 0; i < notifications.length; i++)
                        System.out.println("Got notification: " + notifications[i].getName() + "\n payload: " + notifications[i].getParameter());
                }

                Thread.sleep(500);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
