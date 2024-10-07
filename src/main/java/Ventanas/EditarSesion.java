
package Ventanas;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EditarSesion extends javax.swing.JFrame {

    
    public EditarSesion(String datosS, String datosT) {
        initComponents();
        
        String[] arrS = datosS.split("\n");
        DefaultTableModel model = (DefaultTableModel) TablaSesiones.getModel();
        
        for (String arr1 : arrS) {
            String[] cc = arr1.split(";");
            model.addRow(cc);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaSesiones = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FechaField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TipoTerapiaField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        DuracionField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ObservacionesField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        MejoraField = new javax.swing.JTextField();
        CerrarEditarSesion = new javax.swing.JButton();
        BotonEditar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        RutTerapeutaField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDatosTerapeutas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        TablaSesiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Tipo de Terapia", "Duración", "Observaciones", "Mejora"
            }
        ));
        jScrollPane1.setViewportView(TablaSesiones);
        if (TablaSesiones.getColumnModel().getColumnCount() > 0) {
            TablaSesiones.getColumnModel().getColumn(0).setMinWidth(70);
            TablaSesiones.getColumnModel().getColumn(0).setPreferredWidth(70);
            TablaSesiones.getColumnModel().getColumn(0).setMaxWidth(70);
            TablaSesiones.getColumnModel().getColumn(2).setMinWidth(80);
            TablaSesiones.getColumnModel().getColumn(2).setPreferredWidth(80);
            TablaSesiones.getColumnModel().getColumn(2).setMaxWidth(80);
            TablaSesiones.getColumnModel().getColumn(4).setMinWidth(70);
            TablaSesiones.getColumnModel().getColumn(4).setPreferredWidth(70);
            TablaSesiones.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jLabel1.setText("Listado de Sesiones");

        jLabel2.setText("Ingrese la Fecha de la sesión a editar (dd/mm/yyyy):");

        jLabel3.setText("Complete el resto de campos");

        jLabel4.setText("Tipo de Terapia:");

        jLabel5.setText("Duración:");

        jLabel6.setText("Observaciones:");

        jLabel7.setText("Calificación de Mejora:");

        CerrarEditarSesion.setText("Cerrar");

        BotonEditar.setText("Editar");

        jLabel8.setText("Rut del Terapeuta:");

        TablaDatosTerapeutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Especialidad"
            }
        ));
        jScrollPane2.setViewportView(TablaDatosTerapeutas);

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FondoLayout.createSequentialGroup()
                            .addGap(262, 262, 262)
                            .addComponent(jLabel3))
                        .addGroup(FondoLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(FondoLayout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(FechaField))
                                .addGroup(FondoLayout.createSequentialGroup()
                                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addGroup(FondoLayout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(11, 11, 11))
                                        .addComponent(jLabel8))
                                    .addGap(18, 18, 18)
                                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DuracionField, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ObservacionesField, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TipoTerapiaField)
                                        .addComponent(MejoraField)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                                            .addComponent(RutTerapeutaField, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(CerrarEditarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FechaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(RutTerapeutaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)))
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TipoTerapiaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(DuracionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ObservacionesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(34, 34, 34))
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MejoraField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(27, 27, 27)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CerrarEditarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
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

    public JTextField getRutTerapeutaField() {
        return RutTerapeutaField;
    }
    
    public JTextField getFechaField() {
        return FechaField;
    }
    
    public JTextField getTipoTerapiaField() {
        return TipoTerapiaField;
    }
    
    public JTextField getDuracionField() {
        return DuracionField;
    }
    
    public JTextField getObservacionesField() {
        return ObservacionesField;
    }
    
    public JTextField getMejoraField() {
        return MejoraField;
    }
    
    public JButton getBotonEditar() {
        return BotonEditar;
    }
    
    public JButton getCerrarEditarSesion() {
        return CerrarEditarSesion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton CerrarEditarSesion;
    private javax.swing.JTextField DuracionField;
    private javax.swing.JTextField FechaField;
    private javax.swing.JPanel Fondo;
    private javax.swing.JTextField MejoraField;
    private javax.swing.JTextField ObservacionesField;
    private javax.swing.JTextField RutTerapeutaField;
    private javax.swing.JTable TablaDatosTerapeutas;
    private javax.swing.JTable TablaSesiones;
    private javax.swing.JTextField TipoTerapiaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
