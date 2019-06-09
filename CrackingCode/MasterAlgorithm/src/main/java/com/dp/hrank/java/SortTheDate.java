package com.dp.hrank.java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SortTheDate {

    public static void main(String[] args) throws ParseException {
//        String[] inDates = {"20 Oct 2052", "06 Jun 1933", "26 May 1960"
//                , "20 Sep 1958", " 16 Mar 2068", "25 May 1912", "16 Dec 2018"
//                ,"26 Dec 2061", "04 Nov 2030", "28 Jul 1963"
//        };

        String[] inDates = {"20-Oct-2052", "06-Jun-1933", "26-May-1960"
                , "20-Sep-1958", " 16-Mar-2068", "25-May-1912", "16-Dec-2018"
                ,"26-Dec-2061", "04-Nov-2030", "28-Jul-1963"
        };

        //String[] inDates = { "06-Jun-1933"};
        //DateFormat df1 = new SimpleDateFormat("dd MMM yyyy");
       // List<String> collect = Arrays.stream(dates).map(it -> df1.format(it)).collect(Collectors.toList());

        Date[] dates = new Date[inDates.length];
        for (int i = 0; i < inDates.length; i++) {
            
            String temp = inDates[i];
            DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            Date dateTransformed = df.parse(temp);
            dates[i] = dateTransformed;
        }
        Arrays.sort(dates);

        DateFormat df1 = new SimpleDateFormat("dd MMM yyyy");
        List<String> collect = Arrays.stream(dates).map(it -> df1.format(it)).collect(Collectors.toList());



        collect.stream().forEach(System.out::println);
    }
}
