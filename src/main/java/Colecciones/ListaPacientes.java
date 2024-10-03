
package Colecciones;

import Clases.Paciente;
import Clases.SesionTerapia;
import Clases.Utilidades;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
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
    
    public boolean contienePaciente(String rut){
        return tablaHashPacientes.containsKey(rut);
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
    
    public void guardarPacientesCSV()
    {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/Datos/listadoPacientes.csv", false))) {

            writer.write("NOMBRE;RUT;EDAD;DIRECCION;HISTORIAL MEDICO");
            writer.newLine();
            for (Paciente paciente : this.tablaHashPacientes.values()) {

                writer.write(paciente.getNombre() + ";" + paciente.getRut() + ";" + paciente.getEdad() +
                        ";" + paciente.getDireccion() + ";" + paciente.getHistorialMedico());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar los pacientes.");
        }

    }
    public void guardarSesionesCSV()
    {


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/Datos/listadoSesiones.csv", false))) {

            writer.write("Rut ; Fecha ; Tipo de terapia ; Duracion ; Observaciones ; calificacion de mejora");
            writer.newLine();
            for (Paciente paciente : this.tablaHashPacientes.values()) {
                ListaSesiones sesiones = paciente.ObtenerListaSesiones();
                sesiones.reiniciarRecorrido();
                for (int i = 0; i < sesiones.largo() ; i++)
                {
                    // Accedemos a la sesion
                    sesiones.siguiente();
                    SesionTerapia sesion = sesiones.obtenerSesionActual();

                    // Con la sesion agregamos la linea en el csv
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String fechaSTR = sesion.getFecha().format(formato);
                    writer.write(paciente.getRut() + ";" + fechaSTR + ";" + sesion.getTipoTerapia() 
                             + ";" + sesion.getDuracion() + ";" + sesion.getObservaciones() + ";" + sesion.getCalificacionMejora());
                    writer.newLine();
                }  
            }



        } catch (IOException e) {
            System.out.println("Error al guardar las sesiones");
        }

    }
}

