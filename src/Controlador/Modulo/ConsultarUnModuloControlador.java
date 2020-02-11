package Controlador.Modulo;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarUnModuloControlador extends BaseModulo
{
    public Object[] ConsultarUnModulo(Object objModelo)
    {
        return getModuloServicio().ConsultarUno(objModelo);
    }
}