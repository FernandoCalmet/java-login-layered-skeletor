package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.PermisoEntidad;
import Excepcion.PermisoException;
import Interface.IServicioBase;
import Repositorio.PermisoRepositorio;
import java.util.ArrayList;

public class PermisoServicio implements IServicioBase
{
    private PermisoEntidad permiso;
    private final PermisoRepositorio repositorio;
    
    public PermisoServicio()
    {
        this.permiso = new PermisoEntidad();
        this.repositorio = new PermisoRepositorio();
    }

    @Override
    public boolean Crear(Object obj) 
    {
        permiso = (PermisoEntidad) obj;
        if(permiso.getId_rol() > 0 && permiso.getId_operacion() > 0)
        {   
            if(repositorio.Crear(permiso) == true)
                return true;
            else
            {
                try { throw new PermisoException("Algun dato de campo del formulario no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }  
                return false;
            }   
        }
        else
        {
            try { throw new PermisoException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
            return false;
        }
    }

    @Override
    public boolean Eliminar(Object obj) {
        permiso = (PermisoEntidad) obj;
        if(permiso.getId() > 0)
        {   
            if(repositorio.Eliminar(permiso) == true)
                return true;
            else
            {
                try { throw new PermisoException("Algun dato de campo del formulario no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }  
                return false;
            }   
        }
        else
        {
            try { throw new PermisoException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
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
    public boolean Modificar(Object obj) {
        permiso = (PermisoEntidad) obj;
        if(permiso.getId() > 0 && permiso.getId_rol() > 0 && permiso.getId_operacion() > 0)
        {   
            if(repositorio.Modificar(permiso) == true)
                return true;
            else
            {
                try { throw new PermisoException("Algun dato de campo del formulario no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
                return false;
            }   
        }
        else
        {
            try { throw new PermisoException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
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
