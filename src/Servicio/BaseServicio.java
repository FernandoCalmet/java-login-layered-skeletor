package Servicio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import Excepcion.*;
import Modelo.*;
import Repositorio.*;

public abstract class BaseServicio 
{    
    protected UsuarioModelo usuarioModelo;
    protected ModuloModelo moduloModelo;
    protected OperacionModelo operacionModelo;
    protected PermisoModelo permisoModelo;
    protected RolModelo rolModelo;
    protected AccesoRepositorio accesoRepositorio;
    protected UsuarioRepositorio usuarioRepositorio;
    protected ModuloRepositorio moduloRepositorio;
    protected OperacionRepositorio operacionRepositorio;
    protected PermisoRepositorio permisoRepositorio;
    protected RolRepositorio rolRepositorio;
    
    public BaseServicio()
    {
        this.usuarioModelo = new UsuarioModelo();
        this.moduloModelo = new ModuloModelo();
        this.operacionModelo = new OperacionModelo();
        this.permisoModelo = new PermisoModelo();
        this.rolModelo = new RolModelo();
        this.accesoRepositorio = new AccesoRepositorio();
        this.usuarioRepositorio = new UsuarioRepositorio();
        this.moduloRepositorio = new ModuloRepositorio();
        this.operacionRepositorio = new OperacionRepositorio();
        this.permisoRepositorio = new PermisoRepositorio();
        this.rolRepositorio = new RolRepositorio();
    }
    
    protected static String validarUsuarioCorreo(String correo)
    {
        try 
        { 
            correo.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
            throw new UsuarioException("El correo no es valido."); 
        } 
        catch (Exception ex) 
        { 
            System.out.println("Excepción capturada: "+ex); 
        }  
        return correo;
    }
    
    protected static String validarUsuarioClave(String clave)
    {
        try 
        { 
            clave.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
            throw new UsuarioException("La contraseña no es valida. Debe tener una longitud de 8 digitos, y debe contener por lo menos una letra mayuscula/minuscula, numeros y un simbolo."); 
        } 
        catch (Exception ex) 
        { 
            System.out.println("Excepción capturada: "+ex); 
        }  
        return clave;
    }
    
    protected static String validarUsuarioNombre(String nombre)
    {
        try 
        { 
            nombre.matches("[A-Za-z]*\\D{3}");
            throw new UsuarioException("El nombre no es valido. Debe tener por lo menos una longitud de 3 digitos, y solo puede contener letras."); 
        } 
        catch (Exception ex) 
        { 
            System.out.println("Excepción capturada: "+ex); 
        }  
        return nombre;
    }
}