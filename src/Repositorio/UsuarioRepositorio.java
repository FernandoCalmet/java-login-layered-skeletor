package Repositorio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import Interface.IRepositorioBase ;
import Entidad.UsuarioEntidad;
import BaseDatos.*;

public class UsuarioRepositorio implements IRepositorioBase 
{
    private final MySql baseDatos;
    private UsuarioEntidad entidad;
    
    public UsuarioRepositorio()
    {
        this.baseDatos = new MySql();
        this.entidad = new UsuarioEntidad();
    }

    @Override
    public boolean Crear(Object obj) 
    {
        entidad = (UsuarioEntidad) obj;
        String consultaSql = "INSERT INTO usuarios (correo, clave, nombre, id_rol) VALUES (?, ?, ?, ?)";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setString(1, entidad.getCorreo());
            declaracionSql.setString(2, entidad.getClave());
            declaracionSql.setString(3, entidad.getNombre());
            declaracionSql.setInt(4, entidad.getId_rol());
            int filas = declaracionSql.executeUpdate();
            if(filas > 0){return true;}
            else{return false;}
        }
        catch(SQLException ex)
        {
            System.out.println("Ocurrio un error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean Eliminar(Object obj) 
    {
        entidad = (UsuarioEntidad) obj;
        String consultaSql = "DELETE FROM usuarios WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setInt(1, entidad.getId());
            int filas = declaracionSql.executeUpdate();
            if(filas > 0){return true;}
            else{return false;}
        }
        catch(SQLException ex)
        {
            System.out.println("Ocurrio un error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public Object[] ListarDetalles(Object obj) 
    {
        entidad = (UsuarioEntidad) obj;
        String consultaSql = "SELECT * FROM usuarios WHERE correo=?";         
        PreparedStatement declaracionSql;    
        ResultSet resultadoSql;
        ResultSetMetaData metaSql;
        Object[] listaDatos = null;
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);  
            declaracionSql.setString(1, entidad.getCorreo());            
            int filas = declaracionSql.executeUpdate();            
            if(filas > 0)
            {                
                resultadoSql = declaracionSql.executeQuery();
                metaSql = resultadoSql.getMetaData();
                while(resultadoSql.next())
                {
                    Object[] fila = new Object[metaSql.getColumnCount()];
                    for(int i=0; i<fila.length; i++){fila[i] = resultadoSql.getObject(i + 1);}               
                }
            }
            else{System.out.println("El registro no existe en la base de datos");}         
        }
        catch(SQLException ex){System.out.println("Ocurrio un error: "+ex.getMessage());}
        return listaDatos;
    }

    @Override
    public boolean Modificar(Object obj) 
    {
        entidad = (UsuarioEntidad) obj;
        String consultaSql = "UPDATE usuarios SET correo=?, clave=?, nombre=?, id_rol=? WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setString(1, entidad.getCorreo());
            declaracionSql.setString(2, entidad.getClave());
            declaracionSql.setString(3, entidad.getNombre());
            declaracionSql.setInt(4, entidad.getId_rol());
            declaracionSql.setInt(5, entidad.getId());
            int filas = declaracionSql.executeUpdate();
            if(filas > 0){return true;}
            else{return false;}
        }
        catch(SQLException ex)
        {
            System.out.println("Ocurrio un error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Object[]> ListarTodos() 
    {           
        String consultaSql = "SELECT "
                + "U.id, U.correo correo, U.clave clave, U.nombre nombre, U.id_rol id_rol, R.nombre nombre_rol "
                + "FROM usuarios U "
                + "INNER JOIN roles R ON R.id = U.id_rol "
                + "ORDER BY U.id ASC";
        PreparedStatement declaracionSql; 
        ResultSet resultadoSql;
        ResultSetMetaData metaSql;
        ArrayList<Object[]> listaDatos = new ArrayList<>();
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);      
            resultadoSql = declaracionSql.executeQuery();
            metaSql = resultadoSql.getMetaData();
            while(resultadoSql.next())
            {
                Object[] fila = new Object[metaSql.getColumnCount()];
                for(int i=0; i<fila.length; i++){ fila[i] = resultadoSql.getObject(i + 1); }
                listaDatos.add(fila);
            }
        }
        catch(SQLException ex){ System.out.println("Ocurrio un error: "+ex.getMessage()); }
        return listaDatos;
    }
}