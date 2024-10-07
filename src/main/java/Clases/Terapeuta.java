
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
    
    // Metodo para poder agregar sesiones a la lista del paciente.
    public void agregarSesion(SesionTerapia sesion) {
        sesiones.agregarSesion(sesion);
    }
    
    // Metodo encargado de mostrar las sesiones de la lista.
    public String listarSesiones() {
        return sesiones.listarSesiones();
    }
    
    // Sobreescritura de metodos
    // Encargado de retornar los datos del terapeuta.
    @Override
    public String obtenerDatos() {
        return (getNombre() + "; " + getRut() + "; " + getEdad() + "; " + especialidad + "\n");
    }
}
