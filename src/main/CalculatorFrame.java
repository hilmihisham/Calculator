package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/**
 * @author hilmi
 */
public class CalculatorFrame extends JFrame {

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 750;

    private static final int TEXTFIELD_HEIGHT = 150;

    private JPanel panel;
    private static JTextField textField;

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
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(FRAME_WIDTH-20, TEXTFIELD_HEIGHT));
        textField.setFont(new Font("Calibri", Font.BOLD, 80));
        //textField.setEditable(false);
    }

    public static void updateTextField() {
        textField.setText(input1 + inputoperand + input2);
    }

    private void createPanel() {
        panel = new JPanel();

        // adding all GUI onto panel
        panel.add(textField);

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
