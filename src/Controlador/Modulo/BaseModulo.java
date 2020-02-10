package Controlador.Modulo;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.ModuloServicio;

public class BaseModulo extends BaseControlador
{ 
    protected ModuloServicio moduloServicio;
    
    public BaseModulo()
    { 
        this.moduloServicio = new ModuloServicio();
    }
    
    protected ModuloServicio getModuloServicio(){ return moduloServicio; }
}