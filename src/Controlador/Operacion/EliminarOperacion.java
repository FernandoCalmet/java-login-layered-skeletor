package Controlador.Operacion;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class EliminarOperacion extends BaseOperacion
{
    public boolean EliminarOperacion(Object objModelo)
    {
        return getOperacionServicio().Eliminar(objModelo);
    }
}