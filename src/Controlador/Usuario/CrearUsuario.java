
package Controlador.Usuario;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class CrearUsuario extends BaseUsuario
{
    public boolean CrearUsuario(Object objModelo)
    {
        return getUsuarioServicio().Crear(objModelo);
    }
}