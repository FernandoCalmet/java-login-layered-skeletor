package Controlador.Rol;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class EliminarRolControlador extends BaseRol
{
    public boolean EliminarRol(Object objModelo)
    {
        return getRolServicio().Eliminar(objModelo);
    }
}