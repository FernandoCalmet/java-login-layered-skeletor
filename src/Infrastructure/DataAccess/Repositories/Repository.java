package Infrastructure.DataAccess.Repositories;

import java.sql.Connection;
import java.util.HashMap;

/**
 *
 * @author FernandoCalmet
 * @version 2.0
 * @since 2020-01-10
 */
public abstract class Repository {

    private final HashMap<String, String> connectionString;

    public Repository() {
        this.connectionString = new HashMap();
        this.connectionString.put("driver", "com.mysql.jdbc.Driver");
        this.connectionString.put("host", "jdbc:mysql://localhost/crud_java");
        this.connectionString.put("user", "root");
        this.connectionString.put("pass", "root");
    }

    protected Connection GetConnection() {
        return DbProvider.getMySQL(this.connectionString);
    }
}
