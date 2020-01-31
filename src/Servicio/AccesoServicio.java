package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Repositorio.AccesoRepositorio;
import Interface.IServicioAcceso;
import Entidad.UsuarioEntidad;
import Excepcion.AccesoException;

public class AccesoServicio implements IServicioAcceso
{
    private final AccesoRepositorio repositorio;
    private UsuarioEntidad entidad;
    
    public AccesoServicio()
    {
        this.repositorio = new AccesoRepositorio();
        this.entidad = new UsuarioEntidad();
    }     
    
    @Override
    public Object Login(String correo, String clave)
    {   
        if(correo.isEmpty() || clave.isEmpty())
        {              
            try { throw new AccesoException("No esta permitido campos vacios, ingresar los datos solicitados"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }
        }
        else
        {
            // pendiente: hash de clave
            entidad = (UsuarioEntidad) repositorio.accesoLogin(correo, clave);
            if(entidad.getId() == 0)
            {
                try { throw new AccesoException("El usuario no existe o algun dato ingresado es incorrecto"); } 
                catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }
            }  
        }              
        return entidad;
    }

    @Override
    public Object Logout(Object objEntidad) 
    {
        entidad = (UsuarioEntidad) objEntidad;
        return entidad;
    }
}