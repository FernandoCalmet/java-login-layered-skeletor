package Controlador.Modulo;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ModificarModuloControlador extends BaseModulo
{
    public boolean ModificarModulo(Object objModelo)
    {
        return getModuloServicio().Modificar(objModelo);
    }
}