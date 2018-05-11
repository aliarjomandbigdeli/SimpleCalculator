import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CBtn extends JPanel {
    JButton[] numBtn;
    JButton[] opBtn;

    Calc.CButtonHandler btnsHandler;
    Calc.KeyHandler keyHandler;

    public CBtn() {
        super(new GridLayout(4, 4, 5, 5));


        numBtn = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numBtn[i] = new JButton("" + i);
            numBtn[i].setActionCommand("number" + i);
            numBtn[i].addActionListener(btnsHandler);
            numBtn[i].addKeyListener(keyHandler);
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
        for (int i = 0; i < 6; i++) {
            opBtn[i].addActionListener(btnsHandler);
            opBtn[i].addKeyListener(keyHandler);
        }

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

    public void setBtnsHandler(Calc.CButtonHandler btnsHandler) {
        this.btnsHandler = btnsHandler;
    }

    public void setKeyHandler(Calc.KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }
}
