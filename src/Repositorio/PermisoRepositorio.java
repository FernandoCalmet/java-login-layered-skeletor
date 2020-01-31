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
import Entidad.PermisoEntidad;
import BaseDatos.*;

public class PermisoRepositorio implements IRepositorioBase 
{
    private final MySql baseDatos;
    private PermisoEntidad entidad;
    
    public PermisoRepositorio()
    {
        this.baseDatos = new MySql();
        this.entidad = new PermisoEntidad();
    }
    
    @Override
    public boolean Crear(Object obj) 
    {
        entidad = (PermisoEntidad) obj;
        String consultaSql = "INSERT INTO permisos (id_rol, id_operacion) VALUES (?, ?)";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setInt(1, entidad.getId_rol());
            declaracionSql.setInt(2, entidad.getId_operacion());
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
        entidad = (PermisoEntidad) obj;
        String consultaSql = "DELETE FROM permisos WHERE id=?";      
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
        String consultaSql = "SELECT * FROM permisos WHERE id=?";      
        PreparedStatement declaracionSql; 
        ResultSet resultadoSql;
        ResultSetMetaData metaSql;
        Object[] listaDatos = null;
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);  
            declaracionSql.setInt(1, entidad.getId());
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
        entidad = (PermisoEntidad) obj;
        String consultaSql = "UPDATE permisos SET id_rol=?, id_operacion=? WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setInt(1, entidad.getId_rol());
            declaracionSql.setInt(2, entidad.getId_operacion());
            declaracionSql.setInt(3, entidad.getId());
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
                + "P.id, P.id_rol, R.nombre, P.id_operacion, O.nombre "
                + "FROM permisos P "
                + "INNER JOIN roles R ON R.id = P.id_rol "
                + "INNER JOIN operaciones O ON O.id = P.id_operacion "
                + "ORDER BY P.id ASC";     
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
                for(int i=0; i<fila.length; i++){fila[i] = resultadoSql.getObject(i + 1);}
                listaDatos.add(fila);
            }
        }
        catch(SQLException ex){System.out.println("Ocurrio un error: "+ex.getMessage());}
        return listaDatos;
    }
}