
package Clases;

import Colecciones.ListaSesiones;

public class Terapeuta extends Persona {
    private String especialidad;
    private ListaSesiones sesiones;
    
    //Constructores
    public Terapeuta(){
        super();
        especialidad = "";
        sesiones = new ListaSesiones();
    }
    
    public Terapeuta(String nombre, String rut, int edad, String especialidad){
        super(nombre, rut, edad);
        this.especialidad = especialidad;
        sesiones = new ListaSesiones();
    }
    
    //Getter y setter
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    //Metodos de la clase
    
    public void agregarSesion(SesionTerapia sesion) {
        sesiones.agregarSesion(sesion);
    }
    
    public String listarSesiones() {
        return sesiones.listarSesiones();
    }
    
    @Override
    public String obtenerDatos() {
        return (getNombre() + ", " + getRut() + ", " + getEdad() + ", " + especialidad + "\n");
    }
}
