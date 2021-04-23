package view;

import controller.EstoqueEquipamentoController;
import dao.EquipamentoDAO;
import dao.EstoqueEquipamentoDAO;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entidades.Equipamento;
import model.entidades.EstoqueEquipamento;

public class TelaEstoque extends javax.swing.JFrame {

    private SimpleDateFormat dataBrasil = new SimpleDateFormat("dd/MM/yyyy");

    public TelaEstoque() {
        initComponents();
        preencher();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblFechar1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultTableModel tableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        tabela = new javax.swing.JTable();
        tabela.setDefaultRenderer(Object.class, new CellRenderer());
        txtFiltro = new javax.swing.JTextField();
        btnRelatorio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        txtDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDataFinal = new com.toedter.calendar.JDateChooser();
        lblDatar = new javax.swing.JLabel();
        btnManutencao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();

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
        jLabel2.setText("Estoque de equipamentos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(795, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(296, 296, 296))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1090, 50));

        lblFechar1.setBackground(new java.awt.Color(255, 255, 255));
        lblFechar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/fechar.png"))); // NOI18N
        lblFechar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFechar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFechar1MouseClicked(evt);
            }
        });
        jPanel1.add(lblFechar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, 50, 40));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tabela.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        tabela.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabela.setFillsViewportHeight(true);
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setRowHeight(20);
        tabela.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tabela.setShowVerticalLines(false);
        tabela.setModel(tableModel);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 950, 390));

        txtFiltro.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtFiltro.setForeground(new java.awt.Color(51, 51, 51));
        txtFiltro.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtFiltro.setSelectionColor(new java.awt.Color(153, 153, 153));
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });
        jPanel1.add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 240, 40));

        btnRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        btnRelatorio.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnRelatorio.setForeground(new java.awt.Color(51, 51, 51));
        btnRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-filter-30.png"))); // NOI18N
        btnRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRelatorioMouseClicked(evt);
            }
        });
        jPanel1.add(btnRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 30, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Descrição");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Selecione um dado para mais opções");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 300, -1));

        btnAdicionar.setBackground(new java.awt.Color(255, 255, 255));
        btnAdicionar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-add-file-30.png"))); // NOI18N
        btnAdicionar.setText("Novo");
        btnAdicionar.setBorder(null);
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdicionar.setIconTextGap(0);
        btnAdicionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 300, 70, 60));

        txtDataInicial.setBackground(new java.awt.Color(255, 255, 255));
        txtDataInicial.setForeground(new java.awt.Color(51, 51, 51));
        txtDataInicial.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txtDataInicial.setIcon(new ImageIcon(getClass().getResource("/view/img/data.png")));
        txtDataInicial.setMaxSelectableDate(new Date());
        jPanel1.add(txtDataInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 110, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("De:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 30, 20));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Data de entrada:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 120, 20));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Até:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 30, 20));

        txtDataFinal.setBackground(new java.awt.Color(255, 255, 255));
        txtDataFinal.setForeground(new java.awt.Color(51, 51, 51));
        txtDataFinal.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txtDataFinal.setIcon(new ImageIcon(getClass().getResource("/view/img/data.png")));
        txtDataFinal.setMaxSelectableDate(new Date());
        jPanel1.add(txtDataFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 110, 40));

        lblDatar.setBackground(new java.awt.Color(255, 255, 255));
        lblDatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/pesquisar.png"))); // NOI18N
        lblDatar.setToolTipText("Pesquisar período");
        lblDatar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDatarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDatarMouseEntered(evt);
            }
        });
        jPanel1.add(lblDatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 30, 40));

        btnManutencao.setBackground(new java.awt.Color(255, 255, 255));
        btnManutencao.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnManutencao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/quebrado.png"))); // NOI18N
        btnManutencao.setText("Quebrado");
        btnManutencao.setBorder(null);
        btnManutencao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManutencao.setEnabled(false);
        btnManutencao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnManutencao.setIconTextGap(0);
        btnManutencao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManutencaoActionPerformed(evt);
            }
        });
        jPanel1.add(btnManutencao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 540, 70, 60));

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-delete-bin-30.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(null);
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.setEnabled(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setIconTextGap(0);
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 460, 70, 60));

        btnIncluir.setBackground(new java.awt.Color(255, 255, 255));
        btnIncluir.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-edit-file-30.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.setBorder(null);
        btnIncluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIncluir.setEnabled(false);
        btnIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIncluir.setIconTextGap(0);
        btnIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 380, 70, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1160, 692));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblFechar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFechar1MouseClicked

        this.dispose();
    }//GEN-LAST:event_lblFechar1MouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (tabela.getSelectedRow() != -1) {
            btnManutencao.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnIncluir.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        filtrar(txtFiltro.getText().toUpperCase());
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped

    }//GEN-LAST:event_txtFiltroKeyTyped

    private void btnRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRelatorioMouseClicked

    }//GEN-LAST:event_btnRelatorioMouseClicked

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        new CadastroEstoqueEquipamento().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void lblDatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDatarMouseClicked
        try {
            Date inicial = txtDataInicial.getDate();
            Date dataFinal = txtDataFinal.getDate();

            if (inicial.after(dataFinal)) {
                JOptionPane.showMessageDialog(null, "Data inicial deve ser menor que a final", "Erro", JOptionPane.ERROR_MESSAGE);
                preencher();
            } else {
                filtraByData(inicial, dataFinal);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Digite datas válidas (DD/MM/YYYY)", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_lblDatarMouseClicked

    private void btnManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManutencaoActionPerformed
        String equip = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
        int qtd = Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        Equipamento e = new EquipamentoDAO().findByDesc(equip);
        EstoqueEquipamento ee = new EstoqueEquipamento(e, qtd);
        new CadastroManutencao(ee).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnManutencaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String desc = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
        String[] btns = {"Sim", "Não"};
        int res = JOptionPane.showOptionDialog(null, "Deseja excluir o registro", "Confrmação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, btns, btns[0]);
        if (res == 0) {
            if (new EstoqueEquipamentoController().excluir(desc)) {
                preencher();
                tabela.clearSelection();
                btnExcluir.setEnabled(false);
                btnManutencao.setEnabled(false);
                btnIncluir.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void lblDatarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDatarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblDatarMouseEntered

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        try {
            int qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade para inserir\n\n"));
            if (qtd + "" == "" || qtd < 0) {
                throw new NumberFormatException();
            } else {
                if (new EstoqueEquipamentoController().inserir(tabela.getValueAt(tabela.getSelectedRow(), 0).toString(), qtd)) {
                    preencher();
                    btnIncluir.setEnabled(false);
                    btnExcluir.setEnabled(false);
                    btnManutencao.setEnabled(false);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite um valor inteiro válido", "Erro", JOptionPane.ERROR_MESSAGE);
            tabela.clearSelection();
            btnExcluir.setEnabled(false);
            btnManutencao.setEnabled(false);
            btnIncluir.setEnabled(false);
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnManutencao;
    private javax.swing.JLabel btnRelatorio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatar;
    private javax.swing.JLabel lblFechar1;
    private javax.swing.JTable tabela;
    private com.toedter.calendar.JDateChooser txtDataFinal;
    private com.toedter.calendar.JDateChooser txtDataInicial;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    private void filtrar(String filtro) {

        List<EstoqueEquipamento> equipamentos;
        equipamentos = new EstoqueEquipamentoController().filtrar(filtro);
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);
        ((DefaultTableModel) tabela.getModel()).setColumnCount(3);
        String[] header = {"Equipamento", "Quantidade em estoque", "Data da entrada"};
        ((DefaultTableModel) tabela.getModel()).setColumnIdentifiers(header);
        tabela.getTableHeader().setFont(new Font("Nirmala ui", NORMAL, 14));
        tabela.getColumnModel().getColumn(0).setMinWidth(310);
        tabela.getColumnModel().getColumn(1).setMinWidth(310);
        tabela.getColumnModel().getColumn(2).setMinWidth(310);
        for (EstoqueEquipamento c : equipamentos) {
            String[] dados = new String[3];

            dados[0] = c.getEquipamento().getDescricao();

            dados[1] = c.getQtd() + "";
            dados[2] = dataBrasil.format(c.getDataEntrada());
            ((DefaultTableModel) tabela.getModel()).addRow(dados);
        }

    }

    private void preencher() {

        List<EstoqueEquipamento> equipamentos;
        equipamentos = new EstoqueEquipamentoController().listar();
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);
        ((DefaultTableModel) tabela.getModel()).setColumnCount(3);
        String[] header = {"Equipamento", "Quantidade em estoque", "Data da entrada"};
        ((DefaultTableModel) tabela.getModel()).setColumnIdentifiers(header);
        tabela.getTableHeader().setFont(new Font("Nirmala ui", NORMAL, 14));
        tabela.getColumnModel().getColumn(0).setMinWidth(310);
        tabela.getColumnModel().getColumn(1).setMinWidth(310);
        tabela.getColumnModel().getColumn(2).setMinWidth(310);
        for (EstoqueEquipamento c : equipamentos) {
            String[] dados = new String[3];

            dados[0] = c.getEquipamento().getDescricao();

            dados[1] = c.getQtd() + "";
            dados[2] = dataBrasil.format(c.getDataEntrada());
            ((DefaultTableModel) tabela.getModel()).addRow(dados);
        }
    }

    private void filtraByData(Date inicio, Date fim) {
        List<EstoqueEquipamento> equipamentos;
        equipamentos = new EstoqueEquipamentoController().filtraByData(inicio, fim);
        if (equipamentos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não foram encontrados registros", "Erro", JOptionPane.ERROR_MESSAGE);
            preencher();
        } else {
            ((DefaultTableModel) tabela.getModel()).setRowCount(0);
            ((DefaultTableModel) tabela.getModel()).setColumnCount(3);
            String[] header = {"Equipamento", "Quantidade em estoque", "Data da entrada"};
            ((DefaultTableModel) tabela.getModel()).setColumnIdentifiers(header);
            tabela.getTableHeader().setFont(new Font("Nirmala ui", NORMAL, 14));
            tabela.getColumnModel().getColumn(0).setMinWidth(310);
            tabela.getColumnModel().getColumn(1).setMinWidth(310);
            tabela.getColumnModel().getColumn(2).setMinWidth(310);
            for (EstoqueEquipamento c : equipamentos) {
                String[] dados = new String[3];

                dados[0] = c.getEquipamento().getDescricao();

                dados[1] = c.getQtd() + "";
                dados[2] = dataBrasil.format(c.getDataEntrada());
                ((DefaultTableModel) tabela.getModel()).addRow(dados);
            }
        }
    }
}
