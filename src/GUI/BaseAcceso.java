package GUI;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.Acceso.*;

public class BaseAcceso 
{
    private AccesoLogin accesoLogin;
    private AccesoLogout accesoLogout;
    
    public BaseAcceso()
    {
        this.accesoLogin = new AccesoLogin();
        this.accesoLogout = new AccesoLogout();
    }   
    
    public Object getAccesoLogin(String correo, String clave){ return accesoLogin.AccesoLogin(correo, clave); }    
    public Object getAccesoLogout(Object objModelo){ return accesoLogout.AccesoLogout(objModelo); } 
}