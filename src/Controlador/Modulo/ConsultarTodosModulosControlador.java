package Controlador.Modulo;

import java.util.ArrayList;

/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class ConsultarTodosModulosControlador extends BaseModulo
{
    private ArrayList<Object[]> objLista;
    
    public ArrayList<Object[]> ConsultarTodosModulos()
    { 
        objLista = new ArrayList<>();
        objLista = getModuloServicio().ConsultarTodos();
        return objLista;
    }    
}