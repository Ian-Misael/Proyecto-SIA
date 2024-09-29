
package Colecciones;

import Clases.Paciente;
import Clases.Utilidades;
import java.util.HashMap;

public class ListaPacientes {
    private HashMap<String, Paciente> tablaHashPacientes;
    
    public ListaPacientes() {
        tablaHashPacientes = new HashMap<>();
        // Se ingresan Datos
        Utilidades.leerArchivoPacientes(tablaHashPacientes);
        Utilidades.leerArchivoSesiones(tablaHashPacientes); 
    }
    
    public boolean agregarPaciente(Paciente paciente) {
        String rut = paciente.getRut();
        Paciente aux = tablaHashPacientes.put(rut, paciente);
        return aux == null;
    } 
    
    public String listarPacientes() {
        String cadena;
        cadena = "";
        for (Paciente paciente : tablaHashPacientes.values()) {
            cadena += paciente.obtenerDatos();
            //cadena += paciente.listarSesiones();
        }
        return cadena;
    }
}

