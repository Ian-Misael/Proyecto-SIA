package com.mycompany.programarehabilitacionfisica;

import java.time.LocalDate;

public class SesionTerapia {
    
    private LocalDate fecha;
    private String tipoTerapia;
    private String duracion;
    private String observaciones;
    private int calificacionMejora;

    // Métodos Constructores
    public SesionTerapia(LocalDate fecha, String tipoTerapia, String duracion, String observaciones, int calificacionMejora) {
        this.fecha = fecha;
        this.tipoTerapia = tipoTerapia;
        this.duracion = duracion;
        this.observaciones = observaciones;
        this.calificacionMejora = calificacionMejora;
    }
    public SesionTerapia(LocalDate fecha){
        this.fecha = fecha;
        this.tipoTerapia = "";
        this.duracion = "";
        this.observaciones = "";
        this.calificacionMejora = 0;
    }

    // Métodos Getter y Setter
    public LocalDate getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipoTerapia() {
        return tipoTerapia;
    }
    
    public void setTipoTerapia(String tipoTerapia) {
        this.tipoTerapia = tipoTerapia;
    }

    public String getDuracion() {
        return duracion;
    }
    
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public int getCalificacionMejora() {
        return calificacionMejora;
    }

    public void setCalificacionMejora(int calificacionMejora) {
        this.calificacionMejora = calificacionMejora;
    }
    
    // Métodos de la Clase
    
    public void mostrarSesion(int num) {
        System.out.println("Sesion " + num);
        System.out.println("Fecha: " + fecha);
        System.out.println("Tipo de terapia: " + tipoTerapia);
        System.out.println("Duracion: " + duracion);
        System.out.println("Observacion: " + observaciones);
        System.out.println("Calificacion de mejora: " + calificacionMejora);
        System.out.println("---------------------------------------");
    }
}
