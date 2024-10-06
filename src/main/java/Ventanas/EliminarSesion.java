
package Ventanas;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EliminarSesion extends javax.swing.JFrame {

    public EliminarSesion(String datos) {
        initComponents();
        
        String[] arr = datos.split("\n");
        DefaultTableModel model = (DefaultTableModel) TablaSesiones.getModel();
        
        for (String arr1 : arr) {
            String[] cc = arr1.split(";");
            model.addRow(cc);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaSesiones = new javax.swing.JTable();
        CerrarEliminarSesion = new javax.swing.JButton();
        BotonEliminarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        FechaEliminarField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Listado de Sesiones");

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

        CerrarEliminarSesion.setText("Cerrar");

        BotonEliminarSesion.setText("Eliminar");

        jLabel2.setText("Ingrese la fecha de la sesión a eliminar (dd/mm/yyyy):");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(CerrarEliminarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonEliminarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(FechaEliminarField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(FechaEliminarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CerrarEliminarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonEliminarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
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

    public JTextField getFechaEliminarField() {
        return FechaEliminarField;
    }
    
    public JButton getBotonEliminarSesion() {
        return BotonEliminarSesion;
    }
    
    public JButton getCerrarEliminarSesion() {
        return CerrarEliminarSesion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEliminarSesion;
    private javax.swing.JButton CerrarEliminarSesion;
    private javax.swing.JTextField FechaEliminarField;
    private javax.swing.JPanel Fondo;
    private javax.swing.JTable TablaSesiones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
