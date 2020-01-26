package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.OperacionEntidad;
import Interface.IServicioBase;
import Repositorio.OperacionRepositorio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class OperacionServicio implements IServicioBase
{
    private OperacionEntidad operacion = null;
    private final OperacionRepositorio repositorio = new OperacionRepositorio();

    @Override
    public boolean Crear(Object obj) {
        operacion = (OperacionEntidad) obj;
        if(!operacion.getNombre().isEmpty() && operacion.getId_modulo() > 0)
        {   
            if(repositorio.Crear(operacion) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Id/Nombre/Id_Modulo no es valido"); 
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
        operacion = (OperacionEntidad) obj;
        if(operacion.getId() != 0)
        {   
            if(repositorio.Eliminar(operacion) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Id no es valido"); 
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
        operacion = (OperacionEntidad) obj;
        if(operacion.getId() != 0 &&!operacion.getNombre().isEmpty() && operacion.getId_modulo()!= 0)
        {   
            if(repositorio.Modificar(operacion) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Id/Nombre/Id_Modulo no es valido"); 
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
