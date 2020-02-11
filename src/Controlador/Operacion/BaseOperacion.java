package Controlador.Operacion;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.OperacionServicio;

public abstract class BaseOperacion extends BaseControlador
{
    private OperacionServicio operacionServicio;
    
    public BaseOperacion()
    {     
        this.operacionServicio = null;
    }
    
    protected OperacionServicio getOperacionServicio()
    { 
        operacionServicio = new OperacionServicio();
        return operacionServicio; 
    }
}