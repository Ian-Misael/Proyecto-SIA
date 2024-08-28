/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programarehabilitacionfisica;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iangu
 */
public class ProgramaRehabilitacionFisica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        HashMap<String, Paciente> tablaHashPacientes = new HashMap<>();
        
        
        do{
            Utilidades.limpiarPantalla();
            System.out.println("--- Menú de Gestión de Rehabilitación Física ---");
            System.out.println("1. Registrar un nuevo paciente");
            System.out.println("2. Registrar nueva sesion de terapia");
            System.out.println("3. Seguimiento paciente");
            System.out.println("4. Reporte Progreso");
            System.out.println("5. Salir");
            
            opcion = scanner.nextInt();
             
            switch(opcion)
            {
                case 1:
                    Paciente nuevoPaciente = new Paciente();
                    nuevoPaciente.agregarPaciente(scanner,tablaHashPacientes);
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
                    if (opcion == 5)
                    {
                        System.out.println("Saliendo del programa....");
                        break;
                    }
                    System.out.println("Opcion no valida!!");
                    break;
            }
            Utilidades.presioneTeclaParaContinuar();
        } while(opcion != 5);
        
    }
}
