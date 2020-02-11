package Controlador.Rol;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarUnRolControlador extends BaseRol
{
    public Object[] ConsultarUnRol(Object objModelo)
    {
        return getRolServicio().ConsultarUno(objModelo);
    }
}