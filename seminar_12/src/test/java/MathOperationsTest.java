import org.example.MathOperations;
import org.junit.Test;
import static org.junit.Assert.*;

public class MathOperationsTest {
    private MathOperations mathOperations = new MathOperations();

    @Test
    public void testAdd() {
        assertEquals(8, mathOperations.add(3, 5));
    }

    @Test
    public void testSubtract() {
        assertEquals(6, mathOperations.subtract(10, 4));
    }

    @Test
    public void testMultiply() {
        assertEquals(15, mathOperations.multiply(3, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, mathOperations.divide(5, 2), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        mathOperations.divide(10, 0);
    }
}