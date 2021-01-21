package kata.moderate;

import kata.moderate.calculator.Calculator;
import kata.moderate.calculator.CalculatorWithStack;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void calculateTest() {
        Calculator calculator = new Calculator();
        double actual = calculator.calculate("2-6-7*8/2+5");
        System.err.println(actual);
        Assert.assertEquals(-27.0, actual, 0.5);
    }

    @Test
    public void calculateStackTest() {
        CalculatorWithStack calculator = new CalculatorWithStack();
        double actual = calculator.calculate("2-6-7*8/2+5");
        System.err.println(actual);
        Assert.assertEquals(-27.0, actual, 0.5);
    }
}
