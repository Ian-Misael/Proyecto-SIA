
package Colecciones;

import Clases.SesionTerapia;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListaSesiones {
    private ArrayList<SesionTerapia> lista;
    private int indiceActual;
    
    public ListaSesiones() {
        this.lista = new ArrayList();
        this.indiceActual = -1;
    }
    
    
    public SesionTerapia getSesion(int i) {
        return lista.get(i);
    }
    
    public boolean agregarSesion(SesionTerapia sesion) {
        return this.lista.add(sesion);
    }
    
    public int largo() {
        return this.lista.size();
    }
    
    // Elimina una sesion de la lista a través de su fecha
    public boolean eliminarSesion(LocalDate fecha) {
        for (int i = 0 ; i < lista.size() ; i++) {
            if (lista.get(i).getFecha().equals(fecha)) {
                lista.remove(i);
                return true;
            }
        }
        return false;
    }
    
    // Elimina la sesion a través del objeto.
    public boolean eliminarSesion(SesionTerapia sesion) {
        if (lista.remove(sesion)==true) {
            System.out.println("Si");
            return true;
        } else {
            System.out.println("No");
            return false;
        }
    }
    
    // Muestra las sesiones
    public String listarSesiones() {
        String cadena;
        cadena = "";
        for (int i = 0 ; i < this.lista.size() ; i++) {
            cadena += this.lista.get(i).obtenerDatos();
        }
        return cadena;
    }
    
    // Encargado de sobreescribir una sesion dada.
    public boolean sobreescribirSesion(SesionTerapia nuevaSesion) {
        LocalDate fechaNuevaSesion = nuevaSesion.getFecha();
        for (int i = 0; i < lista.size(); i++) {
            SesionTerapia sesionActual = lista.get(i);
            if (sesionActual.getFecha().equals(fechaNuevaSesion)) {
                lista.set(i, nuevaSesion);
                return true;
            }
        }
        return false;
    }
    
    // Encargado de mostrar las sesiones filtradas por año
    public ArrayList<SesionTerapia> filtrarSesionesPorAnio(int anio) {
        ArrayList<SesionTerapia> sesionesFiltradas = new ArrayList<>();
        for (SesionTerapia sesion : lista) {
            if (sesion.getFecha().getYear() == anio) {
                sesionesFiltradas.add(sesion);
            }
        }
        return sesionesFiltradas;
    }
    
    // Obtiene la sesion actual donde se encuentra el indice
    public SesionTerapia obtenerSesionActual() {
        if (indiceActual >= 0 && indiceActual < lista.size()) {
            return lista.get(indiceActual);
        } else {
            return null; // No hay sesión actual válida
        }
    }
    
    // Mueve el indice al siguiente
    public SesionTerapia siguiente() {
        if (indiceActual < lista.size() - 1) {
            indiceActual++;
            return lista.get(indiceActual);
        } else {
            return null; // Ya estamos en la última sesión
        }
    }
    
    // Reinicia el indice a -1
    public void reiniciarRecorrido() {
        this.indiceActual = -1; // Resetea el índice
    }        
}
