/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programarehabilitacionfisica;

/**
 *
 * @author felip
 */
public class SesionTerapia {
    private String fecha;
    private String tipoTerapia;
    private String duracion;
    private String observaciones;
    private int calificacionMejora;

    public SesionTerapia(String fecha, String tipoTerapia, String duracion, String observaciones, int calificacionMejora) {
        this.fecha = fecha;
        this.tipoTerapia = tipoTerapia;
        this.duracion = duracion;
        this.observaciones = observaciones;
        this.calificacionMejora = calificacionMejora;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTipoTerapia() {
        return tipoTerapia;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public int getCalificacionMejora() {
        return calificacionMejora;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTipoTerapia(String tipoTerapia) {
        this.tipoTerapia = tipoTerapia;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setCalificacionMejora(int calificacionMejora) {
        this.calificacionMejora = calificacionMejora;
    }
    
    
    
    
}
