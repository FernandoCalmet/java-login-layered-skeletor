package Entidad;
/**
 *
 * @author Fernando Calmet <github.com/fernandocalmet>
 */
public class OperacionEntidad 
{
    private int id;
    private String nombre;
    private int id_modulo;

    public OperacionEntidad() {}   
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}  
    public int getId_modulo() {return id_modulo;}
    public void setId_modulo(int id_modulo) {this.id_modulo = id_modulo;}    
    @Override
    public String toString(){return "\nId: "+getId()+"\nNombre: "+getNombre()+"\nId Modulo: "+getId_modulo();}
}