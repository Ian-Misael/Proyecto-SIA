
package Controlador;

import java.awt.event.*;
import javax.swing.JFrame;
import Clases.*;
import Colecciones.*;
import Errores.*;
import Ventanas.*;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

public class Controlador implements ActionListener {
    
    private ListaPacientes listaPacientes;
    // Ventanas
    private MenuPrincipal menu;
    private GestionarPaciente gestionP;
    private AgregarPaciente agregarP;
    private EliminarPaciente eliminarP;
    private ListarPacientes listarP;
    private SeguimientoPaciente seguirP;
    private ListarSesiones listarS;
    private GestionarSesion gestionS;
    private AgregarSesion agregarS;    
    private HashMap<String, Terapeuta> tablaHashTerapeutas = new HashMap<>();
    
    
    public void iniciar() {
        listaPacientes = new ListaPacientes();
        Utilidades.leerArchivoTerapeutas(tablaHashTerapeutas);
        
        menu = new MenuPrincipal();
        menu.getGestionarPacientes().addActionListener(this);
        menu.getSeguimientoPaciente().addActionListener(this);
        menu.getGestionarSesiones().addActionListener(this);
        menu.getSalirPrograma().addActionListener(this);
        
        menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menu.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        // =========== Acciones de Ventana Gestionar Paciente ===========
        if (ae.getSource() == menu.getGestionarPacientes()) {
            gestionP = new GestionarPaciente(listaPacientes);
            gestionP.getAgregarPaciente().addActionListener(this);
            gestionP.getEliminarPaciente().addActionListener(this);
            gestionP.getListarPacientes().addActionListener(this);
            gestionP.getCerrarGestionarPacientes().addActionListener(this);
            gestionP.setVisible(true);
            return;
        }
        if (gestionP != null && ae.getSource() == gestionP.getCerrarGestionarPacientes()) {
            gestionP.dispose();
            return;
        }
        
        // =========== Acciones de Ventana Agregar Paciente ===========
        if (gestionP != null && ae.getSource() == gestionP.getAgregarPaciente()) {
            agregarP = new AgregarPaciente();
            agregarP.getBotonAgregarPaciente().addActionListener(this);
            agregarP.getCerrarAgregarPaciente().addActionListener(this);
            agregarP.setVisible(true);
            return;
        }
        if (agregarP != null && ae.getSource() == agregarP.getBotonAgregarPaciente()) {
            try {
                String nombre =  agregarP.getNombreField().getText();
                String rut = Utilidades.formatearRut(agregarP.getRutField().getText());
                int edad = Integer.parseInt(agregarP.getEdadField().getText());
                String direccion = agregarP.getDireccionField().getText();
                String historial = agregarP.getHistorialField().getText();
                
                if(nombre.equals("") || rut.equals("") || direccion.equals("") || historial.equals("")) {
                    javax.swing.JOptionPane.showMessageDialog(null,"Rellene todos los campos\n", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
                    agregarP.dispose();
                    return;
                }
                
                Paciente paciente = new Paciente();
                paciente.setNombre(nombre);
                paciente.setRut(rut);
                paciente.setEdad(edad);
                paciente.setDireccion(direccion);
                paciente.setHistorialMedico(historial);
                
                if(listaPacientes.agregarPaciente(paciente)) {
                    //Utilidades.guardarPacienteCSV(nombre, rut, edad, direccion, historial);
                    javax.swing.JOptionPane.showMessageDialog(null,"Paciente guardado exitosamente\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null,"EL paciente ya se encuenta registrado\n", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null,"Ingrese una edad válida\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            } catch (EdadInvalidaException e) {
                javax.swing.JOptionPane.showMessageDialog(null,"Edad fuera de rango\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            } catch (RutInvalidoException e) {
                javax.swing.JOptionPane.showMessageDialog(null,"Rut invalido\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            agregarP.dispose();
            return;
        }
        if (agregarP != null && ae.getSource() == agregarP.getCerrarAgregarPaciente()) {
            agregarP.dispose();
            return;
        }
        
        // =========== Acciones de Ventana Eliminar Paciente ===========
        if (gestionP != null && ae.getSource() == gestionP.getEliminarPaciente()) {
            eliminarP = new EliminarPaciente(listaPacientes.listarPacientes());
            eliminarP.getBotonEliminarPaciente().addActionListener(this);
            eliminarP.getCerrarEliminarPaciente().addActionListener(this);
            eliminarP.setVisible(true);
            return;
        }
        if (eliminarP != null && ae.getSource() == eliminarP.getBotonEliminarPaciente()) {
            String rut = Utilidades.formatearRut(eliminarP.getRutEliminarField().getText());
            if (listaPacientes.eliminarPaciente(rut)) {
                javax.swing.JOptionPane.showMessageDialog(null,"Paciente eliminado exitosamente\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                javax.swing.JOptionPane.showMessageDialog(null,"No existe paciente con el rut entregado\n", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
            eliminarP.dispose();
            return;
        }
        if (eliminarP != null && ae.getSource() == eliminarP.getCerrarEliminarPaciente()) {
            eliminarP.dispose();
            return;
        }
        
        // =========== Acciones de Ventana Listar Pacientes ===========
        if (gestionP != null && ae.getSource() == gestionP.getListarPacientes()) {
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
            seguirP = new SeguimientoPaciente(listaPacientes);
            seguirP.getCerrarSeguimientoPaciente().addActionListener(this);
            seguirP.getBotonSeguirPaciente().addActionListener(this);
            seguirP.setVisible(true);
            return;
        }
        if (seguirP != null && ae.getSource() == seguirP.getBotonSeguirPaciente()) {
            try {
                String rut = seguirP.getRutSeguirField().getText();
                rut = Utilidades.formatearRut(rut);

                listarS = new ListarSesiones((listaPacientes.getPaciente(rut)).listarSesiones());
                listarS.getCerrarListarSesiones().addActionListener(this);
                listarS.setVisible(true);
                return;
            } catch (java.lang.NullPointerException nulo) {
                javax.swing.JOptionPane.showMessageDialog(null,"No existe paciente con el rut especificado\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        if (listarS != null && ae.getSource() == listarS.getCerrarListarSesiones()) {
            listarS.dispose();
            return;
        }
        if (seguirP != null && ae.getSource() == seguirP.getCerrarSeguimientoPaciente()) {
            seguirP.dispose();
            return;
        }
        
        // =========== Acciones de Ventana Gestionar Sesión ===========
        if (ae.getSource() == menu.getGestionarSesiones()) {
            gestionS = new GestionarSesion(listaPacientes);
            gestionS.getAgregarSesion().addActionListener(this);
            gestionS.getEliminarSesion().addActionListener(this);
            gestionS.getFiltrarSesiones().addActionListener(this);
            gestionS.getCerrarGestionarSesion().addActionListener(this);
            gestionS.setVisible(true);
            return;
        }
        
        // =========== Acciones de Ventana Agregar Sesión ===========
        if (gestionS != null && ae.getSource() == gestionS.getAgregarSesion()) {
            agregarS = new AgregarSesion();
            agregarS.getBotonAgregarSesion().addActionListener(this);
            agregarS.getCerrarAgregarSesion().addActionListener(this);
            agregarS.setVisible(true);
            return;
        }
        
        if (agregarS != null && ae.getSource() == agregarS.getBotonAgregarSesion()){
            try {
                String rutTerapeuta =  Utilidades.formatearRut(agregarS.getRutTerapeutaField().getText());
                String rutPaciente = Utilidades.formatearRut(agregarS.getRutPacienteField().getText());
                String fecha = agregarS.getFechaField().getText();
                String terapia = agregarS.getTerapiaField().getText();
                int nota = Integer.parseInt(agregarS.getNotaField().getText());
                String comentarios = agregarS.getComentariosField().getText();
                String duracion = agregarS.getDuracionField().getText();
                
                if(rutTerapeuta.equals("") || rutPaciente.equals("") || fecha.equals("") || terapia.equals("") || comentarios.equals("") || duracion.equals("")) {
                    javax.swing.JOptionPane.showMessageDialog(null,"Rellene todos los campos\n", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
                    agregarP.dispose();
                    return;
                }
                
                SesionTerapia sesion = new SesionTerapia();
                sesion.setRutTerapeuta(rutTerapeuta);
                sesion.setFecha(fecha);
                sesion.setTipoTerapia(terapia);
                sesion.setCalificacionMejora(nota);
                sesion.setObservaciones(comentarios);
                
                
                if(listaPacientes.contienePaciente(rutPaciente)) {
                    //Utilidades.guardarPacienteCSV(nombre, rut, edad, direccion, historial);
                    listaPacientes.getPaciente(rutPaciente).agregarSesion(sesion);
                    javax.swing.JOptionPane.showMessageDialog(null,"Sesión guardada exitosamente\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null,"No existe paciente con el rut especificado\\n\"", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null,"Ingrese una nota válida\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            } catch (DateTimeParseException e) {
                javax.swing.JOptionPane.showMessageDialog(null,"Fecha inválida. Ingresar en formato dd/mm/yyyy\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            } catch (RutInvalidoException e) {
                javax.swing.JOptionPane.showMessageDialog(null,"Rut invalido\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            agregarS.dispose();
            return;
        }
        
        if (agregarS != null && ae.getSource() == agregarS.getCerrarAgregarSesion()){
            agregarS.dispose();
            return;
        }
        
        
        // =========== Acciones de Ventana Eliminar Sesión ===========
        if (gestionS != null && ae.getSource() == gestionS.getEliminarSesion()) {
            
            return;
        }
        
        // =========== Acciones de Ventana Filtrar Sesiones ===========
        if (gestionS != null && ae.getSource() == gestionS.getFiltrarSesiones()) {
            
            return;
        }
        if (gestionS != null && ae.getSource() == gestionS.getCerrarGestionarSesion()) {
            gestionS.dispose();
            return;
        }
        
        // =========== Cerrar Programa ===========
        if (ae.getSource() == menu.getSalirPrograma()) {
            listaPacientes.guardarPacientesCSV();
            listaPacientes.guardarSesionesCSV();
            menu.dispose();
            return;
        }
    }
}
