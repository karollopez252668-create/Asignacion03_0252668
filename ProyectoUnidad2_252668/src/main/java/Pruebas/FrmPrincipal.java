/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pruebas;

import Implementaciones.Funciones;
import Implementaciones.Metodos;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.function.DoubleUnaryOperator;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana principal de la aplicación de métodos numéricos.
 * 
 * Esta clase proporciona una interfaz gráfica para seleccionar una función,
 * elegir un método de solución de raíces (Bisección, Regla Falsa, Newton-Raphson, Secante),
 * ingresar valores iniciales y visualizar en una tabla los resultados iterativos.
 * 
 * 
 * También permite abrir ventanas auxiliares para mostrar ejemplos y comparaciones.
 * 
 * @author KARITO
 */
public class FrmPrincipal extends javax.swing.JFrame {
      /**
     * Constructor principal de la ventana.
     * 
     * Inicializa los componentes, configura el panel de fondo con imagen,
     * centra la ventana en pantalla, y asigna listeners para manejar los eventos
     * de selección de método y cálculo.
     * 
     */
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        this.setContentPane(new ImagendeFondo());
        initComponents();
        setLocationRelativeTo(null); 

        jComboBoxFunciones.setModel(new javax.swing.DefaultComboBoxModel<>(Funciones.getNombres()));

        cmbMetodo.addActionListener(e -> {
            String metodo = (String) cmbMetodo.getSelectedItem();
            cambiarColumnasTabla(metodo);
        });

