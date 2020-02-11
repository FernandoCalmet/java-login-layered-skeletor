package Controlador.Operacion;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ModificarOperacionControlador extends BaseOperacion
{
    public boolean ModificarOperacion(Object objModelo)
    {
        return getOperacionServicio().Modificar(objModelo);
    }
}