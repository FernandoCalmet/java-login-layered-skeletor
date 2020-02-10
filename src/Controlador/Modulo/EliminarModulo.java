package Controlador.Modulo;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class EliminarModulo extends BaseModulo
{
    public boolean EliminarModulo(Object objModelo)
    {
        return getModuloServicio().Eliminar(objModelo);
    }
}