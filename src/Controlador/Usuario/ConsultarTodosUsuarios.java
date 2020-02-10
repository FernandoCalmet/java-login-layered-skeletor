package Controlador.Usuario;

import java.util.ArrayList;

/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarTodosUsuarios extends BaseUsuario
{
    public ArrayList<Object[]> ConsultarTodosUsuarios()
    {
        return getUsuarioServicio().ConsultarTodos();
    }
}