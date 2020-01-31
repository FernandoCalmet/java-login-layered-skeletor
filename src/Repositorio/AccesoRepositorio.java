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
    private final MySql baseDatos;
    private UsuarioEntidad entidad;
    
    public AccesoRepositorio()
    {
        this.baseDatos = new MySql();
        this.entidad = new UsuarioEntidad();
    }
    
    @Override
    public Object accesoLogin(String correo, String clave)
    {
        entidad.setCorreo(correo);
        entidad.setClave(clave);
        String consultaSql = "SELECT * FROM usuarios WHERE correo=? AND clave=?";       
        PreparedStatement declaracionSql;
        ResultSet resultadoSql;   
        try{
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);             
            declaracionSql.setString(1, entidad.getCorreo());
            declaracionSql.setString(2, entidad.getClave());            
            resultadoSql = declaracionSql.executeQuery();
            resultadoSql.next();
            if(entidad.getCorreo().equals(resultadoSql.getString("correo")) && entidad.getClave().equals(resultadoSql.getString("clave")))
            {                  
                entidad.setId(resultadoSql.getInt("id"));
                entidad.setCorreo(resultadoSql.getString("correo"));
                entidad.setClave(resultadoSql.getString("clave"));
                entidad.setNombre(resultadoSql.getString("nombre"));
                entidad.setId_rol(resultadoSql.getInt("id_rol"));
            }
            else{               
                entidad = (UsuarioEntidad) accesoLogout(entidad);
            } 
        }
        catch(SQLException ex){System.out.println("Ocurrio un error: "+ex.getMessage());}      
        return entidad;
    }
    
    @Override
    public Object accesoLogout(Object objEntidad)
    {
        entidad.setId(0);
        entidad.setCorreo(null);
        entidad.setClave(null);
        entidad.setNombre(null);
        entidad.setId_rol(0);
        entidad = null;
        objEntidad = entidad;
        return objEntidad;
    }
}