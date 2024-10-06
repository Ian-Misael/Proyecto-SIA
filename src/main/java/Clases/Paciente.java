
package Clases;

import Colecciones.ListaSesiones;
import java.time.LocalDate;

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
    
    public boolean eliminarSesion(LocalDate fecha) {
        return sesiones.eliminarSesion(fecha);
    }
    
    public boolean eliminarSesion(SesionTerapia sesion) {
        return sesiones.eliminarSesion(sesion);
    }
    
    public ListaSesiones obtenerListaSesiones() {
        return this.sesiones;
    }
    
    public boolean mismaFecha(ListaSesiones sesiones, LocalDate fecha) {
        for (int i = 0 ; i < sesiones.largo() ; i++) {
            if ((sesiones.getSesion(i)).getFecha().isEqual(fecha)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String obtenerDatos() {
        return (getNombre() + "; " + getRut() + "; " + getEdad() + "; " + direccion + ";" + historialMedico + "\n");
    }
}