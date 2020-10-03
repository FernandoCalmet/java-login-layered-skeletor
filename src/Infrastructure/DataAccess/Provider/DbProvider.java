package Infrastructure.DataAccess.Provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class DbProvider {
    public static Connection getDB(HashMap<String, String> connectionString) {
        Connection db = null;
        try {
            Class.forName(connectionString.get("driver"));
            db = DriverManager.getConnection(connectionString.get("host"), connectionString.get("user"), connectionString.get("pass"));
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return db;
    }
}
