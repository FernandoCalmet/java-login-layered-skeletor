package Repositorio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Excepcion.AccesoException;

public class AccesoRepositorio extends BaseRepositorio implements IAccesoRepositorio
{  
    public AccesoRepositorio(){ }
    
    @Override
    public Object accesoLogin(String correo, String clave)
    { 
        String consultaSql = "SELECT * FROM usuarios WHERE correo=? AND clave=?";       
        PreparedStatement declaracionSql;
        ResultSet resultadoSql;   
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);             
            declaracionSql.setString(1, correo);
            declaracionSql.setString(2, clave);            
            resultadoSql = declaracionSql.executeQuery();
            if(resultadoSql.next())
            {
                if(correo.equals(resultadoSql.getString("correo")) && clave.equals(resultadoSql.getString("clave")))
                {
                    usuarioModelo.setId(resultadoSql.getInt("id"));
                    usuarioModelo.setCorreo(resultadoSql.getString("correo"));
                    usuarioModelo.setClave(resultadoSql.getString("clave"));
                    usuarioModelo.setNombre(resultadoSql.getString("nombre"));
                    usuarioModelo.setId_rol(resultadoSql.getInt("id_rol"));
                    try { throw new AccesoException("Bienvenido "+usuarioModelo.getNombre()+"!"); }
                    catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }                
                }
                else
                {
                    try { throw new AccesoException("El correo o la contraseña es incorrecta, intentelo de nuevo."); }
                    catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }
                }
            } 
            else
            {
                try { throw new AccesoException("El Usuario no existe."); }
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }
            }
        }
        catch(SQLException ex){System.out.println("Ocurrio un error: "+ex.getMessage());}      
        return usuarioModelo;
    }
    
    @Override
    public Object accesoLogout(Object objEntidad)
    {
        usuarioModelo.setId(0);
        usuarioModelo.setCorreo(null);
        usuarioModelo.setClave(null);
        usuarioModelo.setNombre(null);
        usuarioModelo.setId_rol(0);
        usuarioModelo = null;
        objEntidad = usuarioModelo;
        return objEntidad;
    }
}