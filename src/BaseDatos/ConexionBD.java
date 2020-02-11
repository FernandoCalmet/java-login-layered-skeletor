package BaseDatos;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD implements IConexionBD
{
    private Connection bd_conexion;

    public ConexionBD() 
    {
        this.bd_conexion = null;
    }
    
    @Override
    public Connection getConexion()
    {
        return getMySQL(); //Instancia del Gestor de Base de Datos
    }
    
    @Override
    public void getDesconexion() throws SQLException
    {
        bd_conexion.close();
        bd_conexion = null;
        System.out.println("La conexion a la Base de Datos se ha cerrado exitosamente");
    } 
    
    @Override
    public void getPruebaConexion()
    {
        if (bd_conexion != null){
            System.out.println("La conexión con la Base de Datos esta funcionando correctamente");
        }else{
            System.out.println("No hay conexión con la Base de Datos");
        }
    }  
    
    private Connection getMySQL()
    {      
        String bd_driver = "com.mysql.jdbc.Driver";
        String bd_url = "jdbc:mysql://localhost/sistema_modular";
        String bd_usuario = "root";
        String bd_clave = "root"; 
        try
        {
            Class.forName(bd_driver); 
            bd_conexion = DriverManager.getConnection(bd_url, bd_usuario, bd_clave);
        }
        catch(SQLException e){System.out.println(e.getMessage());}
        catch(ClassNotFoundException e){System.out.println(e.getMessage());}
        return bd_conexion;
    }

    private Connection getSQLServer()
    {
        try 
        { 
            String bd_url = "jdbc:sqlserver://localhost\\sqlexpress";
            String bd_usuario = "root";
            String bd_clave = "root";
            bd_conexion = DriverManager.getConnection(bd_url, bd_usuario, bd_clave);
            if (bd_conexion != null) {
                DatabaseMetaData dm = (DatabaseMetaData) bd_conexion.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bd_conexion != null && !bd_conexion.isClosed()) {
                    bd_conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return bd_conexion;
    }
    
    private Connection getOracleSQL()
    {   
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String bd_url = "jdbc:oracle:thin:@localhost:1521:sistema_modular";
            String bd_usuario = "tiger";
            String bd_clave = "scott";
            bd_conexion = DriverManager.getConnection(bd_url, bd_usuario, bd_clave);
            if (bd_conexion != null) {
                System.out.println("Connected with connection #2");
            } 
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bd_conexion != null && !bd_conexion.isClosed()) {
                    bd_conexion.close();
                }               
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return bd_conexion;
    }
}