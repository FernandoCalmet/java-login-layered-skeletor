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
import Modelo.UsuarioModelo;

public class UsuarioRepositorio extends BaseRepositorio implements IBaseRepositorio 
{  
    public UsuarioRepositorio(){ }

    @Override
    public boolean Crear(Object obj) 
    {
        usuarioModelo = (UsuarioModelo) obj;
        String consultaSql = "INSERT INTO usuarios (correo, clave, nombre, id_rol) VALUES (?, ?, ?, ?)";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);
            declaracionSql.setString(1, usuarioModelo.getCorreo());
            declaracionSql.setString(2, usuarioModelo.getClave());
            declaracionSql.setString(3, usuarioModelo.getNombre());
            declaracionSql.setInt(4, usuarioModelo.getId_rol());
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
        usuarioModelo = (UsuarioModelo) obj;
        String consultaSql = "DELETE FROM usuarios WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);
            declaracionSql.setInt(1, usuarioModelo.getId());
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
        usuarioModelo = (UsuarioModelo) obj;
        String consultaSql = "SELECT * FROM usuarios WHERE correo=?";         
        PreparedStatement declaracionSql;    
        ResultSet resultadoSql;
        ResultSetMetaData metaSql;
        Object[] listaDatos = null;
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);  
            declaracionSql.setString(1, usuarioModelo.getCorreo());            
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
        usuarioModelo = (UsuarioModelo) obj;
        String consultaSql = "UPDATE usuarios SET correo=?, clave=?, nombre=?, id_rol=? WHERE id=?";      
        PreparedStatement declaracionSql;        
        try
        {
            declaracionSql = getBD().prepareStatement(consultaSql);
            declaracionSql.setString(1, usuarioModelo.getCorreo());
            declaracionSql.setString(2, usuarioModelo.getClave());
            declaracionSql.setString(3, usuarioModelo.getNombre());
            declaracionSql.setInt(4, usuarioModelo.getId_rol());
            declaracionSql.setInt(5, usuarioModelo.getId());
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