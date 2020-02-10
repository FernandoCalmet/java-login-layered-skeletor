
package Controlador.Modulo;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class CrearModulo extends BaseModulo
{
    public boolean CrearModulo(Object objModelo)
    {
        return getModuloServicio().Crear(objModelo);
    }
}