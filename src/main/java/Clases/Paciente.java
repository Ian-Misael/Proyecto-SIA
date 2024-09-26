package Clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Paciente extends Persona{
    
    private String direccion;
    private String historialMedico;

    // Métodos Constructores
    public Paciente(String nombre, String rut, int edad, String direccion, String historialMedico) {
        super(nombre, rut, edad);
        this.direccion = direccion;
        this.historialMedico = historialMedico;
    }
    
    public Paciente() {
        super();
        this.direccion = "";
        this.historialMedico = "";
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
    @Override
    public void poblar() throws IOException {
        super.poblar();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Ingrese la direccion del paciente: ");
        //scanner.nextLine();
        direccion = lector.readLine();
                    
        System.out.print("Ingrese el historial medico del paciente: ");
        historialMedico = lector.readLine();
        
        Utilidades.guardarPacienteCSV(getNombre(),getRut(), getEdad(), direccion, historialMedico);
    }
    
    public void mostrarDatos() {
        Utilidades.limpiarPantalla();
        System.out.println("--- Informacion del Paciente ---\n");
        System.out.println("Nombre: " + getNombre());
        System.out.println("RUT: " + getRut());
        System.out.println("Historial Medico: " + historialMedico);
        System.out.println("\n-- Registro de Sesiones --\n");
        int i = 1;
        System.out.println("---------------------------------------");
        for(SesionTerapia sesion : getSesiones()) {
            sesion.mostrarSesion(i);
            i++;
        } 
    }
}