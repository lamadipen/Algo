package kata.recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Recursion and dynamic programming
 * Parens
 * CC: pg 136 Q: 8.9
 */
public class Parens {

    public Set<String> getParens(int n) {
        Set<String> set = new HashSet<>();

        if (n == 0) {
            set.add("");
        } else {
            Set<String> prev = getParens(n - 1);

            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    private String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());
        return left + "()" + right;
    }

    public List<String> getParensOptmized(int n) {
        char[] str = new char[n * 2];
        ArrayList<String> list = new ArrayList<>();
        addParams(list, n, n, str, 0);
        return list;
    }

    public void addParams(List<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) {
            return;
        }

        if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParams(list, leftRem - 1, rightRem, str, index + 1);

            str[index] = ')';
            addParams(list, leftRem, rightRem - 1, str, index + 1);
        }
    }
}
