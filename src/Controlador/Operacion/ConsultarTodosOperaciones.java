package Controlador.Operacion;

import java.util.ArrayList;

/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarTodosOperaciones extends BaseOperacion
{
    public ArrayList<Object[]> ConsultarTodosOperaciones()
    {
        return getOperacionServicio().ConsultarTodos();
    }
}