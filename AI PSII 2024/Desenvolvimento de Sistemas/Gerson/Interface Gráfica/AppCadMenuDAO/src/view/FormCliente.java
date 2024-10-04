/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.ClienteDao;
import dao.ClienteDaoImpl;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 *
 * @author lucas-gabreil_silva
 */
public class FormCliente extends javax.swing.JInternalFrame {

    public ArrayList<Object> inputs = new ArrayList<>();
    public boolean newCli = false;
    public int selectedCli;
    private ClienteDao clienteDao;

    public FormCliente() {
        clienteDao = new ClienteDaoImpl();
        initComponents();
        addInputsToTheList();
        evtListenerInputs();
        loadClientes();
    }

    private void loadClientes() {
        List<Cliente> clientes = clienteDao.getAllClientes();
        DefaultTableModel modelCli = new DefaultTableModel(new Object[]{
            "Código",
            "Nome",
            "Fone",
            "Email",
            "Endereço"}, 0);
        for (Cliente cliente : clientes) {
            Object linhaPro[] = new Object[]{
                cliente.getCod(),
                cliente.getNome(),
                cliente.getFone(),
                cliente.getEmail(),
                cliente.getEndereco()
            };
            modelCli.addRow(linhaPro);
        }
        tblCli.setModel(modelCli);
    }

    private void addInputsToTheList() {
        inputs.add(jtfCodCli);
        inputs.add(jtfNomeCli);
        inputs.add(jtfFoneCli);
        inputs.add(jtfEmailCli);
        inputs.add(jtaEnderecoCli);
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
            newCli = enabled;
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
            btnNovoCli.setEnabled(false);
            btnEditarCli.setEnabled(false);
            btnExcluirCli.setEnabled(false);
            btnCancelarCli.setEnabled(true);
            btnSalvarCli.setEnabled(editMode);

            jtfCodCli.setEnabled(false);
            if (!editMode) {
                jtfCodCli.setText(clienteDao.getNextCod() + "");
            }
        } else {
            btnNovoCli.setEnabled(true);
            btnEditarCli.setEnabled(false);
            btnExcluirCli.setEnabled(false);
            btnCancelarCli.setEnabled(false);
            btnSalvarCli.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCli = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfCodCli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNomeCli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfFoneCli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfEmailCli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaEnderecoCli = new javax.swing.JTextArea();
        btnNovoCli = new javax.swing.JButton();
        btnEditarCli = new javax.swing.JButton();
        btnExcluirCli = new javax.swing.JButton();
        btnCancelarCli = new javax.swing.JButton();
        btnSalvarCli = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setPreferredSize(new java.awt.Dimension(250, 250));
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Formulário - Cliente");
        setMinimumSize(new java.awt.Dimension(750, 550));

        tblCli.setModel(new javax.swing.table.DefaultTableModel(
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
                "Código", "Nome", "Fone", "Email", "Endereço"
            }
        ));
        tblCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCliMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCli);

        jLabel1.setText("Código:");

        jtfCodCli.setEnabled(false);

        jLabel2.setText("Nome:");

        jtfNomeCli.setEnabled(false);

        jLabel3.setText("Fone:");

        jtfFoneCli.setEnabled(false);

        jLabel4.setText("Email:");

        jtfEmailCli.setEnabled(false);

        jLabel5.setText("Endereço:");

        jtaEnderecoCli.setColumns(20);
        jtaEnderecoCli.setRows(5);
        jtaEnderecoCli.setEnabled(false);
        jScrollPane1.setViewportView(jtaEnderecoCli);

        btnNovoCli.setText("Novo");
        btnNovoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCliActionPerformed(evt);
            }
        });

        btnEditarCli.setText("Editar");
        btnEditarCli.setEnabled(false);
        btnEditarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCliActionPerformed(evt);
            }
        });

        btnExcluirCli.setText("Excluir");
        btnExcluirCli.setEnabled(false);
        btnExcluirCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCliActionPerformed(evt);
            }
        });

        btnCancelarCli.setText("Cancelar");
        btnCancelarCli.setEnabled(false);
        btnCancelarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCliActionPerformed(evt);
            }
        });

        btnSalvarCli.setText("Salvar");
        btnSalvarCli.setEnabled(false);
        btnSalvarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCliActionPerformed(evt);
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
                        .addComponent(btnNovoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnEditarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(btnExcluirCli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnCancelarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(btnSalvarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jtfEmailCli, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jtfFoneCli, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jtfNomeCli, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jtfCodCli)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)))
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
                        .addComponent(jtfCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoCli)
                    .addComponent(btnExcluirCli)
                    .addComponent(btnSalvarCli)
                    .addComponent(btnCancelarCli)
                    .addComponent(btnEditarCli))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCliActionPerformed
        setFormEnabled(true, false);
    }//GEN-LAST:event_btnNovoCliActionPerformed

    private void btnEditarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCliActionPerformed
        setFormEnabled(true, true);
    }//GEN-LAST:event_btnEditarCliActionPerformed

    private void btnExcluirCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCliActionPerformed
        int cod = Integer.parseInt(jtfCodCli.getText());
        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja mesmo excluir esse produto?",
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            clienteDao.deleteCliente(cod);
            loadClientes();
            setFormEnabled(false, false);
        }
    }//GEN-LAST:event_btnExcluirCliActionPerformed

    private void btnCancelarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCliActionPerformed
        setFormEnabled(false, false);
    }//GEN-LAST:event_btnCancelarCliActionPerformed

    private void btnSalvarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCliActionPerformed
        int cod = Integer.parseInt(jtfCodCli.getText());
        String nome = jtfNomeCli.getText();
        String fone = jtfFoneCli.getText();
        String email = jtfEmailCli.getText();
        String endereco = jtaEnderecoCli.getText();
        Cliente cliente = new Cliente(cod, nome, fone, email, endereco);
        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja mesmo salvar esse produto?",
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            if (newCli) {
                clienteDao.addCliente(cliente);
            } else {
                clienteDao.updateCliente(cliente);
            }
            loadClientes();
            setFormEnabled(false, false);
        }
    }//GEN-LAST:event_btnSalvarCliActionPerformed

    private void tblCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCliMouseClicked
        if (!newCli) {
            selectedCli = tblCli.getSelectedRow();
            for (int i = 0; i < 5; i++) {
                if (inputs.get(i) instanceof JTextField) {
                    ((JTextField) inputs.get(i)).setText(tblCli.getValueAt(selectedCli, i).toString());
                } else if (inputs.get(i) instanceof JTextArea) {
                    ((JTextArea) inputs.get(i)).setText(tblCli.getValueAt(selectedCli, i).toString());
                }
            }
            btnEditarCli.setEnabled(true);
            btnExcluirCli.setEnabled(true);
        }
    }//GEN-LAST:event_tblCliMouseClicked

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
                btnSalvarCli.setEnabled(isAllFilled());
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
    private javax.swing.JButton btnCancelarCli;
    private javax.swing.JButton btnEditarCli;
    private javax.swing.JButton btnExcluirCli;
    private javax.swing.JButton btnNovoCli;
    private javax.swing.JButton btnSalvarCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jtaEnderecoCli;
    private javax.swing.JTextField jtfCodCli;
    private javax.swing.JTextField jtfEmailCli;
    private javax.swing.JTextField jtfFoneCli;
    private javax.swing.JTextField jtfNomeCli;
    private javax.swing.JTable tblCli;
    // End of variables declaration//GEN-END:variables
}
