package simplejavacalculatorTest;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import simplejavacalculator.Calculator;

/**
 * Test suite for binary operations (operations involving two operands)
 * Tests: normal, add, minus, multiply, divide, xpowerofy
 */
public class CalculatorBiOperatorTest {
    
    private Calculator calculator;
    
    @Before
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    public void testCalculateBiNormal() {
        calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.0);
        Double result = calculator.calculateBi(Calculator.BiOperatorModes.normal, 3.0);
        assertTrue("Result should be NaN for normal mode", Double.isNaN(result));
    }

    @Test
    public void testCalculateBiAdd() {
        calculator.calculateBi(Calculator.BiOperatorModes.add, 3.0);
        Double result = calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.5);
        assertEquals("Addition should work correctly", 5.5, result, 0.0001);
    }

    @Test
    public void testCalculateBiMinus() {
        calculator.calculateBi(Calculator.BiOperatorModes.minus, 3.1415);
        Double result = calculator.calculateBi(Calculator.BiOperatorModes.normal, 1.1);
        assertEquals("Subtraction should work correctly", 2.0415, result, 0.0001);
    }

    @Test
    public void testCalculateBiMultiply() {
        calculator.calculateBi(Calculator.BiOperatorModes.multiply, 3.2);
        Double result = calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.0);
        assertEquals("Multiplication should work correctly", 6.4, result, 0.0001);
    }

    @Test
    public void testCalculateBiDivide() {
        calculator.calculateBi(Calculator.BiOperatorModes.divide, 6.4);
        Double result = calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.0);
        assertEquals("Division should work correctly", 3.2, result, 0.0001);
    }
    
    @Test
    public void testCalculateBiXPowerOfY() {
        calculator.calculateBi(Calculator.BiOperatorModes.xpowerofy, 2.0);
        Double result = calculator.calculateBi(Calculator.BiOperatorModes.normal, 3.0);
        assertEquals("Power operation should work correctly", 8.0, result, 0.0001);
    }

    @Test
    public void testCalculateEqual() {
        calculator.calculateBi(Calculator.BiOperatorModes.add, 6.4);
        calculator.calculateBi(Calculator.BiOperatorModes.add, 2.0);
        Double result = calculator.calculateEqual(3.0);
        assertEquals("Equal operation should complete calculation chain", 11.4, result, 0.0001);
    }
    
    @Test
    public void testCalculateEqualSimple() {
        calculator.calculateBi(Calculator.BiOperatorModes.add, 5.0);
        Double result = calculator.calculateEqual(3.0);
        assertEquals("Simple equal should work", 8.0, result, 0.0001);
    }

    @Test
    public void testReset() {
        calculator.calculateBi(Calculator.BiOperatorModes.add, 6.4);
        assertEquals("First addition result", 8.4, calculator.calculateBi(Calculator.BiOperatorModes.add, 2.0), 0.0001);
        Double resetResult = calculator.reset();
        assertTrue("Reset should return NaN", Double.isNaN(resetResult));
    
        // After reset, calculator returns NaN until a new operation is started
        Double afterReset = calculator.calculateEqual(5.0);
        assertTrue("After reset with no operation, should return NaN", Double.isNaN(afterReset));
    }
    
    @Test
    public void testChainedOperations() {
        calculator.calculateBi(Calculator.BiOperatorModes.add, 10.0);
        calculator.calculateBi(Calculator.BiOperatorModes.multiply, 5.0);
        Double result = calculator.calculateEqual(2.0);
        assertEquals("Chained operations should work: (10 + 5) * 2", 30.0, result, 0.0001);
    }
}