package kata.moderate.calculator;

import java.util.ArrayList;
import java.util.List;


/**
 * Moderate
 * Calculator
 * CC: pg 185 Q: 16.26
 */
public class Calculator {

    public double calculate(String sequence) {
        List<Term> terms = Term.parseSequenceToTerms(sequence);

        if (terms == null) {
            return Integer.MAX_VALUE;
        }

        double result = 0;
        Term processing = null;

        for (int i = 0; i < terms.size(); i++) {
            Term current = terms.get(i);
            Term next = i + 1 < terms.size() ? terms.get(i + 1) : null;

            processing = collapseTerm(processing, current);

            if (next == null || next.operator == Term.Operator.ADD ||
                    next.operator == Term.Operator.SUBTRACT) {
                result = applyOp(result, processing.operator, processing.digit);
                processing = null;
            }
        }
        return result;
    }

    private Term collapseTerm(Term primary, Term secondary) {
        if (primary == null) return secondary;
        if (secondary == null) return primary;

        double value = applyOp(primary.digit, secondary.operator, secondary.digit);
        primary.digit = value;
        return primary;
    }

    private double applyOp(double left, Term.Operator operator, double right) {
        if (operator == Term.Operator.ADD) return left + right;
        else if (operator == Term.Operator.SUBTRACT) return left - right;
        else if (operator == Term.Operator.MULTIPLY) return left * right;
        else if (operator == Term.Operator.DIVIDE) return left / right;
        else return right;
    }
}

class Term {
    public enum Operator {ADD, SUBTRACT, MULTIPLY, DIVIDE, BLANK}


    public Operator operator;
    public double digit;

    public Term(Operator operator, double digit) {
        this.operator = operator;
        this.digit = digit;
    }

    public static List<Term> parseSequenceToTerms(String sequence) {

        List<Term> terms = new ArrayList<>();
        char[] chars = sequence.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            char aChar = chars[i];
            int digit = Character.getNumericValue(chars[i + 1]);
            if (aChar == '+') {
                terms.add(new Term(Operator.ADD, digit));
                i++;
            } else if (aChar == '-') {
                terms.add(new Term(Operator.SUBTRACT, digit));
                i++;
            } else if (aChar == '*') {
                terms.add(new Term(Operator.MULTIPLY, digit));
                i++;
            } else if (aChar == '/') {
                terms.add(new Term(Operator.DIVIDE, digit));
                i++;
            } else {
                terms.add(new Term(Operator.BLANK, Character.getNumericValue(chars[i])));
            }
        }
        return terms;
    }

    public void test() {
        String name = "";

        if (name != null) {

        }

    }
}
