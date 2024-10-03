
package Colecciones;

import Clases.SesionTerapia;
import java.util.ArrayList;

public class ListaSesiones {
    private ArrayList<SesionTerapia> lista;
    private int indiceActual;
    
    public ListaSesiones() {
        this.lista = new ArrayList();
        this.indiceActual = -1;
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
    public ArrayList<SesionTerapia> filtrarSesionesPorAnio(int anio) {
        ArrayList<SesionTerapia> sesionesFiltradas = new ArrayList<>();
        for (SesionTerapia sesion : lista) {
            if (sesion.getFecha().getYear() == anio) {
                sesionesFiltradas.add(sesion);
            }
        }
        return sesionesFiltradas;
    }
    
    public SesionTerapia obtenerSesionActual() {
        if (indiceActual >= 0 && indiceActual < lista.size()) {
            return lista.get(indiceActual);
        } else {
            return null; // No hay sesión actual válida
        }
    }
    public SesionTerapia siguiente() {
        if (indiceActual < lista.size() - 1) {
            indiceActual++;
            return lista.get(indiceActual);
        } else {
            return null; // Ya estamos en la última sesión
        }
    }

    public void reiniciarRecorrido() {
        this.indiceActual = -1; // Resetea el índice
    }        
}
