import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame
{
    private JTextField outputText;
    private JButton clearButton;
    private JButton numberButton6;
    private JButton numberButton9;
    private JButton divideButton;
    private JButton numberButton8;
    private JButton numberButton5;
    private JButton composeButton;
    private JButton numberButton7;
    private JButton numberButton4;
    private JButton minusButton;
    private JButton plusButton;
    private JButton numberButton3;
    private JButton numberButton2;
    private JButton numberButton0;
    private JPanel mainForm;
    private JButton numberButton1;
    private JButton equButton;
    private JButton tickButton;
    private JButton reverdDigit;
    private JTextField historyText;
    private boolean plus, minus, compose, divide, unair;
    private double equ, SolveEqu;

    public Calculator()
    {
        setTitle("Calculator");
        setSize(400, 500);
        add(mainForm);
        outputText.setEditable(false);
        historyText.setEditable(false);
        equ = 0;

        class ListenToOne implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "1");
                historyText.setText(historyText.getText() + "1");
            }
        }

        class ListenToTwo implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "2");
                historyText.setText(historyText.getText() + "2");
            }
        }

        class ListenToThree implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "3");
                historyText.setText(historyText.getText() + "3");
            }
        }

        class ListenToFour implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "4");
                historyText.setText(historyText.getText() + "4");
            }
        }

        class ListenToFive implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "5");
                historyText.setText(historyText.getText() + "5");
            }
        }

        class ListenToSix implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "6");
                historyText.setText(historyText.getText() + "6");
            }
        }

        class ListenToSeven implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "7");
                historyText.setText(historyText.getText() + "7");
            }
        }

        class ListenToEight implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "8");
                historyText.setText(historyText.getText() + "8");
            }
        }

        class ListenToNine implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "9");
                historyText.setText(historyText.getText() + "9");
            }
        }

        class ListenToTick implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                outputText.setText(outputText.getText() + ".");
            }
        }

        class ListenToZero implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "0");
            }
        }

        class ListenToUnairOperation implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                equ = -Double.parseDouble(outputText.getText());
                outputText.setText(""+ equ);
                unair = true;

            }
        }

        class ListenToClear implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText("");
                historyText.setText("");
                plus = false;
                minus = false;
                compose = false;
                divide = false;

                equ = 0;
                SolveEqu = 0;
            }
        }

        class ListenToPlus implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                historyText.setText(historyText.getText() + "+");
                equ = Double.parseDouble(outputText.getText());
                outputText.setText("");
                plus = true;
            }
        }

        class ListenToMinus implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                historyText.setText(historyText.getText() + "-");
                equ = Double.parseDouble(outputText.getText());
                outputText.setText("");
                minus = true;
            }
        }

        class ListenToMulti implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                historyText.setText(historyText.getText() + "x");
                equ = Double.parseDouble(outputText.getText());
                outputText.setText("");
                compose = true;
            }
        }

        class ListenToDivide implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                historyText.setText(historyText.getText() + ":");
                equ = Double.parseDouble(outputText.getText());
                outputText.setText("");
                divide = true;
            }
        }

        class ListenToSolve implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                SolveEqu = Double.parseDouble(outputText.getText());

                if (plus == true)
                    SolveEqu = SolveEqu + equ;
                else if (minus == true)
                    SolveEqu = equ - SolveEqu;
                else if (compose == true)
                    SolveEqu = SolveEqu * equ;
                else if (divide == true)
                    SolveEqu = equ / SolveEqu;
                outputText.setText(Double.toString(SolveEqu));
                historyText.setText(historyText.getText() + "=" + SolveEqu);


                plus = false;
                minus = false;
                compose = false;
                divide = false;
            }
        }

        numberButton0.addActionListener(new ListenToZero());
        numberButton1.addActionListener(new ListenToOne());
        numberButton2.addActionListener(new ListenToTwo());
        numberButton3.addActionListener(new ListenToThree());
        numberButton4.addActionListener(new ListenToFour());
        numberButton5.addActionListener(new ListenToFive());
        numberButton6.addActionListener(new ListenToSix());
        numberButton7.addActionListener(new ListenToSeven());
        numberButton8.addActionListener(new ListenToEight());
        numberButton9.addActionListener(new ListenToNine());
        tickButton.addActionListener(new ListenToTick());

        clearButton.addActionListener(new ListenToClear());
        plusButton.addActionListener(new ListenToPlus());
        minusButton.addActionListener(new ListenToMinus());
        composeButton.addActionListener(new ListenToMulti());
        divideButton.addActionListener(new ListenToDivide());
        equButton.addActionListener(new ListenToSolve());
//        reverdDigit.addActionListener(new ListenToUnairOperation());
    }
}
