package Controlador.Usuario;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ModificarUsuario extends BaseUsuario
{
    public boolean ModificarUsuario(Object objModelo)
    {
        return getUsuarioServicio().Modificar(objModelo);
    }
}