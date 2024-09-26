package Clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terapeuta extends Persona {
    private String especialidad;
    
    //Constructores
    public Terapeuta(){
        super();
        especialidad = "";
    }
    public Terapeuta(String nombre, String rut, int edad, String especialidad){
        super(nombre, rut, edad);
        this.especialidad = especialidad;
    }
    
    //Getter y setter
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    //Metodos de la clase
    @Override
    public void poblar() throws IOException {
        super.poblar();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Ingrese la especialidad del terapeuta: ");
        especialidad = lector.readLine();
    }
}
