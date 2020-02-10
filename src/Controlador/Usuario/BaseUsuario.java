package Controlador.Usuario;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.UsuarioServicio;

public class BaseUsuario extends BaseControlador
{
    protected UsuarioServicio usuarioServicio;
    
    public BaseUsuario()
    { 
        this.usuarioServicio = new UsuarioServicio(); 
    }
    
    protected UsuarioServicio getUsuarioServicio(){ return usuarioServicio; }
}