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
        connectionJDBC(); //seleccionar bd
    }

    private void connectionMySQL() {
        this.connectionString.put("driver", "com.mysql.jdbc.Driver");
        this.connectionString.put("host", "jdbc:mysql://localhost/crud_java");
        this.connectionString.put("user", "root");
        this.connectionString.put("pass", "root");
    }

    private void connectionJDBC() {
        this.connectionString.put("driver", "org.apache.derby.jdbc.ClientDriver");
        this.connectionString.put("host", "jdbc:derby://localhost:1527/java_crud");
        this.connectionString.put("user", "root");
        this.connectionString.put("pass", "root");
    }

    protected Connection GetConnection() {
        return DbProvider.getDB(this.connectionString);
    }
}
