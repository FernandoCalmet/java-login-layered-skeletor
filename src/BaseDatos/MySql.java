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
    private Connection bd_conexion = null;
    private final String bd_driver = "com.mysql.jdbc.Driver";
    private final String bd_url = "jdbc:mysql://localhost/sistema_modular";  
    private final String bd_usuario = "root";
    private final String bd_clave = "root";       
    
    //TODO: El Constructor establece conexion con la base de datos
    public MySql() 
    {
        try{        
            //Con el metodo de la clase forName, le pasamos el driver de MySQL para que lo cargue
            Class.forName(this.bd_driver); 
            this.bd_conexion = DriverManager.getConnection(bd_url, bd_usuario, bd_clave);
        }
        catch(SQLException e){System.out.println(e.getMessage());}
        catch(ClassNotFoundException e){System.out.println(e.getMessage());}
    }
  
    //TODO: Devolver el objeto de conexion a la base de datos
    @Override
    public Connection conectado(){return this.bd_conexion;}

    //TODO: Cerrar la conexion con la base de datos y vaciar el objeto de conexion
    @Override
    public void desconectado() throws SQLException
    {
      this.bd_conexion.close();
      this.bd_conexion = null;      
      System.out.println("La conexion a la Base de Datos se ha cerrado exitosamente");
    } 
    
    //TODO: Devolver por consola si hay conexion con la base de datos
    @Override
    public void prueba()
    {       
        if (this.bd_conexion != null){
            System.out.println("La conexión con la Base de Datos esta funcionando correctamente");
        }else{
            System.out.println("No hay conexión con la Base de Datos");
        }
    }
}