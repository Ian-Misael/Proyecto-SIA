
package Colecciones;

import Clases.SesionTerapia;
import java.util.ArrayList;

public class ListaSesiones {
    private ArrayList<SesionTerapia> lista;
    
    public ListaSesiones() {
        lista = new ArrayList();
    }
    
    public boolean agregarSesion(SesionTerapia sesion) {
        return lista.add(sesion);
    }
    
    public int largo() {
        return lista.size();
    }
    
    public String listarSesiones() {
        String cadena;
        cadena = "";
        for (int i = 0 ; i < lista.size() ; i++) {
            cadena += lista.get(i).obtenerDatos();
        }
        return cadena;
    }
}
