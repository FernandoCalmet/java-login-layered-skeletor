package Repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import Interface.IRepositorioBase;
import Entidad.RolEntidad;
import BaseDatos.*;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class RolRepositorio implements IRepositorioBase 
{
    private final MySql baseDatos = new MySql();
    private RolEntidad rol = new RolEntidad();
    
    //TODO: Recibe como parametro un objeto, verifica si el objeto existe en la base de datos para crear el registro
    @Override
    public boolean Crear(Object obj) 
    {
        rol = (RolEntidad) obj;
        String consultaSql = "INSERT INTO roles (nombre) VALUES (?)";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setString(1, rol.getNombre());
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

    //TODO: Recibe como parametro un objeto, verifica si el objeto existe en la base de datos para eliminar el registro
    @Override
    public boolean Eliminar(Object obj) 
    {
        rol = (RolEntidad) obj;
        String consultaSql = "DELETE FROM roles WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setInt(1, rol.getId());
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

    //TODO: Recibe como parametro un objeto, verifica si el objeto existe en la base de datos para consultar el registro
    @Override
    public Object[] ListarDetalles(Object obj) 
    {
        String consultaSql = "SELECT * FROM roles WHERE id=?";      
        PreparedStatement declaracionSql; 
        ResultSet resultadoSql;
        ResultSetMetaData metaSql;
        Object[] listaDatos = null;
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);  
            declaracionSql.setInt(1, rol.getId());
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

    //TODO: Recibe como parametro un objeto, verifica si el objeto existe en la base de datos para modificar el registro
    @Override
    public boolean Modificar(Object obj) 
    {
        rol = (RolEntidad) obj;
        String consultaSql = "UPDATE roles SET nombre=? WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setString(1, rol.getNombre());
            declaracionSql.setInt(2, rol.getId());
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

    //TODO: Verifica los registros en la base de datos y devuelve una lista de los objetos encontrados
    @Override
    public ArrayList<Object[]> ListarTodos() 
    {   
        String consultaSql = "SELECT * FROM roles ORDER BY id ASC";      
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