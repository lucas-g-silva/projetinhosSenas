package appcalculator;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.xml.transform.OutputKeys;

/**
 *
 * @author lucas-gabreil_silva
 */
public class AppCalculator {

    public static void main(String[] args) {
        
        int OUTPUT_FONT_SIZE = 20;
        int BUTTON_FONT_SIZE = 14;
        int BUTTON_SIZE = 70;
        
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
        form.setSize(365, 570);
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setTitle("Calculadora");
        form.setLayout(null);

        //Fila 1
        JTextField output = new JTextField();
        output.setBounds(20, 20, 310, 80);
        output.setFont(new Font("Inter", Font.PLAIN, OUTPUT_FONT_SIZE));
        output.setEditable(false);
        output.setCursor(null);
        output.setBackground(Color.WHITE);

        Border tfBorder = UIManager.getBorder("TextField.border");
        Border newBorder = BorderFactory.createCompoundBorder(tfBorder,
                BorderFactory.createEmptyBorder(5, 5, 5, 10));
        
        output.setBorder(newBorder);
        output.setHorizontalAlignment(SwingConstants.RIGHT);
        form.add(output);

        JButton btnC = new JButton("C");
        btnC.setBounds(20, 120, BUTTON_SIZE, BUTTON_SIZE);
        btnC.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btnC);
        
        btnC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");
            }
        
        });

        JButton btnBack = new JButton("<");
        btnBack.setBounds(100, 120, BUTTON_SIZE, BUTTON_SIZE);
        btnBack.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btnBack);
        
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(output.getText().length() > 0){
                     output.setText(output.getText().substring(0, output.getText().length() - 1));
                }
            }
        
        });

        JButton btnAPar = new JButton("(");
        btnAPar.setBounds(180, 120, BUTTON_SIZE, BUTTON_SIZE);
        btnAPar.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btnAPar);
        
        btnAPar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"(");
            }
        
        });

        JButton btnFPar = new JButton(")");
        btnFPar.setBounds(260, 120, BUTTON_SIZE, BUTTON_SIZE);
        btnFPar.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btnFPar);
        
        btnFPar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+")");
            }
        
        });

        //Fila 2
        JButton btn7 = new JButton("7");
        btn7.setBounds(20, 200, BUTTON_SIZE, BUTTON_SIZE);
        btn7.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btn7);
        
        btn7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"7");
            }
        
        });

        JButton btn8 = new JButton("8");
        btn8.setBounds(100, 200, BUTTON_SIZE, BUTTON_SIZE);
        btn8.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btn8);
        
        btn8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"8");
            }
        
        });

        JButton btn9 = new JButton("9");
        btn9.setBounds(180, 200, BUTTON_SIZE, BUTTON_SIZE);
        btn9.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btn9);
        
        btn9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"9");
            }
        
        });

        JButton btnDiv = new JButton("/");
        btnDiv.setBounds(260, 200, BUTTON_SIZE, BUTTON_SIZE);
        btnDiv.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btnDiv);
        
        btnDiv.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"/");
            }
        
        });

        //Fila 3
        JButton btn4 = new JButton("4");
        btn4.setBounds(20, 280, BUTTON_SIZE, BUTTON_SIZE);
        btn4.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btn4);
        
        btn4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"4");
            }
        
        });

        JButton btn5 = new JButton("5");
        btn5.setBounds(100, 280, BUTTON_SIZE, BUTTON_SIZE);
        btn5.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btn5);
        
        btn5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"5");
            }
        
        });

        JButton btn6 = new JButton("6");
        btn6.setBounds(180, 280, BUTTON_SIZE, BUTTON_SIZE);
        btn6.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btn6);
        
        btn6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"6");
            }
        
        });

        JButton btnMult = new JButton("X");
        btnMult.setBounds(260, 280, BUTTON_SIZE, BUTTON_SIZE);
        btnMult.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btnMult);
        
        btnMult.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"*");
            }
        
        });

        //Fila 4
        JButton btn1 = new JButton("1");
        btn1.setBounds(20, 360, BUTTON_SIZE, BUTTON_SIZE);
        btn1.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btn1);
        
        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"1");
            }
        
        });

        JButton btn2 = new JButton("2");
        btn2.setBounds(100, 360, BUTTON_SIZE, BUTTON_SIZE);
        btn2.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btn2);
        
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"2");
            }
        
        });

        JButton btn3 = new JButton("3");
        btn3.setBounds(180, 360, BUTTON_SIZE, BUTTON_SIZE);
        btn3.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btn3);
        
        btn3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"3");
            }
        
        });

        JButton btnSub = new JButton("-");
        btnSub.setBounds(260, 360, BUTTON_SIZE, BUTTON_SIZE);
        btnSub.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btnSub);
        
        btnSub.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"-");
            }
        
        });

        //Fila 5
        JButton btn0 = new JButton("0");
        btn0.setBounds(20, 440, BUTTON_SIZE, BUTTON_SIZE);
        btn0.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btn0);
        
        btn0.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"0");
            }
        
        });

        JButton btnDot = new JButton(".");
        btnDot.setBounds(100, 440, BUTTON_SIZE, BUTTON_SIZE);
        btnDot.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btnDot);
        
        btnDot.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+".");
            }
        
        });

        JButton btnIgual = new JButton("=");
        btnIgual.setBounds(180, 440, BUTTON_SIZE, BUTTON_SIZE);
        btnIgual.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btnIgual);

        JButton btnMais = new JButton("+");
        btnMais.setBounds(260, 440, BUTTON_SIZE, BUTTON_SIZE);
        btnMais.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
        form.add(btnMais);
        
        btnMais.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText()+"+");
            }
        
        });

        form.setVisible(true);
    }
}
