package hrank.ProgrammerStringQuestion;

/**
 * Created by dipen on 5/18/2017.
 */
public class AnagramIterative {

    static boolean isAnagram(String string)
    {
        String realProgrammer = "programmer";
        int programmerCounter =0;

        char[] realProgrammerArray = realProgrammer.toCharArray();
        for (char c:realProgrammerArray)
        {

            int index = string.indexOf(c);

            if(index == -1)
            {
                return false;
            }

            string  = string.substring(0,index) + string.substring(index+1, string.length());
            System.out.println(string);

        }



        return true;
    }

    public static void main(String [] args)
    {
        //System.out.println(isAnagram("programmer"));
        System.out.println(isAnagram("progxrammerrxproxgrammer"));
        //System.out.println(isAnagram("xprogxrmaxemrppprmmog"));
    }
}
