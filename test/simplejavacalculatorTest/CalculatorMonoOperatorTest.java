package simplejavacalculatorTest;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import simplejavacalculator.Calculator;

/**
 * Test suite for basic monadic operations (operations involving one operand)
 * Tests: square, squareRoot, oneDividedBy, log, rate
 */
public class CalculatorMonoOperatorTest {
    
    private Calculator calculator;
    
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testCalculateMonoSquare() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.square, 3.0);
        assertEquals("Square of 3 should be 9", 9.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoSquareNegative() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.square, -4.0);
        assertEquals("Square of -4 should be 16", 16.0, result, 0.0001);
    }

    @Test
    public void testCalculateMonoSquareRoot() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, 25.0);
        assertEquals("Square root of 25 should be 5", 5.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoSquareRootDecimal() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot, 2.0);
        assertEquals("Square root of 2", 1.4142, result, 0.0001);
    }

    @Test
    public void testCalculateMonoOneDividedBy() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, 10.0);
        assertEquals("1/10 should be 0.1", 0.10, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoOneDividedByFraction() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, 0.5);
        assertEquals("1/0.5 should be 2", 2.0, result, 0.0001);
    }

    @Test
    public void testCalculateMonoLog() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.log, 100.0);
        assertEquals("Log10 of 100 should be 2", 2.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoLogOne() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.log, 1.0);
        assertEquals("Log10 of 1 should be 0", 0.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoLogTen() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.log, 10.0);
        assertEquals("Log10 of 10 should be 1", 1.0, result, 0.0001);
    }

    @Test
    public void testCalculateMonoRate() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.rate, 75.0);
        assertEquals("75% should be 0.75", 0.75, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoRateHundred() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.rate, 100.0);
        assertEquals("100% should be 1.0", 1.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoRateZero() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.rate, 0.0);
        assertEquals("0% should be 0.0", 0.0, result, 0.0001);
    }
}