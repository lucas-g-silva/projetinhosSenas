/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.ClienteDao;
import dao.ClienteDaoImpl;
import dao.PedidoDao;
import dao.PedidoDaoImpl;
import dao.ProdutoDao;
import dao.ProdutoDaoImpl;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import model.Cliente;
import model.Pedido;
import model.Produto;

/**
 *
 * @author lucas-gabreil_silva
 */
public class FormPedido extends javax.swing.JInternalFrame {

    private ClienteDao clienteDao;
    private ProdutoDao produtoDao;
    private PedidoDao pedidoDao;

    private List<JCheckBox> checkBoxes = new ArrayList<>();
    private List<Cliente> clienteInput = new ArrayList<>();
    private List<Produto> produtoInput = new ArrayList<>();

    private List<Cliente> clientesTabela = new ArrayList<>();
    private List<List<Produto>> produtosTabela = new ArrayList<>();

    private boolean newPed = false;
    private int selectedPed;

    /**
     * Creates new form FormPedido
     */
    public FormPedido() {
        clienteDao = new ClienteDaoImpl();
        produtoDao = new ProdutoDaoImpl();
        pedidoDao = new PedidoDaoImpl();
        initComponents();
        loadInputs();
        loadPedidos();
    }

    private boolean isAllSelected() {
        boolean res = false;
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                res = true;
            }
        }
        return jcbClientePed.getSelectedIndex() != 0 && res;
    }

    private void loadPedidos() {
        clientesTabela = new ArrayList<>();
        produtosTabela = new ArrayList<>();
        List<Pedido> pedidos = pedidoDao.getAllPedidos();
        DefaultTableModel modelPed = new DefaultTableModel(new Object[]{
            "Código",
            "Data",
            "Cliente",
            "Produtos"}, 0);

        for (Pedido pedido : pedidos) {
            List<Integer> idProdutos = pedido.getIdProdutos();
            StringBuilder produtos = new StringBuilder();
            List<Produto> listaPro = new ArrayList<>();
            produtos.append("<html>");
            for (Integer id : idProdutos) {
                Produto produto = produtoDao.getProduto(id);
                listaPro.add(produto);
                produtos.append(produto.getDesc());
                produtos.append("<br>");
            }
            produtosTabela.add(listaPro);
            produtos.append("</html>");
            Cliente cliente = clienteDao.getCliente(pedido.getIdCliente());
            Object linhaPed[] = new Object[]{
                pedido.getCod(),
                pedido.getDataEmissao(),
                cliente.getNome(),
                produtos.toString(),};
            clientesTabela.add(cliente);
            modelPed.addRow(linhaPed);
        }

        tblPed.setModel(modelPed);

        resizeColumnWidthAndHeight(tblPed);
    }

    public void resizeColumnWidthAndHeight(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();

        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 70; // Largura mínima
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) { // Largura máxima
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }

        // Ajusta a altura das linhas
        for (int row = 0; row < table.getRowCount(); row++) {
            int rowHeight = table.getRowHeight(); // Altura atual
            for (int column = 0; column < table.getColumnCount(); column++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                rowHeight = Math.max(comp.getPreferredSize().height + 1, rowHeight);
            }
            table.setRowHeight(row, rowHeight); // Define a nova altura para a linha
        }
    }

    private void loadInputs() {
        List<Cliente> clientes = clienteDao.getAllClientes();
        for (Cliente cliente : clientes) {
            jcbClientePed.addItem(cliente.getCod() + " - " + cliente.getNome());
            clienteInput.add(cliente);
        }

        jpProdutosPed.setLayout(new BoxLayout(jpProdutosPed, BoxLayout.Y_AXIS));
        List<Produto> produtos = produtoDao.getAllProdutos();
        for (Produto produto : produtos) {
            int i = produtos.indexOf(produto);
            checkBoxes.add(new JCheckBox(produto.getDesc()));
            checkBoxes.get(i).setEnabled(false);
            checkBoxes.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnSalvarPed.setEnabled(isAllSelected());
                }
            });
            jpProdutosPed.add(checkBoxes.get(i));
            produtoInput.add(produto);
        }
    }

    private void setFormEnabled(boolean enabled) {
        newPed = enabled;
        jcbClientePed.setEnabled(enabled);
        jcbClientePed.setSelectedIndex(0);
        for (JCheckBox checkbox : checkBoxes) {
            checkbox.setEnabled(enabled);
            checkbox.setSelected(false);
        }
        if (enabled) {
            btnNovoPed.setEnabled(false);
            btnExcluirPed.setEnabled(false);
            btnCancelarPed.setEnabled(true);
            btnSalvarPed.setEnabled(false);

            long milis = System.currentTimeMillis();
            Date data = new Date(milis);
            jtfDataPed.setText(data.toString());
            jtfCodPed.setText(pedidoDao.getNextCod() + "");
        } else {
            btnNovoPed.setEnabled(true);
            btnExcluirPed.setEnabled(false);
            btnCancelarPed.setEnabled(false);
            btnSalvarPed.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblPed = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfCodPed = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfDataPed = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbClientePed = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpProdutosPed = new javax.swing.JPanel();
        btnNovoPed = new javax.swing.JButton();
        btnExcluirPed = new javax.swing.JButton();
        btnCancelarPed = new javax.swing.JButton();
        btnSalvarPed = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Formulário - Pedido");
        setMinimumSize(new java.awt.Dimension(750, 550));
        setPreferredSize(new java.awt.Dimension(750, 550));

        tblPed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Cliente", "Produtos"
            }
        ));
        tblPed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPed);

        jLabel1.setText("Código:");

        jtfCodPed.setEnabled(false);

        jLabel2.setText("Data de Emissão:");

        jtfDataPed.setEnabled(false);

        jLabel3.setText("Cliente:");

        jcbClientePed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jcbClientePed.setEnabled(false);
        jcbClientePed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClientePedActionPerformed(evt);
            }
        });

        jLabel4.setText("Produtos:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jpProdutosPed.setDoubleBuffered(false);

        javax.swing.GroupLayout jpProdutosPedLayout = new javax.swing.GroupLayout(jpProdutosPed);
        jpProdutosPed.setLayout(jpProdutosPedLayout);
        jpProdutosPedLayout.setHorizontalGroup(
            jpProdutosPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        jpProdutosPedLayout.setVerticalGroup(
            jpProdutosPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jpProdutosPed);

        btnNovoPed.setText("Novo");
        btnNovoPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPedActionPerformed(evt);
            }
        });

        btnExcluirPed.setText("Excluir");
        btnExcluirPed.setEnabled(false);
        btnExcluirPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPedActionPerformed(evt);
            }
        });

        btnCancelarPed.setText("Cancelar");
        btnCancelarPed.setEnabled(false);
        btnCancelarPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPedActionPerformed(evt);
            }
        });

        btnSalvarPed.setText("Salvar");
        btnSalvarPed.setEnabled(false);
        btnSalvarPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovoPed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(btnExcluirPed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(btnCancelarPed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(btnSalvarPed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfDataPed, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jcbClientePed, javax.swing.GroupLayout.Alignment.LEADING, 0, 239, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfCodPed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfCodPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDataPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbClientePed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoPed)
                    .addComponent(btnExcluirPed)
                    .addComponent(btnSalvarPed)
                    .addComponent(btnCancelarPed))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPedActionPerformed
        setFormEnabled(true);
    }//GEN-LAST:event_btnNovoPedActionPerformed

    private void btnExcluirPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPedActionPerformed
        int cod = Integer.parseInt(jtfCodPed.getText());
        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja mesmo excluir esse pedido?",
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            pedidoDao.deletePedido(cod);
            loadPedidos();
            setFormEnabled(false);
        }
    }//GEN-LAST:event_btnExcluirPedActionPerformed

    private void btnCancelarPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedActionPerformed
        setFormEnabled(false);
    }//GEN-LAST:event_btnCancelarPedActionPerformed

    private void btnSalvarPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPedActionPerformed
        int cod = Integer.parseInt(jtfCodPed.getText());
        Date data = Date.valueOf(jtfDataPed.getText());
        int idCli = clienteInput.get(jcbClientePed.getSelectedIndex() - 1).getCod();
        List<Integer> idProdutos = new ArrayList<>();
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                idProdutos.add(produtoInput.get(checkBoxes.indexOf(checkBox)).getCod());
            }
        }
        Pedido pedido = new Pedido(cod, data, idCli, idProdutos);
        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja mesmo salvar esse produto?",
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            pedidoDao.addPedido(pedido);
            loadPedidos();
            setFormEnabled(false);
        }
    }//GEN-LAST:event_btnSalvarPedActionPerformed

    private void jcbClientePedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClientePedActionPerformed
        btnSalvarPed.setEnabled(isAllSelected());
    }//GEN-LAST:event_jcbClientePedActionPerformed

    private void tblPedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedMouseClicked
        if (!newPed) {
            selectedPed = tblPed.getSelectedRow();
            jtfCodPed.setText(tblPed.getValueAt(selectedPed, 0).toString());
            jtfDataPed.setText(tblPed.getValueAt(selectedPed, 1).toString());
            int indexCli = 0;
            for (Cliente cli : clienteInput) {
                if (isItTheSameCliente(cli, clientesTabela.get(selectedPed))) {
                    indexCli = clienteInput.indexOf(cli);
                }
            }
            
            for (JCheckBox checkBox : checkBoxes){
                checkBox.setSelected(false);
            }
            
            for (Produto pro : produtosTabela.get(selectedPed)) {
                for(Produto proInput : produtoInput){
                    if(isItTheSameProduto(pro, proInput)){
                        checkBoxes.get(produtoInput.indexOf(proInput)).setSelected(true);
                    }
                }
            }

            jcbClientePed.setSelectedIndex(indexCli + 1);
            btnExcluirPed.setEnabled(true);
        }
    }//GEN-LAST:event_tblPedMouseClicked

    private boolean isItTheSameCliente(Cliente cli1, Cliente cli2) {
        return cli1.getCod() == cli2.getCod();
    }
    
    private boolean isItTheSameProduto(Produto pro1, Produto pro2) {
        return pro1.getCod() == pro2.getCod();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPed;
    private javax.swing.JButton btnExcluirPed;
    private javax.swing.JButton btnNovoPed;
    private javax.swing.JButton btnSalvarPed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jcbClientePed;
    private javax.swing.JPanel jpProdutosPed;
    private javax.swing.JTextField jtfCodPed;
    private javax.swing.JTextField jtfDataPed;
    private javax.swing.JTable tblPed;
    // End of variables declaration//GEN-END:variables
}
