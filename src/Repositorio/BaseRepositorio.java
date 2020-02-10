package Repositorio;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
import BaseDatos.ConexionBD;
import Modelo.*;
import java.sql.Connection;

public abstract class BaseRepositorio extends ConexionBD
{
    protected UsuarioModelo usuarioModelo;
    protected ModuloModelo moduloModelo;
    protected OperacionModelo operacionModelo;
    protected PermisoModelo permisoModelo;
    protected RolModelo rolModelo;
    
    public BaseRepositorio()
    {
        super();
        this.usuarioModelo = new UsuarioModelo();
        this.moduloModelo = new ModuloModelo();
        this.operacionModelo = new OperacionModelo();
        this.permisoModelo = new PermisoModelo();
        this.rolModelo = new RolModelo();
    }
    
    protected Connection getBD()
    {
        return getConexion();
    }
}