package Clases.OperacionesBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author github.com/fernandocalmet
 */
public class Login implements Interfaces.ILogin
{
    private BaseDatos.MySql baseDatos = new BaseDatos.MySql(); 

    //TODO: Valida si el usuario existe en la base de datos y devuelve el objeto de tipo usuario con sus datos
    @Override
    public Clases.Entidades.Usuario Login(Clases.Entidades.Usuario objUsuario)
    {        
        String consultaSql = "SELECT * FROM usuarios WHERE correo=? AND clave=?";       
        PreparedStatement declaracionSql;
        ResultSet resultadoSql;   
        try{
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);             
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
                objUsuario = desconectar(objUsuario);
            } 
        }
        catch(SQLException ex){System.out.println("Ocurrio un error: "+ex.getMessage());}      
        return objUsuario;
    }
    
    //TODO: Recibe como parametro un objeto de tipo usuario y lo devuelve vacio
    public Clases.Entidades.Usuario desconectar(Clases.Entidades.Usuario usuario) throws SQLException
    {
        usuario.setId(0);
        usuario.setCorreo(null);
        usuario.setClave(null);
        usuario.setNombre(null);
        usuario.setId_rol(0);
        usuario = null;
        return usuario;
    }
}