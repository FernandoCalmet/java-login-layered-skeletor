package Entidad;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class UsuarioEntidad 
{
    private int id;
    private String correo, clave, nombre;
    private int id_rol;

    public UsuarioEntidad() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
    public String getClave() {return clave;}
    public void setClave(String clave) {this.clave = clave;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public int getId_rol() {return id_rol;}
    public void setId_rol(int id_rol) {this.id_rol = id_rol;}    
    @Override
    public String toString(){return "\nId: "+getId()+"\nCorreo: "+getCorreo()+"\nClave: "+getClave()+"\nNombre: "+getNombre()+"\nRol: "+getId_rol();}
}
