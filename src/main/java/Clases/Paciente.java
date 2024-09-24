package Clases;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.time.LocalDate;


public class Paciente {
    
    private String nombre;
    private String rut;
    private int edad;
    private String ubicacion;
    private String historialMedico;
    private ArrayList<SesionTerapia> sesiones;

    // Métodos Constructores
    public Paciente(String nombre, String rut, int edad, String direccion, String historialMedico) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.ubicacion = direccion;
        this.historialMedico = historialMedico;
        sesiones = new ArrayList();
    }
    
    public Paciente() {
        this.nombre = "";
        this.rut = "";
        this.edad = 0;
        this.ubicacion = "";
        this.historialMedico = "";
        sesiones = new ArrayList();
    }
    
    // Métodos Getter y Setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        if (edad <= 0) {
            // Aquí se lanza una excepción si la edad es inválida
            throw new IllegalArgumentException("La edad debe ser un número positivo.");
        }
        this.edad = edad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String direccion) {
        this.ubicacion = direccion;
    }
    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
    
    // Métodos de la Clase
    public void poblar() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Ingrese el nombre del paciente: ");
        nombre = lector.readLine();
                  
        System.out.print("Ingrese el rut del paciente: ");
        rut = lector.readLine();
        rut = Utilidades.formatearRut(rut);
        
     while (true) {
        System.out.print("Ingrese la edad del paciente: ");
        String input = lector.readLine();
        try {
            edad = Integer.parseInt(input);
            if (edad < 0) {
                System.out.println("Ingrese una edad valida.");
            } else {
                break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido para la edad.");
        }
    }
        System.out.print("Ingrese la ubicacion del paciente: ");
        //scanner.nextLine();
        ubicacion = lector.readLine();
                    
        System.out.print("Ingrese el historial medico del paciente: ");
        historialMedico = lector.readLine();
        
        Utilidades.guardarPacienteCSV(nombre,rut, edad, ubicacion, historialMedico);
    }
    
    public void mostrarDatos() {
        Utilidades.limpiarPantalla();
        System.out.println("--- Informacion del Paciente ---\n");
        System.out.println("Nombre: " + nombre);
        System.out.println("RUT: " + rut);
        System.out.println("Historial Medico: " + historialMedico);
        System.out.println("\n-- Registro de Sesiones --\n");
        int i = 1;
        System.out.println("---------------------------------------");
        for(SesionTerapia sesion : sesiones) {
            sesion.mostrarSesion(i);
            i++;
        } 
    }
    
    public void agregarSesion(LocalDate fecha){
        SesionTerapia nueva = new SesionTerapia(fecha);
        sesiones.add(nueva);
    }
    
    public void agregarSesion(SesionTerapia sesion) {
        sesiones.add(sesion);
    }
}
