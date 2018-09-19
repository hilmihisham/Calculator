package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author hilmi
 */
public class CalculatorButton extends JButton {

    // items for buttons
    JButton button;

    // constructor
    public CalculatorButton(String buttonText) {
        button = new JButton(buttonText);
        createButton(button);
        addListener(button);
    }

    private void createButton(JButton b) {
        b.setFont(new Font("Calibri", Font.BOLD, 50));
        b.setPreferredSize(new Dimension(85, 85));
        b.setVisible(true);
    }

    private void addListener(JButton b) {
        ActionListener listener = new ClickAndKeyListener();
        b.addActionListener(listener);
    }


    public JButton getButton() {
        return button;
    }
}
