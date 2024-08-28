package com.mycompany.programarehabilitacionfisica;

import java.util.*;

public class Paciente {
    
    private String nombre;
    private String rut;
    private int edad;
    private String direccion;
    private String historialMedico;
    private ArrayList<SesionTerapia> sesiones; // Falta crear un metodo relacionado

    // Métodos Constructores
    public Paciente(String nombre, String rut, int edad, String direccion, String historialMedico) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.direccion = direccion;
        this.historialMedico = historialMedico;
    }
    
    public Paciente() {
        this.nombre = "";
        this.rut = "";
        this.edad = 0;
        this.direccion = "";
        this.historialMedico = "";
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
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
    
    // Métodos de la Clase
    public void agregarPaciente(HashMap<String, Paciente> mapaPacientes)
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre del paciente: ");
        scanner.nextLine();
        nombre = scanner.nextLine();
                  
        System.out.print("Ingrese el rut del paciente: ");
        rut = scanner.nextLine();
        rut = Utilidades.formatearRut(rut);
        
        while(true)
        {
            System.out.print("Ingrese la edad del paciente: ");
            
            if (scanner.hasNextInt())
            {
                edad = scanner.nextInt();
                scanner.nextLine();
                if (edad < 0)
                {
                    System.out.print("Ingrese una edad valida: ");
                }
                else
                {
                    break;
                }
            }
            else
            {
                scanner.nextLine();
            }
            
        }
                   
        System.out.print("Ingrese la dirección del paciente: ");
        //scanner.nextLine();
        direccion = scanner.nextLine();
                    
        System.out.print("Ingrese el historial medico del paciente: ");
        historialMedico = scanner.nextLine();
        
        mapaPacientes.put(rut, this);
    }
    
}
