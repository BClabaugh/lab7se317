import org.example.CalculatorModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestModel {

    @Test
    public void testAddition() {
        CalculatorModel model = new CalculatorModel();
        model.calculate("+", 10, 5);
        assertEquals(15, model.getResult(),1);
    }

    @Test
    public void testDivisionByZero() {
        CalculatorModel model = new CalculatorModel();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            model.calculate("/", 10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    public void testSquareRootOfNegativeNumber() {
        CalculatorModel model = new CalculatorModel();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            model.calculate("√", -9, 0);
        });
        assertEquals("Cannot calculate square root of a negative number", exception.getMessage());
    }

    @Test
    public void testSquare() {
        CalculatorModel model = new CalculatorModel();
        model.calculate("^2", 5, 0);
        assertEquals(25, model.getResult(),1);
    }

    @Test
    public void testMemoryAddition() {
        CalculatorModel model = new CalculatorModel();
        model.addToMemory(10);
        assertEquals(10, model.recallMemory(),1);
    }

    @Test
    public void testMemorySubtraction() {
        CalculatorModel model = new CalculatorModel();
        model.addToMemory(10);
        model.subtractFromMemory(10);
        assertEquals(0, model.recallMemory(),1);
    }

    @Test
    public void testLargeNumberAddition() {
        CalculatorModel model = new CalculatorModel();
        model.calculate("+", 1_000_000_000, 1_000_000_000);
        assertEquals(2_000_000_000, model.getResult(), 1);
    }

    @Test
    public void testSmallNumberMultiplication() {
        CalculatorModel model = new CalculatorModel();
        model.calculate("*", 0.000000001, 0.000000001);
        assertEquals(1e-18, model.getResult(), 1e-19);
    }

    @Test
    public void testFloatingPointPrecision() {
        CalculatorModel model = new CalculatorModel();
        model.calculate("+", 0.1, 0.2);
        assertEquals(0.3, model.getResult(), 1e-15); // Precision tolerance
    }

    @Test
    public void testNegativeNumberDivision() {
        CalculatorModel model = new CalculatorModel();
        model.calculate("/", -20, 5);
        assertEquals(-4, model.getResult(), 1);
    }

    @Test
    public void testMemoryClear() {
        CalculatorModel model = new CalculatorModel();
        model.addToMemory(50);
        model.clearMemory();
        assertEquals(0, model.recallMemory(), 1);
    }

    @Test
    public void testInvalidOperation() {
        CalculatorModel model = new CalculatorModel();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            model.calculate("invalid", 10, 5);
        });
        assertEquals("Invalid operation", exception.getMessage());
    }

    @Test
    public void testMultipleOperations() {
        CalculatorModel model = new CalculatorModel();
        model.calculate("+", 10, 5);    // 10 + 5 = 15
        model.calculate("*", model.getResult(), 2);    // 15 * 2 = 30
        model.calculate("-", model.getResult(), 5);    // 30 - 5 = 25
        assertEquals(25, model.getResult(), 1);
    }

    @Test
    public void testMemoryAddAfterCalculation() {
        CalculatorModel model = new CalculatorModel();
        model.calculate("+", 10, 5);  // 10 + 5 = 15
        model.addToMemory(10);        // Add 10 to memory
        model.calculate("*", model.getResult(), 2);  // 15 * 2 = 30
        assertEquals(30, model.getResult(), 1);  // Main calculation is unaffected
    }








}

