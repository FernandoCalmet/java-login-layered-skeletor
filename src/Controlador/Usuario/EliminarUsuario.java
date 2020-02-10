package Controlador.Usuario;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class EliminarUsuario extends BaseUsuario
{
    public boolean EliminarUsuario(Object objModelo)
    {
        return getUsuarioServicio().Eliminar(objModelo);
    }
}