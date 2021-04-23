/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSÉLUISFREIREDASILV
 */
public class CadastroConta extends javax.swing.JFrame {

    /**
     * Creates new form CadastroConta
     */
    public CadastroConta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cmbFornecedor = new javax.swing.JComboBox<>();
        txtData = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblFechar1 = new javax.swing.JLabel();
        addFornecedor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        addArquivo = new javax.swing.JLabel();
        txtArquivo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(79, 158, 195), new java.awt.Color(46, 52, 59)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(230, 227, 231));
        jPanel3.setPreferredSize(new java.awt.Dimension(706, 706));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Cadastro de Contas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(475, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 770, 50));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("(*) Campos obrigatórios.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 250, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Descrição: *");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 100, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Fornecedor: *");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 100, -1));

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setIconTextGap(10);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 170, 40));

        btnLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/limpar.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, 170, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Insira os dados da conta a pagar");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 270, -1));

        cmbFornecedor.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jPanel1.add(cmbFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 210, 40));

        txtData.setBackground(new java.awt.Color(255, 255, 255));
        txtData.setForeground(new java.awt.Color(51, 51, 51));
        txtData.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txtData.setIcon(new ImageIcon(getClass().getResource("/view/img/data.png")));
        txtData.setMaxSelectableDate(new Date());
        jPanel1.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 180, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Valor de venda: (R$)*");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Data de vencimento");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        lblFechar1.setBackground(new java.awt.Color(255, 255, 255));
        lblFechar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/fechar.png"))); // NOI18N
        lblFechar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFechar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFechar1MouseClicked(evt);
            }
        });
        jPanel1.add(lblFechar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 50, 40));

        addFornecedor.setBackground(new java.awt.Color(255, 255, 255));
        addFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/adicionar.png"))); // NOI18N
        addFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addFornecedorMouseClicked(evt);
            }
        });
        jPanel1.add(addFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 30, 40));

        txtValor.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtValor.setForeground(new java.awt.Color(51, 51, 51));
        txtValor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtValor.setSelectionColor(new java.awt.Color(153, 153, 153));
        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorFocusLost(evt);
            }
        });
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 120, 40));

        txtMotivo.setColumns(20);
        txtMotivo.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtMotivo.setForeground(new java.awt.Color(51, 51, 51));
        txtMotivo.setLineWrap(true);
        txtMotivo.setRows(5);
        txtMotivo.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtMotivo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 240, 80));

        addArquivo.setBackground(new java.awt.Color(255, 255, 255));
        addArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-add-file-30.png"))); // NOI18N
        addArquivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addArquivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addArquivoMouseClicked(evt);
            }
        });
        jPanel1.add(addArquivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 30, 40));

        txtArquivo.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txtArquivo.setForeground(new java.awt.Color(51, 51, 51));
        txtArquivo.setText("Selecione um arquivo...");
        txtArquivo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtArquivo.setEnabled(false);
        txtArquivo.setSelectionColor(new java.awt.Color(153, 153, 153));
        jPanel1.add(txtArquivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(849, 653));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
      
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void lblFechar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFechar1MouseClicked
        this.dispose();
    }//GEN-LAST:event_lblFechar1MouseClicked

    private void addFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addFornecedorMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Isso vai fazer com que esta janela se feche. Deseja continuar?", "Confirmação", JOptionPane.YES_NO_OPTION) == 0) {
            new CadastroFornecedores().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_addFornecedorMouseClicked

    private void txtValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusLost
        txtValor.setText(txtValor.getText().replaceAll(",", "."));
    }//GEN-LAST:event_txtValorFocusLost

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        String carac = "0123456789,.";
        if (!carac.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorKeyTyped

    private void addArquivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addArquivoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addArquivoMouseClicked

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
            java.util.logging.Logger.getLogger(CadastroConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addArquivo;
    private javax.swing.JLabel addFornecedor;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbFornecedor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFechar1;
    private javax.swing.JTextField txtArquivo;
    private com.toedter.calendar.JDateChooser txtData;
    private javax.swing.JTextArea txtMotivo;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

    private void limpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
