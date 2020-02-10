package Controlador.Acceso;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class AccesoLogout extends BaseAcceso
{
    public Object AccesoLogout(Object objModelo)
    {
        return getAccesoServicio().Logout(objModelo);
    }
}