package BaseDatos;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.sql.Connection;
import java.sql.SQLException;

public interface IConexionBD 
{
    public Connection getConexion();
    public void getDesconexion() throws SQLException;
    public void getPruebaConexion();
}
