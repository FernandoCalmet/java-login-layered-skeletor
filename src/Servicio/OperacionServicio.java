package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.OperacionEntidad;
import Excepcion.OperacionException;
import Interface.IServicioBase;
import Repositorio.OperacionRepositorio;
import java.util.ArrayList;

public class OperacionServicio implements IServicioBase
{
    private OperacionEntidad operacion;
    private final OperacionRepositorio repositorio;
    
    public OperacionServicio()
    {
        this.operacion = new OperacionEntidad();
        this.repositorio = new OperacionRepositorio();
    }

    @Override
    public boolean Crear(Object obj) {
        operacion = (OperacionEntidad) obj;
        if(!operacion.getNombre().isEmpty() && operacion.getId_modulo() > 0)
        {   
            if(repositorio.Crear(operacion) == true)
                return true;
            else
            {
                try { throw new OperacionException("Algun dato de campo del formulario no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
                return false;
            }   
        }
        else
        {
            try { throw new OperacionException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
            return false;
        }
    }

    @Override
    public boolean Eliminar(Object obj) {
        operacion = (OperacionEntidad) obj;
        if(operacion.getId() > 0)
        {   
            if(repositorio.Eliminar(operacion) == true)
                return true;
            else
            {
                try { throw new OperacionException("Este Id no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }  
                return false;
            }   
        }
        else
        {
            try { throw new OperacionException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
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
        operacion = (OperacionEntidad) obj;
        if(operacion.getId() > 0 && !operacion.getNombre().isEmpty() && operacion.getId_modulo() > 0)
        {   
            if(repositorio.Modificar(operacion) == true)
                return true;
            else
            {            
                try { throw new OperacionException("Algun dato de campo del formulario no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
                return false;
            }   
        }
        else
        {
            try { throw new OperacionException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
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