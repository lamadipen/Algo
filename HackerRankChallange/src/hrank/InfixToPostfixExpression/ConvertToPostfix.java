package hrank.InfixToPostfixExpression;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dipen on 5/11/2017.
 */
public class ConvertToPostfix {

    public static void main(String [] args)
    {

        ConvertToPostfix convertToPostfix = new ConvertToPostfix();
        //convertToPostfix.intoPostFix("(1+2)*(3+4)");
        convertToPostfix.intoPostFix(" A*B-(C+D)+E");

    }

    public void intoPostFix(String infixString)
    {
        StringBuffer postfix = new StringBuffer(infixString.length());

        Stack<Character> stack = new Stack();

        for (int index = 0; index < infixString.length(); ++index) {
            char chValue = infixString.charAt(index);

            if(chValue == '(')
            {
                stack.push(chValue);
            }
            else if (chValue == ')')
            {
                while (!(stack.peek() == '(') && !stack.isEmpty())
                {
                    postfix.append(stack.pop());

                }

                if(!stack.empty())
                {
                    stack.pop();
                }
               // System.out.println(postfix.toString());
            }
            else if (chValue == '+' || chValue == '-')
            {
                if(stack.isEmpty())
                {
                    stack.push(chValue);
                }
                else
                {
                    while (!(stack.empty() || stack.peek().equals('(') || stack.peek().equals(')') ) )
                    {
                        stack.pop();
                        postfix.append(chValue);

                    }
                    stack.push(chValue);
                }
            }
            else if (chValue == '*' || chValue == '/')
            {
                if(stack.isEmpty())
                {
                    stack.push(chValue);
                }
                else
                {
                    while (!stack.empty() && !stack.peek().equals('+') && !stack.peek().equals('-') )
                    {
                        stack.pop();
                        postfix.append(chValue);
                    }
                    stack.push(chValue);

                }
            }
            else {
                postfix.append(chValue);
            }
        }

        while (!stack.isEmpty()) {

            if (!stack.peek().equals(new Character('('))) {
                //stack.pop();
                postfix.append(stack.pop());
            }
        }
        System.out.println(postfix.toString());
    }



}
