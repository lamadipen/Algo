package hackerrank.interviewprepkit.stacksandqueues;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Interview Preparation Kit | Stacks and Queues | Balanced Brackets
 */
public class BalancedBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    //All test didn't passed with this solution
    public static String isBalanced(String s) {
        Map<Character, Character> pairMap = new HashMap<>();
        pairMap.put('(', ')');
        pairMap.put('{', '}');
        pairMap.put('[', ']');

        Deque<Character> brackets = new LinkedList<>();

        for (char item : s.toCharArray()) {
            if (pairMap.containsKey(item)) {
                brackets.push(item);
            } else {
                Character start = pairMap.get(brackets.pop());
                if (start != item) {
                    return "NO";
                }
            }
        }
        // Write your code here
        return brackets.isEmpty() ? "YES" : "NO";
    }

    //All Test passed with this solution
    static String isBalancedBool(String s) {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        Deque<Character> stack = new LinkedList<>();

        for (Character item : s.toCharArray()) {
            if (brackets.containsKey(item))
                stack.push(item);
            else if (!item.equals(brackets.get(stack.poll())))
                return "NO";
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
}
