package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.PermisoEntidad;
import Interface.IServicioBase;
import Repositorio.PermisoRepositorio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PermisoServicio implements IServicioBase
{
    private PermisoEntidad permiso = null;
    private final PermisoRepositorio repositorio = new PermisoRepositorio();

    @Override
    public boolean Crear(Object obj) {
        permiso = (PermisoEntidad) obj;
        if(permiso.getId_rol() > 0 && permiso.getId_operacion() > 0)
        {   
            if(repositorio.Crear(permiso) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Id/Id_Rol/Id_Operacion no es valido"); 
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
        permiso = (PermisoEntidad) obj;
        if(permiso.getId() != 0)
        {   
            if(repositorio.Eliminar(permiso) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Id/Id_Rol/Id_Operacion no es valido"); 
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
        permiso = (PermisoEntidad) obj;
        if(permiso.getId() > 0 && permiso.getId_rol() > 0 && permiso.getId_operacion() > 0)
        {   
            if(repositorio.Modificar(permiso) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Id/Id_Rol/Id_Operacion no es valido"); 
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
