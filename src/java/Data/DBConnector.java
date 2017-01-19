package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnector {

    //Constants
    private Connection conn = null;
    private static final String IP = "localhost";
    private static final int PORT = 3306;
    public static final String DATABASE = "online_shop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public DBConnector() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
            this.conn = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (Exception e ) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Connection getConnection() {
        return this.conn;
    }
}
