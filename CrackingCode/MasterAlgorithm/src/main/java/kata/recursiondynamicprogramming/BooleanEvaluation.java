package kata.recursiondynamicprogramming;

public class BooleanEvaluation {

    public int countEval(String expression, boolean result) {
        if (expression.length() == 0) {
            return 0;
        }
        if (expression.length() == 1) {
            return stringToBoolean(expression) == result ? 1 : 0;
        }
        int ways = 0;

        for (int i = 1; i < expression.length(); i += 2) {
            char c = expression.charAt(i);
            String left = expression.substring(0, i);
            String right = expression.substring(i + 1);

            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);
            int rightTrue = countEval(right, true);
            int rightFalse = countEval(right, false);

            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
            int totalTrue = 0;

            if (c == '^') {
                totalTrue = (leftTrue * rightFalse) + (rightTrue * leftFalse);
            } else if (c == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTrue = leftTrue * rightFalse + rightTrue * leftFalse +
                        leftTrue * rightTrue;
            }
            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }
        return ways;
    }

    private boolean stringToBoolean(String expression) {
        return expression.equals("1");
    }
}
