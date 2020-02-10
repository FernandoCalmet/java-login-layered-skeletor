package GUI;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.Operacion.*;
import java.util.ArrayList;

public abstract class BaseOperacion extends BaseGUI
{
    private ConsultarTodosOperaciones consultarTodosOperaciones;
    private ConsultarUnOperacion consultarUnOperacion;
    private CrearOperacion crearOperacion;
    private EliminarOperacion eliminarOperacion;
    private ModificarOperacion modificarOperacion;
    
    public BaseOperacion()
    {
        this.consultarTodosOperaciones = new ConsultarTodosOperaciones();
        this.consultarUnOperacion = new ConsultarUnOperacion();
        this.crearOperacion = new CrearOperacion();
        this.eliminarOperacion = new EliminarOperacion();
        this.modificarOperacion = new ModificarOperacion();
    }   
    
    public ArrayList<Object[]> getConsultarTodosOperaciones(){ return consultarTodosOperaciones.ConsultarTodosOperaciones(); }    
    public Object[] getConsultarUnOperacion(Object objModelo){ return consultarUnOperacion.ConsultarUnOperacion(objModelo); }    
    public boolean getCrearOperacion(Object objModelo){ return crearOperacion.CrearOperacion(objModelo); }
    public boolean getEliminarOperacion(Object objModelo){ return eliminarOperacion.EliminarOperacion(objModelo); }    
    public boolean getModificarOperacion(Object objModelo){ return modificarOperacion.ModificarOperacion(objModelo); }
}