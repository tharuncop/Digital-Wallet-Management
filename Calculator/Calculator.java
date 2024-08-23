import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame f;
    JTextField tf;
    JButton[] numButs = new JButton[10];
    JButton[] funButs = new JButton[8];
    JButton add, sub, mul, div, dec, eq, del, clr;
    JPanel p;

    double num1 = 0, num2 = 0, result = 0;
    char op;

    Calculator() {
        f = new JFrame("Tharun's Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 550);
        f.setLayout(null);

        tf = new JTextField();
        tf.setBounds(30, 30, 340, 50);
        tf.setEditable(false);
        f.add(tf);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        eq = new JButton("=");
        del = new JButton("X");
        clr = new JButton("C");

        funButs[0] = add;
        funButs[1] = sub;
        funButs[2] = mul;
        funButs[3] = div;
        funButs[4] = dec;
        funButs[5] = eq;
        funButs[6] = del;
        funButs[7] = clr;

        for (int i = 0; i < 8; i++) {
            funButs[i].addActionListener(this);
            funButs[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numButs[i] = new JButton(String.valueOf(i));
            numButs[i].addActionListener(this);
            numButs[i].setFocusable(false);
        }

        del.setBounds(30, 450, 90, 50);
        clr.setBounds(280, 450, 90, 50);

        f.add(del);
        f.add(clr);

        p = new JPanel();
        p.setBounds(30, 85, 340, 350);
        p.setLayout(new GridLayout(4, 4, 2, 2));
        p.setBackground(Color.GRAY);

        p.add(numButs[7]);
        p.add(numButs[8]);
        p.add(numButs[9]);
        p.add(add);
        p.add(numButs[4]);
        p.add(numButs[5]);
        p.add(numButs[6]);
        p.add(sub);
        p.add(numButs[1]);
        p.add(numButs[2]);
        p.add(numButs[3]);
        p.add(mul);
        p.add(dec);
        p.add(numButs[0]);
        p.add(eq);
        p.add(div);

        JLabel l = new JLabel("FOFY");
        l.setBounds(180, 450, 120, 50);
        f.add(l);

        f.add(p);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButs[i]) {
                tf.setText(tf.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dec) {
            tf.setText(tf.getText().concat("."));
        }
        if (e.getSource() == add) {
            num1 = Double.parseDouble(tf.getText());
            op = '+';
            tf.setText("");
        }
        if (e.getSource() == sub) {
            num1 = Double.parseDouble(tf.getText());
            op = '-';
            tf.setText("");
        }
        if (e.getSource() == mul) {
            num1 = Double.parseDouble(tf.getText());
            op = '*';
            tf.setText("");
        }
        if (e.getSource() == div) {
            num1 = Double.parseDouble(tf.getText());
            op = '/';
            tf.setText("");
        }
        if (e.getSource() == eq) {
            num2 = Double.parseDouble(tf.getText());

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            tf.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clr) {
            tf.setText("");
            num1 = 0;
            num2 = 0;
        }
        if (e.getSource() == del) {
            String str = tf.getText();
            tf.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                tf.setText(tf.getText() + str.charAt(i));
            }
        }

    }

    public static void main(String[] args) {
        new Calculator();
    }
}
