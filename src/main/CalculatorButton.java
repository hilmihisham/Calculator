package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author hilmi
 */
public class CalculatorButton extends JButton {

    // items for buttons
    private JButton button;
    private String text;

    // constructor
    public CalculatorButton(String buttonText) {
        button = new JButton(buttonText);
        this.text = buttonText;
        createButton(button);
        setColor(button);
        addListener(button);
    }

    private void setColor(JButton b) {
        if ((text.charAt(0) >= '0') && (text.charAt(0) <= '9'))
            b.setBackground(Color.LIGHT_GRAY);
        else if (text.charAt(0) == 'C') {
            float[] colorC = new float[3];
            Color.RGBtoHSB(145, 30, 50, colorC);
            b.setBackground(Color.getHSBColor(colorC[0], colorC[1], colorC[2]));
            b.setForeground(Color.WHITE);
        }
        else if (text.charAt(0) == '<')
            b.setBackground(Color.PINK);
        else
            b.setBackground(Color.WHITE);
    }

    private void createButton(JButton b) {
        b.setFont(new Font("Calibri", Font.BOLD, 50));
        b.setPreferredSize(new Dimension(110, 110));
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
