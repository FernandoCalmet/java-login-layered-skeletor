package Interfaces;

import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author github.com/fernandocalmet
 */
public interface IConexionBD 
{
    public Connection conectado();
    public void desconectado() throws SQLException;
    public void prueba();
}
