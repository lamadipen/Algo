package kata.moderate.calculator;

import java.util.Stack;

public class CalculatorWithStack {

    public double calculate(String sequence) {
        Stack<Double> numStack = new Stack<>();
        Stack<Term.Operator> opStack = new Stack<>();

        for (int i = 0; i < sequence.length(); i++) {
            try {
                int digit = parseNextNumber(i, sequence);
                numStack.push((double) digit);

                i += Integer.toString(digit).length();

                if (i > sequence.length()) break;

                Term.Operator operator = parseNextOperator(i, sequence);
                collapseTop(operator, numStack, opStack);
                opStack.push(operator);
            } catch (Exception exception) {
                return Integer.MIN_VALUE;
            }
        }

        collapseTop(Term.Operator.BLANK, numStack, opStack);
        if (numStack.size() == 1 && opStack.size() == 0) {
            return numStack.pop();
        } else {
            return 0;
        }
    }

    private void collapseTop(Term.Operator operator, Stack<Double> numStack, Stack<Term.Operator> opStack) {
        while (opStack.size() > 1 && numStack.size() > 2) {
            if (priorityOfOperator(operator) <= priorityOfOperator(opStack.peek())) {
                Double second = numStack.pop();
                Double first = numStack.pop();
                Term.Operator op = opStack.pop();
                double collapsed = applyOp(first, op, second);
                numStack.push(collapsed);
            } else {
                break;
            }
        }
    }

    private double applyOp(Double first, Term.Operator op, Double second) {
        if (op == Term.Operator.ADD) return first + second;
        else if (op == Term.Operator.SUBTRACT) return first - second;
        else if (op == Term.Operator.MULTIPLY) return first * second;
        else if (op == Term.Operator.DIVIDE) return first / second;
        else return second;
    }

    private int priorityOfOperator(Term.Operator operator) {
        switch (operator) {
            case ADD:
            case SUBTRACT:
                return 1;
            case DIVIDE:
            case MULTIPLY:
                return 2;
            case BLANK:
                return 0;
        }
        return 0;
    }

    private Term.Operator parseNextOperator(int index, String sequence) {
        if (index < sequence.length()) {
            char op = sequence.charAt(index);
            switch (op) {
                case '+':
                    return Term.Operator.ADD;
                case '-':
                    return Term.Operator.SUBTRACT;
                case '*':
                    return Term.Operator.MULTIPLY;
                case '/':
                    return Term.Operator.DIVIDE;
            }
        }
        return Term.Operator.BLANK;
    }

    private int parseNextNumber(int index, String sequence) {
        StringBuilder sb = new StringBuilder();
        while (index < sequence.length() && Character.isDigit(sequence.charAt(index))) {
            sb.append(Character.getNumericValue(sequence.charAt(index)));
            index++;
        }
        return Integer.parseInt(sb.toString());
    }
}
