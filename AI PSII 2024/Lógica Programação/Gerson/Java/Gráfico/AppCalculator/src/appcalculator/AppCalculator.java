package appcalculator;

import java.awt.Color;
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

/**
 *
 * @author lucas-gabreil_silva
 */
public class AppCalculator {
    
    public static final int BUTTON_SIZE = 80;
    public static final int MARGIN = 0;
    public static final int GAP = 0;
    public static final int OUTPUT_WIDTH = BUTTON_SIZE * 4 + GAP * 3;
    public static final int OUTPUT_HEIGHT = (int)(BUTTON_SIZE * 1.29);
    public static final int OUTPUT_FONT_SIZE = (int)(BUTTON_SIZE * 0.33);
    public static final int BUTTON_FONT_SIZE = (int)(BUTTON_SIZE * 0.20);

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
        form.setSize(MARGIN * 2 + 15 + GAP * 3 + BUTTON_SIZE * 4, MARGIN * 2 + 40 + OUTPUT_HEIGHT + GAP * 5 + BUTTON_SIZE * 5);
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setTitle("Calculator");
        form.setLayout(null);
        form.setResizable(false);

        //Fila 1
        JTextField output = new JTextField();
        output.setBounds(MARGIN, MARGIN, OUTPUT_WIDTH, OUTPUT_HEIGHT);
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
        configBtn(btnC, 0, 0);
        form.add(btnC);

        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");
            }

        });

        JButton btnBack = new JButton("<");
        configBtn(btnBack, 1, 0);
        form.add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (output.getText().length() > 0) {
                    output.setText(output.getText().substring(0, output.getText().length() - 1));
                }
            }

        });

        JButton btnAPar = new JButton("(");
        configBtn(btnAPar, 2, 0);
        form.add(btnAPar);

        btnAPar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "(");
            }

        });

        JButton btnFPar = new JButton(")");
        configBtn(btnFPar, 3, 0);
        form.add(btnFPar);

        btnFPar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + ")");
            }

        });

        //Fila 2
        JButton btn7 = new JButton("7");
        configBtn(btn7, 0, 1);
        form.add(btn7);

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "7");
            }

        });

        JButton btn8 = new JButton("8");
        configBtn(btn8, 1, 1);
        form.add(btn8);

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "8");
            }

        });

        JButton btn9 = new JButton("9");
        configBtn(btn9, 2, 1);
        form.add(btn9);

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "9");
            }

        });

        JButton btnDiv = new JButton("/");
        configBtn(btnDiv, 3, 1);
        form.add(btnDiv);

        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "/");
            }

        });

        //Fila 3
        JButton btn4 = new JButton("4");
        configBtn(btn4, 0, 2);
        form.add(btn4);

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "4");
            }

        });

        JButton btn5 = new JButton("5");
        configBtn(btn5, 1, 2);
        form.add(btn5);

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "5");
            }

        });

        JButton btn6 = new JButton("6");
        configBtn(btn6, 2, 2);
        form.add(btn6);

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "6");
            }

        });

        JButton btnMult = new JButton("X");
        configBtn(btnMult, 3, 2);
        form.add(btnMult);

        btnMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "*");
            }

        });

        //Fila 4
        JButton btn1 = new JButton("1");
        configBtn(btn1, 0, 3);
        form.add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "1");
            }

        });

        JButton btn2 = new JButton("2");
        configBtn(btn2, 1, 3);
        form.add(btn2);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "2");
            }

        });

        JButton btn3 = new JButton("3");
        configBtn(btn3, 2, 3);
        form.add(btn3);

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "3");
            }

        });

        JButton btnSub = new JButton("-");
        configBtn(btnSub, 3, 3);
        form.add(btnSub);

        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "-");
            }

        });

        //Fila 5
        JButton btnDot = new JButton(".");
        configBtn(btnDot, 0, 4);
        form.add(btnDot);

        btnDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + ".");
            }

        });
        
        JButton btn0 = new JButton("0");
        configBtn(btn0, 1, 4);
        form.add(btn0);

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "0");
            }

        });

        JButton btnIgual = new JButton("=");
        configBtn(btnIgual, 2, 4);
        form.add(btnIgual);

        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String exp = output.getText();
                
                System.out.println(">>>"+exp);
                Calculator calc = new Calculator();
                String result = calc.evalExp(exp);
                output.setText(result);
            }

        });

        JButton btnMais = new JButton("+");
        configBtn(btnMais, 3, 4);
        form.add(btnMais);

        btnMais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "+");
            }

        });

        form.setVisible(true);
    }

    public static void configBtn(JButton btn, int px, int py) {
        btn.setBounds(MARGIN + GAP * px + BUTTON_SIZE * px, MARGIN + OUTPUT_HEIGHT + GAP * (py + 1) + BUTTON_SIZE * py, BUTTON_SIZE, BUTTON_SIZE);
        btn.setFont(new Font("Inter", Font.PLAIN, BUTTON_FONT_SIZE));
    }
}
