
package Ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListarPacientes extends javax.swing.JFrame {

    public ListarPacientes(String datos) {
        initComponents();
        
        String[] arr = datos.split("\n");
        DefaultTableModel model = (DefaultTableModel) TablaPacientes.getModel();
        
        for (String arr1 : arr) {
            String[] cc = arr1.split(",");
            model.addRow(cc);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        Enunciado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPacientes = new javax.swing.JTable();
        CerrarListarPacientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 550));
        setResizable(false);

        Fondo.setMaximumSize(new java.awt.Dimension(700, 550));
        Fondo.setMinimumSize(new java.awt.Dimension(700, 550));

        Enunciado.setText("Listado de Pacientes");

        TablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Rut", "Edad", "Dirección", "Historial"
            }
        ));
        jScrollPane1.setViewportView(TablaPacientes);
        if (TablaPacientes.getColumnModel().getColumnCount() > 0) {
            TablaPacientes.getColumnModel().getColumn(0).setMinWidth(120);
            TablaPacientes.getColumnModel().getColumn(0).setPreferredWidth(120);
            TablaPacientes.getColumnModel().getColumn(0).setMaxWidth(120);
            TablaPacientes.getColumnModel().getColumn(1).setMinWidth(100);
            TablaPacientes.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaPacientes.getColumnModel().getColumn(1).setMaxWidth(100);
            TablaPacientes.getColumnModel().getColumn(2).setMinWidth(50);
            TablaPacientes.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablaPacientes.getColumnModel().getColumn(2).setMaxWidth(50);
            TablaPacientes.getColumnModel().getColumn(3).setMinWidth(150);
            TablaPacientes.getColumnModel().getColumn(3).setPreferredWidth(150);
            TablaPacientes.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        CerrarListarPacientes.setText("Cerrar");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CerrarListarPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Enunciado)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(Enunciado)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CerrarListarPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
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

    public JButton getCerrarListarPacientes() {
        return CerrarListarPacientes;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarListarPacientes;
    private javax.swing.JLabel Enunciado;
    private javax.swing.JPanel Fondo;
    private javax.swing.JTable TablaPacientes;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
