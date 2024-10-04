/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.ProdutoDao;
import dao.ProdutoDaoImpl;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import model.Produto;

/**
 *
 * @author lucas-gabreil_silva
 */
public class FormProduto extends javax.swing.JInternalFrame {

    public ArrayList<Object> inputs = new ArrayList<>();
    public boolean newPro = false;
    public int selectedPro;
    private ProdutoDao produtoDao;

    /**
     * Creates new form FormProduto
     */
    public FormProduto() {
        produtoDao = new ProdutoDaoImpl();
        initComponents();
        addInputsToTheList();
        evtListenerInputs();
        loadProdutos();
    }

    private void loadProdutos() {
        List<Produto> produtos = produtoDao.getAllProdutos();
        DefaultTableModel modelPro = new DefaultTableModel(new Object[]{
            "Código",
            "Preço",
            "Quantidade",
            "Unidade",
            "Descrição"}, 0);
        for (Produto produto : produtos) {
            Object linhaPro[] = new Object[]{
                produto.getCod(),
                produto.getPreco(),
                produto.getQtd(),
                produto.getUnidade(),
                produto.getDesc()
            };
            modelPro.addRow(linhaPro);
        }
        tblPro.setModel(modelPro);
    }

    private void addInputsToTheList() {
        inputs.add(jtfCodPro);
        inputs.add(jtfPrecoPro);
        inputs.add(jtfQtdPro);
        inputs.add(jtfUnidadePro);
        inputs.add(jtaDescPro);
    }

