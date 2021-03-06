import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator extends JFrame implements ActionListener{

    private JFrame frame;
    private JTextField txtfield;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[8];
    private JButton addButton, sButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JPanel panel;

    Font font = new Font("Arial", Font.BOLD, 30);

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    Calculator() {

        //create frame
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setTitle("Calculator");
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        // frame.setResizable(false);

        //create jfield
        txtfield = new JTextField();
        txtfield.setBounds(50,5, 300, 70);
        txtfield.setFont(font);
        txtfield.setEditable(false);
        txtfield.setBackground(Color.LIGHT_GRAY);
        txtfield.setForeground(Color.BLACK);
        frame.add(txtfield);

        //declear operator object
        addButton = new JButton("+");
        sButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        //operator variable added in functioButtons array
        functionButtons[0] = addButton;
        functionButtons[1] = sButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        //add action listner & font size in operator through for loop
        for(int i=0; i<8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setBackground(Color.GRAY);
            functionButtons[i].setForeground(Color.BLACK);
        }

        //add action listner & font size in number button through for loop
        for(int i=0; i<10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setBackground(Color.GRAY);
            numberButtons[i].setForeground(Color.BLACK);
        }

        delButton.setBounds(50,430,140,50);
        frame.add(delButton);
        clrButton.setBounds(205,430,145,50);
        frame.add(clrButton);

        // create panel for operators & numbers
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        frame.add(panel);

        // added all operators & number button in panel
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(sButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(divButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(mulButton);

    }

    public static void main(String[] args) {
        Calculator Calculator = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        // set action performed of all number buttton
        for(int i=0; i<10; i++) {
            if(e.getSource() == numberButtons[i]) {
                txtfield.setText(txtfield.getText().concat(String.valueOf(i)));
            }
        }

        try {
            if(e.getSource() == decButton) {
                txtfield.setText(txtfield.getText().concat("."));
            }
            if(e.getSource() == addButton) {
                num1 = Double.parseDouble(txtfield.getText());
                operator = '+';
                txtfield.setText("");
            }
            if(e.getSource() == sButton) {
                num1 = Double.parseDouble(txtfield.getText());
                operator = '-';
                txtfield.setText("");
            }
            if(e.getSource() == mulButton) {
                num1 = Double.parseDouble(txtfield.getText());
                operator = '*';
                txtfield.setText("");
            }
            if(e.getSource() == divButton) {
                num1 = Double.parseDouble(txtfield.getText());
                operator = '/';
                txtfield.setText("");
            }
            if(e.getSource() == equButton) {
                num2 = Double.parseDouble(txtfield.getText());
                
                switch(operator) {
                    case'+':
                        result = num1 + num2;
                        break;
                    case'-':
                        result = num1 - num2;
                        break;
                    case'*':
                        result = num1 * num2;
                        break;
                    case'/':
                        result = num1 / num2;
                        break;
                }
                txtfield.setText(String.valueOf(result));
                num1 = result;
            }
            if(e.getSource() == clrButton) {
                txtfield.setText("");
            }
            if(e.getSource() == delButton) {
                String string = txtfield.getText();
                txtfield.setText("");
                for(int i=0; i<string.length()-1; i++) {
                    txtfield.setText(txtfield.getText()+string.charAt(i));
                }
            }
        }
        catch (NumberFormatException numberFormatException) {
            return;
        }
        catch(ArithmeticException arithmeticException){
            return;     
        }
    }
}