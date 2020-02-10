package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public interface IAccesoServicio 
{
    public Object Login(String correo, String clave);
    public Object Logout(Object objEntidad);
}