    private boolean isAllFilled() {
        for (Object input : inputs) {
            if (input instanceof JTextField) {
                if (((JTextField) input).getText().isBlank()) {
                    return false;
                }
            } else if (input instanceof JTextArea) {
                if (((JTextArea) input).getText().isBlank()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void setFormEnabled(boolean enabled, boolean editMode) {
        if (!editMode) {
            newPro = enabled;
        }
        for (Object input : inputs) {
            if (input instanceof JTextField) {
                ((JTextField) input).setEnabled(enabled);
                if (!editMode) {
                    ((JTextField) input).setText("");
                }
            } else if (input instanceof JTextArea) {
                ((JTextArea) input).setEnabled(enabled);
                if (!editMode) {
                    ((JTextArea) input).setText("");
                }
            }
        }
        if (enabled) {
            btnNovoPro.setEnabled(false);
            btnEditarPro.setEnabled(false);
            btnExcluirPro.setEnabled(false);
            btnCancelarPro.setEnabled(true);
            btnSalvarPro.setEnabled(editMode);

            jtfCodPro.setEnabled(false);
            if (!editMode) {
                jtfCodPro.setText(produtoDao.getNextCod() + "");
            }
        } else {
            btnNovoPro.setEnabled(true);
            btnEditarPro.setEnabled(false);
            btnExcluirPro.setEnabled(false);
            btnCancelarPro.setEnabled(false);
            btnSalvarPro.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblPro = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfCodPro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfPrecoPro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfUnidadePro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfQtdPro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescPro = new javax.swing.JTextArea();
        btnNovoPro = new javax.swing.JButton();
        btnEditarPro = new javax.swing.JButton();
        btnExcluirPro = new javax.swing.JButton();
        btnCancelarPro = new javax.swing.JButton();
        btnSalvarPro = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Formulário - Produto");
        setMinimumSize(new java.awt.Dimension(750, 550));

        tblPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Preço", "Unidade", "Quantidade", "Descrição"
            }
        ));
        tblPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPro);

        jLabel1.setText("Código:");

        jtfCodPro.setEnabled(false);
        jtfCodPro.setNextFocusableComponent(jtfPrecoPro);

        jLabel2.setText("Preço:");

        jtfPrecoPro.setEnabled(false);
        jtfPrecoPro.setNextFocusableComponent(jtfUnidadePro);

        jLabel3.setText("Unidade:");

        jtfUnidadePro.setEnabled(false);
        jtfUnidadePro.setNextFocusableComponent(jtfQtdPro);

        jLabel4.setText("Quantidade:");

        jtfQtdPro.setEnabled(false);
        jtfQtdPro.setNextFocusableComponent(jtaDescPro);

        jLabel5.setText("Descrição:");

        jtaDescPro.setColumns(20);
        jtaDescPro.setRows(5);
        jtaDescPro.setTabSize(0);
        jtaDescPro.setEnabled(false);
        jtaDescPro.setNextFocusableComponent(btnCancelarPro);
        jScrollPane1.setViewportView(jtaDescPro);

        btnNovoPro.setText("Novo");
        btnNovoPro.setNextFocusableComponent(btnEditarPro);
        btnNovoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProActionPerformed(evt);
            }
        });

        btnEditarPro.setText("Editar");
        btnEditarPro.setEnabled(false);
        btnEditarPro.setNextFocusableComponent(btnExcluirPro);
        btnEditarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProActionPerformed(evt);
            }
        });

        btnExcluirPro.setText("Excluir");
        btnExcluirPro.setEnabled(false);
        btnExcluirPro.setNextFocusableComponent(btnCancelarPro);
        btnExcluirPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProActionPerformed(evt);
            }
        });

        btnCancelarPro.setText("Cancelar");
        btnCancelarPro.setEnabled(false);
        btnCancelarPro.setNextFocusableComponent(btnNovoPro);
        btnCancelarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProActionPerformed(evt);
            }
        });

        btnSalvarPro.setText("Salvar");
        btnSalvarPro.setEnabled(false);
        btnSalvarPro.setNextFocusableComponent(jtfCodPro);
        btnSalvarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnEditarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(btnExcluirPro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnCancelarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(btnSalvarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jtfQtdPro, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jtfUnidadePro, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jtfPrecoPro, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jtfCodPro)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPrecoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfUnidadePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfQtdPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoPro)
                    .addComponent(btnExcluirPro)
                    .addComponent(btnSalvarPro)
                    .addComponent(btnCancelarPro)
                    .addComponent(btnEditarPro))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProActionPerformed
        setFormEnabled(true, false);
    }//GEN-LAST:event_btnNovoProActionPerformed

    private void btnEditarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProActionPerformed
        setFormEnabled(true, true);
    }//GEN-LAST:event_btnEditarProActionPerformed

    private void btnExcluirProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProActionPerformed
        int cod = Integer.parseInt(jtfCodPro.getText());
        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja mesmo excluir esse produto?",
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            produtoDao.deleteProduto(cod);
            loadProdutos();
            setFormEnabled(false, false);
        }
    }//GEN-LAST:event_btnExcluirProActionPerformed

    private void btnCancelarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProActionPerformed
        setFormEnabled(false, false);
    }//GEN-LAST:event_btnCancelarProActionPerformed

    private void btnSalvarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarProActionPerformed
        int cod = Integer.parseInt(jtfCodPro.getText());
        String desc = jtaDescPro.getText();
        String unidade = jtfUnidadePro.getText();
        float qtd = Float.parseFloat(jtfQtdPro.getText());
        float preco = Float.parseFloat(jtfPrecoPro.getText());
        Produto produto = new Produto(cod, desc, unidade, qtd, preco);
        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja mesmo salvar esse produto?",
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            if (newPro) {
                produtoDao.addProduto(produto);
            } else {
                produtoDao.updateProduto(produto);
            }
            loadProdutos();
            setFormEnabled(false, false);
        }
    }//GEN-LAST:event_btnSalvarProActionPerformed

    private void tblProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProMouseClicked
        if (!newPro) {
            selectedPro = tblPro.getSelectedRow();
            for (int i = 0; i < 5; i++) {
                if (inputs.get(i) instanceof JTextField) {
                    ((JTextField) inputs.get(i)).setText(tblPro.getValueAt(selectedPro, i).toString());
                } else if (inputs.get(i) instanceof JTextArea) {
                    ((JTextArea) inputs.get(i)).setText(tblPro.getValueAt(selectedPro, i).toString());
                }
            }
            btnEditarPro.setEnabled(true);
            btnExcluirPro.setEnabled(true);
        }
    }//GEN-LAST:event_tblProMouseClicked

    private void evtListenerInputs() {

        KeyListener keyRealesed = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                btnSalvarPro.setEnabled(isAllFilled());
            }
        };

        for (Object input : inputs) {
            if (input instanceof JTextField) {
                ((JTextField) input).addKeyListener(keyRealesed);
            } else if (input instanceof JTextArea) {
                ((JTextArea) input).addKeyListener(keyRealesed);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPro;
    private javax.swing.JButton btnEditarPro;
    private javax.swing.JButton btnExcluirPro;
    private javax.swing.JButton btnNovoPro;
    private javax.swing.JButton btnSalvarPro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaDescPro;
    private javax.swing.JTextField jtfCodPro;
    private javax.swing.JTextField jtfPrecoPro;
    private javax.swing.JTextField jtfQtdPro;
    private javax.swing.JTextField jtfUnidadePro;
    private javax.swing.JTable tblPro;
    // End of variables declaration//GEN-END:variables
}
