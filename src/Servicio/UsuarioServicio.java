package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Modelo.UsuarioModelo;
import Excepcion.UsuarioException;
import java.util.ArrayList;

public class UsuarioServicio extends BaseServicio implements IBaseServicio
{
    public UsuarioServicio(){ }

    @Override
    public boolean Crear(Object obj) 
    {
        usuarioModelo = (UsuarioModelo) obj;
        if(!usuarioModelo.getCorreo().isEmpty() && !usuarioModelo.getClave().isEmpty() && !usuarioModelo.getNombre().isEmpty() && usuarioModelo.getId_rol() > 0)
        {   
            if(usuarioRepositorio.Crear(usuarioModelo) == true)
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
        usuarioModelo = (UsuarioModelo) obj;
        if(usuarioModelo.getId() != 0)
        {   
            if(usuarioRepositorio.Eliminar(usuarioModelo) == true)
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
    public Object[] ConsultarUno(Object obj) 
    {
        return usuarioRepositorio.ListarDetalles(obj);
    }

    @Override
    public boolean Modificar(Object obj) 
    {
        usuarioModelo = (UsuarioModelo) obj;
        if(usuarioModelo.getId() > 0 && !usuarioModelo.getCorreo().isEmpty() && !usuarioModelo.getClave().isEmpty() && !usuarioModelo.getNombre().isEmpty() && usuarioModelo.getId_rol() > 0)
        {   
            if(usuarioRepositorio.Modificar(usuarioModelo) == true)
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
    public ArrayList<Object[]> ConsultarTodos() 
    {
        return usuarioRepositorio.ListarTodos();
    }    
}