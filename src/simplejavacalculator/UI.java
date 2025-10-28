/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        UI.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 * @create      2012-03-30
 *
 * @modifiedby  Achintha Gunasekara
 * @modifiedby  Kydon Chantzaridis
 * @modweb      http://www.achinthagunasekara.com
 * @modemail    contact@achinthagunasekara.com
 * @modemail    kchantza@csd.auth.gr
 */

package simplejavacalculator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea; 

public class UI implements ActionListener {
    private boolean statMode = false;  // Track if we're in stat mode
    private final JButton butStatMode;  // Toggle button
    private final JFrame frame;
    private final JPanel panel;
    private final JTextArea text;

    // Added new buttons for all new functions added
    private final JButton but[], butAdd, butMinus, butMultiply, butDivide,
            butEqual, butCancel, butSquareRoot, butSquare, butOneDevidedBy,
            butCos, butSin, butTan, butCsc, butSec, butCot, butxpowerofy, butlog, butrate,
            butMin, butMax, butMean, butMedian, butSum, butStdDev;
    private final Calculator calc;

    private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9" };

    public UI() {
        frame = new JFrame("STAT Calculator"); 
        frame.setResizable(true);
        panel = new JPanel(new FlowLayout());

        panel.setBackground(Color.PINK);

        text = new JTextArea(2, 25);
        text.setBackground(Color.ORANGE); // Set background color for the text area
        text.setForeground(Color.BLACK); // Set text color for the text area

        but = new JButton[10];
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(String.valueOf(i));
            but[i].setBackground(Color.LIGHT_GRAY); // Set button background color
            but[i].setForeground(Color.BLACK); // Set button text color
        }

        butAdd = new JButton("+");
        butMinus = new JButton("-");
        butMultiply = new JButton("*");
        butDivide = new JButton("/");
        butEqual = new JButton("=");
        butSquareRoot = new JButton("√");
        butSquare = new JButton("x*x");
        butOneDevidedBy = new JButton("1/x");
        butCos = new JButton("Cos");
        butSin = new JButton("Sin");
        butTan = new JButton("Tan");

        // Added buttons for csc, sec, cot functions
        butCsc = new JButton("Csc");
        butSec = new JButton("Sec");
        butCot = new JButton("Cot");

        butxpowerofy = new JButton("x^y");
        butlog = new JButton("log10(x)");
        butrate = new JButton("x%");

        // Button to toggle stat mode
        butStatMode = new JButton("Stat Mode: OFF");

        // Added buttons for statistical functions
        butMin = new JButton("Min");
        butMax = new JButton("Max");
        butMean = new JButton("Mean");
        butMedian = new JButton("Median");
        butSum = new JButton("Sum");
        butStdDev = new JButton("StdDev");
        butCancel = new JButton("C");

        // COME BACK TO THIS
        // Set colors for operation buttons
        JButton[] operationButtons = {butAdd, butMinus, butMultiply, butDivide};
            for (JButton button : operationButtons) {
            button.setBackground(Color.ORANGE); // Background color
            button.setForeground(Color.BLACK);  // Text color
    }

