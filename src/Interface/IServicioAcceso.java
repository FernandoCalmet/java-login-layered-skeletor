package Interface;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.UsuarioEntidad;

public interface IServicioAcceso 
{
    public UsuarioEntidad Login(UsuarioEntidad objUsuario);
    public UsuarioEntidad Logout(UsuarioEntidad objUsuario);
}
