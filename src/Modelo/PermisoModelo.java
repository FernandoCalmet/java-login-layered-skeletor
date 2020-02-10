package Modelo;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class PermisoModelo 
{
    private int id, id_rol, id_operacion;

    public PermisoModelo() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getId_rol() {return id_rol;}
    public void setId_rol(int id_rol) {this.id_rol = id_rol;}
    public int getId_operacion() {return id_operacion;}
    public void setId_operacion(int id_operacion) {this.id_operacion = id_operacion;}
    @Override
    public String toString(){return "\nId: "+getId()+"\nRol: "+getId_rol()+"\nOperacion: "+getId_operacion();}
}