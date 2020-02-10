package Controlador.Permiso;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.PermisoServicio;

public class BasePermiso extends BaseControlador
{
    protected PermisoServicio permisoServicio;
    
    public BasePermiso()
    {    
        this.permisoServicio = new PermisoServicio();
    }
    
    protected PermisoServicio getPermisoServicio(){ return permisoServicio; }
}