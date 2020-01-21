package Clases.OperacionesBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author github.com/fernandocalmet
 */
public class Permiso implements Interfaces.IOperacionesBD 
{
    private BaseDatos.MySql baseDatos = new BaseDatos.MySql();
    private Clases.Entidades.Permiso permiso = new Clases.Entidades.Permiso();
    
    //TODO: Recibe como parametro un objeto, verifica si el objeto existe en la base de datos para crear el registro
    @Override
    public boolean Crear(Object obj) 
    {
        permiso = (Clases.Entidades.Permiso) obj;
        String consultaSql = "INSERT INTO permisos (id_rol, id_operacion) VALUES (?, ?)";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setInt(1, permiso.getId_rol());
            declaracionSql.setInt(2, permiso.getId_operacion());
            int filas = declaracionSql.executeUpdate();
            if(filas > 0){return true;}
            else{return false;}
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+ex.getMessage());
            return false;
        }
    }

    //TODO: Recibe como parametro un objeto, verifica si el objeto existe en la base de datos para eliminar el registro
    @Override
    public boolean Eliminar(Object obj) 
    {
        permiso = (Clases.Entidades.Permiso) obj;
        String consultaSql = "DELETE FROM permisos WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setInt(1, permiso.getId());
            int filas = declaracionSql.executeUpdate();
            if(filas > 0){return true;}
            else{return false;}
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+ex.getMessage());
            return false;
        }
    }

    //TODO: Recibe como parametro un objeto, verifica si el objeto existe en la base de datos para consultar el registro
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
            declaracionSql.setInt(1, permiso.getId());
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
            else{JOptionPane.showMessageDialog(null, "El registro no existe en la base de datos");}              
        }
        catch(SQLException ex){JOptionPane.showMessageDialog(null, "Ocurrio un error: "+ex.getMessage());}
        return listaDatos;
    }

    //TODO: Recibe como parametro un objeto, verifica si el objeto existe en la base de datos para modificar el registro
    @Override
    public boolean Modificar(Object obj) 
    {
        permiso = (Clases.Entidades.Permiso) obj;
        String consultaSql = "UPDATE permisos SET id_rol=?, id_operacion=? WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = baseDatos.conectado().prepareStatement(consultaSql);
            declaracionSql.setInt(1, permiso.getId_rol());
            declaracionSql.setInt(2, permiso.getId_operacion());
            declaracionSql.setInt(3, permiso.getId());
            int filas = declaracionSql.executeUpdate();
            if(filas > 0){return true;}
            else{return false;}
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+ex.getMessage());
            return false;
        }
    }

    //TODO: Verifica los registros en la base de datos y devuelve una lista de los objetos encontrados
    @Override
    public ArrayList<Object[]> ListarTodos() 
    {   
        String consultaSql = "SELECT * FROM permisos";      
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
        catch(SQLException ex){JOptionPane.showMessageDialog(null, "Ocurrio un error: "+ex.getMessage());}
        return listaDatos;
    }
}