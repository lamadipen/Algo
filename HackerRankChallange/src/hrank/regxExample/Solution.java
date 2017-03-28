package hrank.regxExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dipen on 3/13/2017.
 */
public class Solution {

    public static void main(String[] args) {
        // This will match a sequence of 1 or more uppercase and lowercase English letters as well as spaces
        String myRegExString = "[a-zA-Z\\s]+";

        // This is the string we will check to see if our regex matches:
        String myString = "The quick brown fox jumped over the lazy dog...";

        // Create a Pattern object (compiled RegEx) and save it as 'p'
        Pattern p = Pattern.compile(myRegExString);

        // We need a Matcher to match our compiled RegEx to a String
        Matcher m = p.matcher(myString);

        // if our Matcher finds a match
        if (m.find()) {
            // Print the match
            System.out.println(m.group());
        }

        String s = "Hello, Goodbye, Farewell";
        Pattern p1 = Pattern.compile("\\p{Alpha}+");
        Matcher m1 = p1.matcher(s);

        while( m.find() ){
            System.out.println(m1.group());
        }

        String s1 = "Hello, Goodbye, Farewell";
        String s2 = "Hola, Adios, Hasta Luego";

        String myDelimiter = ", ";

        String[] s1array = s1.split(myDelimiter);
        String[] s2array = s2.split(myDelimiter);

        System.out.println("s1array[0]: " + s1array[0]);
        System.out.println("s1array[1]: " + s1array[1]);
        System.out.println("s1array[2]: " + s1array[2]);
        System.out.println("s2array[0]: " + s2array[0]);
        System.out.println("s2array[1]: " + s2array[1]);
        System.out.println("s2array[2]: " + s2array[2]);

    }
}
