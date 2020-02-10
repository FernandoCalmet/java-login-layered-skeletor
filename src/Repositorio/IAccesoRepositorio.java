package Repositorio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public interface IAccesoRepositorio 
{
    public Object accesoLogin(String correo, String clave);
    public Object accesoLogout(Object objUsuario);    
}
