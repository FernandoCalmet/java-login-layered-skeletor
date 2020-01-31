package Excepcion;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import javax.swing.JOptionPane;

public class ModuloException extends Exception
{
    public ModuloException(String mensaje)
    { 
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje de advertencia" ,JOptionPane.WARNING_MESSAGE); 
    }
}