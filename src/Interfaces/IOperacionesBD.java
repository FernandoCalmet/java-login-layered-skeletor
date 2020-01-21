package Interfaces;

import java.util.ArrayList;
/**
 *
 * @author github.com/fernandocalmet
 */
public interface IOperacionesBD 
{
    public boolean Crear(Object obj);
    public boolean Eliminar(Object obj);
    public Object[] ListarDetalles(Object obj);
    public boolean Modificar(Object obj);
    public ArrayList<Object[]> ListarTodos();
}
