package Controlador.Modulo;

import java.util.ArrayList;

/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarTodosModulos extends BaseModulo
{
    public ArrayList<Object[]> ConsultarTodosModulos()
    {
        return getModuloServicio().ConsultarTodos();
    }
}