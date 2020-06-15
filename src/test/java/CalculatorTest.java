import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
      calculator = new Calculator(new Validator(), new Converter());
    }

    @Test
    public void calculate() {
        Assert.assertEquals(calculator.calculate("-(22+2+2)*(2+4)/(-2)"), "78");
        Assert.assertEquals(calculator.calculate("55/2"), "27.5");
    }
}