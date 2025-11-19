/**
 * Overview of new additions and changes made to Calculator.java:
 * 
 * 1. Added a new enum StatOperatorModes to handle statistical functions 
 *    such as min, max, mean, median, sum, and standard deviation.
 * 2. Implemented the calculateStat method to compute statistical values
 *    based on the selected StatOperatorModes.
 * 3. Ensured that all new functions return Double.NaN for invalid inputs (e.g., empty arrays).
 * 4. Added new MonoOperatorModes for csc, sec, and cot functions.
 * 5. Updated existing trigonometric functions (sin, cos, tan) to work with degrees
 *    instead of radians.
 * 6. Added additional comments for clarity and maintainability.
 */


package simplejavacalculator;

import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    // New StatOperatorModes enum added for the use of statistical functions
    // These functions will take an array as input (i.e. a list of numbers typed
    // by the user separated by commas) and calculate various statistical values 
    // such as min, max, etc...
    public enum StatOperatorModes {
        min, max, mean, median, sum, stddev
    } // End of enum StatOperatorModes

    public enum BiOperatorModes {
        normal, add, minus, multiply, divide , xpowerofy 
    } // End of enum BiOperatorModes

    // Added csc, sec, cot functions
    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan, csc, sec, cot, log, rate
    } // End of enum MonoOperatorModes

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        } // if statement

        if (mode == BiOperatorModes.add) {
            return num1 + num2;
        } // if statement

        if (mode == BiOperatorModes.minus) {
            return num1 - num2;
        } // if statement

        if (mode == BiOperatorModes.multiply) {
            return num1 * num2;
        } // if statement

        if (mode == BiOperatorModes.divide) {
            return num1 / num2;
        } // if statement

        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1,num2);
        } // if statement

        // never reach
        throw new Error();
    } // End of calculateBiImpl

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode == BiOperatorModes.normal) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return Double.NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        } // if-else statement
    } // End of calculateBi

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    } // End of calculateEqual

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;

        return Double.NaN;
    } // End of reset

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.square) {
            return num * num;
        } // if statement

        if (newMode == MonoOperatorModes.squareRoot) {
            return Math.sqrt(num);
        } // if statement

        if (newMode == MonoOperatorModes.oneDividedBy) {
            return 1 / num;
        } // if statement

        // Changed from:
        // return Math.cos(num)
        // -> to return Math.cos(Math.toRadians(num))
        if (newMode == MonoOperatorModes.cos) {
            return Math.cos(Math.toRadians(num));
        } // if statement

        // Changed from:
        // return Math.sin(num)
        // -> to return Math.sin(Math.toRadians(num))
        if (newMode == MonoOperatorModes.sin) {
            return Math.sin(Math.toRadians(num));
        } // if statement

        // Changed from:
        // return Math.tan(num)
        // -> to return Math.tan(Math.toRadians(num))
        if (newMode == MonoOperatorModes.tan) {
            return Math.tan(Math.toRadians(num));
        } // if statement

        // Newly added csc function
        // Recycled from sin function as csc = 1 / sin
        if (newMode == MonoOperatorModes.csc) {
            return 1 / Math.sin(Math.toRadians(num));
        } // if statement

        // Newly added sec function
        // Recycled from cos function as sec = 1 / cos
        if (newMode == MonoOperatorModes.sec) {
            return 1 / Math.cos(Math.toRadians(num));
        } // if statement

        // Newly added cot function
        // Recycled from tan function as cot = 1 / tan
        if (newMode == MonoOperatorModes.cot) {
            return 1 / Math.tan(Math.toRadians(num));
        } // if statement

        if (newMode == MonoOperatorModes.log) {
            return log10(num);
        } // if statement

        if (newMode == MonoOperatorModes.rate) {
           return num / 100;
        } // if statement
        
        // never reach
        throw new Error();
    } // End of calculateMono

    // New method to calculate statistical values
    // based on the selected StatOperatorModes
    // Takes an array of Double as input
    // Returns Double.NaN for empty array input
    // Supports min, max, mean, median, sum, and standard deviation calculations
    public Double calculateStat(StatOperatorModes mode, Double[] numbers) {

        // Handle edge case of empty array
        if (numbers == null || numbers.length == 0) {
            return Double.NaN;
        } // if statement
        
        // Min calculation
        if (mode == StatOperatorModes.min) {
            Double min = numbers[0];
            for (Double num : numbers) {
                if (num < min) min = num;
            }
            return min;
        } // if statement
        
        // Max calculation
        if (mode == StatOperatorModes.max) {
            Double max = numbers[0];
            for (Double num : numbers) {
                if (num > max) max = num;
            }
            return max;
        } // if statement
        
        // Mean calculation
        if (mode == StatOperatorModes.mean) {
            Double sum = 0.0;
            for (Double num : numbers) {
                sum += num;
            }
            return sum / numbers.length;
        } // if statement
    
        // Sum calculation
        if (mode == StatOperatorModes.sum) {
            Double sum = 0.0;
            for (Double num : numbers) {
            sum += num;
            }
            return sum;
        } // if statement
    
        // Median calculation
        if (mode == StatOperatorModes.median) {
            Double[] sorted = numbers.clone();
            java.util.Arrays.sort(sorted);
            int middle = sorted.length / 2;
            if (sorted.length % 2 == 0) {
                return (sorted[middle - 1] + sorted[middle]) / 2.0;
            } else {
                return sorted[middle];
            } // if-else statement
        } // if statement
    
        // Standard Deviation calculation
        if (mode == StatOperatorModes.stddev) {
            // Handle single element case
            if (numbers.length == 1) {
                return 0.0;  // Single element has no deviation
            } // if statement
    
            // Calculate mean first
            Double sum = 0.0;
            for (Double num : numbers) {
                sum += num;
            } // for loop
            Double mean = sum / numbers.length;

            // Calculate variance
            Double variance = 0.0;
            for (Double num : numbers) {
                variance += Math.pow(num - mean, 2);
            } // for loop
            variance /= (numbers.length - 1);  // Sample standard deviation

            // Standard deviation is square root of variance
            return Math.sqrt(variance);
        } // if statement

        // never reach
        throw new Error();
    } // End of calculateStat
}
