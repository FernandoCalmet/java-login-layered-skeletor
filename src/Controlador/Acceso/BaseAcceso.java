package Controlador.Acceso;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.AccesoServicio;

public class BaseAcceso extends BaseControlador
{
    protected AccesoServicio accesoServicio;
    
    public BaseAcceso()
    {
        this.accesoServicio = new AccesoServicio();
    }
    
    protected AccesoServicio getAccesoServicio(){ return accesoServicio; }
}