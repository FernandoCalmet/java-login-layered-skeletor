package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Modelo.PermisoModelo;
import Excepcion.PermisoException;
import java.util.ArrayList;

public class PermisoServicio extends BaseServicio implements IBaseServicio
{
    public PermisoServicio(){ }

    @Override
    public boolean Crear(Object obj) 
    {
        permisoModelo = (PermisoModelo) obj;
        if(permisoModelo.getId_rol() > 0 && permisoModelo.getId_operacion() > 0)
        {   
            if(permisoRepositorio.Crear(permisoModelo) == true)
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
        permisoModelo = (PermisoModelo) obj;
        if(permisoModelo.getId() > 0)
        {   
            if(permisoRepositorio.Eliminar(permisoModelo) == true)
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
    public Object[] ConsultarUno(Object obj) 
    {
        return permisoRepositorio.ListarDetalles(obj);
    }

    @Override
    public boolean Modificar(Object obj) {
        permisoModelo = (PermisoModelo) obj;
        if(permisoModelo.getId() > 0 && permisoModelo.getId_rol() > 0 && permisoModelo.getId_operacion() > 0)
        {   
            if(permisoRepositorio.Modificar(permisoModelo) == true)
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
    public ArrayList<Object[]> ConsultarTodos() 
    {
        return permisoRepositorio.ListarTodos();
    }    
}