
package Ventanas;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ConsultaAño extends javax.swing.JFrame {

    public ConsultaAño() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AñoFiltroField = new javax.swing.JTextField();
        CerrarConsultaAño = new javax.swing.JButton();
        BotonFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(300, 200));
        setResizable(false);

        jLabel1.setText("Ingrese el año");

        CerrarConsultaAño.setText("Cerrar");

        BotonFiltrar.setText("Filtrar");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(AñoFiltroField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(CerrarConsultaAño, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(AñoFiltroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CerrarConsultaAño, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
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

    public JTextField getAñoFiltroField() {
        return AñoFiltroField;
    }
    
    public JButton getBotonFiltrar() {
        return BotonFiltrar;
    }
    
    public JButton getCerrarConsultaAño() {
        return CerrarConsultaAño;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AñoFiltroField;
    private javax.swing.JButton BotonFiltrar;
    private javax.swing.JButton CerrarConsultaAño;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
