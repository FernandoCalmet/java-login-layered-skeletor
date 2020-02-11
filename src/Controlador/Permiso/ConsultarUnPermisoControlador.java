package Controlador.Permiso;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarUnPermisoControlador extends BasePermiso
{
    public Object[] ConsultarUnPermiso(Object objModelo)
    {
        return getPermisoServicio().ConsultarUno(objModelo);
    }
}