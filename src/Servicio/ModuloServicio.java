package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.ModuloEntidad;
import Repositorio.ModuloRepositorio;
import Interface.IServicioBase;
import java.util.ArrayList;
import Excepcion.ModuloException;

public class ModuloServicio implements IServicioBase
{
    private ModuloEntidad entidad;
    private final ModuloRepositorio repositorio;
    
    public ModuloServicio()
    {
        this.entidad = new ModuloEntidad();
        this.repositorio = new ModuloRepositorio();
    }
   
    @Override
    public boolean Crear(Object obj) {
        entidad = (ModuloEntidad) obj;
        if(!entidad.getNombre().isEmpty())
        {   
            if(repositorio.Crear(entidad) == true)
                return true;
            else
            {
                try { throw new ModuloException("Este nombre no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }       
                return false;
            }   
        }
        else
        {
            try { throw new ModuloException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
            return false;
        }
    }

    @Override
    public boolean Eliminar(Object obj) {
        entidad = (ModuloEntidad) obj;
        if(entidad.getId() != 0)
        {   
            if(repositorio.Eliminar(entidad) == true)
                return true;
            else
            {
                try { throw new ModuloException("Este ID no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
                return false;
            }   
        }
        else
        {
            try { throw new ModuloException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }  
            return false;
        }
    }

    @Override
    public Object[] ListarDetalles(Object obj) {
        return repositorio.ListarDetalles(obj);
    }

    @Override
    public boolean Modificar(Object obj) {
        entidad = (ModuloEntidad) obj;
        if(!entidad.getNombre().isEmpty() && entidad.getId() != 0)
        {   
            if(repositorio.Modificar(entidad) == true)
                return true;
            else
            {
                try { throw new ModuloException("Este ID no es valido"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }  
                return false;
            }   
        }
        else
        {
            try { throw new ModuloException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); } 
            return false;
        }
    }

    @Override
    public ArrayList<Object[]> ListarTodos() {
        return repositorio.ListarTodos();
    }    
}