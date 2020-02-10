package Controlador.Usuario;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarUnUsuario extends BaseUsuario
{
    public Object[] ConsultarUnUsuario(Object objModelo)
    {
        return getUsuarioServicio().ConsultarUno(objModelo);
    }
}