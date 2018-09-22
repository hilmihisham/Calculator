package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author hilmi
 */
public class CalculatorMenu extends JMenuBar {

    // items for menu bar
    private JMenuBar bar;
    private JMenu menu;
    private JMenuItem about;
    private JMenuItem exit;

    public CalculatorMenu() {
        buildMenu();
        addMenuListener();
    }

    private void buildMenu() {
        bar = new JMenuBar();
        menu = new JMenu("Menu");
        about = new JMenuItem("About");
        exit = new JMenuItem("Exit");

        about.setFont(new Font("Calibri", Font.PLAIN, 35));
        exit.setFont(new Font("Calibri", Font.PLAIN, 35));

        menu.add(about);
        menu.add(exit);
        menu.setFont(new Font("Calibri", Font.PLAIN, 35));

        bar.add(menu);
    }

    private void addMenuListener() {

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutActionPerformed();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitActionPerformed();
            }
        });
    }

    private void aboutActionPerformed() {

        JLabel aboutText = new JLabel("Created by @hilmihisham");
        aboutText.setFont(new Font("Calibri", Font.PLAIN, 25));

        JOptionPane.showMessageDialog(Main.frame, aboutText,"About", JOptionPane.INFORMATION_MESSAGE);
    }

    private void exitActionPerformed() {
        System.exit(0);
    }

    public JMenuBar getBar() {
        return bar;
    }
}
