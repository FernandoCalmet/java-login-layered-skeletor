package Infrastructure.DataAccess.Repositories;

import Infrastructure.Common.Utils.DbProvider;

import java.sql.Connection;
import java.util.HashMap;

public abstract class Repository {
    private final HashMap<String, String> connectionString;

    public Repository() {
        this.connectionString = new HashMap();
        connectionJDBC();
    }

    private void connectionMySQL() {
        this.connectionString.put("driver", "com.mysql.jdbc.Driver");
        this.connectionString.put("host", "jdbc:mysql://localhost/ToDoDatabase");
        this.connectionString.put("user", "root");
        this.connectionString.put("pass", "root");
    }

    private void connectionJDBC() {
        this.connectionString.put("driver", "org.apache.derby.jdbc.ClientDriver");
        this.connectionString.put("host", "jdbc:derby://localhost:1527/ToDoDatabase");
        this.connectionString.put("user", "root");
        this.connectionString.put("pass", "");
    }

    protected Connection GetConnection() {
        return DbProvider.getDB(this.connectionString);
    }
}
