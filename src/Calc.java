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


    public Calc(String title) {
        calForm = new JFrame(title);
        calForm.setLocationRelativeTo(null);
        calForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon iconImg = new ImageIcon("CalcIcon.png");
        System.out.println(iconImg.getIconHeight());
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
        JButton[] opBtn;
        opBtn = new JButton[6];
        opBtn[0] = new JButton("+");
        opBtn[1] = new JButton("-");
        opBtn[2] = new JButton("\u00F7");
        opBtn[3] = new JButton("=");
        opBtn[4] = new JButton(".");
        opBtn[5] = new JButton("\u00D7");

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
            for (int i = 0; i < 10; i++) {
                if (e.getSource().equals(numBtn[i])) {
                    label.setText("" + i);
                    System.out.println("" + i);
                }
            }
        }
    }

}
