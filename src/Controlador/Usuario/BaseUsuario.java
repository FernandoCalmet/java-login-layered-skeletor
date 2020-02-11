package Controlador.Usuario;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.BaseControlador;
import Servicio.UsuarioServicio;

public abstract class BaseUsuario extends BaseControlador
{
    private UsuarioServicio usuarioServicio;
    
    public BaseUsuario()
    { 
        this.usuarioServicio = null;
    }
    
    protected UsuarioServicio getUsuarioServicio()
    { 
        usuarioServicio = new UsuarioServicio(); 
        return usuarioServicio; 
    }
}