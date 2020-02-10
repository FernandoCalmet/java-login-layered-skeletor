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
import Modelo.PermisoModelo;

public class PermisoRepositorio extends BaseRepositorio implements IBaseRepositorio 
{  
    public PermisoRepositorio(){ }
    
    @Override
    public boolean Crear(Object obj) 
    {
        permisoModelo = (PermisoModelo) obj;
        String consultaSql = "INSERT INTO permisos (id_rol, id_operacion) VALUES (?, ?)";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);
            declaracionSql.setInt(1, permisoModelo.getId_rol());
            declaracionSql.setInt(2, permisoModelo.getId_operacion());
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
        permisoModelo = (PermisoModelo) obj;
        String consultaSql = "DELETE FROM permisos WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);
            declaracionSql.setInt(1, permisoModelo.getId());
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
            declaracionSql = getBD().prepareStatement(consultaSql);  
            declaracionSql.setInt(1, permisoModelo.getId());
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
        permisoModelo = (PermisoModelo) obj;
        String consultaSql = "UPDATE permisos SET id_rol=?, id_operacion=? WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);
            declaracionSql.setInt(1, permisoModelo.getId_rol());
            declaracionSql.setInt(2, permisoModelo.getId_operacion());
            declaracionSql.setInt(3, permisoModelo.getId());
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
                + "permisos.id, permisos.id_rol, roles.nombre, permisos.id_operacion, operaciones.nombre "
                + "FROM permisos "
                + "INNER JOIN roles ON roles.id = permisos.id_rol "
                + "INNER JOIN operaciones ON operaciones.id = permisos.id_operacion "
                + "ORDER BY permisos.id ASC";     
        PreparedStatement declaracionSql; 
        ResultSet resultadoSql;
        ResultSetMetaData metaSql;
        ArrayList<Object[]> listaDatos = new ArrayList<>();
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);      
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