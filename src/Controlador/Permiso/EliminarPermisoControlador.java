package Controlador.Permiso;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class EliminarPermisoControlador extends BasePermiso
{
    public boolean EliminarPermiso(Object objModelo)
    {
        return getPermisoServicio().Eliminar(objModelo);
    }
}