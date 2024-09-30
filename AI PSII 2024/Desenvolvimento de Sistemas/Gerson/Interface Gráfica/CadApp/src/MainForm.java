
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 * @author lucas-gabreil_silva
 */
public class MainForm extends javax.swing.JFrame {

    public static int selectedCli;
    public static int selectedPro;
    public static int selectedFor;

    public static boolean newCli = false;
    public static boolean newPro = false;
    public static boolean newFor = false;

    public static ArrayList<Cliente> listaCliente;
    public static ArrayList<Produto> listaProduto;
    public static ArrayList<Fornecedor> listaFornecedor;

    //<editor-fold defaultstate="collapsed" desc="Funções Tabela">
    //Funções que preenchem as tabelas
    public void tblCliente() {
        DefaultTableModel modelCli = new DefaultTableModel(new Object[]{
            "Código",
            "Nome",
            "Email",
            "Telefone",
            "Endereço"}, 0);
        for (int i = 0; i < listaCliente.size(); i++) {
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

    public void tblProduto() {
        DefaultTableModel modelPro = new DefaultTableModel(new Object[]{
            "Código",
            "Preço",
            "Quantidade",
            "Unidade",
            "Descrição"}, 0);
        for (int i = 0; i < listaProduto.size(); i++) {
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

    public void tblFornecedor() {
        DefaultTableModel modelFor = new DefaultTableModel(new Object[]{
            "Código",
            "Contato",
            "Telefone",
            "Email",
            "Empresa"}, 0);
        for (int i = 0; i < listaFornecedor.size(); i++) {
            Object linhaFor[] = new Object[]{
                listaFornecedor.get(i).getCod(),
                listaFornecedor.get(i).getContato(),
                listaFornecedor.get(i).getFone(),
                listaFornecedor.get(i).getEmail(),
                listaFornecedor.get(i).getEmpresa()
            };
            modelFor.addRow(linhaFor);
        }
        jTbFor.setModel(modelFor);
        jTbFor.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTbFor.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTbFor.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTbFor.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTbFor.getColumnModel().getColumn(4).setPreferredWidth(170);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Funções Salvar Arquivo">
    //Funções que salvam as informaçoes no arquivo
    public static void saveCli() {
        String fileCli = "cliente.db";
        String lineCli = "";

        for (int i = 0; i < listaCliente.size(); i++) {
            lineCli += listaCliente.get(i).getCod() + ";"
                    + listaCliente.get(i).getNome() + ";"
                    + listaCliente.get(i).getFone() + ";"
                    + listaCliente.get(i).getEmail() + ";"
                    + listaCliente.get(i).getEndereco() + "\n";
        }

        if (Arquivo.write(fileCli, lineCli)) {
            JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo!");
        }
    }

    public static void savePro() {
        String filePro = "produto.db";
        String linePro = "";

        for (int i = 0; i < listaProduto.size(); i++) {
            linePro += listaProduto.get(i).getCod() + ";"
                    + listaProduto.get(i).getPreco() + ";"
                    + listaProduto.get(i).getQtd() + ";"
                    + listaProduto.get(i).getUnidade() + ";"
                    + listaProduto.get(i).getDesc() + "\n";
        }

        if (Arquivo.write(filePro, linePro)) {
            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo!");
        }
    }

    public static void saveFor() {
        String fileFor = "fornecedor.db";
        String lineFor = "";

        for (int i = 0; i < listaFornecedor.size(); i++) {
            lineFor += listaFornecedor.get(i).getCod() + ";"
                    + listaFornecedor.get(i).getContato() + ";"
                    + listaFornecedor.get(i).getFone() + ";"
                    + listaFornecedor.get(i).getEmail() + ";"
                    + listaFornecedor.get(i).getEmpresa() + "\n";
        }

        if (Arquivo.write(fileFor, lineFor)) {
            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na gravação do arquivo!");
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Funções Carregar Arquivo">
    //Funções que carregam as informações do arquivo
    public static void loadCli() {
        String fileCli = "cliente.db";
        String content = Arquivo.read(fileCli);

        if (content.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!");
        } else {
            String[] lineCli = content.split("\n");
            String[] dataCli;

            for (int i = 0; i < lineCli.length; i++) {
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

    public static void loadPro() {
        String filePro = "produto.db";
        String content = Arquivo.read(filePro);

        if (content.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!");
        } else {
            String[] linePro = content.split("\n");
            String[] dataPro;

            for (int i = 0; i < linePro.length; i++) {
                dataPro = linePro[i].split(";");
                Produto pro = new Produto();
                pro.setCod(Integer.parseInt(dataPro[0]));
                pro.setPreco(Float.parseFloat(dataPro[1]));
                pro.setQtd(Float.parseFloat(dataPro[2]));
                pro.setUnidade(dataPro[3]);
                pro.setDesc(dataPro[4]);
                listaProduto.add(pro);
            }
        }
    }

    public static void loadFor() {
        String fileFor = "fornecedor.db";
        String content = Arquivo.read(fileFor);

        if (content.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!");
        } else {
            String[] lineFor = content.split("\n");
            String[] dataFor;

            for (int i = 0; i < lineFor.length; i++) {
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
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Funções Verificação de Inputs">
    //Funções que verificam se todos os campos estão preenchidos nos formulários
    public boolean isAllFilledCli() {
        boolean response = !jtfCodCli.getText().isBlank() && !jtfNameCli.getText().isBlank()
                && !jtfEmailCli.getText().isBlank() && !jtfPhoneCli.getText().isBlank()
                && !jtaAddressCli.getText().isBlank();
        return response;
    }

    public boolean isAllFilledPro() {
        boolean response = !jtfCodPro.getText().isBlank() && !jtfPricePro.getText().isBlank()
                && !jtfUntPro.getText().isBlank() && !jtfQtdPro.getText().isBlank()
                && !jtaDescPro.getText().isBlank();
        return response;
    }

    public boolean isAllFilledFor() {
        boolean response = !jtfCodPro.getText().isBlank() && !jtfCompFor.getText().isBlank()
                && !jtfContFor.getText().isBlank() && !jtfEmailFor.getText().isBlank()
                && !jtfPhoneFor.getText().isBlank();
        return response;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Funções Ativação Formulário">
    //Funções que ativam / desativam os campos dos formulários
    public void setCliForm(boolean b, boolean editMode) {
        jtfCodCli.setEnabled(b);
        jtfCodCli.requestFocus();
        jtfNameCli.setEnabled(b);
        jtfEmailCli.setEnabled(b);
        jtfPhoneCli.setEnabled(b);
        jtaAddressCli.setEnabled(b);
        btnCancelCli.setEnabled(b);
        btnNewCli.setEnabled(!b);

        if (!editMode) {
            newCli = b;
            jtfCodCli.setText("");
            jtfNameCli.setText("");
            jtfEmailCli.setText("");
            jtfPhoneCli.setText("");
            jtaAddressCli.setText("");
        } else {
            btnSaveCli.setEnabled(true);
        }
        if(!b){
            btnSaveCli.setEnabled(false);
        }
    }

    public void setProForm(boolean b, boolean editMode) {
        jtfCodPro.setEnabled(b);
        jtfCodPro.requestFocus();
        jtfPricePro.setEnabled(b);
        jtfUntPro.setEnabled(b);
        jtfQtdPro.setEnabled(b);
        jtaDescPro.setEnabled(b);
        btnCancelPro.setEnabled(b);
        btnNewPro.setEnabled(!b);

        if (!editMode) {
            newPro = b;
            jtfCodPro.setText("");
            jtfPricePro.setText("");
            jtfUntPro.setText("");
            jtfQtdPro.setText("");
            jtaDescPro.setText("");
        } else {
            btnSavePro.setEnabled(true);
        }
        if(!b){
            btnSaveCli.setEnabled(false);
        }
    }

    public void setForForm(boolean b, boolean editMode) {
        jtfCodFor.setEnabled(b);
        jtfCodFor.requestFocus();
        jtfCompFor.setEnabled(b);
        jtfContFor.setEnabled(b);
        jtfEmailFor.setEnabled(b);
        jtfPhoneFor.setEnabled(b);
        btnCancelFor.setEnabled(b);
        btnNewFor.setEnabled(!b);

        if (!editMode) {
            newFor = b;
            jtfCodFor.setText("");
            jtfCompFor.setText("");
            jtfContFor.setText("");
            jtfEmailFor.setText("");
            jtfPhoneFor.setText("");
        } else {
            btnSaveFor.setEnabled(true);
        }
        if(!b){
            btnSaveCli.setEnabled(false);
        }
    }
    //</editor-fold>

    public MainForm() {
        listaCliente = new ArrayList<>();
        listaProduto = new ArrayList<>();
        listaFornecedor = new ArrayList<>();
        loadCli();
        loadPro();
        loadFor();
        initComponents();
        tblCliente();
        tblProduto();
        tblFornecedor();
    }

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
        btnSaveCli = new javax.swing.JButton();
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
        btnNewPro = new javax.swing.JButton();
        btnEditPro = new javax.swing.JButton();
        btnDelPro = new javax.swing.JButton();
        btnCancelPro = new javax.swing.JButton();
        btnSavePro = new javax.swing.JButton();
        jpnFor = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTbFor = new javax.swing.JTable();
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
        jTbCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbCliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTbCli);

        formCli.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código:");

        jtfCodCli.setEnabled(false);
        jtfCodCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodCliKeyReleased(evt);
            }
        });

        jLabel4.setText("Nome:");

        jtfNameCli.setEnabled(false);
        jtfNameCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNameCliKeyReleased(evt);
            }
        });

        jLabel2.setText("Email:");

        jtfEmailCli.setEnabled(false);
        jtfEmailCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfEmailCliKeyReleased(evt);
            }
        });

        jLabel16.setText("Telefone:");

        jtfPhoneCli.setEnabled(false);
        jtfPhoneCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPhoneCliKeyReleased(evt);
            }
        });

        jLabel3.setText("Endereço:");

        jtaAddressCli.setColumns(20);
        jtaAddressCli.setRows(5);
        jtaAddressCli.setEnabled(false);
        jtaAddressCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtaAddressCliKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jtaAddressCli);

