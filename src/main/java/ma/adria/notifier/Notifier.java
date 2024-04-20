package ma.adria.notifier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Notifier extends Thread {
    private Connection conn;

    public Notifier(Connection conn) {
        this.conn = conn;
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                PreparedStatement stmt = conn.prepareStatement("NOTIFY newAuditLogsRow, '" + i + "'");
                stmt.execute();
                stmt.close();
                Thread.sleep(2000);
                i++; // Increment i for next iteration
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
