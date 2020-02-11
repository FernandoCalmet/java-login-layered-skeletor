
package Controlador.Operacion;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class CrearOperacionControlador extends BaseOperacion
{
    public boolean CrearOperacion(Object objModelo)
    {
        return getOperacionServicio().Crear(objModelo);
    }
}