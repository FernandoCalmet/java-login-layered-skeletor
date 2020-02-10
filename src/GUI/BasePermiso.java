package GUI;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.Permiso.*;
import java.util.ArrayList;

public abstract class BasePermiso extends BaseGUI
{
    private ConsultarTodosPermisos consultarTodosPermisos;
    private ConsultarUnPermiso consultarUnPermiso;
    private CrearPermiso crearPermiso;
    private EliminarPermiso eliminarPermiso;
    private ModificarPermiso modificarPermiso;
    
    public BasePermiso()
    {
        this.consultarTodosPermisos = new ConsultarTodosPermisos();
        this.consultarUnPermiso = new ConsultarUnPermiso();
        this.crearPermiso = new CrearPermiso();
        this.eliminarPermiso = new EliminarPermiso();
        this.modificarPermiso = new ModificarPermiso();
    }   
    
    public ArrayList<Object[]> getConsultarTodosPermisos(){ return consultarTodosPermisos.ConsultarTodosPermisos(); }    
    public Object[] getConsultarUnPermiso(Object objModelo){ return consultarUnPermiso.ConsultarUnPermiso(objModelo); }    
    public boolean getCrearPermiso(Object objModelo){ return crearPermiso.CrearPermiso(objModelo); }
    public boolean getEliminarPermiso(Object objModelo){ return eliminarPermiso.EliminarPermiso(objModelo); }    
    public boolean getModificarPermiso(Object objModelo){ return modificarPermiso.ModificarPermiso(objModelo); }
}