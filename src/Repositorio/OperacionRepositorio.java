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
import Modelo.OperacionModelo;

public class OperacionRepositorio extends BaseRepositorio implements IBaseRepositorio 
{ 
    public OperacionRepositorio() {}
   
    @Override
    public boolean Crear(Object obj) 
    {
        operacionModelo = (OperacionModelo) obj;
        String consultaSql = "INSERT INTO operaciones (nombre, id_modulo) VALUES (?, ?)";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);
            declaracionSql.setString(1, operacionModelo.getNombre());
            declaracionSql.setInt(2, operacionModelo.getId_modulo());
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
        operacionModelo = (OperacionModelo) obj;
        String consultaSql = "DELETE FROM operaciones WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);
            declaracionSql.setInt(1, operacionModelo.getId());
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
        String consultaSql = "SELECT * FROM operaciones WHERE id=?";      
        PreparedStatement declaracionSql; 
        ResultSet resultadoSql;
        ResultSetMetaData metaSql;
        Object[] listaDatos = null;
        try{
            declaracionSql = getBD().prepareStatement(consultaSql);  
            declaracionSql.setInt(1, operacionModelo.getId());
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
        operacionModelo = (OperacionModelo) obj;
        String consultaSql = "UPDATE operaciones SET nombre=?, id_modulo=? WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);
            declaracionSql.setString(1, operacionModelo.getNombre());
            declaracionSql.setInt(2, operacionModelo.getId_modulo());
            declaracionSql.setInt(3, operacionModelo.getId());
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
        String consultaSql = "SELECT "
                + "O.id, O.nombre, O.id_modulo, M.nombre "
                + "FROM operaciones O "
                + "INNER JOIN modulos M ON M.id = O.id_modulo "
                + "ORDER BY O.id ASC";
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
                for(int i=0; i<fila.length; i++){ fila[i] = resultadoSql.getObject(i + 1); }
                listaDatos.add(fila);
            }
        }
        catch(SQLException ex){ System.out.println("Ocurrio un error: "+ex.getMessage()); }
        return listaDatos;
    }
}