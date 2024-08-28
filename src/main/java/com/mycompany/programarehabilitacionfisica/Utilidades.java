package com.mycompany.programarehabilitacionfisica;

import java.util.Scanner;

public class Utilidades {
    
    // Métodos de la Clase
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    public static String formatearRut(String rut)
    {
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        String rutFormateado = "";
        int largo = rut.length();
        //System.out.println(largo);
        int contador = 0;
        for (int i = largo - 1; i >= 0; i--) {
            if (i == (largo - 1)) {
                rutFormateado = rutFormateado + rut.charAt(i);
                rutFormateado = "-" + rutFormateado;  
            }
            else {
                rutFormateado =  rut.charAt(i) + rutFormateado;
                contador++;
            
                if (contador == 3 && i != 0) {
                    rutFormateado = "." + rutFormateado;
                    contador = 0;
                }
            }
        }
        return rutFormateado;
    }
    
    public static void presioneTeclaParaContinuar() {
        Scanner scanner = new Scanner(System.in);
        String enter;
        System.out.println("Presione enter para continuar..");
        //enter = scanner.nextLine();
        enter = scanner.nextLine();
    }
    
    /*
    public static void getchar(Scanner scanner)
    {
        scanner.nextLine();
    }
    */
    
    
}


