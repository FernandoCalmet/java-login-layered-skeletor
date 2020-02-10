package Controlador.Rol;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.RolServicio;

public class BaseRol extends BaseControlador
{ 
    protected RolServicio rolServicio;
    
    public BaseRol()
    {  
        this.rolServicio = new RolServicio();
    }
    
    protected RolServicio getRolServicio(){ return rolServicio; }
}