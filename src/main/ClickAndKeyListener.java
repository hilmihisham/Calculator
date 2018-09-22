package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author hilmi
 */
public class ClickAndKeyListener implements ActionListener {

    // ----- click action -----

    /**
     * Invoked when an action occurs.
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // getting which button was clicked
        String s = e.getActionCommand();
        // print out button for testing purposes
        System.out.println("----------\ns = " + s);
        System.out.println("clicked!\n----------");

        mapActionToButton(s);

        CalculatorFrame.updateTextField();
    }

    private void mapActionToButton(String s) {
        // if number or dot button was clicked
        if ((s.charAt(0) >= '0') && (s.charAt(0) <= '9')) {
            if (CalculatorFrame.inputoperand.isEmpty()) {
                CalculatorFrame.input1 += s;
                System.out.println("userinput1 = " + CalculatorFrame.input1);
            }
            else {
                CalculatorFrame.input2 += s;
                System.out.println("userinput2 = " + CalculatorFrame.input2);
            }
        }
        // dot button clicked
        if (s.charAt(0) == '.') {
            if (CalculatorFrame.inputoperand.isEmpty()) {
                if (CalculatorFrame.dot1) {
                    if (CalculatorFrame.input1.isEmpty()) {
                        CalculatorFrame.input1 = "0.";
                        System.out.println("userinput1 = " + CalculatorFrame.input1);
                        CalculatorFrame.dot1 = false;
                    }
                    else {
                        CalculatorFrame.input1 += s;
                        System.out.println("userinput1 = " + CalculatorFrame.input1);
                        CalculatorFrame.dot1 = false;
                    }
                }

            }
            else {
                if (CalculatorFrame.dot2) {
                    if (CalculatorFrame.input2.isEmpty()) {
                        CalculatorFrame.input2 = "0.";
                        System.out.println("userinput2 = " + CalculatorFrame.input2);
                        CalculatorFrame.dot2 = false;
                    }
                    else {
                        CalculatorFrame.input2 += s;
                        System.out.println("userinput2 = " + CalculatorFrame.input2);
                        CalculatorFrame.dot2 = false;
                    }
                }
            }
        }
        // C clicked, clear all input
        else if (s.charAt(0) == 'C') {
            CalculatorFrame.input1 = CalculatorFrame.input2 = CalculatorFrame.inputoperand = "";
            System.out.println("input1 = " + CalculatorFrame.input1 + " <-");
            System.out.println("inputop = " + CalculatorFrame.inputoperand + " <-");
            System.out.println("input2 = " + CalculatorFrame.input2 + " <-");

            // reset flag for .
            CalculatorFrame.dot1 = CalculatorFrame.dot2 = true;

            // erasing bufferTextField
            CalculatorFrame.updateBufferText(false);
        }
        // delete button clicked (only works if there's something in the string)
        else if (s.charAt(0) == '<') {
            if (CalculatorFrame.inputoperand.isEmpty() && !CalculatorFrame.input1.isEmpty()) {

                // reset . flag if we erased . instead of number
                if (CalculatorFrame.input1.endsWith(".")) {
                    CalculatorFrame.dot1 = true;

                    // erase last input
                    CalculatorFrame.input1 =
                            CalculatorFrame.input1.substring(0, CalculatorFrame.input1.length()-1);
                    System.out.println("new input1 = " + CalculatorFrame.input1);
                }
                // if input1 was infinity
                else if (CalculatorFrame.input1.endsWith("y") || CalculatorFrame.input1.endsWith("N")) {
                    CalculatorFrame.input1 = "";
                    CalculatorFrame.dot1 = true;
                }
                else {
                    // erase last input
                    CalculatorFrame.input1 =
                            CalculatorFrame.input1.substring(0, CalculatorFrame.input1.length()-1);
                    System.out.println("new input1 = " + CalculatorFrame.input1);
                }

            }
            if (!CalculatorFrame.inputoperand.isEmpty() && !CalculatorFrame.input2.isEmpty()) {

                // reset . flag if we erased . instead of number
                if (CalculatorFrame.input2.endsWith("."))
                    CalculatorFrame.dot2 = true;

                // erase last input
                CalculatorFrame.input2 =
                        CalculatorFrame.input2.substring(0, CalculatorFrame.input2.length()-1);
                System.out.println("new input2 = " + CalculatorFrame.input2);
            }
        }
        // operand clicked
        else {
            if (s.charAt(0) == '+') {
                CalculatorFrame.inputoperand = "+";
                System.out.println("inputoperand = " + CalculatorFrame.inputoperand);

                // if operand was pressed and input1 is empty
                if (CalculatorFrame.input1.isEmpty())
                    CalculatorFrame.input1 = "0";

                // updating bufferTextInput to display 1st input and the operand
                CalculatorFrame.updateBufferText(true);
            }
            if (s.charAt(0) == '-') {
                CalculatorFrame.inputoperand = "-";
                System.out.println("inputoperand = " + CalculatorFrame.inputoperand);

                // if operand was pressed and input1 is empty
                if (CalculatorFrame.input1.isEmpty())
                    CalculatorFrame.input1 = "0";

                // updating bufferTextInput to display 1st input and the operand
                CalculatorFrame.updateBufferText(true);
            }
            if (s.charAt(0) == 'x') {
                CalculatorFrame.inputoperand = "*";
                System.out.println("inputoperand = " + CalculatorFrame.inputoperand);

                // if operand was pressed and input1 is empty
                if (CalculatorFrame.input1.isEmpty())
                    CalculatorFrame.input1 = "0";

                // updating bufferTextInput to display 1st input and the operand
                CalculatorFrame.updateBufferText(true);
            }
            if (s.charAt(0) == '÷') {
                CalculatorFrame.inputoperand = "/";
                System.out.println("inputoperand = " + CalculatorFrame.inputoperand);

                // if operand was pressed and input1 is empty
                if (CalculatorFrame.input1.isEmpty())
                    CalculatorFrame.input1 = "0";

                // updating bufferTextInput to display 1st input and the operand
                CalculatorFrame.updateBufferText(true);
            }
            if (s.charAt(0) == '%') {
                CalculatorFrame.inputoperand = "%";
                System.out.println("inputoperand = " + CalculatorFrame.inputoperand);

                // if operand was pressed and input1 is empty
                if (CalculatorFrame.input1.isEmpty())
                    CalculatorFrame.input1 = "0";

                // updating bufferTextInput to display 1st input and the operand
                CalculatorFrame.updateBufferText(true);
            }
            if (s.charAt(0) == '=') {
                if (!CalculatorFrame.input1.isEmpty() && !CalculatorFrame.input2.isEmpty()
                        && !CalculatorFrame.inputoperand.isEmpty()) {

                    System.out.println("input1 = " + CalculatorFrame.input1 + " <-");
                    System.out.println("inputop = " + CalculatorFrame.inputoperand + " <-");
                    System.out.println("input2 = " + CalculatorFrame.input2 + " <-");

                    // perform calculation, update result to input1, erase the rest
                    Solver solver = new Solver();
                    System.out.println("-----\ntotal = " + solver.getTotal() + "\n-----");
                    System.out.println("-----\ntotal = " + solver.getFormattedTotal() + "\n-----");

                    CalculatorFrame.input1 = solver.getFormattedTotal();

                    CalculatorFrame.input2 = CalculatorFrame.inputoperand = "";

                    // reset flag for dot2 (dot1 handled in solver)
                    CalculatorFrame.dot2 = true;
                    System.out.println("dot 1 = " + CalculatorFrame.dot1);
                    System.out.println("dot 2 = " + CalculatorFrame.dot2);

                    // erasing bufferTextField
                    CalculatorFrame.updateBufferText(false);
                }
            }
        }
    }

}
