import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    //Constants
    private Connection conn = null;
    private static final String IP = "localhost";
    private static final int PORT = 3306;
    public static final String DATABASE = "databaseassignment";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public DBConnector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        this.conn = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return this.conn;
    }
}
