package Controlador.Permiso;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ModificarPermisoControlador extends BasePermiso
{
    public boolean ModificarPermiso(Object objModelo)
    {
        return getPermisoServicio().Modificar(objModelo);
    }
}