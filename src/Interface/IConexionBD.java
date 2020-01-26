package Interface;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.sql.Connection;
import java.sql.SQLException;

public interface IConexionBD 
{
    public Connection conectado();
    public void desconectado() throws SQLException;
    public void prueba();
}
