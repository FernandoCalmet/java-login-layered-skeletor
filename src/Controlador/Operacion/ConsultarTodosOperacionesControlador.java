package Controlador.Operacion;

import java.util.ArrayList;

/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarTodosOperacionesControlador extends BaseOperacion
{
    public ArrayList<Object[]> ConsultarTodosOperaciones()
    {
        return getOperacionServicio().ConsultarTodos();
    }
}