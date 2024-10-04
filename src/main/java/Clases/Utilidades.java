
package Clases;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utilidades {
    
    // Métodos de la Clase
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    public static String formatearRut(String rut) {
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
        enter = scanner.nextLine();
    }
   
    
    public static void leerArchivoPacientes(Map<String, Paciente> tablaHashPacientes)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/Datos/listadoPacientes.csv")))
        {
            String linea;
            linea = reader.readLine(); // Para leer lo primero (rut, nombre...)
             
            while ((linea = reader.readLine())!= null)
            {
                String rut;
                String nombre;
                String edadSTR;
                String direccion;
                String historialMedico;
                 
                String[] campos = linea.split(";");
                nombre = campos[0];
                rut = formatearRut(campos[1]);
                edadSTR =  campos[2];
                direccion = campos[3];
                historialMedico = campos[4];
                 
                int edad = Integer.parseInt(edadSTR); // Se confia que el numero guardado en el excel es un numero.
                 
                Paciente paciente = new Paciente(nombre, rut, edad, direccion, historialMedico);
                tablaHashPacientes.put(paciente.getRut(),paciente);
            } 
        } catch(IOException e){
            System.out.println("No se pudo leer correctamente, excepcion");
        }
    } 
    /*
    public static void guardarPacienteCSV(String nombre, String rut, int edad, String direccion, String historialMedico)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/Datos/listadoPacientes.csv", true))) {
           
            writer.write(nombre + ";" + rut + ";" + edad + ";" + direccion + ";" + historialMedico);
            writer.newLine();
           

        } catch (IOException e) {
            System.out.println("algo paso, excepcion");
        }
    }
    */
    
    public static void leerArchivoSesiones(Map<String, Paciente> tablaHashPacientes)
    {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/Datos/listadoSesiones.csv")))
        {
            String linea;
            linea = reader.readLine(); // Para leer lo primero (rut, nombre...)
             
            while ((linea = reader.readLine())!= null)
            {
                String rut;
                String fechaSTR;
                String tipoTerapia;
                String duracion;
                String observaciones;
                String calificacionMejoraSTR;
                String rutTerapeuta;
                 
                String[] campos = linea.split(";");
                rut = campos[0];
                fechaSTR = campos[1]; 
                tipoTerapia =  campos[2];
                duracion = campos[3];
                observaciones = campos[4];
                calificacionMejoraSTR = campos[5];
                rutTerapeuta = campos[6];
                
                LocalDate fecha = LocalDate.parse(fechaSTR, formato); // Se confia que la fecha esta en el formato correcto.
                int calificacionMejora = Integer.parseInt(calificacionMejoraSTR); // Se confia que el numero guardado en el excel es un numero.
                 
                Paciente pacienteActual = tablaHashPacientes.get(rut);
                if (pacienteActual != null) {
                    SesionTerapia nuevaSesion = new SesionTerapia(fecha, tipoTerapia, duracion, observaciones, calificacionMejora, rutTerapeuta);
                    pacienteActual.agregarSesion(nuevaSesion);
                } else {
                    System.out.println("\nPaciente no encontrado.\n");
                }  
            } 
        } catch(IOException e){
            System.out.println("No se pudo leer correctamente, excepcion");
        }        
    }
    public static void leerArchivoTerapeutas(Map<String, Terapeuta> tablaHashTerapeutas)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/Datos/listadoTerapeutas.csv")))
        {
            String linea;
            linea = reader.readLine(); // Para leer lo primero (rut, nombre...)
             
            while ((linea = reader.readLine())!= null)
            {
                String rut;
                String nombre;
                String edadSTR;
                String especialidad;
                 
                String[] campos = linea.split(",");
                nombre = campos[0];
                rut = formatearRut(campos[1]);
                edadSTR =  campos[2];
                especialidad = campos[3];
                 
                int edad = Integer.parseInt(edadSTR); // Se confia que el numero guardado en el excel es un numero.
                 
                Terapeuta terapeuta = new Terapeuta(nombre, rut, edad, especialidad);
                tablaHashTerapeutas.put(terapeuta.getRut(),terapeuta);
            } 
        } catch(IOException e){
            System.out.println("No se pudo leer correctamente, excepcion");
        }
    } 
    
    /*
    public static void guardarSesionesCSV(LocalDate fecha, String tipoTerapia, String duracion, String observaciones, int calificacionMejora, String rut)
    {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaSTR = fecha.format(formato);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/Datos/listadoSesiones.csv", true))) {
             
            writer.write(rut + ";" + fechaSTR + ";" + tipoTerapia + ";" + duracion + ";" + observaciones + ";" + calificacionMejora);
            writer.newLine();
           

        } catch (IOException e) {
            System.out.println("algo paso, excepcion");
        }

    }
    */
}

