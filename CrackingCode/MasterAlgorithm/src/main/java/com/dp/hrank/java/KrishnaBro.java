package com.dp.hrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class KrishnaBro {

    public static void main(String[] args) {
        SampleDemo A = new SampleDemo("A");
        SampleDemo B = new SampleDemo("B");

       // B.start();
       // A.start();

        getMovieTitles("spiderman");
    }


    static int processInput(int test){
        return 1;
    }

    static  String[] getMovieTitles(String substr){
        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class SampleDemo implements Runnable {
    private Thread t;
    private String threadName;

    public SampleDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true)
            System.out.print(threadName);
    }

    public void start(){
        if(t == null){
            t = new Thread(this, threadName);
        }
        t.start();
    }


}

