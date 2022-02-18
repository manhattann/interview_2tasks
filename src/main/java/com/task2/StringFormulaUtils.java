package com.task2;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Random;

public class StringFormulaUtils {
    
    private StringFormulaUtils() {}

    private static final Random r = new Random();
    static String mathOperators = "+/*-";

    /**
     * Generates random mathematical formula using 0-9 and 4 operators: +/*-
     * @return math formula in string form
     */
    public static String generateTask() {
        int intNumberUpperBound = 10000;
        int numOfString = r.nextInt(30);
        StringBuilder formula = new StringBuilder();
        for (int i = 0; i < numOfString; i++) {
            if (i % 2 == 0) {
                formula.append(r.nextInt(intNumberUpperBound));
            } else {
                formula.append(mathOperators.charAt(r.nextInt(mathOperators.length())));
            }
        }

        if (formula.length() == 0 || mathOperators.indexOf(formula.charAt(formula.length() - 1)) > -1) {
            // formula must end with a number, and have at least one number
            formula.append(r.nextInt(intNumberUpperBound));
        }
        return formula.toString();
    }

    /**
     * Given string formula of some kind, get it's real number
     * @param formula mathematical expression in string form
     * @return math result of formula
     */
    public static double solveFormula(String formula) {
        // used external library for this
        Expression expression = new ExpressionBuilder(formula).build();
        return expression.evaluate();
    }

}