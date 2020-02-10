package GUI;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Controlador.Modulo.*;
import java.util.ArrayList;

public abstract class BaseModulo extends BaseGUI
{
    private ConsultarTodosModulos consultarTodosModulos;
    private ConsultarUnModulo consultarUnModulo;
    private CrearModulo crearModulo;
    private EliminarModulo eliminarModulo;
    private ModificarModulo modificarModulo;
    
    public BaseModulo()
    {
        this.consultarTodosModulos = new ConsultarTodosModulos();
        this.consultarUnModulo = new ConsultarUnModulo();
        this.crearModulo = new CrearModulo();
        this.eliminarModulo = new EliminarModulo();
        this.modificarModulo = new ModificarModulo();
    }   
    
    public ArrayList<Object[]> getConsultarTodosModulos(){ return consultarTodosModulos.ConsultarTodosModulos(); }    
    public Object[] getConsultarUnModulo(Object objModelo){ return consultarUnModulo.ConsultarUnModulo(objModelo); }    
    public boolean getCrearModulo(Object objModelo){ return crearModulo.CrearModulo(objModelo); }
    public boolean getEliminarModulo(Object objModelo){ return eliminarModulo.EliminarModulo(objModelo); }    
    public boolean getModificarModulo(Object objModelo){ return modificarModulo.ModificarModulo(objModelo); }
}