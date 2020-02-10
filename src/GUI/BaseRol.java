package GUI;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.Rol.*;
import java.util.ArrayList;

public abstract class BaseRol extends BaseGUI
{
    private ConsultarTodosRoles consultarTodosRoles;
    private ConsultarUnRol consultarUnRol;
    private CrearRol crearRol;
    private EliminarRol eliminarRol;
    private ModificarRol modificarRol;
    
    public BaseRol()
    {
        this.consultarTodosRoles = new ConsultarTodosRoles();
        this.consultarUnRol = new ConsultarUnRol();
        this.crearRol = new CrearRol();
        this.eliminarRol = new EliminarRol();
        this.modificarRol = new ModificarRol();
    }   
    
    public ArrayList<Object[]> getConsultarTodosRoles(){ return consultarTodosRoles.ConsultarTodosRoles(); }    
    public Object[] getConsultarUnRol(Object objModelo){ return consultarUnRol.ConsultarUnRol(objModelo); }    
    public boolean getCrearRol(Object objModelo){ return crearRol.CrearRol(objModelo); }
    public boolean getEliminarRol(Object objModelo){ return eliminarRol.EliminarRol(objModelo); }    
    public boolean getModificarRol(Object objModelo){ return modificarRol.ModificarRol(objModelo); }
}