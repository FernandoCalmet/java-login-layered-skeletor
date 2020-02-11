package Controlador.Acceso;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class AccesoLoginControlador extends BaseAcceso
{      
    public Object AccesoLogin(String usuarioCorreo, String usuarioClave)
    {
        return getAccesoServicio().Login(usuarioCorreo, usuarioClave);
    }
}