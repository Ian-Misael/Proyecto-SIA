
package Clases;

import java.util.ArrayList;

public class Centro {
    private String direccion;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Terapeuta> terapeutas;
    
    public Centro() {
        direccion = "Quielpue";
        pacientes = new ArrayList();
        terapeutas = new ArrayList();
    }
    
}
