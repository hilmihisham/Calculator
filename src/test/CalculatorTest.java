package test;

import main.Calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import main.Solver;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void evaluatesExpression() {
        /*
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("1+2+3");
        assertEquals(6, sum);
        */

        Solver solver = new Solver();
        double sum = solver.solveInput(1.0, "+", 2.5);
        assertEquals(3.5, sum);
    }

    /*
    @Test
    public void expectingNullPtrException() {
        Calculator calculator = new Calculator();
        String s = "";
        String retVal = calculator.badString(s);
        // expecting a String of length 10 (for example),
        // but will receive a String with length 0 (this test will fail)
        assertEquals(10, retVal.length());
    }
    */
}
