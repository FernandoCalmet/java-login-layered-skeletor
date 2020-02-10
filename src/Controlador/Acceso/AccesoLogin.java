package Controlador.Acceso;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class AccesoLogin extends BaseAcceso
{
    public Object AccesoLogin(String correo, String clave)
    {
        return getAccesoServicio().Login(correo, clave);
    }
}