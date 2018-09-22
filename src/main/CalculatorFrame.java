package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/**
 * @author hilmi
 */
public class CalculatorFrame extends JFrame {

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 900;

    private static final int TEXTFIELD_HEIGHT = 150;

    private JPanel panel;
    private static JTextField buffertextField;
    private static JTextField mainTextField;

    private KeyListener keyListener;

    // all the input from button clicking goes here
    public static String input1, inputoperand, input2;

    // dot button (for handling bad input via . button)
    public static boolean dot1, dot2;

    // constructor
    public CalculatorFrame() {

        // initializing string that gonna hold user input
        input1 = "";
        inputoperand = "";
        input2 = "";

        // true if we can still accept . in the input
        dot1 = true;
        dot2 = true;

        // creating all the GUI components
        createTextField();

        // putting all the GUI onto the panel
        createPanel();

        // set size for the whole frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createTextField() {
        buffertextField = new JTextField();
        buffertextField.setPreferredSize(new Dimension(FRAME_WIDTH-20, 60));
        buffertextField.setFont(new Font("Calibri", Font.BOLD, 35));
        buffertextField.setHorizontalAlignment(JTextField.RIGHT);
        buffertextField.setEditable(false);

        mainTextField = new JTextField();
        mainTextField.setPreferredSize(new Dimension(FRAME_WIDTH-20, TEXTFIELD_HEIGHT));
        mainTextField.setFont(new Font("Calibri", Font.BOLD, 70));
        mainTextField.setHorizontalAlignment(JTextField.RIGHT);
    }

    // updating the main text field
    public static void updateTextField() {
        if (input2.equals(""))
            mainTextField.setText(input1 + inputoperand);
        else
            mainTextField.setText(input2);
    }

    // update is false only if the = was pressed, erasing all the text in the field
    public static void updateBufferText(boolean update) {
        if (update)
            buffertextField.setText(input1 + " " + inputoperand);
        else
            buffertextField.setText("");
    }

    private void createPanel() {
        panel = new JPanel();

        // adding all GUI onto panel
        panel.add(buffertextField);
        panel.add(mainTextField);

        // add buttons
        panel.add(new CalculatorButton("C").getButton());
        panel.add(new CalculatorButton("<-").getButton());
        panel.add(new CalculatorButton("%").getButton());
        panel.add(new CalculatorButton("÷").getButton());

        panel.add(new CalculatorButton("7").getButton());
        panel.add(new CalculatorButton("8").getButton());
        panel.add(new CalculatorButton("9").getButton());
        panel.add(new CalculatorButton("x").getButton());

        panel.add(new CalculatorButton("4").getButton());
        panel.add(new CalculatorButton("5").getButton());
        panel.add(new CalculatorButton("6").getButton());
        panel.add(new CalculatorButton("-").getButton());

        panel.add(new CalculatorButton("1").getButton());
        panel.add(new CalculatorButton("2").getButton());
        panel.add(new CalculatorButton("3").getButton());
        panel.add(new CalculatorButton("+").getButton());

        panel.add(new CalculatorButton("00").getButton());
        panel.add(new CalculatorButton("0").getButton());
        panel.add(new CalculatorButton(".").getButton());
        panel.add(new CalculatorButton("=").getButton());

        // adding panel to frame
        add(panel);

    }

}
