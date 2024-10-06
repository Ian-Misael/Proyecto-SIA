
package Colecciones;

import Clases.Terapeuta;
import Clases.Utilidades;
import java.util.HashMap;

public class ListaTerapeutas {
    private HashMap<String, Terapeuta> tablaHashTerapeutas;
    
    public ListaTerapeutas() {
        this.tablaHashTerapeutas = new HashMap<>();
        // Se ingresan Datos
        Utilidades.leerArchivoTerapeutas(this.tablaHashTerapeutas);
        Utilidades.leerArchivoSesionesT(this.tablaHashTerapeutas); 
    }
    
    public boolean contieneTerapeuta(String rut){
        return tablaHashTerapeutas.containsKey(rut);
    }
    
    public Terapeuta getTerapeuta(String rut) {
        Terapeuta pacienteAux = tablaHashTerapeutas.get(rut);
        return pacienteAux;
    }
    
    public String listarTerapeutas() {
        String cadena;
        cadena = "";
        for (Terapeuta terapeuta : this.tablaHashTerapeutas.values()) {
            cadena += terapeuta.obtenerDatos();
        }
        return cadena;
    }
}
