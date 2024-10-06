
package Clases;

import Colecciones.*;

public class Centro {
    private String direccion;
    private ListaPacientes listaPacientes;
    private ListaTerapeutas listaTerapeutas;
    
    public Centro() {
        direccion = "Quilpue";
        listaPacientes = new ListaPacientes();
        listaTerapeutas = new ListaTerapeutas();
    }
    
    public ListaPacientes obtenerListaPacientes() {
        return listaPacientes;
    }
    
    public ListaTerapeutas obtenerListaTerapeutas() {
        return listaTerapeutas;
    }
}
