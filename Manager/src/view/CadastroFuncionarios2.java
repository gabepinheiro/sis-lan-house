package view;

import controller.FuncionarioController;
import java.util.Date;
import model.entidades.Funcionario;
import webervicecep.ViaCEP;
import webervicecep.ViaCEPException;

public class CadastroFuncionarios2 extends javax.swing.JFrame {

    private String cpf, nome, sobrenome, email, telefone, celular, cargo, cep, logradouro, numero, bairro, complemento, cidade, estado;
    private Date dataAdmissao;
    private boolean editar = false;
    private float salario;

    public CadastroFuncionarios2() {
        initComponents();
        lblErro.setVisible(false);
    }

    public CadastroFuncionarios2(String cpf, String nome, String sobrenome, Date dataAdmissao, String email, String telefone, String celular, String cargo, float salario) {
        initComponents();
        lblErro.setVisible(false);
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataAdmissao = dataAdmissao;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.cargo = cargo;
        this.salario = salario;
    }

    public CadastroFuncionarios2(String cpf, String nome, String sobrenome, Date dataAdmissao, String email, String telefone, String celular, String cargo, float salario, boolean editar) {
        initComponents();
        lblErro.setVisible(false);
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataAdmissao = dataAdmissao;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.cargo = cargo;
        this.salario = salario;
        this.editar = editar;
        puxar(cpf);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblFechar1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        lblErro = new javax.swing.JLabel();
        txtCEP = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Funcionários");
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
        jLabel2.setText("Cadastro de Funcionários");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(625, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(296, 296, 296))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 920, 50));

        lblFechar1.setBackground(new java.awt.Color(255, 255, 255));
        lblFechar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/fechar.png"))); // NOI18N
        lblFechar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFechar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFechar1MouseClicked(evt);
            }
        });
        jPanel1.add(lblFechar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 50, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Insira os dados do novo funcionário");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 300, -1));

        jPanel4.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(153, 153, 153)), "Dados de localização", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nirmala UI", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(706, 706));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("CEP: *");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 60, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Complemento: ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 130, -1));

        txtComplemento.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtComplemento.setForeground(new java.awt.Color(51, 51, 51));
        txtComplemento.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtComplemento.setSelectionColor(new java.awt.Color(153, 153, 153));
        jPanel4.add(txtComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 240, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Número: *");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 100, -1));

        txtNumero.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(51, 51, 51));
        txtNumero.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtNumero.setSelectionColor(new java.awt.Color(153, 153, 153));
        jPanel4.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 90, 40));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Logradouro: *");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 110, -1));

        txtLogradouro.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtLogradouro.setForeground(new java.awt.Color(51, 51, 51));
        txtLogradouro.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtLogradouro.setSelectionColor(new java.awt.Color(153, 153, 153));
        jPanel4.add(txtLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 240, 40));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Bairro: *");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 130, -1));

        txtBairro.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtBairro.setForeground(new java.awt.Color(51, 51, 51));
        txtBairro.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtBairro.setSelectionColor(new java.awt.Color(153, 153, 153));
        jPanel4.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 190, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Cidade: *");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 130, -1));

        txtCidade.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtCidade.setForeground(new java.awt.Color(51, 51, 51));
        txtCidade.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtCidade.setSelectionColor(new java.awt.Color(153, 153, 153));
        jPanel4.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 190, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Estado: *");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 100, -1));

        cmbEstado.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jPanel4.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 80, 40));

        lblErro.setBackground(new java.awt.Color(255, 255, 255));
        lblErro.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lblErro.setForeground(new java.awt.Color(153, 0, 51));
        lblErro.setText("CEP inválido. Digite um CEP válido");
        jPanel4.add(lblErro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 210, 20));

        txtCEP.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtCEP.setForeground(new java.awt.Color(51, 51, 51));
        txtCEP.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCEP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtCEP.setSelectionColor(new java.awt.Color(153, 153, 153));
        txtCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCEPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCEPFocusLost(evt);
            }
        });
        txtCEP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCEPMouseClicked(evt);
            }
        });
        txtCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCEPActionPerformed(evt);
            }
        });
        txtCEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCEPKeyTyped(evt);
            }
        });
        jPanel4.add(txtCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 130, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 830, 370));

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
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 640, 170, 40));

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setEnabled(false);
        btnSalvar.setIconTextGap(10);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 640, 170, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("(*) Campos obrigatórios.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 250, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1003, 713));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblFechar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFechar1MouseClicked
        new TelaFuncionarios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblFechar1MouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtCEPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCEPFocusGained

    }//GEN-LAST:event_txtCEPFocusGained

    private void txtCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCEPFocusLost

        try {
            ViaCEP v = new ViaCEP(txtCEP.getText().replace("-", ""));
            txtLogradouro.setText(v.getLogradouro());
            txtBairro.setText(v.getBairro());
            txtCidade.setText(v.getLocalidade());
            txtComplemento.setText(v.getComplemento());
            cmbEstado.setSelectedItem(v.getUf());
            txtNumero.requestFocus();
            btnSalvar.setEnabled(true);
            String cep = txtCEP.getText().replace("-", "");
            StringBuilder b = new StringBuilder(cep);
            b.insert(cep.length() - 3, "-");
            txtCEP.setText(b.toString());
            lblErro.setVisible(false);
        } catch (ViaCEPException ex) {
            lblErro.setVisible(true);
            limpar();
            txtCEP.requestFocus();
            btnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_txtCEPFocusLost

    private void txtCEPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCEPMouseClicked
        btnSalvar.setEnabled(false);
    }//GEN-LAST:event_txtCEPMouseClicked

    private void txtCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCEPActionPerformed

    }//GEN-LAST:event_txtCEPActionPerformed

    private void txtCEPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCEPKeyTyped

    }//GEN-LAST:event_txtCEPKeyTyped

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cep = txtCEP.getText();
        logradouro = txtLogradouro.getText();
        numero = txtNumero.getText();
        complemento = txtComplemento.getText();
        bairro = txtBairro.getText();
        cidade = txtCidade.getText();
        estado = cmbEstado.getSelectedItem().toString();

        if (editar == true) {
            boolean flag = new FuncionarioController(cpf, nome, sobrenome, dataAdmissao, email, telefone, celular, cargo, cep, logradouro, numero, complemento, bairro, cidade, estado, salario).editar();
            if (flag == true) {
                this.dispose();
                new TelaFuncionarios().setVisible(true);
            }
        } else {
            boolean flag = new FuncionarioController(cpf, nome, sobrenome, dataAdmissao, email, telefone, celular, cargo, cep, logradouro, numero, complemento, bairro, cidade, estado, salario).salvar();
            if (flag) {
                this.dispose();
                new TelaFuncionarios().setVisible(true);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroFuncionarios2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarios2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarios2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarios2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionarios2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblErro;
    private javax.swing.JLabel lblFechar1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
private void limpar() {
        txtCEP.setText("");

        txtLogradouro.setText("");
        txtCEP.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        cmbEstado.setSelectedIndex(0);
    }

    private void puxar(String cpf) {
        Funcionario c = new FuncionarioController().puxar(cpf);
        txtCEP.setText(c.getCep());
        txtLogradouro.setText(c.getLogradouro());
        txtNumero.setText(c.getNumero());
        txtComplemento.setText(c.getComplemento());
        txtBairro.setText(c.getBairro());
        txtCidade.setText(c.getCidade());
        cmbEstado.setSelectedItem(c.getEstado());
        txtNumero.requestFocus();
    }
}
