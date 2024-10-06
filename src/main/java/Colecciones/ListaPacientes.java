
package Colecciones;

import Clases.Paciente;
import Clases.SesionTerapia;
import Clases.Utilidades;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class ListaPacientes {
    private HashMap<String, Paciente> tablaHashPacientes;
    
    public ListaPacientes() {
        this.tablaHashPacientes = new HashMap<>();
        // Se ingresan Datos
        Utilidades.leerArchivoPacientes(this.tablaHashPacientes);
        Utilidades.leerArchivoSesionesP(this.tablaHashPacientes); 
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
        }
        return cadena;
    }
    
    public ListaSesiones getSesiones() {
        ListaSesiones todasLasSesiones = new ListaSesiones();
        for (Paciente paciente : tablaHashPacientes.values()) {
            ListaSesiones sesionesPaciente = paciente.obtenerListaSesiones();
            for (int i = 0; i < sesionesPaciente.largo(); i++) {
                todasLasSesiones.agregarSesion(sesionesPaciente.getSesion(i));
            }
        }
        return todasLasSesiones;
    }
    
    public ListaSesiones getSesiones(int anio) {
        ListaSesiones sesionesAnio = new ListaSesiones();
        for (Paciente paciente : tablaHashPacientes.values()) {
            ListaSesiones sesionesPaciente = paciente.obtenerListaSesiones();
            ArrayList<SesionTerapia> sesionesFiltradas = sesionesPaciente.filtrarSesionesPorAnio(anio);
            for (SesionTerapia sesion : sesionesFiltradas) {
                sesionesAnio.agregarSesion(sesion);
            }
        }
        return sesionesAnio;
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

            writer.write("Rut ; Fecha ; Tipo de terapia ; Duracion ; Observaciones ; calificacion de mejora; RUT TERAPEUTA");
            writer.newLine();
            for (Paciente paciente : this.tablaHashPacientes.values()) {
                ListaSesiones sesiones = paciente.obtenerListaSesiones();
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
                             + ";" + sesion.getDuracion() + ";" + sesion.getObservaciones() + ";" + sesion.getCalificacionMejora() 
                             + ";" + sesion.getRutTerapeuta());
                    writer.newLine();
                }  
            }
        } catch (IOException e) {
            System.out.println("Error al guardar las sesiones");
        }
    }
    
    public void exportarDatos()
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/DatosExportados/datosPacientes.csv", false))) {

            writer.write("Nombre;Rut;Edad;Direccion;Historial Medico;Cantidad De Sesiones");
            writer.newLine();
            for (Paciente paciente : this.tablaHashPacientes.values()) {
                ListaSesiones sesiones = paciente.obtenerListaSesiones();
                int cantidadSesiones = sesiones.largo();
                
                 writer.write(paciente.getNombre() + ";" + paciente.getRut() + ";" + paciente.getEdad() +
                        ";" + paciente.getDireccion() + ";" + paciente.getHistorialMedico() + ";" + cantidadSesiones);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al exportar los datos.");
        }
    
    }
}

