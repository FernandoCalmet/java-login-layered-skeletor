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
import Interface.IRepositorioBase;
import Entidad.ModuloEntidad;
import BaseDatos.*;

public class ModuloRepositorio implements IRepositorioBase 
{
    private final MySql baseDatos;
    private ModuloEntidad entidad;
    
    public ModuloRepositorio()
    {
        this.baseDatos = new MySql();
        this.entidad = new ModuloEntidad();
    }

    @Override
    public boolean Crear(Object obj) 
    {
        entidad = (ModuloEntidad) obj;
        String consultaSql = "INSERT INTO modulos (nombre) VALUES (?)";      
        PreparedStatement declaracionSql;
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setString(1, entidad.getNombre());
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
        entidad = (ModuloEntidad) obj;
        String consultaSql = "DELETE FROM modulos WHERE id=?";      
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
        String consultaSql = "SELECT * FROM modulos WHERE id=?";      
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
                    for(int i=0; i<fila.length; i++){ fila[i] = resultadoSql.getObject(i + 1); }                   
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
        entidad = (ModuloEntidad) obj;
        String consultaSql = "UPDATE modulos SET nombre=? WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setString(1, entidad.getNombre());
            declaracionSql.setInt(2, entidad.getId());
            int filas = declaracionSql.executeUpdate();
            if(filas > 0){ return true; }
            else{ return false; }
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
        String consultaSql = "SELECT * FROM modulos ORDER BY id ASC";        
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