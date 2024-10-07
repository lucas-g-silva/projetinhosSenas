/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.FornecedorDao;
import dao.FornecedorDaoImpl;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import model.Fornecedor;

/**
 *
 * @author lucas-gabreil_silva
 */
public class FormFornecedor extends javax.swing.JInternalFrame {

    public ArrayList<Object> inputs = new ArrayList<>();
    public boolean newFor = false;
    public int selectedFor;
    private FornecedorDao fornecedorDao;

    public FormFornecedor() {
        fornecedorDao = new FornecedorDaoImpl();
        initComponents();
        addInputsToTheList();
        evtListenerInputs();
        loadClientes();
    }

    private void loadClientes() {
        List<Fornecedor> fornecedores = fornecedorDao.getAllFornecedores();
        DefaultTableModel modelFor = new DefaultTableModel(new Object[]{
            "Código",
            "Contato",
            "Email",
            "Fone",
            "Empresa"}, 0);
        for (Fornecedor fornecedor : fornecedores) {
            Object linhaPro[] = new Object[]{
                fornecedor.getCod(),
                fornecedor.getContato(),
                fornecedor.getEmail(),
                fornecedor.getFone(),
                fornecedor.getEmpresa()
            };
            modelFor.addRow(linhaPro);
        }
        tblFor.setModel(modelFor);
        resizeColumnWidth(tblFor);
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 70; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void addInputsToTheList() {
        inputs.add(jtfCodFor);
        inputs.add(jtfContatoFor);
        inputs.add(jtfEmailFor);
        inputs.add(jtfFoneFor);
        inputs.add(jtaEmpresaFor);
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
            newFor = enabled;
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
            btnNovoFor.setEnabled(false);
            btnEditarFor.setEnabled(false);
            btnExcluirFor.setEnabled(false);
            btnCancelarFor.setEnabled(true);
            btnSalvarFor.setEnabled(editMode);

            jtfCodFor.setEnabled(false);
            if (!editMode) {
                jtfCodFor.setText(fornecedorDao.getNextCod() + "");
            }
        } else {
            btnNovoFor.setEnabled(true);
            btnEditarFor.setEnabled(false);
            btnExcluirFor.setEnabled(false);
            btnCancelarFor.setEnabled(false);
            btnSalvarFor.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblFor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfCodFor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfContatoFor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfEmailFor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfFoneFor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtaEmpresaFor = new javax.swing.JTextArea();
        btnNovoFor = new javax.swing.JButton();
        btnEditarFor = new javax.swing.JButton();
        btnExcluirFor = new javax.swing.JButton();
        btnCancelarFor = new javax.swing.JButton();
        btnSalvarFor = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Formulário - Fornecedor");
        setMinimumSize(new java.awt.Dimension(750, 550));
        setName(""); // NOI18N

        tblFor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Contato", "E-mail", "Telefone", "Empresa"
            }
        ));
        tblFor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblForMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblFor);

        jLabel1.setText("Código:");

        jtfCodFor.setToolTipText("");
        jtfCodFor.setEnabled(false);

        jLabel2.setText("Contato:");

        jtfContatoFor.setToolTipText("");
        jtfContatoFor.setEnabled(false);

        jLabel3.setText("Email:");

        jtfEmailFor.setToolTipText("");
        jtfEmailFor.setEnabled(false);

        jLabel4.setText("Fone:");

        jtfFoneFor.setToolTipText("");
        jtfFoneFor.setEnabled(false);

        jLabel5.setText("Empresa");

        jtaEmpresaFor.setColumns(20);
        jtaEmpresaFor.setLineWrap(true);
        jtaEmpresaFor.setRows(5);
        jtaEmpresaFor.setToolTipText("");
        jtaEmpresaFor.setWrapStyleWord(true);
        jtaEmpresaFor.setBorder(jtfCodFor.getBorder());
        jtaEmpresaFor.setEnabled(false);

        btnNovoFor.setText("Novo");
        btnNovoFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoForActionPerformed(evt);
            }
        });

        btnEditarFor.setText("Editar");
        btnEditarFor.setToolTipText("");
        btnEditarFor.setEnabled(false);
        btnEditarFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarForActionPerformed(evt);
            }
        });

        btnExcluirFor.setText("Excluir");
        btnExcluirFor.setToolTipText("");
        btnExcluirFor.setEnabled(false);
        btnExcluirFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirForActionPerformed(evt);
            }
        });

        btnCancelarFor.setText("Cancelar");
        btnCancelarFor.setToolTipText("");
        btnCancelarFor.setEnabled(false);
        btnCancelarFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarForActionPerformed(evt);
            }
        });

        btnSalvarFor.setText("Salvar");
        btnSalvarFor.setToolTipText("");
        btnSalvarFor.setEnabled(false);
        btnSalvarFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarForActionPerformed(evt);
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
                        .addComponent(btnNovoFor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnEditarFor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(btnExcluirFor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnCancelarFor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(btnSalvarFor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jtfFoneFor)
                            .addComponent(jLabel4)
                            .addComponent(jtfEmailFor)
                            .addComponent(jLabel3)
                            .addComponent(jtfContatoFor)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jtfCodFor)
                            .addComponent(jtaEmpresaFor))
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
                        .addComponent(jtfCodFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfContatoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfEmailFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFoneFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtaEmpresaFor, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoFor)
                    .addComponent(btnExcluirFor)
                    .addComponent(btnSalvarFor)
                    .addComponent(btnCancelarFor)
                    .addComponent(btnEditarFor))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoForActionPerformed
        setFormEnabled(true, false);
    }//GEN-LAST:event_btnNovoForActionPerformed

    private void btnEditarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarForActionPerformed
        setFormEnabled(true, true);
    }//GEN-LAST:event_btnEditarForActionPerformed

    private void btnExcluirForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirForActionPerformed
        int cod = Integer.parseInt(jtfCodFor.getText());
        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja mesmo excluir esse produto?",
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            fornecedorDao.deleteFornecedor(cod);
            loadClientes();
            setFormEnabled(false, false);
        }
    }//GEN-LAST:event_btnExcluirForActionPerformed

    private void btnCancelarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarForActionPerformed
        setFormEnabled(false, false);
    }//GEN-LAST:event_btnCancelarForActionPerformed

    private void btnSalvarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarForActionPerformed
        int cod = Integer.parseInt(jtfCodFor.getText());
        String contato = jtfContatoFor.getText();
        String email = jtfEmailFor.getText();
        String fone = jtfFoneFor.getText();
        String empresa = jtaEmpresaFor.getText();
        Fornecedor fornecedor = new Fornecedor(cod, empresa, contato, fone, email);
        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja mesmo salvar esse produto?",
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            if (newFor) {
                fornecedorDao.addFornecedor(fornecedor);
            } else {
                fornecedorDao.updateFornecedor(fornecedor);
            }
            loadClientes();
            setFormEnabled(false, false);
        }
    }//GEN-LAST:event_btnSalvarForActionPerformed

    private void tblForMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblForMouseClicked
        if (!newFor) {
            selectedFor = tblFor.getSelectedRow();
            for (int i = 0; i < 5; i++) {
                if (inputs.get(i) instanceof JTextField) {
                    ((JTextField) inputs.get(i)).setText(tblFor.getValueAt(selectedFor, i).toString());
                } else if (inputs.get(i) instanceof JTextArea) {
                    ((JTextArea) inputs.get(i)).setText(tblFor.getValueAt(selectedFor, i).toString());
                }
            }
            btnEditarFor.setEnabled(true);
            btnExcluirFor.setEnabled(true);
        }
    }//GEN-LAST:event_tblForMouseClicked

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
                btnSalvarFor.setEnabled(isAllFilled());
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
    private javax.swing.JButton btnCancelarFor;
    private javax.swing.JButton btnEditarFor;
    private javax.swing.JButton btnExcluirFor;
    private javax.swing.JButton btnNovoFor;
    private javax.swing.JButton btnSalvarFor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaEmpresaFor;
    private javax.swing.JTextField jtfCodFor;
    private javax.swing.JTextField jtfContatoFor;
    private javax.swing.JTextField jtfEmailFor;
    private javax.swing.JTextField jtfFoneFor;
    private javax.swing.JTable tblFor;
    // End of variables declaration//GEN-END:variables
}
