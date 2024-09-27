
package com.mycompany.programarehabilitacionfisica;
import Clases.Utilidades;
import Clases.SesionTerapia;
import Clases.Paciente;
import Ventanas.Dashboard;
//import Errores.RutInvalidoException;
// InputMismatchException

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// ======================== CONTROLADOR ========================
public class ProgramaRehabilitacionFisica {
    
    public static void main(String[] args) throws IOException {
        
        HashMap<String, Paciente> tablaHashPacientes = new HashMap<>();
        BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
        
        // Se ingresan ejemplos
        Utilidades.leerArchivoPacientes(tablaHashPacientes);
        Utilidades.leerArchivoSesiones(tablaHashPacientes); 

        String opcion;
        
        // Operación Principal del Menú
        do {
            menu();
            opcion = lector.readLine();
            opcionMenu(opcion, tablaHashPacientes);
            Utilidades.presioneTeclaParaContinuar();
            
        } while(!opcion.equals("5"));
    }
    
    public static void menu() {
        Utilidades.limpiarPantalla();
        System.out.println("--- Menu de Gestion de Rehabilitacion Fisica ---\n");
        System.out.println(" 1. Registrar un nuevo paciente");
        System.out.println(" 2. Informacion de pacientes");
        System.out.println(" 3. Registrar nueva sesion de terapia");
        System.out.println(" 4. Reporte Progreso");
        System.out.println(" 5. Salir");
    }
    
public static void opcionMenu(String opcion, HashMap<String, Paciente> tablaHashPacientes) throws IOException {
    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    switch (opcion) {
        case "1":
            Utilidades.limpiarPantalla();
            System.out.println("--- Registro de Paciente ---\n");
            Paciente nuevoPaciente = new Paciente();
            nuevoPaciente.poblar();
            tablaHashPacientes.put(nuevoPaciente.getRut(), nuevoPaciente);
            break;
        case "2":
            Utilidades.limpiarPantalla();
            menu2();
            int opcion2 = Integer.parseInt(lector.readLine());
            opcionMenu2(opcion2, tablaHashPacientes);
            break;
        case "3":
            Utilidades.limpiarPantalla();
            System.out.print("Ingrese el rut del paciente: ");
            String rutAux = lector.readLine();
            rutAux = Utilidades.formatearRut(rutAux);
            Paciente pacienteActual = tablaHashPacientes.get(rutAux);
            registroSesion(pacienteActual);
            break;
        case "4":
            Utilidades.limpiarPantalla();
            System.out.println("Funcionalidad de Reporte Progreso en desarrollo.");
            break;
        default:
            if (opcion.equals("5")) {
                System.out.println("Saliendo del programa....");
            } else {
                System.out.println("Opcion no valida!!");
            }
            break;
        }
    }

    public static void menu2() {
        Utilidades.limpiarPantalla();
        System.out.println("--- Seleccione visualizacion de Pacientes ---\n");
        System.out.println(" 1. Listado de pacientes");
        System.out.println(" 2. Seguimiento de paciente");
    }
    
    public static void opcionMenu2(int opcion, HashMap<String, Paciente> tablaHashPacientes) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        switch (opcion) {
            case 1:
                Utilidades.limpiarPantalla();
                System.out.println("--- Listado de pacientes registrados ---\n");
                System.out.println("---------------------------------------");
                
                for (Paciente paciente : tablaHashPacientes.values()) {
                    System.out.println(" Nombre: " + paciente.getNombre());
                    System.out.println(" RUT: " + paciente.getRut());
                    System.out.println(" Edad: " + paciente.getEdad());
                    System.out.println("---------------------------------------");
                }
                System.out.println("");
                break;
            case 2:    
                Utilidades.limpiarPantalla();
                System.out.print("Ingrese el rut del paciente: ");
                String rut = lector.readLine();
                rut = Utilidades.formatearRut(rut);

                Paciente pacienteBuscado = tablaHashPacientes.get(rut);
                if (pacienteBuscado != null) {
                    pacienteBuscado.mostrarDatos();
                } else {
                    System.out.println("\nPaciente no encontrado.\n");
                }
                break;
            default:
                System.out.println("Opcion no valida!!");
                break;
        }
    }
    
    public static void registroSesion(Paciente pacienteActual) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        if (pacienteActual != null) {
            Utilidades.limpiarPantalla();
            System.out.print("Ingrese la fecha de la sesion (dd/MM/yyyy): ");
            String inputFecha = lector.readLine();
            try {
                LocalDate fecha = LocalDate.parse(inputFecha, formatter);

                // Solicitar más detalles sobre la sesión
                System.out.print("Ingrese el tipo de terapia: ");
                String tipoTerapia = lector.readLine();

                System.out.print("Ingrese la duracion de la terapia: ");
                String duracion = lector.readLine();

                System.out.print("Ingrese observaciones: ");
                String observaciones = lector.readLine();

                System.out.print("Ingrese la calificacion de mejora (1-10): ");
                int calificacionMejora = Integer.parseInt(lector.readLine());

                // Crear una nueva sesión de terapia con los detalles ingresados
                SesionTerapia nuevaSesion = new SesionTerapia(fecha, tipoTerapia, duracion, observaciones, calificacionMejora);
                pacienteActual.agregarSesion(nuevaSesion);
                nuevaSesion.mostrarSesion();
                
                Utilidades.guardarSesionesCSV(fecha, tipoTerapia, duracion, observaciones, calificacionMejora, pacienteActual.getRut());
                System.out.println("\nSesion registrada con exito.\n");
            } catch (DateTimeParseException e) {
                System.out.println("\nFecha ingresada no valida. Asegurese de usar el formato dd/MM/yyyy.\n");
            }
        } else {
            System.out.println("\nPaciente no encontrado.\n");
        }
    }
}

