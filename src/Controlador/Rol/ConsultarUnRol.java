package Controlador.Rol;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarUnRol extends BaseRol
{
    public Object[] ConsultarUnRol(Object objModelo)
    {
        return getRolServicio().ConsultarUno(objModelo);
    }
}