package BaseDatos;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql implements Interface.IConexionBD
{
    private Connection bd_conexion;
    private final String bd_driver;
    private final String bd_url;  
    private final String bd_usuario;
    private final String bd_clave;      

    public MySql() 
    {
        this.bd_conexion = null;
        this.bd_driver = "com.mysql.jdbc.Driver";
        this.bd_url = "jdbc:mysql://localhost/sistema_modular";
        this.bd_usuario = "root";
        this.bd_clave = "root"; 
        try{
            Class.forName(this.bd_driver); 
            this.bd_conexion = DriverManager.getConnection(this.bd_url, this.bd_usuario, this.bd_clave);
        }
        catch(SQLException e){System.out.println(e.getMessage());}
        catch(ClassNotFoundException e){System.out.println(e.getMessage());}
    }
    
    private Connection getBDconexion(){return this.bd_conexion;}    
    
    private void setBDconexion(Connection objConexion){this.bd_conexion = objConexion;}
  
    //TODO: Devolver el objeto de conexion a la base de datos
    @Override
    public Connection conectado(){return getBDconexion();}

    //TODO: Cerrar la conexion con la base de datos y vaciar el objeto de conexion
    @Override
    public void desconectado() throws SQLException
    {
      this.bd_conexion.close();
      setBDconexion(null);
      System.out.println("La conexion a la Base de Datos se ha cerrado exitosamente");
    } 
    
    //TODO: Devolver por consola si hay conexion con la base de datos
    @Override
    public void prueba()
    {       
        if (getBDconexion() != null){
            System.out.println("La conexión con la Base de Datos esta funcionando correctamente");
        }else{
            System.out.println("No hay conexión con la Base de Datos");
        }
    } 
}