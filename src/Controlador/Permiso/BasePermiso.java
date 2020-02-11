package Controlador.Permiso;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.PermisoServicio;

public abstract class BasePermiso extends BaseControlador
{
    private PermisoServicio permisoServicio;
    
    public BasePermiso()
    {    
        this.permisoServicio = null;
    }
    
    protected PermisoServicio getPermisoServicio()
    { 
        permisoServicio = new PermisoServicio();
        return permisoServicio; 
    }
}