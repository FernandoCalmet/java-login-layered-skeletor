package Repositorio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Interface.IRepositorioAcceso;
import Entidad.UsuarioEntidad;
import BaseDatos.*;

public class AccesoRepositorio implements IRepositorioAcceso
{
    private final MySql conexionBD = new MySql(); 

    //TODO: Valida si el usuario existe en la base de datos y devuelve el objeto de tipo usuario con sus datos
    @Override
    public UsuarioEntidad accesoLogin(UsuarioEntidad objUsuario)
    {        
        String consultaSql = "SELECT * FROM usuarios WHERE correo=? AND clave=?";       
        PreparedStatement declaracionSql;
        ResultSet resultadoSql;   
        try{
            declaracionSql = conexionBD.conectado().prepareStatement(consultaSql);             
            declaracionSql.setString(1, objUsuario.getCorreo());
            declaracionSql.setString(2, objUsuario.getClave());            
            resultadoSql = declaracionSql.executeQuery();
            resultadoSql.next();
            if(objUsuario.getCorreo().equals(resultadoSql.getString("correo")) && objUsuario.getClave().equals(resultadoSql.getString("clave"))){                  
                objUsuario.setId(resultadoSql.getInt("id"));
                objUsuario.setCorreo(resultadoSql.getString("correo"));
                objUsuario.setClave(resultadoSql.getString("clave"));
                objUsuario.setNombre(resultadoSql.getString("nombre"));
                objUsuario.setId_rol(resultadoSql.getInt("id_rol"));
            }
            else{               
                objUsuario = accesoLogout(objUsuario);
            } 
        }
        catch(SQLException ex){System.out.println("Ocurrio un error: "+ex.getMessage());}      
        return objUsuario;
    }
    
    //TODO: Recibe como parametro un objeto de tipo usuario y lo devuelve vacio
    @Override
    public UsuarioEntidad accesoLogout(UsuarioEntidad objUsuario)
    {
        objUsuario.setId(0);
        objUsuario.setCorreo(null);
        objUsuario.setClave(null);
        objUsuario.setNombre(null);
        objUsuario.setId_rol(0);
        objUsuario = null;
        return objUsuario;
    }
}