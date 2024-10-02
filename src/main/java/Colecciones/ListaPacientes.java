
package Colecciones;

import Clases.Paciente;
import Clases.Utilidades;
import java.util.HashMap;

public class ListaPacientes {
    private HashMap<String, Paciente> tablaHashPacientes;
    
    public ListaPacientes() {
        this.tablaHashPacientes = new HashMap<>();
        // Se ingresan Datos
        Utilidades.leerArchivoPacientes(this.tablaHashPacientes);
        Utilidades.leerArchivoSesiones(this.tablaHashPacientes); 
    }
    
    public Paciente getPaciente(String rut) {
        Paciente pacienteAux = tablaHashPacientes.get(rut);
        return pacienteAux;
    }
    
    public boolean agregarPaciente(Paciente paciente) {
        String rut = paciente.getRut();
        if(this.tablaHashPacientes.containsKey(rut)) {
            return false;
        }
        this.tablaHashPacientes.put(rut, paciente);
        return true;
    } 
    
    public boolean eliminarPaciente(String rut) {
        if(this.tablaHashPacientes.containsKey(rut)) {
            this.tablaHashPacientes.remove(rut);
            return true;
        }
        return false;
    }
    
    public String listarPacientes() {
        String cadena;
        cadena = "";
        for (Paciente paciente : this.tablaHashPacientes.values()) {
            cadena += paciente.obtenerDatos();
            //cadena += paciente.listarSesiones();
        }
        return cadena;
    }
}

