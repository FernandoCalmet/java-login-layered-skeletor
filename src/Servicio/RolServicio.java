package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.RolEntidad;
import Excepcion.RolException;
import Interface.IServicioBase;
import Repositorio.RolRepositorio;
import java.util.ArrayList;

public class RolServicio implements IServicioBase
{
    private RolEntidad entidad;   
    private final RolRepositorio repositorio;
    
    public RolServicio()
    {
        this.entidad = new RolEntidad();
        this.repositorio = new RolRepositorio();
    }

    @Override
    public boolean Crear(Object obj) 
    {
        entidad = (RolEntidad) obj;
        if(!entidad.getNombre().isEmpty())
        {   
            if(repositorio.Crear(entidad) == true)
                return true;
            else
            {
                try { throw new RolException("Este Id no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
                return false;
            }   
        }
        else
        {
            try { throw new RolException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }
            return false;
        }
    }

    @Override
    public boolean Eliminar(Object obj) 
    {
        entidad = (RolEntidad) obj;
        if(entidad.getId() > 0)
        {   
            if(repositorio.Eliminar(entidad) == true)
                return true;
            else
            {
                try { throw new RolException("Algun dato de campo del formulario no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }  
                return false;
            }   
        }
        else
        {
            try { throw new RolException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
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
        entidad = (RolEntidad) obj;
        if(entidad.getId() > 0 && !entidad.getNombre().isEmpty())
        {   
            if(repositorio.Modificar(entidad) == true)
                return true;
            else
            {
                try { throw new RolException("Algun dato de campo del formulario no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
                return false;
            }   
        }
        else
        {
            try { throw new RolException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
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
