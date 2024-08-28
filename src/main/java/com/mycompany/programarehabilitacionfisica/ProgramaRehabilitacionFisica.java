
package com.mycompany.programarehabilitacionfisica;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.time.LocalDate;

public class ProgramaRehabilitacionFisica {
    
    public static void main(String[] args) throws IOException {
        
        HashMap<String, Paciente> tablaHashPacientes = new HashMap<>();

        Paciente paciente1 = new Paciente("Juan","20.180.417-5", 25, "Viña del Mar", "Resfriado");
        Paciente paciente2 = new Paciente("Ian","21.584.598-2", 20, "Quilpue", "Muerto");
        Paciente paciente3 = new Paciente("Felipe","21.734.001-2", 20, "Quilpue", "Hemorroides");
        
        paciente1.agregarSesion(LocalDate.now());
        paciente1.agregarSesion(LocalDate.now());
        paciente1.agregarSesion(LocalDate.now());
        paciente1.agregarSesion(LocalDate.now());
        
        
        //paciente2.agregarSesion("28/08/2024");
        //paciente3.agregarSesion("28/08/2024");
        tablaHashPacientes.put(paciente1.getRut(),paciente1);
        tablaHashPacientes.put(paciente2.getRut(),paciente2);
        tablaHashPacientes.put(paciente3.getRut(),paciente3);
        
        //Scanner scanner = new Scanner(System.in);
        BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
        
        int opcion;
        
        do{
            menu();
            
            opcion = Integer.parseInt(lector.readLine());
            
            opcionMenu(opcion,tablaHashPacientes);
            
            Utilidades.presioneTeclaParaContinuar();
            
        } while(opcion != 5);
    }
    
    public static void menu() {
        
        Utilidades.limpiarPantalla();
        
        System.out.println("--- Menu de Gestion de Rehabilitacion Fisica ---");
        System.out.println("1. Registrar un nuevo paciente");
        System.out.println("2. Seguimiento paciente");
        System.out.println("3. Registrar nueva sesion de terapia");
        System.out.println("4. Reporte Progreso");
        System.out.println("5. Salir");
    }
    
    public static void opcionMenu(int opcion, HashMap<String, Paciente> tablaHashPacientes) throws IOException {
        BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
        switch(opcion) {
            case 1:
                Paciente nuevoPaciente = new Paciente();
                nuevoPaciente.poblar();
                tablaHashPacientes.put(nuevoPaciente.getRut(), nuevoPaciente);
                break;
            case 2:
                System.out.print("Ingrese el rut del paciente: ");
                String rut = lector.readLine();
                rut = Utilidades.formatearRut(rut);
                
                Paciente pacienteBuscado = tablaHashPacientes.get(rut);
                pacienteBuscado.mostrarDatos();
                
                break;
            case 3:
                System.out.println("Ingrese el rut del paciente: ");
                String rut2 = lector.readLine();
                Paciente pacienteActual = tablaHashPacientes.get(rut2);
                System.out.println("Ingrese la fecha de la sesión(DD/MM/YY):");
                String input = lector.readLine();
                LocalDate fecha = LocalDate.parse(input);
                pacienteActual.agregarSesion(fecha);
                break;
            case 4: 
                System.out.println("Case 4");
                break;
            default:
                if (opcion == 5) {
                    System.out.println("Saliendo del programa....");
                    break;
                }
                System.out.println("Opcion no valida!!");
                break;
        }
    }
}
