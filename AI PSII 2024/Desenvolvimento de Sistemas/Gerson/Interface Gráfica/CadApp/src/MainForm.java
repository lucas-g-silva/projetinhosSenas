
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author lucas-gabreil_silva
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    
    public static ArrayList<Cliente> listaCliente;
    public static ArrayList<Produto> listaProduto;
    public static ArrayList<Fornecedor> listaFornecedor;
    
    public void tblCliente(){
        DefaultTableModel modelCli = new DefaultTableModel(new Object[]{
            "Código",
            "Nome",
            "Email",
            "Telefone",
            "Endereço"}, 0);
        for (int i = 0; i < listaCliente.size(); i++){
            Object linhaCli[] = new Object[]{
                listaCliente.get(i).getCod(),
                listaCliente.get(i).getNome(),
                listaCliente.get(i).getEmail(),
                listaCliente.get(i).getFone(),
                listaCliente.get(i).getEndereco()
            };
            modelCli.addRow(linhaCli);
        }
        jTbCli.setModel(modelCli);
        jTbCli.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTbCli.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTbCli.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTbCli.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTbCli.getColumnModel().getColumn(4).setPreferredWidth(80);
    }
    
    public void tblProduto(){
        DefaultTableModel modelPro = new DefaultTableModel(new Object[]{
            "Código",
            "Preço",
            "Quantidade",
            "Unidade",
            "Descrição"}, 0);
        for (int i = 0; i < listaProduto.size(); i++){
            Object linhaPro[] = new Object[]{
                listaProduto.get(i).getCod(),
                listaProduto.get(i).getPreco(),
                listaProduto.get(i).getQtd(),
                listaProduto.get(i).getUnidade(),
                listaProduto.get(i).getDesc()
            };
            modelPro.addRow(linhaPro);
        }
        jTbPro.setModel(modelPro);
        jTbPro.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTbPro.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTbPro.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTbPro.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTbPro.getColumnModel().getColumn(4).setPreferredWidth(250);
    }
    public void tblFornecedor(){
        DefaultTableModel modelFor = new DefaultTableModel(new Object[]{
            "Código",
            "Contato",
            "Telefone",
            "Email",
            "Empresa"}, 0);
        for (int i = 0; i < listaFornecedor.size(); i++){
            Object linhaFor[] = new Object[]{
                listaFornecedor.get(i).getCod(),
                listaFornecedor.get(i).getContato(),
                listaFornecedor.get(i).getFone(),
                listaFornecedor.get(i).getEmail(),
                listaFornecedor.get(i).getEmpresa()
            };
            modelFor.addRow(linhaFor);
        }
        JTbFor.setModel(modelFor);
        JTbFor.getColumnModel().getColumn(0).setPreferredWidth(50);
        JTbFor.getColumnModel().getColumn(1).setPreferredWidth(100);
        JTbFor.getColumnModel().getColumn(2).setPreferredWidth(100);
        JTbFor.getColumnModel().getColumn(3).setPreferredWidth(120);
        JTbFor.getColumnModel().getColumn(4).setPreferredWidth(170);
    }
    
    public static void saveCli(){
        String fileCli = "cliente.db";
        String lineCli = "";
        
        for (int i = 0; i < listaCliente.size(); i++){
            lineCli += listaCliente.get(i).getCod() + ";"
                     + listaCliente.get(i).getNome()+ ";"
                     + listaCliente.get(i).getFone()+ ";"
                     + listaCliente.get(i).getEmail()+ ";"
                     + listaCliente.get(i).getEndereco()+ ";";
        }
        
        if(Arquivo.write(fileCli, lineCli)){
            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo!");
        }
    }
    
    public static void savePro(){
        String filePro = "produto.db";
        String linePro = "";
        
        for (int i = 0; i < listaProduto.size(); i++){
            linePro += listaProduto.get(i).getCod() + ";"
                     + listaProduto.get(i).getPreco()+ ";"
                     + listaProduto.get(i).getQtd()+ ";"
                     + listaProduto.get(i).getUnidade()+ ";"
                     + listaProduto.get(i).getDesc()+ ";";
        }
        
        if(Arquivo.write(filePro, linePro)){
            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo!");
        }
    }
    
    public static void saveFor(){
        String fileFor = "fornecedor.db";
        String lineFor = "";
        
        for (int i = 0; i < listaFornecedor.size(); i++){
            lineFor += listaFornecedor.get(i).getCod() + ";"
                     + listaFornecedor.get(i).getContato()+ ";"
                     + listaFornecedor.get(i).getFone()+ ";"
                     + listaFornecedor.get(i).getEmail()+ ";"
                     + listaFornecedor.get(i).getEmpresa()+ ";";
        }
        
        if(Arquivo.write(fileFor, lineFor)){
            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo!");
        }
    }
    
    public static void loadCli(){
        String fileCli = "cliente.db";
        String content = Arquivo.read(fileCli);
        
        if(content.isEmpty()){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!");
        } else {
            String[] lineCli = content.split("\n");
            String[] dataCli;
            
            for (int i = 0; i < lineCli.length; i++){
                dataCli = lineCli[i].split(";");
                Cliente cli = new Cliente();
                cli.setCod(Integer.parseInt(dataCli[0]));
                cli.setNome(dataCli[1]);
                cli.setFone(dataCli[2]);
                cli.setEmail(dataCli[3]);
                cli.setEndereco(dataCli[4]);
                listaCliente.add(cli);
            }
        }
    }
    
    public static void loadPro(){
        String filePro = "produto.db";
        String content = Arquivo.read(filePro);
        
        if(content.isEmpty()){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!");
        } else {
            String[] linePro = content.split("\n");
            String[] dataPro;
            
            for (int i = 0; i < linePro.length; i++){
                dataPro = linePro[i].split(";");
                Produto pro = new Produto();
                pro.setCod(Integer.parseInt(dataPro[0]));
                pro.setPreco(Float.parseFloat(dataPro[1]));
                pro.setQtd(Integer.parseInt(dataPro[2]));
                pro.setUnidade(dataPro[3]);
                pro.setDesc(dataPro[4]);
                listaProduto.add(pro);
            }
        }
    }
    
    public static void loadFor(){
        String fileFor = "fornecedor.db";
        String content = Arquivo.read(fileFor);
        
        if(content.isEmpty()){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!");
        } else {
            String[] lineFor = content.split("\n");
            String[] dataFor;
            
            for (int i = 0; i < lineFor.length; i++){
                dataFor = lineFor[i].split(";");
                Fornecedor forn = new Fornecedor();
                forn.setCod(Integer.parseInt(dataFor[0]));
                forn.setContato(dataFor[1]);
                forn.setFone(dataFor[2]);
                forn.setEmail(dataFor[3]);
                forn.setEmpresa(dataFor[4]);
                listaFornecedor.add(forn);
            }
        }
    }
    
    public MainForm() {
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

        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpnCli = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbCli = new javax.swing.JTable();
        formCli = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfCodCli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfNameCli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfEmailCli = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtfPhoneCli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtaAddressCli = new javax.swing.JTextArea();
        btnNewCli = new javax.swing.JButton();
        btnEditCli = new javax.swing.JButton();
        btnDelCli = new javax.swing.JButton();
        btnCancelCli = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jpnPro = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTbPro = new javax.swing.JTable();
        formPro = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jtfCodPro = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtfPricePro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jtfQtdPro = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtfUntPro = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtaDescPro = new javax.swing.JTextArea();
        brnNewPro = new javax.swing.JButton();
        btnEditPro = new javax.swing.JButton();
        btnDelPro = new javax.swing.JButton();
        btnCacelPro = new javax.swing.JButton();
        btnSavePro = new javax.swing.JButton();
        jpnFor = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTbFor = new javax.swing.JTable();
        formFor = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jtfCodFor = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jtfContFor = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jtfPhoneFor = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jtfEmailFor = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jtfCompFor = new javax.swing.JTextField();
        btnNewFor = new javax.swing.JButton();
        btnEditFor = new javax.swing.JButton();
        btnDelFor = new javax.swing.JButton();
        btnCancelFor = new javax.swing.JButton();
        btnSaveFor = new javax.swing.JButton();

        jLabel9.setText("Descrção:");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro");

        jTbCli.setModel(new javax.swing.table.DefaultTableModel(
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
                "Código", "Nome", "Email", "Telefone", "Endereço"
            }
        ));
        jScrollPane1.setViewportView(jTbCli);

        formCli.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código:");

        jtfCodCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodCliActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome:");

        jLabel2.setText("Email:");

        jLabel16.setText("Telefone:");

        jLabel3.setText("Endereço:");

        jtaAddressCli.setColumns(20);
        jtaAddressCli.setRows(5);
        jScrollPane4.setViewportView(jtaAddressCli);

        btnNewCli.setText("Novo");
        btnNewCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCliActionPerformed(evt);
            }
        });

        btnEditCli.setText("Editar");

        btnDelCli.setText("Excluir");

        btnCancelCli.setText("Cancelar");
        btnCancelCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelCliActionPerformed(evt);
            }
        });

        jButton6.setText("Salvar");

        javax.swing.GroupLayout formCliLayout = new javax.swing.GroupLayout(formCli);
        formCli.setLayout(formCliLayout);
        formCliLayout.setHorizontalGroup(
            formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formCliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(formCliLayout.createSequentialGroup()
                        .addGroup(formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtfEmailCli))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jtfPhoneCli)))
                    .addGroup(formCliLayout.createSequentialGroup()
                        .addGroup(formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jtfCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jtfNameCli)))
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditCli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewCli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelCli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        formCliLayout.setVerticalGroup(
            formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formCliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNameCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewCli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formCliLayout.createSequentialGroup()
                        .addGroup(formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPhoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                    .addGroup(formCliLayout.createSequentialGroup()
                        .addComponent(btnEditCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnCliLayout = new javax.swing.GroupLayout(jpnCli);
        jpnCli.setLayout(jpnCliLayout);
        jpnCliLayout.setHorizontalGroup(
            jpnCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(formCli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnCliLayout.setVerticalGroup(
            jpnCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cliente", jpnCli);

        jTbPro.setModel(new javax.swing.table.DefaultTableModel(
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
                "Código", "Preço", "Quantidade", "Unidade", "Descrição"
            }
        ));
        jScrollPane2.setViewportView(jTbPro);

        formPro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setText("Código:");

        jtfCodPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodProActionPerformed(evt);
            }
        });

        jLabel18.setText("Preco:");

        jLabel20.setText("Quantidade:");

        jLabel19.setText("Unidade:");

        jLabel21.setText("Descrição:");

        jtaDescPro.setColumns(20);
        jtaDescPro.setRows(5);
        jScrollPane5.setViewportView(jtaDescPro);

        brnNewPro.setText("Novo");
        brnNewPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnNewProActionPerformed(evt);
            }
        });

        btnEditPro.setText("Editar");

        btnDelPro.setText("Excluir");

        btnCacelPro.setText("Cancelar");

        btnSavePro.setText("Salvar");

        javax.swing.GroupLayout formProLayout = new javax.swing.GroupLayout(formPro);
        formPro.setLayout(formProLayout);
        formProLayout.setHorizontalGroup(
            formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formProLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(formProLayout.createSequentialGroup()
                        .addGroup(formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jtfQtdPro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jtfUntPro)))
                    .addComponent(jLabel21)
                    .addGroup(formProLayout.createSequentialGroup()
                        .addGroup(formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jtfCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPricePro)
                            .addGroup(formProLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(6, 6, 6)
                .addGroup(formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCacelPro, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(btnDelPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brnNewPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSavePro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        formProLayout.setVerticalGroup(
            formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formProLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formProLayout.createSequentialGroup()
                        .addGroup(formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPricePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfQtdPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfUntPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                    .addGroup(formProLayout.createSequentialGroup()
                        .addComponent(brnNewPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCacelPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSavePro)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnProLayout = new javax.swing.GroupLayout(jpnPro);
        jpnPro.setLayout(jpnProLayout);
        jpnProLayout.setHorizontalGroup(
            jpnProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnProLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(formPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnProLayout.setVerticalGroup(
            jpnProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnProLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Produto", jpnPro);

        JTbFor.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Contato", "Telefone", "Email", "Empresa"
            }
        ));
        jScrollPane3.setViewportView(JTbFor);

        formFor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setText("Código:");

        jtfCodFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodForActionPerformed(evt);
            }
        });

        jLabel23.setText("Contato:");

        jtfContFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfContForActionPerformed(evt);
            }
        });

        jLabel24.setText("Telefone:");

        jLabel25.setText("Email:");

        jLabel26.setText("Empresa:");

        jtfCompFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCompForActionPerformed(evt);
            }
        });

        btnNewFor.setText("Novo");
        btnNewFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewForActionPerformed(evt);
            }
        });

        btnEditFor.setText("Editar");

        btnDelFor.setText("Excluir");

        btnCancelFor.setText("Cancelar");

        btnSaveFor.setText("Salvar");

        javax.swing.GroupLayout formForLayout = new javax.swing.GroupLayout(formFor);
        formFor.setLayout(formForLayout);
        formForLayout.setHorizontalGroup(
            formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formForLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formForLayout.createSequentialGroup()
                        .addGroup(formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jtfPhoneFor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jtfEmailFor)))
                    .addComponent(jtfCompFor)
                    .addGroup(formForLayout.createSequentialGroup()
                        .addGroup(formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCodFor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formForLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtfContFor))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveFor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelFor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelFor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditFor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewFor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        formForLayout.setVerticalGroup(
            formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formForLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formForLayout.createSequentialGroup()
                        .addGroup(formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCodFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfContFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPhoneFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfEmailFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCompFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formForLayout.createSequentialGroup()
                        .addComponent(btnNewFor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditFor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelFor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelFor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveFor)))
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout jpnForLayout = new javax.swing.GroupLayout(jpnFor);
        jpnFor.setLayout(jpnForLayout);
        jpnForLayout.setHorizontalGroup(
            jpnForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnForLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(formFor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnForLayout.setVerticalGroup(
            jpnForLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnForLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formFor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Fornecedor", jpnFor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCodCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodCliActionPerformed

    private void btnNewCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewCliActionPerformed

    private void jtfCodProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodProActionPerformed

    private void brnNewProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnNewProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brnNewProActionPerformed

    private void jtfCodForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodForActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodForActionPerformed

    private void jtfCompForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCompForActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCompForActionPerformed

    private void btnNewForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewForActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewForActionPerformed

    private void btnCancelCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelCliActionPerformed

    private void jtfContForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfContForActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfContForActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTbFor;
    private javax.swing.JButton brnNewPro;
    private javax.swing.JButton btnCacelPro;
    private javax.swing.JButton btnCancelCli;
    private javax.swing.JButton btnCancelFor;
    private javax.swing.JButton btnDelCli;
    private javax.swing.JButton btnDelFor;
    private javax.swing.JButton btnDelPro;
    private javax.swing.JButton btnEditCli;
    private javax.swing.JButton btnEditFor;
    private javax.swing.JButton btnEditPro;
    private javax.swing.JButton btnNewCli;
    private javax.swing.JButton btnNewFor;
    private javax.swing.JButton btnSaveFor;
    private javax.swing.JButton btnSavePro;
    private javax.swing.JPanel formCli;
    private javax.swing.JPanel formFor;
    private javax.swing.JPanel formPro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTbCli;
    private javax.swing.JTable jTbPro;
    private javax.swing.JPanel jpnCli;
    private javax.swing.JPanel jpnFor;
    private javax.swing.JPanel jpnPro;
    private javax.swing.JTextArea jtaAddressCli;
    private javax.swing.JTextArea jtaDescPro;
    private javax.swing.JTextField jtfCodCli;
    private javax.swing.JTextField jtfCodFor;
    private javax.swing.JTextField jtfCodPro;
    private javax.swing.JTextField jtfCompFor;
    private javax.swing.JTextField jtfContFor;
    private javax.swing.JTextField jtfEmailCli;
    private javax.swing.JTextField jtfEmailFor;
    private javax.swing.JTextField jtfNameCli;
    private javax.swing.JTextField jtfPhoneCli;
    private javax.swing.JTextField jtfPhoneFor;
    private javax.swing.JTextField jtfPricePro;
    private javax.swing.JTextField jtfQtdPro;
    private javax.swing.JTextField jtfUntPro;
    // End of variables declaration//GEN-END:variables
}
