
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
    
    // Encargado de agregar la sesion a la lista del paciente.
    public void agregarSesion(SesionTerapia sesion) {
        sesiones.agregarSesion(sesion);
    }
    
    // Encargada de mostrar las sesiones del paciente.
    public String listarSesiones() {
        return sesiones.listarSesiones();
    }
    
    // Sobrecarga de metodos
    // Encargado de eliminar la sesion a través de la fecha
    public boolean eliminarSesion(LocalDate fecha) {
        return sesiones.eliminarSesion(fecha);
    }
    // Encargado de Eliminar la sesion a través del objeto
    public boolean eliminarSesion(SesionTerapia sesion) {
        return sesiones.eliminarSesion(sesion);
    }
    // Retorna la lista del paciente para poder trabajar en ella
    public ListaSesiones obtenerListaSesiones() {
        return this.sesiones;
    }
    // Retorna si tienen la misma fecha una sesion.
    public boolean mismaFecha(ListaSesiones sesiones, LocalDate fecha) {
        for (int i = 0 ; i < sesiones.largo() ; i++) {
            if ((sesiones.getSesion(i)).getFecha().isEqual(fecha)) {
                return true;
            }
        }
        return false;
    }
    
    // Sobreescritura de metodos
    // Encargado de retornar los datos del paciente.
    @Override
    public String obtenerDatos() {
        return (getNombre() + "; " + getRut() + "; " + getEdad() + "; " + direccion + ";" + historialMedico + "\n");
    }
}