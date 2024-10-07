
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
    // Metodo para retornar la listaPacientes y poder trabajar en ella.
    public ListaPacientes obtenerListaPacientes() {
        return listaPacientes;
    }
    // Metodo para retornar la lista con los terapeutas y trabajar en ella.
    public ListaTerapeutas obtenerListaTerapeutas() {
        return listaTerapeutas;
    }
}
