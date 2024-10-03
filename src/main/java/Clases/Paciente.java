
package Clases;

import Colecciones.ListaSesiones;

public class Paciente extends Persona{
    
    private String direccion;
    private String historialMedico;
    private ListaSesiones sesiones;

    // Métodos Constructores
    public Paciente(String nombre, String rut, int edad, String direccion, String historialMedico) {
        super(nombre, rut, edad);
        this.direccion = direccion;
        this.historialMedico = historialMedico;
        sesiones = new ListaSesiones();
    }
    
    public Paciente() {
        super();
        this.direccion = "";
        this.historialMedico = "";
        sesiones = new ListaSesiones();
    }
    
    // Métodos Getter y Setter
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
    
    // Métodos de la Clase
    
    public void agregarSesion(SesionTerapia sesion) {
        sesiones.agregarSesion(sesion);
    }
    
    public String listarSesiones() {
        return sesiones.listarSesiones();
    }
    
    public ListaSesiones ObtenerListaSesiones() {
        return this.sesiones;
    }
    
    @Override
    public String obtenerDatos() {
        return (getNombre() + ", " + getRut() + ", " + getEdad() + ", " + direccion + ", " + historialMedico + "\n");
    }
}