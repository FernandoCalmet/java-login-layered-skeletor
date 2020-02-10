package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Modelo.RolModelo;
import Excepcion.RolException;
import java.util.ArrayList;

public class RolServicio extends BaseServicio implements IBaseServicio
{    
    public RolServicio(){ }

    @Override
    public boolean Crear(Object obj) 
    {
        rolModelo = (RolModelo) obj;
        if(!rolModelo.getNombre().isEmpty())
        {   
            if(rolRepositorio.Crear(rolModelo) == true)
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
        rolModelo = (RolModelo) obj;
        if(rolModelo.getId() > 0)
        {   
            if(rolRepositorio.Eliminar(rolModelo) == true)
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
        return rolRepositorio.ListarDetalles(obj);
    }

    @Override
    public boolean Modificar(Object obj) 
    {
        rolModelo = (RolModelo) obj;
        if(rolModelo.getId() > 0 && !rolModelo.getNombre().isEmpty())
        {   
            if(rolRepositorio.Modificar(rolModelo) == true)
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
        return rolRepositorio.ListarTodos();
    }
    
}
