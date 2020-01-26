package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.RolEntidad;
import Interface.IServicioBase;
import Repositorio.RolRepositorio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RolServicio implements IServicioBase
{
    private RolEntidad rol = null;    
    private final RolRepositorio repositorio = new RolRepositorio();

    @Override
    public boolean Crear(Object obj) {
        rol = (RolEntidad) obj;
        if(!rol.getNombre().isEmpty())
        {   
            if(repositorio.Crear(rol) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Id/Nombre no es valido"); 
                return false;
            }   
        }
        else
        {
            JOptionPane.showMessageDialog(null ,"No esta permitido campos vacios"); 
            return false;
        }
    }

    @Override
    public boolean Eliminar(Object obj) {
        rol = (RolEntidad) obj;
        if(rol.getId() != 0)
        {   
            if(repositorio.Eliminar(rol) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Id/Nombre no es valido"); 
                return false;
            }   
        }
        else
        {
            JOptionPane.showMessageDialog(null ,"No esta permitido campos vacios"); 
            return false;
        }
    }

    @Override
    public Object[] ListarDetalles(Object obj) {
        return repositorio.ListarDetalles(obj);
    }

    @Override
    public boolean Modificar(Object obj) {
        rol = (RolEntidad) obj;
        if(rol.getId() != 0 && !rol.getNombre().isEmpty())
        {   
            if(repositorio.Modificar(rol) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Id/Nombre no es valido"); 
                return false;
            }   
        }
        else
        {
            JOptionPane.showMessageDialog(null ,"No esta permitido campos vacios"); 
            return false;
        }
    }

    @Override
    public ArrayList<Object[]> ListarTodos() {     
        return repositorio.ListarTodos();
    }
    
}
