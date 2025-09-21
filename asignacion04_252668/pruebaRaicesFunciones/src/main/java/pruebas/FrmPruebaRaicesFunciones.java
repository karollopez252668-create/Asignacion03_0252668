package pruebas;

import implementaciones.PasoIteracion;
import implementaciones.RaicesFunciones;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * JFrame que permite probar métodos numéricos para encontrar raíces de funciones.
 * <p>
 * La interfaz gráfica permite seleccionar el método (Bisección o Regla Falsa),
 * ingresar los valores del intervalo (Xi, Xf) y el error máximo permitido,
 * y mostrar los resultados en una tabla.
 * </p>
 * 
 * Autor: KARITO
 */

public class FrmPruebaRaicesFunciones extends javax.swing.JFrame {
    
    /**
     * Constructor de la ventana principal.
     * Configura el fondo, inicializa componentes y muestra la función según el método seleccionado.
     */
    public FrmPruebaRaicesFunciones() {
        this.setContentPane(new ImagendeFondo());
        initComponents();
        mostarfuncion();
    }
    
    /**
     * Clase interna que representa un panel con imagen de fondo.
     */
    class ImagendeFondo extends JPanel {

        private Image imagen;

        public ImagendeFondo() {
            URL imageUrl = getClass().getResource("/fondo/rosapastel.png");
            if (imageUrl != null) {
                imagen = new ImageIcon(imageUrl).getImage();
            } else {
                System.err.println("⚠ No se encontro la imagen /imagenes/Fondo1.jp");
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
    
    /**
     * Muestra la función correspondiente según el método seleccionado en la etiqueta lblFuncion.
     */
    private void mostarfuncion(){
            if (cmbMetodo.getSelectedItem().equals("Biseccion")) {
            lblFuncion.setText("Funcion: " + "4x^3-6x^2+7x-2.3");          
        } else {
                       lblFuncion.setText("Funcion: " + "x^2{|cos(x)|}-5");
        

}
    }
   
 
 
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblMetodo = new javax.swing.JLabel();
        cmbMetodo = new javax.swing.JComboBox<>();
        lblXi = new javax.swing.JLabel();
        txtXi = new javax.swing.JTextField();
        txtXf = new javax.swing.JTextField();
        lblXf = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEamax = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        lblFuncion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Metodos Numericos - Raices de Funciones");

        lblMetodo.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        lblMetodo.setForeground(new java.awt.Color(153, 0, 51));
        lblMetodo.setText("Metodo : ");
        lblMetodo.setToolTipText("");

        cmbMetodo.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        cmbMetodo.setForeground(new java.awt.Color(153, 0, 51));
        cmbMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biseccion", "Regla Falsa" }));
        cmbMetodo.setToolTipText("");
        cmbMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMetodoActionPerformed(evt);
            }
        });

        lblXi.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        lblXi.setForeground(new java.awt.Color(153, 0, 51));
        lblXi.setText("Xi :");
        lblXi.setToolTipText("");

        txtXi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtXi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXiActionPerformed(evt);
            }
        });

        txtXf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtXf.setForeground(new java.awt.Color(153, 0, 51));
        txtXf.setToolTipText("");
        txtXf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXfActionPerformed(evt);
            }
        });

        lblXf.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        lblXf.setForeground(new java.awt.Color(153, 0, 51));
        lblXf.setText("Xf :");
        lblXf.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 51));
        jLabel2.setText("Error Max (ea):");
        jLabel2.setToolTipText("");

        txtEamax.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtEamax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEamaxActionPerformed(evt);
            }
        });

        btnCalcular.setBackground(new java.awt.Color(255, 204, 204));
        btnCalcular.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        btnCalcular.setForeground(new java.awt.Color(153, 0, 51));
        btnCalcular.setText("Calcular");
        btnCalcular.setToolTipText("");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        tblResultados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Iteracion", "Xi", "Xf", "Raiz aproximada", "f(Raíz)", "Error"
            }
        ));
        jScrollPane2.setViewportView(tblResultados);

        lblFuncion.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        lblFuncion.setForeground(new java.awt.Color(153, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(lblMetodo)
                                .addGap(18, 18, 18)
                                .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(354, 354, 354)
                                .addComponent(lblXi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtXi, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(lblXf, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtXf, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(txtEamax, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMetodo)
                    .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblXi)
                    .addComponent(txtXi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblXf)
                    .addComponent(txtXf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtEamax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 375;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 6, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMetodoActionPerformed
        if (cmbMetodo.getSelectedItem().equals("Biseccion")) {
            lblFuncion.setText("Funcion: " + "4x^3-6x^2+7x-2.3");          
        } else {
                       lblFuncion.setText("Funcion: " + "x^2{|cos(x)|}-5");
        }
    }//GEN-LAST:event_cmbMetodoActionPerformed

    private void txtXiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXiActionPerformed

    private void txtXfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXfActionPerformed

    private void txtEamaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEamaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEamaxActionPerformed

    
    
    
    /**
     * Acción realizada al hacer clic en el botón "Calcular".
     * Valida los datos, ejecuta el método numérico seleccionado y muestra los resultados en la tabla.
     *
     * @param evt evento de acción
     */
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
     
        
        DefaultTableModel model1 = (DefaultTableModel) tblResultados.getModel();
        model1.setRowCount(0); 
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Iteración", "Xi", "Xf", "Raíz aprox", "f(Raíz)", "Error %"}
        );
        tblResultados.setModel(model);

        RaicesFunciones rf = new RaicesFunciones();

        double xi = Double.parseDouble(txtXi.getText());
        double xf = Double.parseDouble(txtXf.getText());
        double eamax = Double.parseDouble(txtEamax.getText());
        java.util.function.DoubleUnaryOperator funcion = (x) -> Math.pow(x, 3) - x - 2;

        if (cmbMetodo.getSelectedItem().equals("Biseccion")) {

            lblFuncion.setText("Funcion: " + "4x^3-6x^2+7x-2.3");
            rf.biseccion(funcion, xi, xf, eamax);
        } else {
            rf.reglaFalsa(funcion, xi, xf, eamax);
            lblFuncion.setText("Funcion: " + "x^2{|cos(x)|}-5");
        }

        for (PasoIteracion paso : rf.getPasos()) {
            model.addRow(new Object[]{
                paso.getIteracion(),
                String.format("%.6f", paso.getXi()),
                String.format("%.6f", paso.getXf()),
                String.format("%.6f", paso.getXr()),
                String.format("%.6f", paso.getFxr()),
                String.format("%.6f", paso.getError())
            });
        }
            

    }//GEN-LAST:event_btnCalcularActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPruebaRaicesFunciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JComboBox<String> cmbMetodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFuncion;
    private javax.swing.JLabel lblMetodo;
    private javax.swing.JLabel lblXf;
    private javax.swing.JLabel lblXi;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtEamax;
    private javax.swing.JTextField txtXf;
    private javax.swing.JTextField txtXi;
    // End of variables declaration//GEN-END:variables
}
