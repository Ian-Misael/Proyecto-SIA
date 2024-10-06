
package Ventanas;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AgregarSesion extends javax.swing.JFrame {

    public AgregarSesion(String datosP, String datosT) {
        initComponents();
        
        String[] arrP = datosP.split("\n");
        DefaultTableModel modelP = (DefaultTableModel) TablaDatosPacientes.getModel();

        for (String registroP : arrP) {
            String[] campos = registroP.split("; ");

            String nombre = campos[0].trim();
            String rut = campos[1].trim();
            modelP.addRow(new Object[]{rut, nombre});
        }
        
        String[] arrT = datosT.split("\n");
        DefaultTableModel modelT = (DefaultTableModel) TablaDatosTerapeutas.getModel();

        for (String registroT : arrT) {
            String[] campos = registroT.split("; ");

            String rut = campos[1].trim();
            String especialidad = campos[3].trim();
            modelT.addRow(new Object[]{rut, especialidad});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosPacientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDatosTerapeutas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        RutPacienteField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        RutTerapeutaField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        FechaField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TerapiaField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        DuracionField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ObservacionesField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        CalificacionField = new javax.swing.JTextField();
        BotonAgregarSesion = new javax.swing.JButton();
        CerrarAgregarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Agregar Nueva Sesion");

        TablaDatosPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(TablaDatosPacientes);
        if (TablaDatosPacientes.getColumnModel().getColumnCount() > 0) {
            TablaDatosPacientes.getColumnModel().getColumn(0).setMinWidth(100);
            TablaDatosPacientes.getColumnModel().getColumn(0).setPreferredWidth(100);
            TablaDatosPacientes.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        TablaDatosTerapeutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Especialidad"
            }
        ));
        jScrollPane2.setViewportView(TablaDatosTerapeutas);
        if (TablaDatosTerapeutas.getColumnModel().getColumnCount() > 0) {
            TablaDatosTerapeutas.getColumnModel().getColumn(0).setMinWidth(100);
            TablaDatosTerapeutas.getColumnModel().getColumn(0).setPreferredWidth(100);
            TablaDatosTerapeutas.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel2.setText("Registro de Pacientes");

        jLabel3.setText("Terapeutas Disponibles");

        jLabel4.setText("Rut Paciente");

        jLabel5.setText("Rut Terapeuta");

        jLabel6.setText("Fecha:");

        jLabel7.setText("Tipo de terapia:");

        jLabel8.setText("Duración:");

        jLabel9.setText("Observaciones:");

        jLabel10.setText("Calificación:");

        BotonAgregarSesion.setText("Agregar");

        CerrarAgregarSesion.setText("Cerrar");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(120, 120, 120))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(126, 126, 126))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ObservacionesField)
                                    .addComponent(CalificacionField)))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(CerrarAgregarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonAgregarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(RutPacienteField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RutTerapeutaField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(48, 48, 48)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TerapiaField)
                                    .addComponent(FechaField)
                                    .addComponent(DuracionField))))))
                .addGap(41, 41, 41))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RutPacienteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RutTerapeutaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TerapiaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DuracionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(30, 30, 30)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ObservacionesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(30, 30, 30)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalificacionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CerrarAgregarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonAgregarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getRutPacienteField() {
        return RutPacienteField;
    }
    
    public JTextField getRutTerapeutaField() {
        return RutTerapeutaField;
    }
    
    public JTextField getFechaField() {
        return FechaField;
    }
    
    public JTextField getTerapiaField() {
        return TerapiaField;
    }
    
    public JTextField getCalificacionField() {
        return CalificacionField;
    }
    
    public JTextField getObservacionesField() {
        return ObservacionesField;
    }
    
    public JTextField getDuracionField() {
        return DuracionField;
    }
    
    public JButton getBotonAgregarSesion() {
        return BotonAgregarSesion;
    }
    
    public JButton getCerrarAgregarSesion() {
        return CerrarAgregarSesion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregarSesion;
    private javax.swing.JTextField CalificacionField;
    private javax.swing.JButton CerrarAgregarSesion;
    private javax.swing.JTextField DuracionField;
    private javax.swing.JTextField FechaField;
    private javax.swing.JPanel Fondo;
    private javax.swing.JTextField ObservacionesField;
    private javax.swing.JTextField RutPacienteField;
    private javax.swing.JTextField RutTerapeutaField;
    private javax.swing.JTable TablaDatosPacientes;
    private javax.swing.JTable TablaDatosTerapeutas;
    private javax.swing.JTextField TerapiaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
