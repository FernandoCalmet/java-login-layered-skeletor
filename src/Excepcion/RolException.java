package Excepcion;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import javax.swing.JOptionPane;

public class RolException extends Exception
{
    public RolException(String mensaje)
    { 
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje de advertencia" ,JOptionPane.WARNING_MESSAGE); 
    }
}