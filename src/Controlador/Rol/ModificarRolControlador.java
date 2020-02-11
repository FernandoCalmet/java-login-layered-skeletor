package Controlador.Rol;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ModificarRolControlador extends BaseRol
{
    public boolean ModificarRol(Object objModelo)
    {
        return getRolServicio().Modificar(objModelo);
    }
}