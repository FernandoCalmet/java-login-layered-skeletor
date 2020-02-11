package Controlador.Usuario;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.util.ArrayList;

public class ConsultarTodosUsuariosControlador extends BaseUsuario
{
    public ArrayList<Object[]> ConsultarTodosUsuarios()
    {
        return getUsuarioServicio().ConsultarTodos();
    }
}