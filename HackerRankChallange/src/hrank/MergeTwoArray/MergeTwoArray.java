package hrank.MergeTwoArray;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Created by dipen on 3/1/2018.
 */
public class MergeTwoArray {

    public static void main(String[] args) {
       String [] thisWeek = {"Dipen", "Sanjeev", "Ram", "Hari"};
       String [] lastWeek = { "Shaym", "Sita", "Gita", "Dipen", "Hari", "Ram"};

       returnArray(thisWeek, lastWeek);
    }

    /*public static String[] returnArray(String [] thisWeek, String [] lastWeek){
        List<String> aList = Arrays.asList(thisWeek);
        List<String> bList = Arrays.asList(lastWeek);
        List<String> latest = new ArrayList<>();
        aList.stream().forEach((item)-> {
            if(!bList.contains(item)){
                latest.add(item+"-new!" );
            }
        });

        bList.stream().forEach((item)->{
            latest.add(item);
        });
        Collections.sort(latest);
        System.out.println(Arrays.toString(latest.toArray()));
        return null;
    }*/

    public static String[] returnArray(String [] thisWeek, String [] lastWeek){
        List<String> thisWeekLst = Arrays.asList(thisWeek);
        List<String> lastWeekLst = Arrays.asList(lastWeek);

    /*    List<String> latest = lastWeekLst.stream()
                .flatMap((lastWeekitem)-> {
                    return thisWeekLst.stream()
                            .filter((thisWeekItem)-> !lastWeekLst.contains(thisWeekItem))
                            .map((thisWeekItem)->thisWeekItem+"-new!");
                }).collect(toList());
        System.out.println(Arrays.toString(latest.toArray()));
     */
        return null;
    }

}
