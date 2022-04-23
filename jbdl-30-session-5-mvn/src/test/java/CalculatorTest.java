import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void test(){
        Calculator calculator = new Calculator();
        int actual = calculator.add(2,3);
        int expected = 100;
        Assert.assertEquals(expected,actual);
    }

}
