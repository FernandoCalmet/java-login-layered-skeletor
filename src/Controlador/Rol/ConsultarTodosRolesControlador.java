package Controlador.Rol;

import java.util.ArrayList;

/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarTodosRolesControlador extends BaseRol
{
    public ArrayList<Object[]> ConsultarTodosRoles()
    {
        return getRolServicio().ConsultarTodos();
    }
}