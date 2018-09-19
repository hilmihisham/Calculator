package main;

/**
 * @author hilmi
 */
public class Solver {

    private Double in1, in2, total;
    private String operand;

    // constructor
    public Solver() {
        this.in1 = Double.parseDouble(CalculatorFrame.input1);
        this.in2 = Double.parseDouble(CalculatorFrame.input2);
        this.operand = CalculatorFrame.inputoperand;

        total = solveInput(in1, operand, in2);
    }

    public Double solveInput(Double input1, String op, Double input2) {
        double answer = 0.0;

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

    public Double getTotal() {
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
