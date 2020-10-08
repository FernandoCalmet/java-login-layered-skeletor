package Infrastructure.DataAccess.Repositories;

import Infrastructure.DataAccess.Provider.DbProvider;

import java.sql.Connection;
import java.util.HashMap;

public abstract class Repository {
    private final HashMap<String, String> connectionString;

    public Repository() {
        this.connectionString = new HashMap();
        connectionJDBC();
    }

    private void connectionMySQL() {
        this.connectionString.put("driver", "com.mysql.cj.jdbc.Driver");
        this.connectionString.put("host", "jdbc:mysql://localhost:3306/ToDoDatabase");
        this.connectionString.put("user", "root");
        this.connectionString.put("pass", "root");
    }

    private void connectionMariaDB(){
        this.connectionString.put("driver", "org.mariadb.jdbc.Driver");
        this.connectionString.put("host", "jdbc:mariadb://localhost:3306/ToDoDatabase");
        this.connectionString.put("user", "root");
        this.connectionString.put("pass", "root");
    }

    private void connectionJDBC() {
        this.connectionString.put("driver", "org.apache.derby.jdbc.ClientDriver");
        this.connectionString.put("host", "jdbc:derby://localhost:1527/ToDoDatabase");
        this.connectionString.put("user", "app");
        this.connectionString.put("pass", "derby");
    }

    protected Connection GetConnection() {
        return DbProvider.getDB(this.connectionString);
    }
}
