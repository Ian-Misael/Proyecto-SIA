
package Controlador;

import java.awt.event.*;
import javax.swing.JFrame;
import Clases.*;
import Errores.*;
import Ventanas.*;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Controlador implements ActionListener {
    private String rutAux;  // Se usará para almacenar el RUT una vez encontrado
    private Centro centro;
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
    private BuscarEliminarSesion buscarS;
    private EliminarSesion eliminarS;
    private FiltrarSesiones filtrarS;
    private ConsultaAño consultaA;
    private ConsultaTerapeuta consultaT;
    
    public void iniciar() {
        FlatMacLightLaf.setup();
        centro = new Centro();
        
        menu = new MenuPrincipal();
        menu.getGestionarPacientes().addActionListener(this);
        menu.getSeguimientoPaciente().addActionListener(this);
        menu.getGestionarSesiones().addActionListener(this);
        menu.getSalirPrograma().addActionListener(this);
        menu.getExportar().addActionListener(this);
        
        menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menu.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        // =========== Acciones de Ventana Gestionar Paciente ===========
        if (ae.getSource() == menu.getGestionarPacientes()) {
            gestionP = new GestionarPaciente(centro.obtenerListaPacientes());
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
            gestionP.dispose();
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
                
                if((centro.obtenerListaPacientes()).agregarPaciente(paciente)) {
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
            gestionP.dispose();
            eliminarP = new EliminarPaciente((centro.obtenerListaPacientes()).listarPacientes());
            eliminarP.getBotonEliminarPaciente().addActionListener(this);
            eliminarP.getCerrarEliminarPaciente().addActionListener(this);
            eliminarP.setVisible(true);
            return;
        }
        if (eliminarP != null && ae.getSource() == eliminarP.getBotonEliminarPaciente()) {
            String rut = Utilidades.formatearRut(eliminarP.getRutEliminarField().getText());
            if ((centro.obtenerListaPacientes()).eliminarPaciente(rut)) {
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
            gestionP.dispose();
            listarP = new ListarPacientes((centro.obtenerListaPacientes()).listarPacientes());
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
            seguirP = new SeguimientoPaciente(centro.obtenerListaPacientes());
            seguirP.getCerrarSeguimientoPaciente().addActionListener(this);
            seguirP.getBotonSeguirPaciente().addActionListener(this);
            seguirP.setVisible(true);
            return;
        }
        if (seguirP != null && ae.getSource() == seguirP.getBotonSeguirPaciente()) {
            seguirP.dispose();
            try {
                String rut = seguirP.getRutSeguirField().getText();
                rut = Utilidades.formatearRut(rut);

                listarS = new ListarSesiones(((centro.obtenerListaPacientes()).getPaciente(rut)).listarSesiones());
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
            gestionS = new GestionarSesion(centro.obtenerListaPacientes());
            gestionS.getAgregarSesion().addActionListener(this);
            gestionS.getEliminarSesion().addActionListener(this);
            gestionS.getFiltrarSesiones().addActionListener(this);
            gestionS.getCerrarGestionarSesion().addActionListener(this);
            gestionS.setVisible(true);
            return;
        }
        if (gestionS != null && ae.getSource() == gestionS.getCerrarGestionarSesion()) {
            gestionS.dispose();
            return;
        }
        
        // =========== Acciones de Ventana Agregar Sesión ===========
        if (gestionS != null && ae.getSource() == gestionS.getAgregarSesion()) {
            gestionS.dispose();
            agregarS = new AgregarSesion((centro.obtenerListaPacientes()).listarPacientes(), (centro.obtenerListaTerapeutas()).listarTerapeutas());
            agregarS.getBotonAgregarSesion().addActionListener(this);
            agregarS.getCerrarAgregarSesion().addActionListener(this);
            agregarS.setVisible(true);
            return;
        }
        
        if (agregarS != null && ae.getSource() == agregarS.getBotonAgregarSesion()){
            try {
                String rutPaciente = Utilidades.formatearRut(agregarS.getRutPacienteField().getText());
                String rutTerapeuta =  Utilidades.formatearRut(agregarS.getRutTerapeutaField().getText());
                String fecha = agregarS.getFechaField().getText();
                String terapia = agregarS.getTerapiaField().getText();
                String duracion = agregarS.getDuracionField().getText();
                String observaciones = agregarS.getObservacionesField().getText();
                int calificacion = Integer.parseInt(agregarS.getCalificacionField().getText());
                
                if(rutPaciente.equals("") || rutTerapeuta.equals("") || fecha.equals("") || terapia.equals("") || duracion.equals("") || observaciones.equals("")) {
                    javax.swing.JOptionPane.showMessageDialog(null,"Rellene todos los campos\n", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
                    agregarP.dispose();
                    return;
                }
                
                SesionTerapia sesion = new SesionTerapia();
                sesion.setRutTerapeuta(rutTerapeuta);
                sesion.setFecha(fecha);
                sesion.setTipoTerapia(terapia);
                sesion.setDuracion(duracion);
                sesion.setObservaciones(observaciones);
                sesion.setCalificacionMejora(calificacion);
                
                if((centro.obtenerListaPacientes()).contienePaciente(rutPaciente)) {
                    if((centro.obtenerListaTerapeutas()).contieneTerapeuta(rutTerapeuta)) {
                        Paciente paciente = (centro.obtenerListaPacientes()).getPaciente(rutPaciente);
                        if (!paciente.mismaFecha(paciente.obtenerListaSesiones(), sesion.getFecha())) {
                            (centro.obtenerListaPacientes()).getPaciente(rutPaciente).agregarSesion(sesion);
                            javax.swing.JOptionPane.showMessageDialog(null,"Sesión guardada exitosamente\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(null,"El paciente ya posee una sesión esa fecha\n", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(null,"No existe terapeuta con el rut especificado\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null,"No existe paciente con el rut especificado\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null,"Ingrese una nota válida (0-10)\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
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
        
        // =========== Acciones de Ventana Buscar para Eliminar Sesión ===========
        if (gestionS != null && ae.getSource() == gestionS.getEliminarSesion()) {
            gestionS.dispose();
            buscarS = new BuscarEliminarSesion((centro.obtenerListaPacientes()).listarPacientes());
            buscarS.getBotonBuscarRut().addActionListener(this);
            buscarS.getCerrarBuscarEliminarSesion().addActionListener(this);
            buscarS.setVisible(true);
            return;
        }
        if (buscarS != null && ae.getSource() == buscarS.getCerrarBuscarEliminarSesion()) {
            buscarS.dispose();
            return;
        }
        
        // =========== Acciones de Ventana Eliminar Sesión ===========
        if (buscarS != null && ae.getSource() == buscarS.getBotonBuscarRut()) {
            buscarS.dispose();
            rutAux = Utilidades.formatearRut(buscarS.getRutBuscarSesionField().getText());
            if ((centro.obtenerListaPacientes()).contienePaciente(rutAux)) {
                eliminarS = new EliminarSesion((centro.obtenerListaPacientes()).getPaciente(rutAux).listarSesiones());
                eliminarS.getBotonEliminarSesion().addActionListener(this);
                eliminarS.getCerrarEliminarSesion().addActionListener(this);
                eliminarS.setVisible(true);
                buscarS.dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(null,"No existe paciente con el rut especificado\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                buscarS.dispose();
            }
            buscarS.dispose();
            return;
        }
        if (eliminarS != null && ae.getSource() == eliminarS.getBotonEliminarSesion()) {
            try {
                String fechaSTR = eliminarS.getFechaEliminarField().getText();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fecha = LocalDate.parse(fechaSTR, formato);
                if ((centro.obtenerListaPacientes()).getPaciente(rutAux).eliminarSesion(fecha)) {
                    javax.swing.JOptionPane.showMessageDialog(null,"La sesión fue eliminada exitosamente\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    eliminarS.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null,"No se encontró una sesión registrada en la fecha mencionada\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                    eliminarS.dispose();
                }
            } catch (DateTimeParseException e) {
                javax.swing.JOptionPane.showMessageDialog(null,"Fecha inválida. Ingresar en formato dd/mm/yyyy\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            eliminarS.dispose();
            return;
        }
        if (eliminarS != null && ae.getSource() == eliminarS.getCerrarEliminarSesion()) {
            eliminarS.dispose();
            return;
        }
                
        // =========== Acciones de Ventana Filtrar Sesiones ===========
        if (gestionS != null && ae.getSource() == gestionS.getFiltrarSesiones()) {
            gestionS.dispose();
            filtrarS = new FiltrarSesiones();
            filtrarS.getFiltrarTodas().addActionListener(this);
            filtrarS.getFiltrarPorAño().addActionListener(this);
            filtrarS.getFiltrarPorTerapueta().addActionListener(this);
            filtrarS.getCerrarFiltrarSesiones().addActionListener(this);
            filtrarS.setVisible(true);
            return;
        }
        if (filtrarS != null && ae.getSource() == filtrarS.getCerrarFiltrarSesiones()) {
            filtrarS.dispose();
            return;
        }
        
        // =========== Acciones de Ventana Todas las Sesiones ===========
        if (filtrarS != null && ae.getSource() == filtrarS.getFiltrarTodas()) {
            filtrarS.dispose();
            listarS = new ListarSesiones((centro.obtenerListaPacientes()).getSesiones().listarSesiones());
            listarS.getCerrarListarSesiones().addActionListener(this);
            listarS.setVisible(true);
            return;
        }
        if (listarS != null && ae.getSource() == listarS.getCerrarListarSesiones()) {
            listarS.dispose();
            return;
        }
        
        // =========== Acciones de Ventana Consultar Por Año ===========
        if (filtrarS != null && ae.getSource() == filtrarS.getFiltrarPorAño()) {
            filtrarS.dispose();
            consultaA = new ConsultaAño();
            consultaA.getBotonFiltrar().addActionListener(this);
            consultaA.getCerrarConsultaAño().addActionListener(this);
            consultaA.setVisible(true);
            return;
        }
        if (consultaA != null && ae.getSource() == consultaA.getCerrarConsultaAño()) {
            consultaA.dispose();
            return;
        }
        
        // =========== Acciones de Ventana Filtrar Por Año ===========
        if (consultaA != null && ae.getSource() == consultaA.getBotonFiltrar()) {
            consultaA.dispose();
            try {
                int año = Integer.parseInt(consultaA.getAñoFiltroField().getText());
                listarS = new ListarSesiones((centro.obtenerListaPacientes()).getSesiones(año).listarSesiones());
                listarS.getCerrarListarSesiones().addActionListener(this);
                listarS.setVisible(true);
                return;
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null,"Ingrese una fecha válida\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            return;
        }
        if (listarS != null && ae.getSource() == listarS.getCerrarListarSesiones()) {
            listarS.dispose();
            return;
        }
        
        // =========== Acciones de Ventana Consultar Por Terapeuta ===========
        if (filtrarS != null && ae.getSource() == filtrarS.getFiltrarPorTerapueta()) {
            filtrarS.dispose();
            consultaT = new ConsultaTerapeuta((centro.obtenerListaTerapeutas()).listarTerapeutas());
            consultaT.getBotonFiltrar().addActionListener(this);
            consultaT.getCerrarConsultaTerapeuta().addActionListener(this);
            consultaT.setVisible(true);
            return;
        }
        if (consultaT != null && ae.getSource() == consultaT.getCerrarConsultaTerapeuta()) {
            consultaT.dispose();
            return;
        }
        
        // =========== Acciones de Ventana Filtrar Por Año ===========
        if (consultaT != null && ae.getSource() == consultaT.getBotonFiltrar()) {
            consultaT.dispose();
            String rut = Utilidades.formatearRut(consultaT.getRutTerapeutaField().getText());
            if ((centro.obtenerListaTerapeutas()).contieneTerapeuta(rut)) {
                listarS = new ListarSesiones((centro.obtenerListaTerapeutas()).getTerapeuta(rut).listarSesiones());
                listarS.getCerrarListarSesiones().addActionListener(this);
                listarS.setVisible(true);
                return;
            } else {
                javax.swing.JOptionPane.showMessageDialog(null,"No existe un terapeuta con el rut espeificado\n", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
            return;
        }
        if (listarS != null && ae.getSource() == listarS.getCerrarListarSesiones()) {
            listarS.dispose();
            return;
        }
        
        // =========== Acciones Botón Exportar ===========
        if (ae.getSource() == menu.getExportar()) {
            centro.obtenerListaPacientes().exportarDatos();
            javax.swing.JOptionPane.showMessageDialog(null,"Documento exportado exitosamente\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        
        // =========== Cerrar Programa ===========
        if (ae.getSource() == menu.getSalirPrograma()) {
            (centro.obtenerListaPacientes()).guardarPacientesCSV();
            (centro.obtenerListaPacientes()).guardarSesionesCSV();
            (centro.obtenerListaPacientes()).exportarDatos();
            
            menu.dispose();
            return;
        }
    }
}
