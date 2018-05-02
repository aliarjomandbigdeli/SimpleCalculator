import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CBtn extends JPanel {
    JButton[] numBtn;
    JButton[] opBtn;


    public CBtn() {
        super(new GridLayout(4, 4, 5, 5));


        numBtn = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numBtn[i] = new JButton("" + i);
            //numBtn[i].addActionListener();
        }
        opBtn = new JButton[6];
        opBtn[0] = new JButton("+");
        opBtn[1] = new JButton("-");
        opBtn[2] = new JButton("\u00F7");
        opBtn[3] = new JButton("=");
        opBtn[4] = new JButton(".");
        opBtn[5] = new JButton("\u00D7");

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
        add(opBtn[3]);
        add(numBtn[0]);
        add(opBtn[4]);
        add(opBtn[5]);

        int buttonWidth = numBtn[0].getPreferredSize().width + 20;
        int buttonHeight = numBtn[0].getPreferredSize().height + 20;
        numBtn[0].setPreferredSize(new Dimension(buttonWidth, buttonHeight));

    }

}
