package hrank.BalancedBrackets;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by dipen on 5/27/2017.
 */
public class Solution {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack();

        for (char bracket:expression.toCharArray()) {
            switch (bracket)
            {
                case '{' : stack.push('}');
                break;
                case '(' : stack.push(')');
                break;
                case  '[' : stack.push(']');
                break;
                default:
                    System.out.println(stack.empty());
                    if(stack.empty() || bracket != stack.peek())
                    {
                        return false;
                    }
                    stack.pop();
            }
        }

        return stack.empty();
    }

    /** inputs
     3
     {[()]}
     {[(])}
     {{[[(())]]}}
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
