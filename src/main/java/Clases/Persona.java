
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
    // Verifica que no haya letras entre a-j o A-J en todo el string, excepto 'k' o 'K' solo al final
        if (!rut.matches("\\d{1,2}(\\.\\d{3}){2}-[0-9kK]")) {
            throw new RutInvalidoException();
        }
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException(); // Excepcion personalizada, se puede encontrar en la carpeta errores.
        }
        this.edad = edad;
    }
    // Sobreescritura de metodos
    // Metodo encargado de retornar los datos de la persona.
    public String obtenerDatos() {
        return (nombre + ", " + rut + ", " + edad + "\n");
    }
}