        calc = new Calculator();
    }

    public void init() {
        frame.setVisible(true);
        frame.setSize(350, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.add(text);
       
        // Changed the loop to start from
        //  for (int i = 1; i < 10; i++)
        // -> to  for (int i = 0; i < 10; i++)
        // So now, the zero button will function as intended because the
        // original loop did not add any action listener to the zero button.
        for (int i = 0; i < 10; i++) {
            panel.add(but[i]);
            but[i].addActionListener(this);
        }

        panel.add(but[0]);

        panel.add(butAdd);
        panel.add(butMinus);
        panel.add(butMultiply);
        panel.add(butDivide);
        panel.add(butSquare);
        panel.add(butSquareRoot);
        panel.add(butOneDevidedBy);
        panel.add(butCos);
        panel.add(butSin);
        panel.add(butTan);

        // Added buttons to the panel
        panel.add(butCsc);
        panel.add(butSec);
        panel.add(butCot);

        panel.add(butxpowerofy);
        panel.add(butlog);
        panel.add(butrate);

        panel.add(butEqual);
        panel.add(butCancel);

        panel.add(butStatMode);

        panel.add(butMin);
        panel.add(butMax);
        panel.add(butMean);
        panel.add(butMedian);
        panel.add(butSum);
        panel.add(butStdDev);

        butAdd.addActionListener(this);
        butMinus.addActionListener(this);
        butMultiply.addActionListener(this);
        butDivide.addActionListener(this);
        butSquare.addActionListener(this);
        butSquareRoot.addActionListener(this);
        butOneDevidedBy.addActionListener(this);
        butCos.addActionListener(this);
        butSin.addActionListener(this);
        butTan.addActionListener(this);

        // Added action listeners for csc, sec, cot buttons
        butCsc.addActionListener(this);
        butSec.addActionListener(this);
        butCot.addActionListener(this);

        // Added action listener for stat mode
        butStatMode.addActionListener(this);

        butxpowerofy.addActionListener(this);
        butlog.addActionListener(this);
        butrate.addActionListener(this);

        butEqual.addActionListener(this);
        butCancel.addActionListener(this);

        butMin.addActionListener(this);
        butMax.addActionListener(this);
        butMean.addActionListener(this);
        butMedian.addActionListener(this);
        butSum.addActionListener(this);
        butStdDev.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        
        // Handle Stat Mode toggle first
        if (source == butStatMode) {
            statMode = !statMode;  // Toggle the mode
            if (statMode) {
                butStatMode.setText("Stat Mode: ON");
                
                // Hide regular operation buttons
                butAdd.setVisible(false);
                butMinus.setVisible(false);
                butMultiply.setVisible(false);
                butDivide.setVisible(false);
                butSquare.setVisible(false);
                butSquareRoot.setVisible(false);
                butOneDevidedBy.setVisible(false);
                butCos.setVisible(false);
                butSin.setVisible(false);
                butTan.setVisible(false);
                butxpowerofy.setVisible(false);
                butlog.setVisible(false);
                butrate.setVisible(false);
                butEqual.setVisible(false);
                
                // Show stat buttons
                butMin.setVisible(true);
                butMax.setVisible(true);
                butMean.setVisible(true);
                butMedian.setVisible(true);
                butSum.setVisible(true);
                butStdDev.setVisible(true);
            } else {
                butStatMode.setText("Stat Mode: OFF");
                text.setText("");
                
                // Show regular operation buttons
                butAdd.setVisible(true);
                butMinus.setVisible(true);
                butMultiply.setVisible(true);
                butDivide.setVisible(true);
                butSquare.setVisible(true);
                butSquareRoot.setVisible(true);
                butOneDevidedBy.setVisible(true);
                butCos.setVisible(true);
                butSin.setVisible(true);
                butTan.setVisible(true);
                butxpowerofy.setVisible(true);
                butlog.setVisible(true);
                butrate.setVisible(true);
                butEqual.setVisible(true);
                
                // Hide stat buttons
                butMin.setVisible(false);
                butMax.setVisible(false);
                butMean.setVisible(false);
                butMedian.setVisible(false);
                butSum.setVisible(false);
                butStdDev.setVisible(false);
            }
            
            panel.revalidate();
            panel.repaint();
            text.selectAll();
            return;
        }
        
        // Number buttons work in both modes
        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                text.replaceSelection(buttonValue[i]);
                return;
            }
        }

        // Statistical operations - only work in stat mode
        if (statMode) {
            if (source == butMin) {
                Double[] arr = arrayReader();
                if (arr != null && arr.length > 0) {
                    writer(calc.calculateStat(Calculator.StatOperatorModes.min, arr));
                } else {
                    text.setText("Invalid input");
                }
                text.selectAll();
                return;
            }

            if (source == butMax) {
                Double[] arr = arrayReader();
                if (arr != null && arr.length > 0) {
                    writer(calc.calculateStat(Calculator.StatOperatorModes.max, arr));
                } else {
                    text.setText("Invalid input");
                }
                text.selectAll();
                return;
            }

            if (source == butMean) {
                Double[] arr = arrayReader();
                if (arr != null && arr.length > 0) {
                    writer(calc.calculateStat(Calculator.StatOperatorModes.mean, arr));
                } else {
                    text.setText("Invalid input");
                }
                text.selectAll();
                return;
            }

            if (source == butMedian) {
                Double[] arr = arrayReader();
                if (arr != null && arr.length > 0) {
                    writer(calc.calculateStat(Calculator.StatOperatorModes.median, arr));
                } else {
                    text.setText("Invalid input");
                }
                text.selectAll();
                return;
            }

            if (source == butSum) {
                Double[] arr = arrayReader();
                if (arr != null && arr.length > 0) {
                    writer(calc.calculateStat(Calculator.StatOperatorModes.sum, arr));
                } else {
                    text.setText("Invalid input");
                }
                text.selectAll();
                return;
            }

            if (source == butStdDev) {
                Double[] arr = arrayReader();
                if (arr != null && arr.length > 0) {
                    writer(calc.calculateStat(Calculator.StatOperatorModes.stddev, arr));
                } else {
                    text.setText("Invalid input");
                }
                text.selectAll();
                return;
            }

            // Cancel button works in stat mode too
            if (source == butCancel) {
                text.setText("Enter numbers separated by commas");
                text.selectAll();
                return;
            }
            
            // If we're in stat mode and reach here, ignore other buttons
            return;
        }

        // Regular calculator operations - only work when NOT in stat mode
        if (!statMode) {
            if (source == butAdd) {
                writer(calc.calculateBi(Calculator.BiOperatorModes.add, reader()));
            }

            if (source == butMinus) {
                writer(calc.calculateBi(Calculator.BiOperatorModes.minus, reader()));
            }

            if (source == butMultiply) {
                writer(calc.calculateBi(Calculator.BiOperatorModes.multiply, reader()));
            }

            if (source == butDivide) {
                writer(calc.calculateBi(Calculator.BiOperatorModes.divide, reader()));
            }
            
            if (source == butxpowerofy) {
                writer(calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, reader()));
            }

            if (source == butSquare) {
                writer(calc.calculateMono(Calculator.MonoOperatorModes.square, reader()));
            }

            if (source == butSquareRoot) {
                writer(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, reader()));
            }

            if (source == butOneDevidedBy) {
                writer(calc.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, reader()));
            }

            if (source == butCos) {
                writer(calc.calculateMono(Calculator.MonoOperatorModes.cos, reader()));
            }

            if (source == butSin) {
                writer(calc.calculateMono(Calculator.MonoOperatorModes.sin, reader()));
            }

            if (source == butTan) {
                writer(calc.calculateMono(Calculator.MonoOperatorModes.tan, reader()));
            }
            
            if (source == butlog) {
                writer(calc.calculateMono(Calculator.MonoOperatorModes.log, reader()));
            }
            
            if (source == butrate) {
                writer(calc.calculateMono(Calculator.MonoOperatorModes.rate, reader()));
            }

            if (source == butEqual) {
                writer(calc.calculateEqual(reader()));
            }

            if (source == butCancel) {
                writer(calc.reset());
            }

            text.selectAll();
        }
    }

    public void writer(final Double num) {
        if (num == null || Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }

    /**
     * Read a single double value from the text area (regular mode)
     */
    public Double reader() {
        try {
            String str = text.getText();
            return Double.valueOf(str);
        } catch (Exception ex) {
            text.setText("0");
            return 0.0;
        }
    }

    /**
     * Parse comma-separated numbers from the text area into a Double[]
     */
    private Double[] arrayReader() {
        String s = text.getText();
        if (s == null || s.trim().isEmpty()) return null;
        String[] parts = s.split(",");
        java.util.List<Double> list = new java.util.ArrayList<>();
        try {
            for (String p : parts) {
                String t = p.trim();
                if (!t.isEmpty()) list.add(Double.valueOf(t));
            }
        } catch (NumberFormatException ex) {
            return null;
        }
        return list.toArray(new Double[0]);
    }
}