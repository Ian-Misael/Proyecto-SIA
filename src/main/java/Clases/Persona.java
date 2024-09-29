
package Clases;

import Errores.EdadInvalidaException;
import Errores.RutInvalidoException;

public class Persona {
    
    private String nombre;
    private String rut;
    private int edad;
    
    public Persona(){
        nombre = "";
        rut = "";
        edad = 0;
    }

    public Persona(String nombre, String rut, int edad) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
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
    
    public String obtenerDatos() {
        return (nombre + ", " + rut + ", " + edad + "\n");
    }
}
