package simplejavacalculatorTest;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import simplejavacalculator.Calculator;

/**
 * Test suite for statistical operations
 * Tests: min, max, mean, median, sum, stddev
 * All operations work on arrays of Double values
 */
public class CalculatorStatisticalTest {
    
    private Calculator calculator;
    
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testCalculateStatMin() {
        Double[] data = {3.0, 1.0, 4.0, 1.5};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.min, data);
        assertEquals("Min of [3.0, 1.0, 4.0, 1.5] should be 1.0", 1.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateStatMinSingleElement() {
        Double[] data = {5.0};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.min, data);
        assertEquals("Min of single element should be that element", 5.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateStatMinNegative() {
        Double[] data = {-3.0, -1.0, -4.0, -1.5};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.min, data);
        assertEquals("Min of negative numbers should be most negative", -4.0, result, 0.0001);
    }

    @Test
    public void testCalculateStatMax() {
        Double[] data = {3.0, 1.0, 4.0, 1.5};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.max, data);
        assertEquals("Max of [3.0, 1.0, 4.0, 1.5] should be 4.0", 4.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateStatMaxSingleElement() {
        Double[] data = {5.0};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.max, data);
        assertEquals("Max of single element should be that element", 5.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateStatMaxNegative() {
        Double[] data = {-3.0, -1.0, -4.0, -1.5};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.max, data);
        assertEquals("Max of negative numbers should be least negative", -1.0, result, 0.0001);
    }

    @Test
    public void testCalculateStatMean() {
        Double[] data = {3.0, 1.0, 4.0, 1.5};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.mean, data);
        assertEquals("Mean of [3.0, 1.0, 4.0, 1.5] should be 2.375", 2.375, result, 0.0001);
    }
    
    @Test
    public void testCalculateStatMeanSimple() {
        Double[] data = {2.0, 4.0, 6.0, 8.0};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.mean, data);
        assertEquals("Mean of [2, 4, 6, 8] should be 5", 5.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateStatMeanSingleElement() {
        Double[] data = {7.5};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.mean, data);
        assertEquals("Mean of single element should be that element", 7.5, result, 0.0001);
    }

    @Test
    public void testCalculateStatMedianEvenCount() {
        Double[] data = {3.0, 1.0, 4.0, 1.5};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.median, data);
        // Sorted: [1.0, 1.5, 3.0, 4.0], median = (1.5 + 3.0) / 2 = 2.25
        assertEquals("Median of even count should be average of middle two", 2.25, result, 0.0001);
    }
    
    @Test
    public void testCalculateStatMedianOddCount() {
        Double[] data = {3.0, 1.0, 4.0, 1.5, 9.0};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.median, data);
        // Sorted: [1.0, 1.5, 3.0, 4.0, 9.0], median = 3.0
        assertEquals("Median of odd count should be middle element", 3.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateStatMedianSingleElement() {
        Double[] data = {5.0};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.median, data);
        assertEquals("Median of single element should be that element", 5.0, result, 0.0001);
    }

    @Test
    public void testCalculateStatSum() {
        Double[] data = {3.0, 1.0, 4.0, 1.5};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.sum, data);
        assertEquals("Sum of [3.0, 1.0, 4.0, 1.5] should be 9.5", 9.5, result, 0.0001);
    }
    
    @Test
    public void testCalculateStatSumSimple() {
        Double[] data = {1.0, 2.0, 3.0, 4.0, 5.0};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.sum, data);
        assertEquals("Sum of [1, 2, 3, 4, 5] should be 15", 15.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateStatSumSingleElement() {
        Double[] data = {10.0};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.sum, data);
        assertEquals("Sum of single element should be that element", 10.0, result, 0.0001);
    }

    @Test
    public void testCalculateStatStdDev() {
        Double[] data = {3.0, 1.0, 4.0, 1.5};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.stddev, data);
        // Mean = 2.375
        // Variance = ((3-2.375)^2 + (1-2.375)^2 + (4-2.375)^2 + (1.5-2.375)^2) / 4
        // StdDev ≈ 1.136
        assertEquals("StdDev (sample) should be approximately 1.377", 1.377, result, 0.001);
    }
    
    @Test
    public void testCalculateStatStdDevUniform() {
        Double[] data = {5.0, 5.0, 5.0, 5.0};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.stddev, data);
        assertEquals("StdDev of uniform data should be 0", 0.0, result, 0.0001);
    }
    
    @Test
    public void testCalculateStatStdDevSingleElement() {
        Double[] data = {7.0};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.stddev, data);
        assertEquals("StdDev of single element should be 0", 0.0, result, 0.0001);
    }

    @Test
    public void testCalculateStatEmptyArray() {
        Double[] data = {};
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.min, data);
        assertTrue("Empty array should return NaN", Double.isNaN(result));
    }
    
    @Test
    public void testCalculateStatNullArray() {
        Double result = calculator.calculateStat(Calculator.StatOperatorModes.max, null);
        assertTrue("Null array should return NaN", Double.isNaN(result));
    }
}