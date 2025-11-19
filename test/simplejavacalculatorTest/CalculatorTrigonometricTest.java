package simplejavacalculatorTest;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import simplejavacalculator.Calculator;

/**
 * Test suite for trigonometric operations
 * Tests: sin, cos, tan, csc, sec, cot
 * NOTE: All operations expect input in DEGREES (not radians)
 */
public class CalculatorTrigonometricTest {
    
    private Calculator calculator;
    
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testCalculateMonoSin30() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.sin, 30.0);
        assertEquals("Sin(30°) should be 0.5", 0.5, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoSin90() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.sin, 90.0);
        assertEquals("Sin(90°) should be 1.0", 1.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoSin0() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.sin, 0.0);
        assertEquals("Sin(0°) should be 0.0", 0.0, result, 0.0001);
    }

    @Test
    public void testCalculateMonoCos60() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.cos, 60.0);
        assertEquals("Cos(60°) should be 0.5", 0.5, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoCos0() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.cos, 0.0);
        assertEquals("Cos(0°) should be 1.0", 1.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoCos90() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.cos, 90.0);
        assertEquals("Cos(90°) should be 0.0", 0.0, result, 0.0001);
    }

    @Test
    public void testCalculateMonoTan45() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.tan, 45.0);
        assertEquals("Tan(45°) should be 1.0", 1.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoTan0() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.tan, 0.0);
        assertEquals("Tan(0°) should be 0.0", 0.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoTan60() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.tan, 60.0);
        assertEquals("Tan(60°) should be √3 ≈ 1.732", 1.732, result, 0.001);
    }

    @Test
    public void testCalculateMonoCsc30() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.csc, 30.0);
        assertEquals("Csc(30°) should be 2.0 (1/sin(30°))", 2.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoCsc90() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.csc, 90.0);
        assertEquals("Csc(90°) should be 1.0 (1/sin(90°))", 1.0, result, 0.0001);
    }

    @Test
    public void testCalculateMonoSec60() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.sec, 60.0);
        assertEquals("Sec(60°) should be 2.0 (1/cos(60°))", 2.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoSec0() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.sec, 0.0);
        assertEquals("Sec(0°) should be 1.0 (1/cos(0°))", 1.0, result, 0.0001);
    }

    @Test
    public void testCalculateMonoCot45() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.cot, 45.0);
        assertEquals("Cot(45°) should be 1.0 (1/tan(45°))", 1.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateMonoCot60() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.cot, 60.0);
        assertEquals("Cot(60°) should be 1/√3 ≈ 0.577", 0.577, result, 0.001);
    }
    
    @Test
    public void testCalculateMonoCot30() {
        Double result = calculator.calculateMono(Calculator.MonoOperatorModes.cot, 30.0);
        assertEquals("Cot(30°) should be √3 ≈ 1.732", 1.732, result, 0.001);
    }
}