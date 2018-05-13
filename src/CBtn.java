import javax.swing.*;
import java.awt.*;

public class CBtn extends JPanel {
    JButton[] numBtn;
    JButton[] opBtn;

    public CBtn() {
        super(new GridLayout(4, 4, 5, 5));


        numBtn = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numBtn[i] = new JButton("" + i);
            numBtn[i].setActionCommand("number" + i);
            //numBtn[i].setFocusable(false);
        }
        opBtn = new JButton[6];
        opBtn[0] = new JButton("+");
        opBtn[0].setToolTipText("addition");
        opBtn[0].setActionCommand("addition");
        opBtn[1] = new JButton("-");
        opBtn[1].setToolTipText("subtraction");
        opBtn[1].setActionCommand("subtraction");
        opBtn[2] = new JButton("\u00F7");
        opBtn[2].setToolTipText("division");
        opBtn[2].setActionCommand("division");
        opBtn[3] = new JButton("\u00D7");
        opBtn[3].setToolTipText("multiplication");
        opBtn[3].setActionCommand("multiplication");
        opBtn[4] = new JButton("C");
        opBtn[4].setToolTipText("clear");
        opBtn[4].setActionCommand("clear");
        opBtn[5] = new JButton("=");
        opBtn[5].setToolTipText("equal");
        opBtn[5].setActionCommand("equal");

        for (int i = 1; i < 4; i++) {
            add(numBtn[i]);
        }
        add(opBtn[0]);
        for (int i = 4; i < 7; i++) {
            add(numBtn[i]);
        }
        add(opBtn[1]);
        for (int i = 7; i < 10; i++) {
            add(numBtn[i]);
        }
        add(opBtn[2]);
        add(opBtn[5]);
        add(numBtn[0]);
        add(opBtn[4]);
        add(opBtn[3]);

        int buttonWidth = numBtn[0].getPreferredSize().width + 20;
        int buttonHeight = numBtn[0].getPreferredSize().height + 20;
        numBtn[0].setPreferredSize(new Dimension(buttonWidth, buttonHeight));

    }

    public void setActionListener(Calc.CButtonHandler listener) {
        for (int i = 0; i < 10; i++) {
            numBtn[i].addActionListener(listener);
        }
        for (int i = 0; i < 6; i++) {
            opBtn[i].addActionListener(listener);
        }


    }

    public void setKeyHandler(Calc.KeyHandler keyHandler) {
        for (int i = 0; i < 10; i++) {
            numBtn[i].addKeyListener(keyHandler);
        }
        for (int i = 0; i < 6; i++) {
            opBtn[i].addKeyListener(keyHandler);
        }
    }


//    @Override
//    public void actionPerformed(ActionEvent e) {
//        for (int i = 0; i < 4; i++) {
//            if (e.getSource().equals(opBtn[i])) {
//                opFlag[i] = true;
//                result = temp;
//                temp = 0;
//                resultText = "";
//                label.setText(resultText);
//            }
//        }
//        if (e.getSource().equals(opBtn[4])) {
//            result = 0;
//            temp = 0;
//            resultText = "";
//            label.setText(resultText);
//        } else if (e.getSource().equals(opBtn[5])) {
//            operatorOperations();
//            label.setText("" + result);
//        } else {
//            for (int i = 0; i < 10; i++) {
//                if (e.getSource().equals(numBtn[i])) {
//                    if (resultText.length() < 14) {
//                        resultText = resultText + i;
//                    }
//                    temp = Double.parseDouble(resultText);
//                    label.setText(resultText);
//                }
//            }
//        }
//    }
//
//    private void operatorOperations() {
//        if (opFlag[0]) {
//            result += temp;
//            opFlag[0] = false;
//        } else if (opFlag[1]) {
//            result -= temp;
//            opFlag[1] = false;
//        } else if (opFlag[2]) {
//            result /= temp;
//            opFlag[2] = false;
//        } else if (opFlag[3]) {
//            result *= temp;
//            opFlag[3] = false;
//        }
//        temp = result;
//    }

}
