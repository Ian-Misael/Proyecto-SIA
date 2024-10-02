
package Clases;

public class Terapeuta extends Persona {
    private String especialidad;
    
    //Constructores
    public Terapeuta(){
        super();
        especialidad = "";
    }
    
    public Terapeuta(String nombre, String rut, int edad, String especialidad){
        super(nombre, rut, edad);
        this.especialidad = especialidad;
    }
    
    //Getter y setter
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    //Metodos de la clase
    @Override
    public String obtenerDatos() {
        return (getNombre() + ", " + getRut() + ", " + getEdad() + ", " + especialidad + "\n");
    }
}
