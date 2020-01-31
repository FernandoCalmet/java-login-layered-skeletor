package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.UsuarioEntidad;
import Excepcion.UsuarioException;
import Interface.IServicioBase;
import Repositorio.UsuarioRepositorio;
import java.util.ArrayList;

public class UsuarioServicio implements IServicioBase
{
    private UsuarioEntidad usuario;
    private final UsuarioRepositorio repositorio;
    
    public UsuarioServicio()
    {
        this.usuario = new UsuarioEntidad();
        this.repositorio = new UsuarioRepositorio();
    }

    @Override
    public boolean Crear(Object obj) 
    {
        usuario = (UsuarioEntidad) obj;
        if(!usuario.getCorreo().isEmpty() && !usuario.getClave().isEmpty() && !usuario.getNombre().isEmpty() && usuario.getId_rol() > 0)
        {   
            if(repositorio.Crear(usuario) == true)
                return true;
            else
            {
                try { throw new UsuarioException("Algun dato de campo del formulario no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }
                return false;
            }   
        }
        else
        {
            try { throw new UsuarioException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
            return false;
        }
    }

    @Override
    public boolean Eliminar(Object obj) 
    {
        usuario = (UsuarioEntidad) obj;
        if(usuario.getId() != 0)
        {   
            if(repositorio.Eliminar(usuario) == true)
                return true;
            else
            {
                try { throw new UsuarioException("Algun dato de campo del formulario no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
                return false;
            }   
        }
        else
        {
            try { throw new UsuarioException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
            return false;
        }
    }

    @Override
    public Object[] ListarDetalles(Object obj) 
    {
        return repositorio.ListarDetalles(obj);
    }

    @Override
    public boolean Modificar(Object obj) 
    {
        usuario = (UsuarioEntidad) obj;
        if(usuario.getId() > 0 && !usuario.getCorreo().isEmpty() && !usuario.getClave().isEmpty() && !usuario.getNombre().isEmpty() && usuario.getId_rol() > 0)
        {   
            if(repositorio.Modificar(usuario) == true)
                return true;
            else
            {
                try { throw new UsuarioException("Algun dato de campo del formulario no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }
                return false;
            }   
        }
        else
        {
            try { throw new UsuarioException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
            return false;
        }
    }

    @Override
    public ArrayList<Object[]> ListarTodos() 
    {
        return repositorio.ListarTodos();
    }    
}