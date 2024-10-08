
package Clases;

import Errores.RutInvalidoException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SesionTerapia {
    private String rutTerapeuta;
    private LocalDate fecha;
    private String tipoTerapia;
    private String duracion;
    private String observaciones;
    private int calificacionMejora;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato que tendran las fechas.

    // Métodos Constructores
    public SesionTerapia(LocalDate fecha, String tipoTerapia, String duracion, String observaciones, int calificacionMejora, String rutTerapeuta) {
        this.fecha = fecha;
        this.tipoTerapia = tipoTerapia;
        this.duracion = duracion;
        this.observaciones = observaciones;
        this.calificacionMejora = calificacionMejora;
        this.rutTerapeuta = rutTerapeuta;
    }
    
    public SesionTerapia(){
        this.fecha = null;
        this.tipoTerapia = "";
        this.duracion = "";
        this.observaciones = "";
        this.calificacionMejora = 0;
    }

    // Métodos Getter y Setter
    public String getRutTerapeuta() {
        return rutTerapeuta;
    }

    public void setRutTerapeuta(String rutTerapeuta) throws RutInvalidoException{
        // Verifica que no haya letras entre a-j o A-J en todo el string, excepto 'k' o 'K' solo al final
        if (!rutTerapeuta.matches("\\d{1,2}(\\.\\d{3}){2}-[0-9kK]")) {
            throw new RutInvalidoException();
        }
        this.rutTerapeuta = rutTerapeuta;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) throws DateTimeParseException {
        this.fecha = LocalDate.parse(fecha, formato);    
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
    
    // Sobreescritura de metodos
    // Retorna los datos de una sesion en especifico.
    public String obtenerDatos() {
        return (fecha + "; " + tipoTerapia + "; " + duracion + "; " + observaciones + ";" + calificacionMejora + "\n");
    }
}
