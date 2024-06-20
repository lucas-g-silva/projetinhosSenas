package firstform;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author lucas-gabreil_silva
 */
public class FirstForm {

    public static void main(String[] args) {
        //Construção da Janela
        JFrame form = new JFrame();
        form.setSize(600, 400);
        form.setTitle("Exemplo de Form em Java");
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        form.setLayout(null);

        //Construção dde uma label
        JLabel label = new JLabel();
        label.setText("Teste de label no form");
        label.setBounds(50, 50, 200, 30);
        Color cor1 = new Color(150, 150, 200);
        label.setForeground(cor1);
        label.setFont(new Font("Inter", Font.PLAIN, 18));
        form.add(label);

        //Construção de um input
        JTextField jTfNome = new JTextField();
        jTfNome.setBounds(50, 90, 200, 30);
        form.add(jTfNome);

        JButton botao = new JButton("Confirmar");
        botao.setBounds(50, 130, 200, 30);
        form.add(botao);

        form.setVisible(true);
    }
}
