package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.UsuarioEntidad;
import Interface.IServicioBase;
import Repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioServicio implements IServicioBase
{
    private UsuarioEntidad usuario = null;
    private final UsuarioRepositorio repositorio = new UsuarioRepositorio();

    @Override
    public boolean Crear(Object obj) {
        usuario = (UsuarioEntidad) obj;
        if(!usuario.getCorreo().isEmpty() && !usuario.getClave().isEmpty() && !usuario.getNombre().isEmpty() && usuario.getId_rol() > 0)
        {   
            if(repositorio.Crear(usuario) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Id/Correo/Clave/Nombre/Id_Rol no es valido"); 
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
        usuario = (UsuarioEntidad) obj;
        if(usuario.getId() != 0)
        {   
            if(repositorio.Eliminar(usuario) == true)
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
        usuario = (UsuarioEntidad) obj;
        if(usuario.getId() != 0 && !usuario.getCorreo().isEmpty() && !usuario.getClave().isEmpty() && !usuario.getNombre().isEmpty() && usuario.getId_rol()!= 0)
        {   
            if(repositorio.Modificar(usuario) == true)
                return true;
            else
            {
                JOptionPane.showMessageDialog(null ,"Id/Correo/Clave/Nombre/Id_Rol no es valido"); 
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
