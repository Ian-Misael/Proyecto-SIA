package com.mycompany.programarehabilitacionfisica;

public class SesionTerapia {
    
    private String fecha;
    private String tipoTerapia;
    private String duracion;
    private String observaciones;
    private int calificacionMejora;

    // Métodos Constructores
    public SesionTerapia(String fecha, String tipoTerapia, String duracion, String observaciones, int calificacionMejora) {
        this.fecha = fecha;
        this.tipoTerapia = tipoTerapia;
        this.duracion = duracion;
        this.observaciones = observaciones;
        this.calificacionMejora = calificacionMejora;
    }

    // Métodos Getter y Setter
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
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
    
}
