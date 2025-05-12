import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;

public class DBConnector {
    public static Connection getConnection() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pass = props.getProperty("db.password");
        return DriverManager.getConnection(url, user, pass);
    }
}