        btncalcular.addActionListener(e -> {
            String metodo = (String) cmbMetodo.getSelectedItem();

            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();

            modelo.setRowCount(0); 

            if ("Biseccion".equals(metodo)) {
                
                for (int i = 1; i <= 5; i++) {
                    modelo.addRow(new Object[]{i, 1.0, 2.0, 1.5, -0.5, 0.01});
                }
            } else if ("Newton - Raphson".equals(metodo)) {
                for (int i = 1; i <= 5; i++) {
                    modelo.addRow(new Object[]{i, 1.5, -0.7, 2.4, 1.6, 0.005});
                }
            }
        });

    }

    private void cambiarColumnasTabla(String metodo) {
        String[] columnas;

        switch (metodo) {
            case "Biseccion":
            case "Regla Falsaa":
                columnas = new String[]{"Iteración", "Xi", "Xf", "Xr", "F(Xr)", "Error (Ea)"};
                break;

            case "Newton - Raphson":
                columnas = new String[]{"Iteración", "Xi", "F(Xi)", "F’(Xi)", "Xr", "Error (Ea)"};
                break;

            case "Secante":
                columnas = new String[]{"Iteración", "Xi-1", "Xi", "Xr", "F(Xr)", "Error (Ea)"};
                break;

            default:
                columnas = new String[]{"Iteración", "Xi", "Xf", "Xr", "F(Xr)", "Error (Ea)"};
                break;
        }

        // Crear nuevo modelo con las columnas correspondientes
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(null, columnas);
        jTable1.setModel(modelo);
    }

    /**
     * Clase interna que representa un panel con imagen de fondo.
     */
    class ImagendeFondo extends JPanel {

        private Image imagen;

        public ImagendeFondo() {
            URL imageUrl = getClass().getResource("/fondo/corazon.jpg");
            if (imageUrl != null) {
                imagen = new ImageIcon(imageUrl).getImage();
            } else {
                System.err.println("⚠ No se encontro la imagen /fondo/corazon.jpg");
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

    private void m() {
        String metodo = cmbMetodo.getSelectedItem().toString();
        switch (metodo) {
            case "Newton - Raphson":
                LblXi.setText("Xi-1");
                TxtXf.setEditable(false);
                TxtXf.setBackground(java.awt.Color.LIGHT_GRAY);
                break;
            case "Secante":
                LblXi.setText("X0: ");
                lblXf.setText("X1: ");
                TxtXf.setEditable(true);
                TxtXf.setBackground(java.awt.Color.WHITE);
                break;
            case "Biseccion":
                LblXi.setText("Xi: ");
                lblXf.setText("Xf: ");
                TxtXf.setEditable(true);
                TxtXf.setBackground(java.awt.Color.WHITE);
                break;
            case "Regla Falsa":
                LblXi.setText("Xi: ");
                lblXf.setText("Xf: ");
                TxtXf.setEditable(true);
                TxtXf.setBackground(java.awt.Color.WHITE);
                break;
            default:
                throw new AssertionError();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        LblXi = new javax.swing.JLabel();
        lblXf = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbMetodo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtXi = new javax.swing.JTextField();
        TxtXf = new javax.swing.JTextField();
        TxtEa = new javax.swing.JTextField();
        btncalcular = new javax.swing.JButton();
        jComboBoxFunciones = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Calculadora - Metodos Computacionales");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 281, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(102, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);

        jTable1.setBackground(new java.awt.Color(255, 204, 204));
        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Iteración", "Xi", "Xf", "Xr", "F(Xr)", "Error (Ea)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        LblXi.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        LblXi.setForeground(new java.awt.Color(255, 255, 255));
        LblXi.setText("Xi : ");

        lblXf.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        lblXf.setForeground(new java.awt.Color(255, 255, 255));
        lblXf.setText("Xf : ");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Error Max (ea): ");

        cmbMetodo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        cmbMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biseccion", "Regla Falsaa", "Newton - Raphson", "Secante" }));
        cmbMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMetodoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Metodo : ");

        txtXi.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        TxtXf.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        TxtEa.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        btncalcular.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btncalcular.setText("Calcular");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        jComboBoxFunciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "f(x) = 4x^3 - 6x^2 + 7x - 2.3", "f(x) = x^3 - 2x^2 + 4x - 8", "f(x) = cos(x) - x", "f(x) = e^x - 3x", "f(x) = x^2 - 2" }));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Funcion: ");

        jButton1.setText("Ejemplos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Comparaciones");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LblXi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtXi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblXf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtXf, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtEa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btncalcular))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblXi)
                    .addComponent(lblXf)
                    .addComponent(jLabel4)
                    .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtXi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtXf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncalcular))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jComboBoxFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 75, 27, 69);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        try {
            double xi = Double.parseDouble(txtXi.getText());
            double xf = Double.parseDouble(TxtXf.getText());
            double tol = Double.parseDouble(TxtEa.getText());

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0); // limpiar tabla

            int indiceFuncion = jComboBoxFunciones.getSelectedIndex();
            DoubleUnaryOperator f = Funciones.getFuncion(indiceFuncion);
            DoubleUnaryOperator df = Funciones.getDerivada(indiceFuncion);

            String metodo = cmbMetodo.getSelectedItem().toString();

            switch (metodo) {
                case "Biseccion":
                    Metodos.biseccion(f, xi, xf, tol, 20, modelo);
                    break;
                case "Regla Falsa":
                    Metodos.reglaFalsa(f, xi, xf, tol, 20, modelo);
                    break;
                case "Newton - Raphson":

                    Metodos.newtonRaphson(f, df, xi, tol, 20, modelo);
                    break;
                case "Secante":
                    Metodos.secante(f, xi, xf, tol, 20, modelo);
                    break;
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en los datos: " + e.getMessage());
        }

    }//GEN-LAST:event_btncalcularActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Comp frm = new Comp();
        frm.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ejemplo panel = new Ejemplo();
        panel.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMetodoActionPerformed
        m();
    }//GEN-LAST:event_cmbMetodoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblXi;
    private javax.swing.JTextField TxtEa;
    private javax.swing.JTextField TxtXf;
    private javax.swing.JButton btncalcular;
    private javax.swing.JComboBox<String> cmbMetodo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxFunciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblXf;
    private javax.swing.JTextField txtXi;
    // End of variables declaration//GEN-END:variables
}
