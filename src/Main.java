import javax.swing.*;

/**
 * this class is for running Calculator
 *
 * @author Ali ArjomandBigdeli
 * @since 5.13.2018
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Calc cal = new Calc("Calculator");
        cal.showGUI();
    }
}
