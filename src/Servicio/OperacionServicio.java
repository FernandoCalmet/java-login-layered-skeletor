package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Modelo.OperacionModelo;
import Excepcion.OperacionException;
import java.util.ArrayList;

public class OperacionServicio extends BaseServicio implements IBaseServicio
{
    public OperacionServicio(){ }

    @Override
    public boolean Crear(Object obj) {
        operacionModelo = (OperacionModelo) obj;
        if(!operacionModelo.getNombre().isEmpty() && operacionModelo.getId_modulo() > 0)
        {   
            if(operacionRepositorio.Crear(operacionModelo) == true)
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
        operacionModelo = (OperacionModelo) obj;
        if(operacionModelo.getId() > 0)
        {   
            if(operacionRepositorio.Eliminar(operacionModelo) == true)
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
        return operacionRepositorio.ListarDetalles(obj);
    }

    @Override
    public boolean Modificar(Object obj) {
        operacionModelo = (OperacionModelo) obj;
        if(operacionModelo.getId() > 0 && !operacionModelo.getNombre().isEmpty() && operacionModelo.getId_modulo() > 0)
        {   
            if(operacionRepositorio.Modificar(operacionModelo) == true)
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
        return operacionRepositorio.ListarTodos();
    }
}