package com.dp.hrank.java;

import java.io.*;
import java.util.Calendar;
import java.util.Locale;

public class JavaDateTime {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static String findDay(int month, int day, int year) {

        Calendar cal = Calendar.getInstance();

        cal.set(year,month,day);
        int i = cal.get(Calendar.DAY_OF_WEEK);
        String displayName = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()).toUpperCase();


//        DayOfWeek dayOfWeek = DayOfWeek.of(i);
//        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
//        System.out.println(simpleDateformat.format(cal.getDisplayName()));

        return displayName;

    }


}
