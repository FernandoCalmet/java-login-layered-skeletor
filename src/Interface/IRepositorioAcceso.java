package Interface;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.UsuarioEntidad;

public interface IRepositorioAcceso 
{
    public UsuarioEntidad accesoLogin(UsuarioEntidad objUsuario);
    public UsuarioEntidad accesoLogout(UsuarioEntidad objUsuario);
}
