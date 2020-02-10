package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import java.util.ArrayList;

public interface IBaseServicio 
{
    public boolean Crear(Object obj);
    public boolean Eliminar(Object obj);
    public Object[] ListarDetalles(Object obj);
    public boolean Modificar(Object obj);
    public ArrayList<Object[]> ListarTodos();
}
