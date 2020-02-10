package GUI;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.Usuario.*;
import java.util.ArrayList;

public abstract class BaseUsuario extends BaseGUI
{
    private ConsultarTodosUsuarios consultarTodosUsuarios;
    private ConsultarUnUsuario consultarUnUsuario;
    private CrearUsuario crearUsuario;
    private EliminarUsuario eliminarUsuario;
    private ModificarUsuario modificarUsuario;
    
    public BaseUsuario()
    {
        this.consultarTodosUsuarios = new ConsultarTodosUsuarios();
        this.consultarUnUsuario = new ConsultarUnUsuario();
        this.crearUsuario = new CrearUsuario();
        this.eliminarUsuario = new EliminarUsuario();
        this.modificarUsuario = new ModificarUsuario();
    }   
    
    public ArrayList<Object[]> getConsultarTodosUsuarios(){ return consultarTodosUsuarios.ConsultarTodosUsuarios(); }    
    public Object[] getConsultarUnUsuario(Object objModelo){ return consultarUnUsuario.ConsultarUnUsuario(objModelo); }    
    public boolean getCrearUsuario(Object objModelo){ return crearUsuario.CrearUsuario(objModelo); }
    public boolean getEliminarUsuario(Object objModelo){ return eliminarUsuario.EliminarUsuario(objModelo); }    
    public boolean getModificarUsuario(Object objModelo){ return modificarUsuario.ModificarUsuario(objModelo); }
}