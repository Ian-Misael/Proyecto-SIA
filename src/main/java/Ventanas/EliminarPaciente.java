
package Ventanas;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EliminarPaciente extends javax.swing.JFrame {

    public EliminarPaciente(String datos) {
        initComponents();
        
        String[] arr = datos.split("\n");
        DefaultTableModel model = (DefaultTableModel) TablaDatos.getModel();

        for (String registro : arr) {
            String[] campos = registro.split(", ");

            String nombre = campos[0].trim();
            String rut = campos[1].trim();
            model.addRow(new Object[]{rut, nombre});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        BotonEliminarPaciente = new javax.swing.JButton();
        CerrarEliminarPaciente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RutEliminarField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BotonEliminarPaciente.setText("Eliminar");

        CerrarEliminarPaciente.setText("Cerrar");

        TablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(TablaDatos);
        if (TablaDatos.getColumnModel().getColumnCount() > 0) {
            TablaDatos.getColumnModel().getColumn(0).setMinWidth(200);
            TablaDatos.getColumnModel().getColumn(0).setPreferredWidth(200);
            TablaDatos.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        jLabel1.setText("Pacientes Registrados");

        jLabel2.setText("Ingrese el rut del paciente a eliminar:");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RutEliminarField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(CerrarEliminarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                                .addComponent(BotonEliminarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(71, 71, 71))))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(RutEliminarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CerrarEliminarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonEliminarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
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

    public JTextField getRutEliminarField() {
        return RutEliminarField;
    }
    
    public JButton getBotonEliminarPaciente() {
        return BotonEliminarPaciente;
    }
    
    public JButton getCerrarEliminarPaciente() {
        return CerrarEliminarPaciente;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEliminarPaciente;
    private javax.swing.JButton CerrarEliminarPaciente;
    private javax.swing.JPanel Fondo;
    private javax.swing.JTextField RutEliminarField;
    private javax.swing.JTable TablaDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
