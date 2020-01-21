package Clases.Entidades;
/**
 *
 * @author github.com/fernandocalmet
 */
public class Rol 
{
    private int id;
    private String nombre;

    public Rol() {}   
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    @Override
    public String toString(){return "\nId: "+getId()+"\nNombre: "+getNombre();}
}