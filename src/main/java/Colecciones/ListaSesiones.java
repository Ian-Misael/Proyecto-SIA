
package Colecciones;

import Clases.SesionTerapia;
import java.util.ArrayList;

public class ListaSesiones {
    private ArrayList<SesionTerapia> lista;
    
    public ListaSesiones() {
        this.lista = new ArrayList();
    }
    
    public boolean agregarSesion(SesionTerapia sesion) {
        return this.lista.add(sesion);
    }
    
    public int largo() {
        return this.lista.size();
    }
    
    
    
    public String listarSesiones() {
        String cadena;
        cadena = "";
        for (int i = 0 ; i < this.lista.size() ; i++) {
            cadena += this.lista.get(i).obtenerDatos();
        }
        return cadena;
    }
}
