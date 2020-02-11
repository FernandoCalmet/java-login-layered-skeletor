package Controlador.Acceso;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.AccesoServicio;

public abstract class BaseAcceso extends BaseControlador
{
    private AccesoServicio accesoServicio;    
    
    public BaseAcceso(){ this.accesoServicio = null; }
    
    protected AccesoServicio getAccesoServicio()
    { 
        accesoServicio = new AccesoServicio();
        return accesoServicio; 
    }   
}