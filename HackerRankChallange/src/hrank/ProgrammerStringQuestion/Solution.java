package hrank.ProgrammerStringQuestion;

/**
 * Created by dipen on 5/17/2017.
 */
public class Solution {


    static int programmerString(String string)
    {
        StringBuilder tempString = new StringBuilder();
        String realProgrammer = "programmer";
        int mCounter = 0;
        int rCounter =0;
        int programmerCounter =0;
        int indexTracker =0;
        for (int i=0; i < string.length(); i++)
        {
            char compariableChar = string.charAt(i);

            if(compariableChar == 'p' && !tempString.toString().contains("p"))
            {
                tempString.append(compariableChar);
            }else if(compariableChar == 'r' && rCounter <=3 )
            {
                tempString.append(compariableChar);
                rCounter++;
            }else if(compariableChar == 'o' && !tempString.toString().contains("o"))
            {
                tempString.append(compariableChar);
            }else if(compariableChar == 'g' && !tempString.toString().contains("g"))
            {
                tempString.append(compariableChar);
            }else if(compariableChar == 'a' && !tempString.toString().contains("a"))
            {
                tempString.append(compariableChar);
            }
            else if(compariableChar == 'm' && mCounter <=2)
            {
                tempString.append(compariableChar);
                mCounter++;
            }
            else if(compariableChar == 'e' && !tempString.toString().contains("e"))
            {
                tempString.append(compariableChar);
            }
            else
            {
            }

            if(tempString.length() == realProgrammer.length())
            {
                if(realProgrammer.equals(tempString.toString()))
                {
                    indexTracker = i - indexTracker;
                    if(indexTracker >= 10)
                    {
                        programmerCounter = programmerCounter+1;
                        rCounter =0;
                        mCounter =0;
                        tempString.setLength(0);
                    }
                }
                else
                {
                    programmerCounter = programmerCounter+1;
                    rCounter =0;
                    mCounter =0;
                    tempString.setLength(0);
                }
            }
        }


        return programmerCounter;
    }

    public static void main(String [] args)
    {
        //System.out.println(programmerString("programmer"));
        //System.out.println(programmerString("progxrammerrxproxgrammer"));
        System.out.println(programmerString("xprogxrmaxemrppprmmog"));


    }
}
