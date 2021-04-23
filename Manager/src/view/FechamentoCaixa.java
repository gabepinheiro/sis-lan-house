/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CaixaController;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import model.entidades.Usuario;

/**
 *
 * @author JOSÉLUISFREIREDASILV
 */
public class FechamentoCaixa extends javax.swing.JFrame {

    private NumberFormat f = NumberFormat.getCurrencyInstance();
    private float valorCaixa = 0;
    private String login = "";

    public FechamentoCaixa() {
        initComponents();

    }

    FechamentoCaixa(String usuario) {
        initComponents();
        login = usuario;
        valorCaixa = new CaixaController().getValorCaixa();
        txtValorCaixa.setText(f.format(valorCaixa));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSangria = new javax.swing.JButton();
        lblFechar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtValorCaixa = new javax.swing.JTextField();
        txtValorRetirado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        btnFecharCaixa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(79, 158, 195), new java.awt.Color(46, 52, 59)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(230, 227, 231));
        jPanel3.setPreferredSize(new java.awt.Dimension(706, 706));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Fechamento do caixa");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(333, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 60));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Motivo do fechamento:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        btnSangria.setBackground(new java.awt.Color(255, 255, 255));
        btnSangria.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnSangria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/contas.png"))); // NOI18N
        btnSangria.setText("Retirar tudo");
        btnSangria.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        btnSangria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSangria.setIconTextGap(10);
        btnSangria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSangriaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSangria, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 140, 40));

        lblFechar.setBackground(new java.awt.Color(255, 255, 255));
        lblFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/fechar.png"))); // NOI18N
        lblFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        jPanel1.add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 50, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Valor no caixa: R$");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 140, -1));

        txtValorCaixa.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtValorCaixa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValorCaixa.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtValorCaixa.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtValorCaixa.setEnabled(false);
        txtValorCaixa.setSelectionColor(new java.awt.Color(153, 153, 153));
        txtValorCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorCaixaKeyTyped(evt);
            }
        });
        jPanel1.add(txtValorCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 120, 40));

        txtValorRetirado.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtValorRetirado.setForeground(new java.awt.Color(51, 51, 51));
        txtValorRetirado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValorRetirado.setText("0.0");
        txtValorRetirado.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtValorRetirado.setSelectionColor(new java.awt.Color(153, 153, 153));
        txtValorRetirado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorRetiradoFocusLost(evt);
            }
        });
        txtValorRetirado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorRetiradoKeyTyped(evt);
            }
        });
        jPanel1.add(txtValorRetirado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 120, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Retirar Valor: R$");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 170, -1, -1));

        txtMotivo.setColumns(20);
        txtMotivo.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtMotivo.setForeground(new java.awt.Color(51, 51, 51));
        txtMotivo.setLineWrap(true);
        txtMotivo.setRows(5);
        txtMotivo.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtMotivo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 240, -1));

        btnFecharCaixa.setBackground(new java.awt.Color(255, 255, 255));
        btnFecharCaixa.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnFecharCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/caixaAbrir.png"))); // NOI18N
        btnFecharCaixa.setText("Fechar Caixa");
        btnFecharCaixa.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        btnFecharCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFecharCaixa.setIconTextGap(10);
        btnFecharCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharCaixaActionPerformed(evt);
            }
        });
        jPanel1.add(btnFecharCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 240, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(637, 448));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSangriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSangriaActionPerformed
        txtValorRetirado.setText(valorCaixa + "");
    }//GEN-LAST:event_btnSangriaActionPerformed

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        TelaPrincipal.getInstance().TelaPrincipalUser(login);
                TelaPrincipal.getInstance().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblFecharMouseClicked

    private void txtValorCaixaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorCaixaKeyTyped
        String carac = "0123456789.,";
        if (!carac.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorCaixaKeyTyped

    private void txtValorRetiradoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRetiradoKeyTyped
        String carac = "0123456789.,";
        if (!carac.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnFecharCaixa.doClick();
        }
    }//GEN-LAST:event_txtValorRetiradoKeyTyped

    private void btnFecharCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharCaixaActionPerformed
        try {
            float valor = Float.parseFloat(txtValorRetirado.getText());
            String motivo = txtMotivo.getText();
            if (motivo.equals("")) {
                throw new NumberFormatException();
            }
            if (new CaixaController().fecharCaixa(motivo, valor, login)) {
               TelaPrincipal c = new TelaPrincipal();
               c.dispose();
                TelaPrincipal.getInstance().TelaPrincipalLoginB(login, true);
                TelaPrincipal.getInstance().setVisible(true);
                this.dispose();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite o valor e o motivo corretamente!\n Exemplo: 1000,00.", "ERRO", JOptionPane.ERROR_MESSAGE);
            txtValorRetirado.setText("0.0");
        }
    }//GEN-LAST:event_btnFecharCaixaActionPerformed

    private void txtValorRetiradoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorRetiradoFocusLost
        txtValorRetirado.setText(txtValorRetirado.getText().replaceAll(",", "."));
    }//GEN-LAST:event_txtValorRetiradoFocusLost

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FechamentoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FechamentoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FechamentoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FechamentoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FechamentoCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFecharCaixa;
    private javax.swing.JButton btnSangria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JTextArea txtMotivo;
    private javax.swing.JTextField txtValorCaixa;
    private javax.swing.JTextField txtValorRetirado;
    // End of variables declaration//GEN-END:variables
}
