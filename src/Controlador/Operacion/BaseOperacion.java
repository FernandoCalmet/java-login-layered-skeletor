package Controlador.Operacion;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.OperacionServicio;

public class BaseOperacion extends BaseControlador
{
    protected OperacionServicio operacionServicio;
    
    public BaseOperacion()
    {     
        this.operacionServicio = new OperacionServicio();
    }
    
    protected OperacionServicio getOperacionServicio(){ return operacionServicio; }
}