        btnNewCli.setText("Novo");
        btnNewCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCliActionPerformed(evt);
            }
        });

        btnEditCli.setText("Editar");
        btnEditCli.setEnabled(false);
        btnEditCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCliActionPerformed(evt);
            }
        });

        btnDelCli.setText("Excluir");
        btnDelCli.setEnabled(false);
        btnDelCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelCliActionPerformed(evt);
            }
        });

        btnCancelCli.setText("Cancelar");
        btnCancelCli.setEnabled(false);
        btnCancelCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelCliActionPerformed(evt);
            }
        });

        btnSaveCli.setText("Salvar");
        btnSaveCli.setEnabled(false);
        btnSaveCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCliActionPerformed(evt);
            }
        });

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
                    .addComponent(btnSaveCli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(btnSaveCli)))
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
        jTbPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbProMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTbPro);

        formPro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setText("Código:");

        jtfCodPro.setEnabled(false);
        jtfCodPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodProKeyReleased(evt);
            }
        });

        jLabel18.setText("Preco:");

        jtfPricePro.setEnabled(false);
        jtfPricePro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPriceProKeyReleased(evt);
            }
        });

        jLabel20.setText("Quantidade:");

        jtfQtdPro.setEnabled(false);
        jtfQtdPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfQtdProKeyReleased(evt);
            }
        });

        jLabel19.setText("Unidade:");

        jtfUntPro.setEnabled(false);
        jtfUntPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfUntProKeyReleased(evt);
            }
        });

        jLabel21.setText("Descrição:");

        jtaDescPro.setColumns(20);
        jtaDescPro.setRows(5);
        jtaDescPro.setEnabled(false);
        jtaDescPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtaDescProKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jtaDescPro);

        btnNewPro.setText("Novo");
        btnNewPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProActionPerformed(evt);
            }
        });

        btnEditPro.setText("Editar");
        btnEditPro.setEnabled(false);
        btnEditPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProActionPerformed(evt);
            }
        });

        btnDelPro.setText("Excluir");
        btnDelPro.setEnabled(false);
        btnDelPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelProActionPerformed(evt);
            }
        });

        btnCancelPro.setText("Cancelar");
        btnCancelPro.setEnabled(false);
        btnCancelPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelProActionPerformed(evt);
            }
        });

        btnSavePro.setText("Salvar");
        btnSavePro.setEnabled(false);
        btnSavePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProActionPerformed(evt);
            }
        });

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
                    .addComponent(btnCancelPro, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(btnDelPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(btnNewPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelPro)
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

        jTbFor.setModel(new javax.swing.table.DefaultTableModel(
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
        jTbFor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbForMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTbFor);

        formFor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setText("Código:");

        jtfCodFor.setEnabled(false);
        jtfCodFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodForKeyReleased(evt);
            }
        });

        jLabel23.setText("Contato:");

        jtfContFor.setEnabled(false);
        jtfContFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfContForKeyReleased(evt);
            }
        });

        jLabel24.setText("Telefone:");

        jtfPhoneFor.setEnabled(false);
        jtfPhoneFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPhoneForKeyReleased(evt);
            }
        });

        jLabel25.setText("Email:");

        jtfEmailFor.setEnabled(false);
        jtfEmailFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfEmailForKeyReleased(evt);
            }
        });

        jLabel26.setText("Empresa:");

        jtfCompFor.setEnabled(false);
        jtfCompFor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCompForKeyReleased(evt);
            }
        });

        btnNewFor.setText("Novo");
        btnNewFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewForActionPerformed(evt);
            }
        });

        btnEditFor.setText("Editar");
        btnEditFor.setEnabled(false);
        btnEditFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditForActionPerformed(evt);
            }
        });

        btnDelFor.setText("Excluir");
        btnDelFor.setEnabled(false);
        btnDelFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelForActionPerformed(evt);
            }
        });

        btnCancelFor.setText("Cancelar");
        btnCancelFor.setEnabled(false);
        btnCancelFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelForActionPerformed(evt);
            }
        });

        btnSaveFor.setText("Salvar");
        btnSaveFor.setEnabled(false);
        btnSaveFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveForActionPerformed(evt);
            }
        });

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
    
    //<editor-fold defaultstate="collapsed" desc="Ações Componentes">
    //Ações dos botões "Novo"
    private void btnNewCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCliActionPerformed
        setCliForm(true, false);
        btnEditCli.setEnabled(false);
        btnDelCli.setEnabled(false);
    }//GEN-LAST:event_btnNewCliActionPerformed

    private void btnNewProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProActionPerformed
        setProForm(true, false);
        btnEditPro.setEnabled(false);
        btnDelPro.setEnabled(false);
    }//GEN-LAST:event_btnNewProActionPerformed

    private void btnNewForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewForActionPerformed
        setForForm(true, false);
        btnEditFor.setEnabled(false);
        btnDelFor.setEnabled(false);
    }//GEN-LAST:event_btnNewForActionPerformed
    
    //Ações dos botões "Cancelar"
    private void btnCancelCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCliActionPerformed
        setCliForm(false, false);
    }//GEN-LAST:event_btnCancelCliActionPerformed

    private void btnCancelProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelProActionPerformed
        setProForm(false, false);
    }//GEN-LAST:event_btnCancelProActionPerformed

    private void btnCancelForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelForActionPerformed
        setForForm(false, false);
    }//GEN-LAST:event_btnCancelForActionPerformed

    //Ações dos botões "Salvar"
    private void btnSaveCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCliActionPerformed
        int cod = Integer.parseInt(jtfCodCli.getText());
        String nome = jtfNameCli.getText();
        String fone = jtfPhoneCli.getText();
        String email = jtfEmailCli.getText();
        String endereco = jtaAddressCli.getText();

        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja salvar essas informações?\n\n"
                + "Código: " + cod
                + "\nNome: " + nome
                + "\nFone: " + fone
                + "\nEmail: " + email
                + "\nEndereço: " + endereco,
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            Cliente cliente = new Cliente(cod, nome, fone, email, endereco);
            if (newCli) {
                listaCliente.add(cliente);
            } else {
                listaCliente.add(selectedCli, cliente);
                listaCliente.remove(selectedCli + 1);
            }
            tblCliente();
            saveCli();
            setCliForm(false, false);
        }
    }//GEN-LAST:event_btnSaveCliActionPerformed

    private void btnSaveProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProActionPerformed
        int cod = Integer.parseInt(jtfCodPro.getText());
        String desc = jtaDescPro.getText();
        String unidade = jtfUntPro.getText();
        float qtd = Float.parseFloat(jtfQtdPro.getText());
        float preco = Float.parseFloat(jtfPricePro.getText());

        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja salvar essas informações?\n\n"
                + "Código: " + cod
                + "\nPreço: " + preco
                + "\nQuantidade: " + qtd
                + "\nUnidade: " + unidade
                + "\nDescrição: " + desc,
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            Produto produto = new Produto(cod, desc, unidade, qtd, preco);
            if (newPro) {
                listaProduto.add(produto);
            } else {
                listaProduto.add(selectedPro, produto);
                listaProduto.remove(selectedPro + 1);
            }
            tblProduto();
            savePro();
            setProForm(false, false);
        }
    }//GEN-LAST:event_btnSaveProActionPerformed

    private void btnSaveForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveForActionPerformed
        int cod = Integer.parseInt(jtfCodFor.getText());
        String empresa = jtfCompFor.getText();
        String contato = jtfContFor.getText();
        String fone = jtfPhoneFor.getText();
        String email = jtfEmailFor.getText();

        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja salvar essas informações?\n\n"
                + "Código: " + cod
                + "\nEmpresa: " + empresa
                + "\nContato: " + contato
                + "\nFone: " + fone
                + "\nEmail: " + email,
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            Fornecedor fornecedor = new Fornecedor(cod, empresa, contato, fone, email);
            if (newFor) {
                listaFornecedor.add(fornecedor);
            } else {
                listaFornecedor.add(selectedFor, fornecedor);
                listaFornecedor.remove(selectedFor + 1);
            }
            tblFornecedor();
            saveFor();
            setForForm(false, false);
        }
    }//GEN-LAST:event_btnSaveForActionPerformed

    //Ações dos botões "Excluir"
    private void btnDelCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelCliActionPerformed
        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja mesmo excluir essa linha?",
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            listaCliente.remove(selectedCli);
            tblCliente();
            saveCli();
            btnDelCli.setEnabled(false);
            btnEditCli.setEnabled(false);
        }
    }//GEN-LAST:event_btnDelCliActionPerformed

    private void btnDelProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelProActionPerformed
        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja mesmo excluir essa linha?",
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            listaProduto.remove(selectedPro);
            tblProduto();
            savePro();
            btnDelPro.setEnabled(false);
            btnEditPro.setEnabled(false);
        }
    }//GEN-LAST:event_btnDelProActionPerformed

    private void btnDelForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelForActionPerformed
        int opt = JOptionPane.showConfirmDialog(null,
                "Deseja mesmo excluir essa linha?",
                "Comfirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            listaFornecedor.remove(selectedFor);
            tblFornecedor();
            saveFor();
            btnDelFor.setEnabled(false);
            btnEditFor.setEnabled(false);
        }
    }//GEN-LAST:event_btnDelForActionPerformed

    //Ações dos botões "Editar"
    private void btnEditCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCliActionPerformed
        setCliForm(true, true);
        btnEditCli.setEnabled(false);
        btnDelCli.setEnabled(false);
    }//GEN-LAST:event_btnEditCliActionPerformed

    private void btnEditProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProActionPerformed
        setProForm(true, true);
        btnEditPro.setEnabled(false);
        btnDelPro.setEnabled(false);
    }//GEN-LAST:event_btnEditProActionPerformed

    private void btnEditForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditForActionPerformed
        setForForm(true, true);
        btnEditFor.setEnabled(false);
        btnDelFor.setEnabled(false);
    }//GEN-LAST:event_btnEditForActionPerformed

    //Ações liberadas a soltar tecla nos campos do Cliente
    private void jtfCodCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodCliKeyReleased
        btnSaveCli.setEnabled(isAllFilledCli());
    }//GEN-LAST:event_jtfCodCliKeyReleased

    private void jtfNameCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNameCliKeyReleased
        btnSaveCli.setEnabled(isAllFilledCli());
    }//GEN-LAST:event_jtfNameCliKeyReleased

    private void jtfEmailCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailCliKeyReleased
        btnSaveCli.setEnabled(isAllFilledCli());
    }//GEN-LAST:event_jtfEmailCliKeyReleased

    private void jtfPhoneCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPhoneCliKeyReleased
        btnSaveCli.setEnabled(isAllFilledCli());
    }//GEN-LAST:event_jtfPhoneCliKeyReleased

    private void jtaAddressCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaAddressCliKeyReleased
        btnSaveCli.setEnabled(isAllFilledCli());
    }//GEN-LAST:event_jtaAddressCliKeyReleased

    //Ações liberadas a soltar tecla nos campos do Produto
    private void jtfCodProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodProKeyReleased
        btnSavePro.setEnabled(isAllFilledPro());
    }//GEN-LAST:event_jtfCodProKeyReleased

    private void jtfPriceProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPriceProKeyReleased
        btnSavePro.setEnabled(isAllFilledPro());
    }//GEN-LAST:event_jtfPriceProKeyReleased

    private void jtfQtdProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQtdProKeyReleased
        btnSavePro.setEnabled(isAllFilledPro());
    }//GEN-LAST:event_jtfQtdProKeyReleased

    private void jtfUntProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUntProKeyReleased
        btnSavePro.setEnabled(isAllFilledPro());
    }//GEN-LAST:event_jtfUntProKeyReleased

    private void jtaDescProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaDescProKeyReleased
        btnSavePro.setEnabled(isAllFilledPro());
    }//GEN-LAST:event_jtaDescProKeyReleased

    //Ações liberadas a soltar tecla nos campos do Fornecedor
    private void jtfCodForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodForKeyReleased
        btnSaveFor.setEnabled(isAllFilledFor());
    }//GEN-LAST:event_jtfCodForKeyReleased

    private void jtfContForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfContForKeyReleased
        btnSaveFor.setEnabled(isAllFilledFor());
    }//GEN-LAST:event_jtfContForKeyReleased

    private void jtfPhoneForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPhoneForKeyReleased
        btnSaveFor.setEnabled(isAllFilledFor());
    }//GEN-LAST:event_jtfPhoneForKeyReleased

    private void jtfEmailForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailForKeyReleased
        btnSaveFor.setEnabled(isAllFilledFor());
    }//GEN-LAST:event_jtfEmailForKeyReleased

    private void jtfCompForKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCompForKeyReleased
        btnSaveFor.setEnabled(isAllFilledFor());
    }//GEN-LAST:event_jtfCompForKeyReleased

    private void jTbCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbCliMouseClicked
        if (!newCli) {
            selectedCli = jTbCli.getSelectedRow();
            jtfCodCli.setText(jTbCli.getValueAt(selectedCli, 0).toString());
            jtfNameCli.setText(jTbCli.getValueAt(selectedCli, 1).toString());
            jtfEmailCli.setText(jTbCli.getValueAt(selectedCli, 2).toString());
            jtfPhoneCli.setText(jTbCli.getValueAt(selectedCli, 3).toString());
            jtaAddressCli.setText(jTbCli.getValueAt(selectedCli, 4).toString());
            btnEditCli.setEnabled(true);
            btnDelCli.setEnabled(true);
        }
    }//GEN-LAST:event_jTbCliMouseClicked

    private void jTbProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbProMouseClicked
        if (!newPro) {
            selectedPro = jTbPro.getSelectedRow();
            jtfCodPro.setText(jTbPro.getValueAt(selectedPro, 0).toString());
            jtfPricePro.setText(jTbPro.getValueAt(selectedPro, 1).toString());
            jtfQtdPro.setText(jTbPro.getValueAt(selectedPro, 2).toString());
            jtfUntPro.setText(jTbPro.getValueAt(selectedPro, 3).toString());
            jtaDescPro.setText(jTbPro.getValueAt(selectedPro, 4).toString());
            btnEditPro.setEnabled(true);
            btnDelPro.setEnabled(true);
        }
    }//GEN-LAST:event_jTbProMouseClicked

    private void jTbForMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbForMouseClicked
        if (!newFor) {
            selectedFor = jTbFor.getSelectedRow();
            jtfCodFor.setText(jTbFor.getValueAt(selectedFor, 0).toString());
            jtfContFor.setText(jTbFor.getValueAt(selectedFor, 1).toString());
            jtfPhoneFor.setText(jTbFor.getValueAt(selectedFor, 2).toString());
            jtfEmailFor.setText(jTbFor.getValueAt(selectedFor, 3).toString());
            jtfCompFor.setText(jTbFor.getValueAt(selectedFor, 4).toString());
            btnEditFor.setEnabled(true);
            btnDelFor.setEnabled(true);
        }
    }//GEN-LAST:event_jTbForMouseClicked
    //</editor-fold>
    
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
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelCli;
    private javax.swing.JButton btnCancelFor;
    private javax.swing.JButton btnCancelPro;
    private javax.swing.JButton btnDelCli;
    private javax.swing.JButton btnDelFor;
    private javax.swing.JButton btnDelPro;
    private javax.swing.JButton btnEditCli;
    private javax.swing.JButton btnEditFor;
    private javax.swing.JButton btnEditPro;
    private javax.swing.JButton btnNewCli;
    private javax.swing.JButton btnNewFor;
    private javax.swing.JButton btnNewPro;
    private javax.swing.JButton btnSaveCli;
    private javax.swing.JButton btnSaveFor;
    private javax.swing.JButton btnSavePro;
    private javax.swing.JPanel formCli;
    private javax.swing.JPanel formFor;
    private javax.swing.JPanel formPro;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTable jTbFor;
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
