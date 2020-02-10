package Controlador.Operacion;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarUnOperacion extends BaseOperacion
{
    public Object[] ConsultarUnOperacion(Object objModelo)
    {
        return getOperacionServicio().ConsultarUno(objModelo);
    }
}