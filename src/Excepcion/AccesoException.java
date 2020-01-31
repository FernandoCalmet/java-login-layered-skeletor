package Excepcion;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import javax.swing.JOptionPane;

public class AccesoException extends Exception
{
    public AccesoException(String mensaje)
    { 
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje de advertencia" ,JOptionPane.WARNING_MESSAGE);
    }
}