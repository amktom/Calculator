import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

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
    private JButton leftBracketButton;
    private JButton rightBracketButton;

    public Calculator()
    {
        setTitle("Calculator");
        setSize(400, 500);
        add(mainForm);
        outputText.setEditable(false);

        class ListenToOne implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "1");
            }
        }

        class ListenToTwo implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "2");
            }
        }

        class ListenToThree implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "3");
            }
        }

        class ListenToFour implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "4");
            }
        }

        class ListenToFive implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "5");
            }
        }

        class ListenToSix implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "6");
            }
        }

        class ListenToSeven implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "7");
            }
        }

        class ListenToEight implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "8");
            }
        }

        class ListenToNine implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "9");
            }
        }

//        class ListenToTick implements ActionListener {
//            public void actionPerformed(ActionEvent e) {
//                outputText.setText(outputText.getText() + ".");
//            }
//        }

        class ListenToZero implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "0");
            }
        }

        class ListenToLeftBracket implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "(");
            }
        }

        class ListenToRightBracket implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + ")");
            }
        }

//        class ListenToUnairOperation implements ActionListener {
//            public void actionPerformed(ActionEvent e) {
//                equ = -Double.parseDouble(outputText.getText());
//                outputText.setText(""+ equ);
//                unair = true;
//
//            }
//        }

        class ListenToClear implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText("");
            }
        }

        class ListenToPlus implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "+");
            }
        }

        class ListenToMinus implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "-");
            }
        }

        class ListenToMulti implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "*");
            }
        }

        class ListenToDivide implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(outputText.getText() + "/");
            }
        }

        class ListenToSolve implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                outputText.setText(Integer.toString(eval(outputText.getText())));
//                outputText.setText(Double.toString(eval(outputText.getText())));
            }
        }
        //Привязка лисанеров к кнопкам с цифрами/точкой/скобками/операциями
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
        leftBracketButton.addActionListener(new ListenToLeftBracket());
        rightBracketButton.addActionListener(new ListenToRightBracket());

        clearButton.addActionListener(new ListenToClear());
        plusButton.addActionListener(new ListenToPlus());
        minusButton.addActionListener(new ListenToMinus());
        composeButton.addActionListener(new ListenToMulti());
        divideButton.addActionListener(new ListenToDivide());
        equButton.addActionListener(new ListenToSolve());

    }

    static boolean isDelim(char c) { // функция возвращает тру если пробел
        return c == ' ';
    }
    static boolean isOperator(char c) { // функция возвращяет тру если один из символов ниже
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    static int priority(char op) { // функция возвращает приоритет операции
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
    static void processOperator(LinkedList<Integer> st, char op) {
        int r = st.removeLast(); // выдёргивает из упорядоченного листа последний элемент
        int l = st.removeLast(); // также
        switch (op) { // выполняет действие между l и r в зависимости от оператора в кейсе и результат валим в st
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
        }
    }
    public static int eval(String s) {
        LinkedList<Integer> st = new LinkedList<Integer>(); // лист с цифрами
        LinkedList<Character> op = new LinkedList<Character>(); // лист с операторами в порядке поступления
        for (int i = 0; i < s.length(); i++) { // парсится строка с текствью
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st,op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    operand += s.charAt(i++);
                --i;
                st.add(Integer.parseInt(operand));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);  // результат
    }
}
