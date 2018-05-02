import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc {
    private JFrame calForm;
    private JLabel label;
    private JPanel fieldsPanel;
    JButton[] numBtn;
    JButton[] opBtn;
    String resultText;
    double result;
    double temp;

    boolean flagPlus;
    boolean flagMinus;
    boolean flagDivide;
    boolean flagMultiply;


    public Calc(String title) {
        resultText = "";
        result = 0;
        temp = 0;
        flagPlus = false;
        flagMinus = false;
        flagDivide = false;
        flagMultiply = false;


        calForm = new JFrame(title);
        calForm.setLocationRelativeTo(null);
        calForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon iconImg = new ImageIcon("CalcIcon.png");
        calForm.setIconImage(iconImg.getImage());

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        calForm.setContentPane(panel);

        label = new JLabel(" 0 ");
        label.setBackground(Color.GRAY);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 30;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));


        //fieldsPanel = new GridLayout(4, 4, 5, 5));
        CButtonHandler btnsHandler = new CButtonHandler();
        fieldsPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        numBtn = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numBtn[i] = new JButton("" + i);
            numBtn[i].addActionListener(btnsHandler);
        }
        opBtn = new JButton[6];
        opBtn[0] = new JButton("+");
        opBtn[1] = new JButton("-");
        opBtn[2] = new JButton("\u00F7");   //divide
        opBtn[3] = new JButton("=");
        opBtn[4] = new JButton("C");
        opBtn[5] = new JButton("\u00D7");   //multiply
        for (int i = 0; i < 6; i++) {
            opBtn[i].addActionListener(btnsHandler);
        }

        for (int i = 1; i < 4; i++) {
            fieldsPanel.add(numBtn[i]);
        }
        fieldsPanel.add(opBtn[0]);
        for (int i = 4; i < 7; i++) {
            fieldsPanel.add(numBtn[i]);
        }
        fieldsPanel.add(opBtn[1]);
        for (int i = 7; i < 10; i++) {
            fieldsPanel.add(numBtn[i]);
        }
        fieldsPanel.add(opBtn[2]);
        fieldsPanel.add(opBtn[3]);
        fieldsPanel.add(numBtn[0]);
        fieldsPanel.add(opBtn[4]);
        fieldsPanel.add(opBtn[5]);

        int buttonWidth = numBtn[0].getPreferredSize().width + 20;
        int buttonHeight = numBtn[0].getPreferredSize().height + 20;
        numBtn[0].setPreferredSize(new Dimension(buttonWidth, buttonHeight));


        panel.add(label, BorderLayout.NORTH);
        panel.add(fieldsPanel, BorderLayout.CENTER);
    }

    public void showGUI() {
        calForm.pack();
        calForm.setVisible(true);
    }

    public class CButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(opBtn[4])) {
                result = 0;
                temp = 0;
                resultText = "";
                label.setText(resultText);
            } else if (e.getSource().equals(opBtn[0])) {
                flagPlus = true;
                result = temp;
                temp = 0;
                resultText = "";
                label.setText(resultText);
            } else if (e.getSource().equals(opBtn[1])) {
                flagMinus = true;
                result = temp;
                temp = 0;
                resultText = "";
                label.setText(resultText);
            } else if (e.getSource().equals(opBtn[2])) {
                flagDivide = true;
                result = temp;
                temp = 0;
                resultText = "";
                label.setText(resultText);
            } else if (e.getSource().equals(opBtn[5])) {
                flagMultiply = true;
                result = temp;
                temp = 0;
                resultText = "";
                label.setText(resultText);
            } else if (e.getSource().equals(opBtn[3])) {
                if (flagPlus) {
                    result += temp;
                    flagPlus = false;
                } else if (flagMinus) {
                    result -= temp;
                    flagMinus = false;
                } else if (flagDivide) {
                    result /= temp;
                    flagDivide = false;
                } else if (flagMultiply) {
                    result *= temp;
                    flagMultiply = false;
                }
                temp = result;
                label.setText("" + result);
            } else {
                for (int i = 0; i < 10; i++) {
                    if (e.getSource().equals(numBtn[i])) {
                        if (resultText.length() < 14) {
                            resultText = resultText + i;
                        }
                        temp = Double.parseDouble(resultText);
                        label.setText(resultText);
                        System.out.println("" + i);
                    }
                }
            }
        }
    }

}
