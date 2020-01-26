package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.ModuloEntidad;
import Repositorio.ModuloRepositorio;
import Interface.IServicioBase;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModuloServicio implements IServicioBase
{
    private ModuloEntidad modulo = null;
    private final ModuloRepositorio repositorio = new ModuloRepositorio();

    @Override
    public boolean Crear(Object obj) {
        modulo = (ModuloEntidad) obj;
        if(!modulo.getNombre().isEmpty())
        {   
            if(repositorio.Crear(modulo) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Este nombre no es valido"); 
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
        modulo = (ModuloEntidad) obj;
        if(modulo.getId() != 0)
        {   
            if(repositorio.Eliminar(modulo) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Este ID no es valido"); 
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
        modulo = (ModuloEntidad) obj;
        if(!modulo.getNombre().isEmpty() && modulo.getId() != 0)
        {   
            if(repositorio.Modificar(modulo) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"ID/Nombre no es valido"); 
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