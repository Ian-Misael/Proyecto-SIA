package com.mycompany.programarehabilitacionfisica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iangu
 */
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nombre;
    private String rut;
    private int edad;
    private String direccion;
    private String historialMedico;
    private List<SesionTerapia> sesiones; // Falta crear un metodo relacionado

    public Paciente(String nombre, String rut, int edad, String direccion, String historialMedico) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.direccion = direccion;
        this.historialMedico = historialMedico;
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
    
}
