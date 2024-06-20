package cadcli;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author lucas-gabreil_silva
 */
public class CadCli {

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } catch (InstantiationException exc) {
            exc.printStackTrace();
        } catch (IllegalAccessException exc) {
            exc.printStackTrace();
        }

        JFrame form = new JFrame();
        form.setSize(500, 400);
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLayout(null);

        //Título
        JLabel title = new JLabel("Cadastro de Cliente");
        title.setBounds(40, 30, 194, 24);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Inter", Font.PLAIN, 16));
        form.add(title);

        //Nome
        JLabel labelNome = new JLabel("Nome");
        labelNome.setBounds(76, 80, 34, 15);
        labelNome.setForeground(Color.BLACK);
        labelNome.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(labelNome);

        JTextField inputNome = new JTextField();
        inputNome.setBounds(140, 75, 300, 25);
        inputNome.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(inputNome);

        //CPF
        JLabel labelCPF = new JLabel("CPF");
        labelCPF.setBounds(86, 125, 24, 15);
        labelCPF.setForeground(Color.BLACK);
        labelCPF.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(labelCPF);

        JTextField inputCPF = new JTextField();
        inputCPF.setBounds(140, 120, 300, 25);
        inputCPF.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(inputCPF);

        //Email
        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(80, 170, 30, 15);
        labelEmail.setForeground(Color.BLACK);
        labelEmail.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(labelEmail);

        JTextField inputEmail = new JTextField();
        inputEmail.setBounds(140, 165, 300, 25);
        inputEmail.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(inputEmail);

        //Telefone
        JLabel labelTel = new JLabel("Telefone");
        labelTel.setBounds(61, 215, 50, 15);
        labelTel.setForeground(Color.BLACK);
        labelTel.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(labelTel);

        JTextField inputTel = new JTextField();
        inputTel.setBounds(140, 210, 300, 25);
        inputTel.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(inputTel);

        //Botão Cadastrar
        JButton buttonCad = new JButton("Cadastrar");
        buttonCad.setBounds(35, 265, 90, 25);
        buttonCad.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(buttonCad);

        buttonCad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou no botão cadastrar!");
            }
        });

        //Botão Cadastrar
        JButton buttonClear = new JButton("Limpar");
        buttonClear.setBounds(140, 265, 90, 25);
        buttonClear.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(buttonClear);
        
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou no botão limpar!");
            }
        });

        //Botão Cadastrar
        JButton buttonExit = new JButton("Fechar");
        buttonExit.setBounds(245, 265, 90, 25);
        buttonExit.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(buttonExit);
        
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou no botão fechar!");
            }
        });

        //Botão Cadastrar
        JButton buttonSearch = new JButton("Busca");
        buttonSearch.setBounds(350, 265, 90, 25);
        buttonSearch.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(buttonSearch);
        
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou no botão buscar!");
            }
        });

        //Botão Cadastrar
        JButton buttonChange = new JButton("Alterar");
        buttonChange.setBounds(35, 300, 90, 25);
        buttonChange.setFont(new Font("Inter", Font.PLAIN, 12));
        form.add(buttonChange);
        
        buttonChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou no botão alterar!");
            }
        });

        form.setVisible(true);
    }

}
