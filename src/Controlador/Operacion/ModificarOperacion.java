package Controlador.Operacion;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ModificarOperacion extends BaseOperacion
{
    public boolean ModificarOperacion(Object objModelo)
    {
        return getOperacionServicio().Modificar(objModelo);
    }
}