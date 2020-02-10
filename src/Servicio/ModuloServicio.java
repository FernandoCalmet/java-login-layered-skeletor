package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Modelo.ModuloModelo;
import java.util.ArrayList;
import Excepcion.ModuloException;

public class ModuloServicio extends BaseServicio implements IBaseServicio
{    
    public ModuloServicio(){ }
   
    @Override
    public boolean Crear(Object obj) {
        moduloModelo = (ModuloModelo) obj;
        if(!moduloModelo.getNombre().isEmpty())
        {   
            if(moduloRepositorio.Crear(moduloModelo) == true)
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
        moduloModelo = (ModuloModelo) obj;
        if(moduloModelo.getId() != 0)
        {   
            if(moduloRepositorio.Eliminar(moduloModelo) == true)
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
        return moduloRepositorio.ListarDetalles(obj);
    }

    @Override
    public boolean Modificar(Object obj) {
        moduloModelo = (ModuloModelo) obj;
        if(!moduloModelo.getNombre().isEmpty() && moduloModelo.getId() != 0)
        {   
            if(moduloRepositorio.Modificar(moduloModelo) == true)
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
        return moduloRepositorio.ListarTodos();
    }    
}