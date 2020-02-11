package Controlador.Modulo;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.ModuloServicio;

public abstract class BaseModulo extends BaseControlador
{ 
    private ModuloServicio moduloServicio;
    
    public BaseModulo()
    { 
        this.moduloServicio = null;
    }
    
    protected ModuloServicio getModuloServicio()
    { 
        moduloServicio = new ModuloServicio();
        return moduloServicio; 
    }
}