package Infrastructure.DataAccess.Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author FernandoCalmet
 * @version 2.0
 * @since 2020-01-10
 */
public class DbProvider {

    protected static Connection getMySQL(HashMap<String, String> connectionString) {
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
