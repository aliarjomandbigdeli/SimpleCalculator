import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class Calc {
    private JFrame calForm;
    private JLabel label;
    private JPanel fieldsPanel;
    private JButton[] numBtn;
    private JButton[] opBtn;
    private String resultText;
    double result;
    double temp;
    boolean[] opFlag;
    JMenu fileMenu;


    public Calc(String title) {
        resultText = "";
        result = 0;
        temp = 0;
        opFlag = new boolean[4];
        for (int i = 0; i < 4; i++) {
            opFlag[i] = false;
        }


        calForm = new JFrame(title);
        calForm.setLocationRelativeTo(null);
        calForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon iconImg = new ImageIcon("CalcIcon.png");
        calForm.setIconImage(iconImg.getImage());

        fileMenu = new JMenu("File"); // create file menu
        fileMenu.setMnemonic(KeyEvent.VK_F); // set mnemonic to F
        JMenuItem copyItem = new JMenuItem("Copy Result",KeyEvent.VK_C);
        KeyStroke ctrlCKeyStroke = KeyStroke.getKeyStroke("control C");
        copyItem.setAccelerator(ctrlCKeyStroke);
        //copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); // set mnemonic to x
        fileMenu.add(copyItem); // add copy item to file menu
        JMenuItem exitItem = new JMenuItem("Exit"); // create exit item
        exitItem.setMnemonic(KeyEvent.VK_X); // set mnemonic to x
        fileMenu.add(exitItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        calForm.setJMenuBar(menuBar);


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
        KeyHandler keyHandler = new KeyHandler();
        fieldsPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        numBtn = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numBtn[i] = new JButton("" + i);
            numBtn[i].addActionListener(btnsHandler);
            numBtn[i].addKeyListener(keyHandler);
        }
        opBtn = new JButton[6];
        opBtn[0] = new JButton("+");
        opBtn[0].setToolTipText("addition");
        opBtn[1] = new JButton("-");
        opBtn[1].setToolTipText("subtraction");
        opBtn[2] = new JButton("\u00F7");
        opBtn[2].setToolTipText("division");
        opBtn[3] = new JButton("\u00D7");
        opBtn[3].setToolTipText("multiplication");
        opBtn[4] = new JButton("C");
        opBtn[4].setToolTipText("clear");
        opBtn[5] = new JButton("=");
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
        fieldsPanel.add(opBtn[5]);
        fieldsPanel.add(numBtn[0]);
        fieldsPanel.add(opBtn[4]);
        fieldsPanel.add(opBtn[3]);

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
            for (int i = 0; i < 4; i++) {
                if (e.getSource().equals(opBtn[i])) {
                    opFlag[i] = true;
                    result = temp;
                    temp = 0;
                    resultText = "";
                    label.setText(resultText);
                }
            }
            if (e.getSource().equals(opBtn[4])) {
                result = 0;
                temp = 0;
                resultText = "";
                label.setText(resultText);
            } else if (e.getSource().equals(opBtn[5])) {
                operatorOperations();
                label.setText("" + result);
            } else {
                for (int i = 0; i < 10; i++) {
                    if (e.getSource().equals(numBtn[i])) {
                        if (resultText.length() < 14) {
                            resultText = resultText + i;
                        }
                        temp = Double.parseDouble(resultText);
                        label.setText(resultText);
                    }
                }
            }
        }
    }


    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_0:
                    if (resultText.length() < 14) {
                        resultText = resultText + 0;
                    }
                    temp = Double.parseDouble(resultText);
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_1:
                    if (resultText.length() < 14) {
                        resultText = resultText + 1;
                    }
                    temp = Double.parseDouble(resultText);
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_2:
                    if (resultText.length() < 14) {
                        resultText = resultText + 2;
                    }
                    temp = Double.parseDouble(resultText);
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_3:
                    if (resultText.length() < 14) {
                        resultText = resultText + 3;
                    }
                    temp = Double.parseDouble(resultText);
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_4:
                    if (resultText.length() < 14) {
                        resultText = resultText + 4;
                    }
                    temp = Double.parseDouble(resultText);
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_5:
                    if (resultText.length() < 14) {
                        resultText = resultText + 5;
                    }
                    temp = Double.parseDouble(resultText);
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_6:
                    if (resultText.length() < 14) {
                        resultText = resultText + 6;
                    }
                    temp = Double.parseDouble(resultText);
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_7:
                    if (resultText.length() < 14) {
                        resultText = resultText + 7;
                    }
                    temp = Double.parseDouble(resultText);
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_8:
                    if (resultText.length() < 14) {
                        resultText = resultText + 8;
                    }
                    temp = Double.parseDouble(resultText);
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_9:
                    if (resultText.length() < 14) {
                        resultText = resultText + 9;
                    }
                    temp = Double.parseDouble(resultText);
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_PLUS:
                    opFlag[0] = true;
                    result = temp;
                    temp = 0;
                    resultText = "";
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_MINUS:
                    opFlag[1] = true;
                    result = temp;
                    temp = 0;
                    resultText = "";
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_DIVIDE:
                    opFlag[2] = true;
                    result = temp;
                    temp = 0;
                    resultText = "";
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_MULTIPLY:
                    opFlag[3] = true;
                    result = temp;
                    temp = 0;
                    resultText = "";
                    label.setText(resultText);
                    break;
                case KeyEvent.VK_EQUALS:
                    operatorOperations();
                    label.setText("" + result);
                    break;
                case KeyEvent.VK_C: //copy result
                    StringSelection stringSelection = new StringSelection(resultText);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);
                    //System.out.println("'c' released.");
                    break;

                case KeyEvent.VK_F:
                    fileMenu.doClick();
                    break;
            }
        }
    }


    private void operatorOperations(){
        if (opFlag[0]) {
            result += temp;
            opFlag[0] = false;
        } else if (opFlag[1]) {
            result -= temp;
            opFlag[1] = false;
        } else if (opFlag[2]) {
            result /= temp;
            opFlag[2] = false;
        } else if (opFlag[3]) {
            result *= temp;
            opFlag[3] = false;
        }
        temp = result;
    }
}
