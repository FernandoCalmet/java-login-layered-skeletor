package Interface;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public interface IServicioAcceso 
{
    public Object Login(String correo, String clave);
    public Object Logout(Object objEntidad);
}
