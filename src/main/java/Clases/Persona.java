package Clases;

import Errores.EdadInvalidaException;
import Errores.RutInvalidoException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class Persona {
    
    private String nombre;
    private String rut;
    private int edad;
    private ArrayList<SesionTerapia> sesiones;
    
    public Persona(){
        nombre = "";
        rut = "";
        edad = 0;
        sesiones = new ArrayList();
    }

    public Persona(String nombre, String rut, int edad) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        sesiones = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws RutInvalidoException {
        if (rut.matches(".*[a-jl-zA-JL-Z].*")) {
            throw new RutInvalidoException();
        }
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws EdadInvalidaException {
        if (edad < 0) {
            throw new EdadInvalidaException();
        }
        this.edad = edad;
    }

    public ArrayList<SesionTerapia> getSesiones() {
        return sesiones;
    }

    public void setSesiones(ArrayList<SesionTerapia> sesiones) {
        this.sesiones = sesiones;
    }
    
    
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
    }
    
    public void agregarSesion(LocalDate fecha){
        SesionTerapia nueva = new SesionTerapia(fecha);
        sesiones.add(nueva);
    }
    
    public void agregarSesion(SesionTerapia sesion) {
        sesiones.add(sesion);
    }
    
}
