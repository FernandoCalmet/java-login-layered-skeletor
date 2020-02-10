package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Modelo.UsuarioModelo;
import Excepcion.AccesoException;

public class AccesoServicio extends BaseServicio implements IAccesoServicio
{   
    public AccesoServicio(){ }
    
    @Override
    public Object Login(String correo, String clave)
    {   
        if(correo.isEmpty())
        {              
            try { throw new AccesoException("El campo de correo electrónico es obligatorio"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }
        }
        if(clave.isEmpty())
        {              
            try { throw new AccesoException("El campo de contraseña es obligatorio"); } 
            catch (Exception ex) { System.out.println("Excepción capturada: "+ex); }
        }
        //correo = validarUsuarioCorreo(correo);
        //clave = validarUsuarioClave(clave);
        // pendiente hash de clave
        usuarioModelo = (UsuarioModelo) accesoRepositorio.accesoLogin(correo, clave);              
        return usuarioModelo;
    }

    @Override
    public Object Logout(Object objEntidad) 
    {
        usuarioModelo = (UsuarioModelo) objEntidad;
        return usuarioModelo;
    }
}