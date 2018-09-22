package main;

import javax.swing.*;

/**
 * @author hilmi
 */
public class Main {

    public static JFrame frame;

    public static void main(String[] args) {
        // set up the frame from CalculatorFrame
        frame = new CalculatorFrame();

        // other behavior setting for the frame
        frame.setTitle("Calculator");
        frame.setJMenuBar(new CalculatorMenu().getBar());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}