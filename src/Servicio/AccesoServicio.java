package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Entidad.UsuarioEntidad;
import Repositorio.AccesoRepositorio;
import Interface.IServicioAcceso;
import javax.swing.JOptionPane;

public class AccesoServicio implements IServicioAcceso
{
    private UsuarioEntidad usuario = null;
    private final AccesoRepositorio acceso = new AccesoRepositorio();
    
    @Override
    public UsuarioEntidad Login(UsuarioEntidad objUsuario)
    {
        if(!objUsuario.getCorreo().isEmpty() && !objUsuario.getClave().isEmpty())
        {            
            usuario = acceso.accesoLogin(objUsuario);              
            if(usuario.getId() > 0)            
                JOptionPane.showMessageDialog(null, "Bienvenido "+usuario.getNombre()+"!");           
            else            
                JOptionPane.showMessageDialog(null ,"El correo/contraseña no existe o es incorrecta, vuelva a intentarlo");          
        }
        else
            JOptionPane.showMessageDialog(null ,"No esta permitido campos vacios"); 
        return usuario;
    }

    @Override
    public UsuarioEntidad Logout(UsuarioEntidad objUsuario) {
        return acceso.accesoLogout(objUsuario);
    }
}
