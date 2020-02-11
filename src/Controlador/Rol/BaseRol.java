package Controlador.Rol;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.RolServicio;

public abstract class BaseRol extends BaseControlador
{ 
    private RolServicio rolServicio;
    
    public BaseRol()
    {  
        this.rolServicio = null;
    }
    
    protected RolServicio getRolServicio()
    { 
        rolServicio = new RolServicio();
        return rolServicio; 
    }
}