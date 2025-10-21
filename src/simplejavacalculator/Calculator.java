package simplejavacalculator;

import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    // New ArrayOperatorModes enum added for the use of statistical functions
    // These functions will take an array as input (i.e. a list of numbers typed
    // by the user) and calculate various statistical values such as min, max, etc...
    public enum StatOperatorModes {
        min, max, mean, median, sum, stddev
    }

    public enum BiOperatorModes {
        normal, add, minus, multiply, divide , xpowerofy 
    }

    // Added csc, sec, cot functions
    public enum MonoOperatorModes {
        square, squareRoot, oneDevidedBy, cos, sin, tan, csc, sec, cot, log, rate
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        }

        if (mode == BiOperatorModes.add) {
            return num1 + num2;
        }

        if (mode == BiOperatorModes.minus) {
            return num1 - num2;
        }

        if (mode == BiOperatorModes.multiply) {
            return num1 * num2;
        }

        if (mode == BiOperatorModes.divide) {
            return num1 / num2;
        }

        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1,num2);
        }

        // never reach
        throw new Error();
    }

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
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;

        return Double.NaN;
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.square) {
            return num * num;
        }

        if (newMode == MonoOperatorModes.squareRoot) {
            return Math.sqrt(num);
        }

        if (newMode == MonoOperatorModes.oneDevidedBy) {
            return 1 / num;
        }

        // Changed from:
        // return Math.cos(num)
        // -> to return Math.cos(Math.toRadians(num))
        if (newMode == MonoOperatorModes.cos) {
            return Math.cos(Math.toRadians(num));
        }

        // Changed from:
        // return Math.sin(num)
        // -> to return Math.sin(Math.toRadians(num))
        if (newMode == MonoOperatorModes.sin) {
            return Math.sin(Math.toRadians(num));
        }

        // Changed from:
        // return Math.tan(num)
        // -> to return Math.tan(Math.toRadians(num))
        if (newMode == MonoOperatorModes.tan) {
            return Math.tan(Math.toRadians(num));
        }

        // Newly added csc function
        // Recycled from sin function as csc = 1 / sin
        if (newMode == MonoOperatorModes.csc) {
            return 1 / Math.sin(Math.toRadians(num));
        }

        // Newly added sec function
        // Recycled from cos function as sec = 1 / cos
        if (newMode == MonoOperatorModes.sec) {
            return 1 / Math.cos(Math.toRadians(num));
        }

        // Newly added cot function
        // Recycled from tan function as cot = 1 / tan
        if (newMode == MonoOperatorModes.cot) {
            return 1 / Math.tan(Math.toRadians(num));
        }

        if (newMode == MonoOperatorModes.log) {
            return log10(num);
        }

        if (newMode == MonoOperatorModes.rate) {
           return num / 100;
        }
        
        // never reach
        throw new Error();
    }

    public Double calculateStat(StatOperatorModes mode, Double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Double.NaN;
        }
        
    if (mode == StatOperatorModes.min) {
            Double min = numbers[0];
            for (Double num : numbers) {
                if (num < min) min = num;
            }
            return min;
        }
        
    if (mode == StatOperatorModes.max) {
            Double max = numbers[0];
            for (Double num : numbers) {
                if (num > max) max = num;
            }
            return max;
        }
        
    if (mode == StatOperatorModes.mean) {
            Double sum = 0.0;
            for (Double num : numbers) {
                sum += num;
            }
            return sum / numbers.length;
        }
    
    if (mode == StatOperatorModes.sum) {
            Double sum = 0.0;
            for (Double num : numbers) {
            sum += num;
            }
            return sum;
        }
    
    if (mode == StatOperatorModes.median) {
            Double[] sorted = numbers.clone();
            java.util.Arrays.sort(sorted);
            int middle = sorted.length / 2;
            if (sorted.length % 2 == 0) {
                return (sorted[middle - 1] + sorted[middle]) / 2.0;
            } else {
                return sorted[middle];
            }
        }
    
    if (mode == StatOperatorModes.stddev) {
            // Calculate mean first
            Double sum = 0.0;
            for (Double num : numbers) {
                sum += num;
            }
            Double mean = sum / numbers.length;
        
            // Calculate variance
            Double variance = 0.0;
            for (Double num : numbers) {
                variance += Math.pow(num - mean, 2);
            }
            variance /= numbers.length;
        
            // Standard deviation is square root of variance
            return Math.sqrt(variance);
        }
    
    throw new Error();
    }
}
