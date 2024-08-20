package javalab;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calci implements ActionListener {
    JFrame f;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
    JPanel jp;
    TextField tf;
    String s1, s2, s3, s4, s5;
    int c, n;

    Calci() {
        f = new JFrame("Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        tf = new TextField(20);
        tf.setEditable(false);
        tf.setBackground(Color.WHITE);
        tf.setFont(new Font("Arial", Font.PLAIN, 20));
        f.add(tf, BorderLayout.NORTH);

        jp = new JPanel();
        jp.setLayout(new GridLayout(4, 4, 5, 5));
        Button[] buttons = new Button[16];
        buttons[0] = b1 = new Button("0");
        buttons[1] = b2 = new Button("1");
        buttons[2] = b3 = new Button("2");
        buttons[3] = b4 = new Button("3");
        buttons[4] = b5 = new Button("4");
        buttons[5] = b6 = new Button("5");
        buttons[6] = b7 = new Button("6");
        buttons[7] = b8 = new Button("7");
        buttons[8] = b9 = new Button("8");
        buttons[9] = b10 = new Button("9");
        buttons[10] = b11 = new Button("+");
        buttons[11] = b12 = new Button("-");
        buttons[12] = b13 = new Button("*");
        buttons[13] = b14 = new Button("/");
        buttons[14] = b15 = new Button("=");
        buttons[15] = b16 = new Button("C");

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            buttons[i].setBackground(Color.LIGHT_GRAY);
            jp.add(buttons[i]);
        }

        f.add(jp, BorderLayout.CENTER);
        f.setSize(300, 400);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof Button) {
            Button clickedButton = (Button) source;
            String buttonLabel = clickedButton.getLabel();

            if (buttonLabel.matches("[0-9]")) {
                tf.setText(tf.getText() + buttonLabel);
            } else if (buttonLabel.matches("[+\\-*/]")) {
                
                s4 = tf.getText();
                tf.setText(tf.getText() + buttonLabel);
                if (buttonLabel.equals("+")) c = 1;
                else if (buttonLabel.equals("-")) c = 2;
                else if (buttonLabel.equals("*")) c = 3;
                else if (buttonLabel.equals("/")) c = 4;
            } else if (buttonLabel.equals("=")) {
                s5 = tf.getText().substring(s4.length() + 1);
                try {
                    if (c == 1) {
                        n = Integer.parseInt(s4) + Integer.parseInt(s5);
                    } else if (c == 2) {
                        n = Integer.parseInt(s4) - Integer.parseInt(s5);
                    } else if (c == 3) {
                        n = Integer.parseInt(s4) * Integer.parseInt(s5);
                    } else if (c == 4) {
                        int p = Integer.parseInt(s5);
                        if (p != 0) {
                            n = Integer.parseInt(s4) / p;
                        } else {
                            tf.setText("Error");
                            return;
                        }
                    }
                    tf.setText(String.valueOf(n));
                } catch (NumberFormatException ex) {
                    tf.setText("Error");
                }
            } else if (buttonLabel.equals("C"))
            {
                tf.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new Calci();
    }
}
