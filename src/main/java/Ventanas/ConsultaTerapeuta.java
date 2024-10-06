
package Ventanas;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ConsultaTerapeuta extends javax.swing.JFrame {

    public ConsultaTerapeuta(String datos) {
        initComponents();
        
        String[] arr = datos.split("\n");
        DefaultTableModel model = (DefaultTableModel) TablaDatosTerapeutas.getModel();

        for (String registro : arr) {
            String[] campos = registro.split("; ");

            String nombre = campos[0].trim();
            String rut = campos[1].trim();
            String especialidad = campos[3].trim();
            model.addRow(new Object[]{nombre, rut, especialidad});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosTerapeutas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RutTerapeutaField = new javax.swing.JTextField();
        CerrarConsultaTerapeuta = new javax.swing.JButton();
        BotonFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        TablaDatosTerapeutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Rut", "Especialidad"
            }
        ));
        jScrollPane1.setViewportView(TablaDatosTerapeutas);
        if (TablaDatosTerapeutas.getColumnModel().getColumnCount() > 0) {
            TablaDatosTerapeutas.getColumnModel().getColumn(0).setMinWidth(150);
            TablaDatosTerapeutas.getColumnModel().getColumn(0).setPreferredWidth(150);
            TablaDatosTerapeutas.getColumnModel().getColumn(0).setMaxWidth(150);
            TablaDatosTerapeutas.getColumnModel().getColumn(1).setMinWidth(100);
            TablaDatosTerapeutas.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaDatosTerapeutas.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jLabel1.setText("Terapeutas disponibles");

        jLabel2.setText("Ingrese el Rut del terapeuta para ver sus sesiones");

        CerrarConsultaTerapeuta.setText("Cerrar");

        BotonFiltrar.setText("Filtrar");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(CerrarConsultaTerapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220)
                        .addComponent(BotonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(FondoLayout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(RutTerapeutaField, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(FondoLayout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(jLabel2))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(RutTerapeutaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CerrarConsultaTerapeuta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
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
    
    public JButton getBotonFiltrar() {
        return BotonFiltrar;
    }
    
    public JButton getCerrarConsultaTerapeuta() {
        return CerrarConsultaTerapeuta;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonFiltrar;
    private javax.swing.JButton CerrarConsultaTerapeuta;
    private javax.swing.JPanel Fondo;
    private javax.swing.JTextField RutTerapeutaField;
    private javax.swing.JTable TablaDatosTerapeutas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
