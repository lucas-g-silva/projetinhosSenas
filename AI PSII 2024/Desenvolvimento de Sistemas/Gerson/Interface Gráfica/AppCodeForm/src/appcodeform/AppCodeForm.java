package appcodeform;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author lucas-gabreil_silva
 */
public class AppCodeForm extends JFrame {

    public AppCodeForm() {
        setTitle("Aplicativo Exemplo de Formulário");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        

        JLabel lblNome = new JLabel("Nome do Aluno: ");
        lblNome.setBounds(100, 50, 100, 30);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 80, 300, 30);
        add(txtNome);
    }

    public static void main(String[] args) {
        AppCodeForm form = new AppCodeForm();
        form.setVisible(true);
    }

}
