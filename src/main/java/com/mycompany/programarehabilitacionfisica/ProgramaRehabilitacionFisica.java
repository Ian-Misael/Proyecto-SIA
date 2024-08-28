
package com.mycompany.programarehabilitacionfisica;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProgramaRehabilitacionFisica {

    public static void main(String[] args) throws IOException {
        
        //Scanner scanner = new Scanner(System.in);
        BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
        
        int opcion;
        
        do{
            menu();
            
            opcion = Integer.parseInt(lector.readLine());
            
            opcionMenu(opcion);
            
            Utilidades.presioneTeclaParaContinuar();
            
        } while(opcion != 5);
    }
    
    public static void menu() {
        
        Utilidades.limpiarPantalla();
        
        System.out.println("--- Menú de Gestion de Rehabilitacion Fisica ---");
        System.out.println("1. Registrar un nuevo paciente");
        System.out.println("2. Registrar nueva sesion de terapia");
        System.out.println("3. Seguimiento paciente");
        System.out.println("4. Reporte Progreso");
        System.out.println("5. Salir");
    }
    
    public static void opcionMenu(int opcion) {
        
        HashMap<String, Paciente> tablaHashPacientes = new HashMap<>();
        
        switch(opcion) {
            case 1:
                Paciente nuevoPaciente = new Paciente();
                
                nuevoPaciente.agregarPaciente(tablaHashPacientes);
                break;
            case 2:
                System.out.println("Case 2");
                break;
            case 3:
                System.out.println("Case 3");
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
