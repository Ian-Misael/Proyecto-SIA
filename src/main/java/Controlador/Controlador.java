
package Controlador;

import java.awt.event.*;
import javax.swing.JFrame;
import Clases.*;
import Colecciones.*;
import Ventanas.*;

// javax.swing.JOptionPane.ShowMessageDialog(this, "Debe llenar los campos\n", "AVISO", javax.swing.JOptionPane.ERROR);

public class Controlador implements ActionListener {
    
    private ListaPacientes listaPacientes;
    // Ventanas
    private MenuPrincipal menu;
    private AgregarPaciente agregarP;
    private ListarPacientes listarP;
    private SeguimientoPaciente seguirP;
    
    
    public void iniciar() {
        listaPacientes = new ListaPacientes();

        menu = new MenuPrincipal();
        menu.getAgregarPaciente().addActionListener(this);
        menu.getListarPacientes().addActionListener(this);
        menu.getSeguimientoPaciente().addActionListener(this);
        menu.getSalirPrograma().addActionListener(this);
        
        menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menu.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        // =========== Acciones de Ventana Agregar Paciente ===========
        if (ae.getSource() == menu.getAgregarPaciente()) {
            agregarP = new AgregarPaciente();
            agregarP.getBotonAgregarPaciente().addActionListener(this);
            agregarP.getCerrarAgregarPaciente().addActionListener(this);
            agregarP.setVisible(true);
            return;
        }
        if (agregarP != null && ae.getSource() == agregarP.getBotonAgregarPaciente()) {
            String nombre =  agregarP.getNombreField().getText();
            String rut = agregarP.getRutField().getText();
            int edad = Integer.parseInt(agregarP.getEdadField().getText());
            String direccion = agregarP.getDireccionField().getText();
            String historial = agregarP.getHistorialField().getText();
            
            Paciente paciente = new Paciente(nombre, rut, edad, direccion, historial);
            if(listaPacientes.agregarPaciente(paciente)) {
                Utilidades.guardarPacienteCSV(nombre, rut, edad, direccion, historial);
                //javax.swing.JOptionPane.showMessageDialog(this,"Paciente guardado exitosamente\n", "AVISO", javax.swing.JOptionPane.ERROR);
            } else {
                // Ya existe el paciente
            }
            agregarP.dispose();
            return;
        }
        if (agregarP != null && ae.getSource() == agregarP.getCerrarAgregarPaciente()) {
            agregarP.dispose();
            return;
        }
        // =========== Acciones de Ventana Listar Pacientes ===========
        if (ae.getSource() == menu.getListarPacientes()) {
            listarP = new ListarPacientes(listaPacientes.listarPacientes());
            listarP.getCerrarListarPacientes().addActionListener(this);
            listarP.setVisible(true);
            return;
        }
        if (listarP != null && ae.getSource() == listarP.getCerrarListarPacientes()) {
            listarP.dispose();
            return;
        }
        // =========== Acciones de Ventana Seguimiento Paciente ===========
        if (ae.getSource() == menu.getSeguimientoPaciente()) {
            seguirP = new SeguimientoPaciente();
            seguirP.getCerrarSeguimientoPaciente().addActionListener(this);
            
            seguirP.setVisible(true);
            return;
        }
        if (seguirP != null && ae.getSource() == seguirP.getCerrarSeguimientoPaciente()) {
            seguirP.dispose();
            return;
        }
        // =========== Cerrar Programa ===========
        if (ae.getSource() == menu.getSalirPrograma()) {
            menu.dispose();
            return;
        }
    }
}
