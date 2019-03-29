package com.dp.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingConflict {

    public static void main(String[] args) {
        //EqualesImplQuiz();

        Integer[][] array = {{0,30},{15,20},{5,10}};
        //JAVA 8 IMPLEMENTATION
        //Arrays.sort(array, Comparator.comparing(pair -> pair[0]));

        Comparator<Integer[]> comparator = new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0].compareTo(o2[0]);
                //return compare(o1[0],o2[0]);
            }
        };
        //Using Comparator
        Arrays.sort(array, comparator);


        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void EqualesImplQuiz() {
        //What is difference in the below implementation.
        String apple = null;
        System.out.println("Apple".equals(null));
        System.out.println("Apple".equals(apple));
        //This will throw null point exception
        System.out.println(apple.equals("apple"));
    }
}
/*

//  int a = 5, b = 10
//  a = a + b;
//  b = a - b;
// a = a - b;
//  3->2->5->1->


// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

// Example 1:
// Input: [[0,30],[5,10],[15,20]]

// Output: false
// 0-30 5 -10 15 -20
//
// Example 2:
// Input: [[7,10],[2,4]]
// Output: true
//
// Example 3:
// Input: [[7,10],[6,9]]
// Output: false


    public boolean couldAttend(int[][] input){

        Arrays.sort(input, (a,b) -> a[0] - b[0]);
        //Arrays.stream(input).sorted(Comparator.comparing(val -> ))

//int largest = input[0][input.length -1]; // input[0][1]; input[input.length-1][1];

        for(int i =0; i < input.length -1; i++){ // i < input.length-1
            if(input[i][1] > input[i+1][0] ) //input[i][1] > input[i+1][0] => false
            {
                return false;
            }
        }
        return true;
    }



    Designing a URL Shortening service like TinyURL
        Functional Requirements:
        Given a URL, our service should generate a shorter(length is 6) and unique alias of it. This is called a short link.
        When users access a short link, our service should redirect them to the original link.

        For example, if we shorten this page through TinyURL:
        https://www.educative.io/collection/page/5668639101419520/5649050225344512/5668600916475904/
        We would get:
        http://tinyurl.com/jlg8zpc



        1. I need implementation
        1. How to convert Long url to Shorter url
        2. How to convert a shorter url to the original URl
        2. I need the restful service implemention
        1. GET, POST or PUT?
        2. How to implment the rest service
        3. I need the DB design
        1. RMSDB? NO-SQL? Why?
        2. How many tables?
        3. Whats the column we may need
        4. I need a high level Capacity Estimation(Optional)
        1. How many VMs we may need? -> 1 vm

        The order that to anwser questions : 4 - 3 - 2 - 1

        Daily Active User: 1M
        QPS : write -> 100, read -> 1000

        id primary longur(unique) shortulr(unique)

public TinyUrl{
private int id;
private String tinryUrl;
private String longUrl;
        }

@RestContorller
public class UrlController{

    @Mapping(value ="/tinyUrl", Method= HttpMethod.Get)
    public List<TinyUrl> getAllTinyUrls(){
        return mockService.getAllTinyList();
    }

    @Mapping(value ="/tinyUrl/{shortUrl}", Method= HttpMethod.Get)
    public List<TinyUrl> getAllTinyUrls(@Params String id){
        return mockService.getTinyById(id);
    }

    @Mapping(value ="/tinyUrl", Method= HttpMethod.Post)
    public List<TinyUrl> getAllTinyUrls(@RequestBody String tinyUrl){
        return mockService.savetinyUrl(tinyUrl);
    }

}


    public String longToShortUrl(String longUrl){
        input:https://www.educative.io/collection/page/5668639101419520/5649050225344512/5668600916475904/,https://www.urbandictionary.com/author.php?author=asldkjf%3B
        output:jlg8zp

        List<Character> chars = Arrays.asList(new Character[]{A,B,,C})
        DateTime currenttime = DateTime.now();

        String date =currentTime.toString();
        Character[] dateChar = date.toCharArray();

        for(int i =0; i < date.length(); i++){
            int randomIndex = Math.random(0,date.length);
            dateaChar[i] = chars.get(randmIndes);

        }

        String finalReul=  dateChar.toString()



    }
*/
