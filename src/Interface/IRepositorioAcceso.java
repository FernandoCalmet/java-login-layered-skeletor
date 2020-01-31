package Interface;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public interface IRepositorioAcceso 
{
    public Object accesoLogin(String correo, String clave);
    public Object accesoLogout(Object objUsuario);    
}
