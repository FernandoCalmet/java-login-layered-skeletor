
package Controlador.Rol;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class CrearRolControlador extends BaseRol
{
    public boolean CrearRol(Object objModelo)
    {
        return getRolServicio().Crear(objModelo);
    }
}