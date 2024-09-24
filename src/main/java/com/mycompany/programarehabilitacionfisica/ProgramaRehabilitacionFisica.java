
package com.mycompany.programarehabilitacionfisica;
import Clases.Utilidades;
import Clases.SesionTerapia;
import Clases.Paciente;
//import Errores.RutInvalidoException;

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
        //ingresoCasos(tablaHashPacientes);
        Utilidades.leerArchivoPacientes(tablaHashPacientes);
        Utilidades.leerArchivoSesiones(tablaHashPacientes); 
        
        int opcion;
        
        // Operación Principal del Menú
        do {
            menu();
            opcion = Integer.parseInt(lector.readLine());
            opcionMenu(opcion, tablaHashPacientes);
            Utilidades.presioneTeclaParaContinuar();
            
        } while(opcion != 5);
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
    
public static void opcionMenu(int opcion, HashMap<String, Paciente> tablaHashPacientes) throws IOException {
    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    switch (opcion) {
        case 1:
            Utilidades.limpiarPantalla();
            System.out.println("--- Registro de Paciente ---\n");
            Paciente nuevoPaciente = new Paciente();
            nuevoPaciente.poblar();
            tablaHashPacientes.put(nuevoPaciente.getRut(), nuevoPaciente);
            break;
        case 2:
            Utilidades.limpiarPantalla();
            menu2();
            int opcion2 = Integer.parseInt(lector.readLine());
            opcionMenu2(opcion2, tablaHashPacientes);
            break;
        case 3:
            Utilidades.limpiarPantalla();
            System.out.print("Ingrese el rut del paciente: ");
            String rutAux = lector.readLine();
            rutAux = Utilidades.formatearRut(rutAux);
            Paciente pacienteActual = tablaHashPacientes.get(rutAux);
            registroSesion(pacienteActual);
            break;
        case 4:
            Utilidades.limpiarPantalla();
            System.out.println("Funcionalidad de Reporte Progreso en desarrollo.");
            break;
        default:
            if (opcion == 5) {
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
    
    public static void ingresoCasos(HashMap<String, Paciente> tablaHashPacientes) {
        Paciente paciente1 = new Paciente("Juan","20.180.417-5", 25, "Viña del Mar", "Resfriado");
        Paciente paciente2 = new Paciente("Felipe","21.734.001-2", 20, "Quilpue", "Hemorroides");
        Paciente paciente3 = new Paciente("Ian","21.584.598-2", 20, "Quilpue", "Dicenteria");
        
        paciente1.agregarSesion(LocalDate.now());
        paciente2.agregarSesion(LocalDate.of(2004, 12, 20));
        paciente3.agregarSesion(LocalDate.of(2022, 4, 10));
        
        SesionTerapia sesion11 = new SesionTerapia(LocalDate.of(2074, 3, 8), "Conductual", "4 Horas", "Mantiene las apuestas en casinos", 2);
        paciente1.agregarSesion(sesion11);
        SesionTerapia sesion21 = new SesionTerapia(LocalDate.of(2019, 10, 10), "Logoterapia", "30 Minutos", "Aun no encuentra el sentido de la Vida", 5);
        paciente2.agregarSesion(sesion21);
        SesionTerapia sesion31 = new SesionTerapia(LocalDate.of(2004, 5, 25), "Psicoanalitica", "1 Hora", "Presenta estres academico", 3);
        paciente3.agregarSesion(sesion31);
        
        tablaHashPacientes.put(paciente1.getRut(),paciente1);
        tablaHashPacientes.put(paciente2.getRut(),paciente2);
        tablaHashPacientes.put(paciente3.getRut(),paciente3);
    }
}

