package main;

/**
 * @author hilmi
 */
public class Solver {

    private float in1, in2, total;
    private String operand;

    // constructor
    public Solver() {

        try {
            this.in1 = Float.parseFloat(CalculatorFrame.input1);
        }
        catch (NullPointerException npe) {
            this.in1 = 0;
        }

        try {
            this.in2 = Float.parseFloat(CalculatorFrame.input2);
        }
        catch (NullPointerException npe) {
            this.in2 = 0;
        }

        //this.in1 = Float.parseFloat(CalculatorFrame.input1);
        //this.in2 = Float.parseFloat(CalculatorFrame.input2);
        this.operand = CalculatorFrame.inputoperand;

        total = solveInput(in1, operand, in2);
    }

    public float solveInput(float input1, String op, float input2) {
        float answer = 0.0f;

        if (op.charAt(0) == '+') {
            answer =  in1 + in2;
        }
        if (operand.charAt(0) == '-') {
            answer = in1 - in2;
        }
        if (operand.charAt(0) == '*') {
            answer = in1 * in2;
        }
        if (operand.charAt(0) == '/') {
            answer = in1 / in2;
        }
        if (operand.charAt(0) == '%') {
            answer = in1 % in2;
        }

        return answer;
    }

    public float getTotal() {
        return total;
    }

    public String getFormattedTotal() {
        String formatted = String.valueOf(total);

        // reset input1 to rounded number if it's x.0
        if ((total % 1 == 0)|| (formatted.endsWith(".0"))) {
            formatted = formatted.substring(0, formatted.length()-2);
            CalculatorFrame.dot1 = true;
        }
        // we have decimal point in our total
        else if (total % 1 != 0) {
            CalculatorFrame.dot1 = false;
        }
        return formatted;
    }
}
