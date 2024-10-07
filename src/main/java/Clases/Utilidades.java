
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
    
    // Metodo utilizado para simular que se limpia la pantalla 
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    // Metodoe encargado de formatear el Rut de la persona, es decir,
    // Con los puntos y guion para que no ocurran errores de busqueda o acceso.
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
   
    // Metodo encargado de leer el archivo csv con los datos de los pacientes.
    // Es llamado cada vez que se inicia el programa
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
                 
                String[] campos = linea.split(";"); // Se divide con ; los campos
                nombre = campos[0];
                rut = formatearRut(campos[1]);
                edadSTR =  campos[2];
                direccion = campos[3];
                historialMedico = campos[4];
                 
                int edad = Integer.parseInt(edadSTR);
                
                // Se llama al constructor para crear el objeto paciente.
                Paciente paciente = new Paciente(nombre, rut, edad, direccion, historialMedico);
                // Se guarda al paciente en la tabla hash.
                tablaHashPacientes.put(paciente.getRut(),paciente);
            } 
        } catch(IOException e){
            System.out.println("No se pudo leer correctamente");
        }
    } 
    
    // Metodo encargado de leer el archivo con las sesiones al principio del programa.
    public static void leerArchivoSesionesP(Map<String, Paciente> tablaHashPacientes)
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
                
                String[] campos = linea.split(";"); // Se divide con ; los campos
                rut = campos[0];
                fechaSTR = campos[1]; 
                tipoTerapia =  campos[2];
                duracion = campos[3];
                observaciones = campos[4];
                calificacionMejoraSTR = campos[5];
                rutTerapeuta = campos[6];
                
                LocalDate fecha = LocalDate.parse(fechaSTR, formato); // Se confia que la fecha esta en el formato correcto.
                int calificacionMejora = Integer.parseInt(calificacionMejoraSTR); // Se confia que el numero guardado en el excel es un numero.
                
                // Primero se busca al paciente para poder agregarle la sesion.
                Paciente pacienteActual = tablaHashPacientes.get(rut);
                if (pacienteActual != null) {
                    // En caso que se encuentre, se llama al constructor para
                    // crear el objeto SesionTerapia
                    SesionTerapia nuevaSesion = new SesionTerapia(fecha, tipoTerapia, duracion, observaciones, calificacionMejora, rutTerapeuta);
                    // Se agrega a la lista el objeto SesionTerapia
                    pacienteActual.agregarSesion(nuevaSesion);
                } else {
                    System.out.println("\nPaciente no encontrado.\n");
                }  
            } 
        } catch(IOException e){
            System.out.println("No se pudo leer correctamente");
        }        
    }
    
    // Metodo encargado de leer el archivo con los terapeutas al principio del programa.
    public static void leerArchivoSesionesT(Map<String, Terapeuta> tablaHashTerapeuta)
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
                 
                String[] campos = linea.split(";"); // Se divide con ; los campos
                rut = campos[0];
                fechaSTR = campos[1]; 
                tipoTerapia =  campos[2];
                duracion = campos[3];
                observaciones = campos[4];
                calificacionMejoraSTR = campos[5];
                rutTerapeuta = campos[6];
                
                // Se pasa la fecha al formato correcto.
                LocalDate fecha = LocalDate.parse(fechaSTR, formato); 
                int calificacionMejora = Integer.parseInt(calificacionMejoraSTR);
                
                // Se obtiene el terapeuta de la tabla hash a través de su rut
                Terapeuta terapeutaActual = tablaHashTerapeuta.get(rutTerapeuta);
                if (terapeutaActual != null) {
                    // En caso que esté se crea el objeto SesionTerapia
                    SesionTerapia nuevaSesion = new SesionTerapia(fecha, tipoTerapia, duracion, observaciones, calificacionMejora, rutTerapeuta);
                    // Se agrega en la lista correspondiente.
                    terapeutaActual.agregarSesion(nuevaSesion);
                } else {
                    System.out.println("\nTerapeuta no encontrado.\n");
                }  
            } 
        } catch(IOException e){
            System.out.println("No se pudo leer correctamente, excepcion");
        }        
    }
    
    // Encargado de leer el archivo con los terapeutas.
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
                 
                String[] campos = linea.split(","); // Separa por ;
                nombre = campos[0];
                rut = formatearRut(campos[1]);
                edadSTR =  campos[2];
                especialidad = campos[3];
                 
                int edad = Integer.parseInt(edadSTR); // Se confia que el numero guardado en el excel es un numero.
                 
                Terapeuta terapeuta = new Terapeuta(nombre, rut, edad, especialidad); // Crea el objeto terapeuta
                tablaHashTerapeutas.put(terapeuta.getRut(),terapeuta); // Lo agrega
            } 
        } catch(IOException e){
            System.out.println("No se pudo leer correctamente");
        }
    } 
    
    public static void leerArchivoSesionesTerapeuta(Map<String, Terapeuta> tablaHashTerapeutas)
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
                
                LocalDate fecha = LocalDate.parse(fechaSTR, formato); 
                int calificacionMejora = Integer.parseInt(calificacionMejoraSTR); 
                 
                Terapeuta terapeutaActual = tablaHashTerapeutas.get(rutTerapeuta);
                if (terapeutaActual != null) {
                    SesionTerapia nuevaSesion = new SesionTerapia(fecha, tipoTerapia, duracion, observaciones, calificacionMejora, rutTerapeuta);
                    //terapeutaActual.agregarSesion(nuevaSesion);
                } else {
                    System.out.println("\nTerapeuta no encontrado.\n");
                }  
            } 
        } catch(IOException e){
            System.out.println("No se pudo leer correctamente");
        }        
    }
}

