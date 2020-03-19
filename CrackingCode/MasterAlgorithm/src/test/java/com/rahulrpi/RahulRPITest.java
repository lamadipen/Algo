package com.rahulrpi;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RahulRPITest {

    @Test
    public void test1() {
        Supplier<String> i = () -> "Car";
        Consumer<String> c = x -> System.out.println(x.toLowerCase());
        Consumer<String> d = x -> System.out.println(x.toUpperCase());

        c.andThen(d).accept(i.get());

//        BufferedReader bufferedReader = new BufferedReader(new FileReader(""));

        System.out.println(
                Stream.of("green", "yellow", "blue")
                        .max((s1,s2)-> s1.compareTo(s2))
                        .filter(s -> s.endsWith("n"))
                        .orElse("yellow")
        );

        String s = "1";
        System.out.println(("1" != s)? "true" : "false");

        int cc =0;
        System.out.println(0 == cc++);

        Double dd = null;
        System.out.println(dd instanceof Double);

//        int x = 5;
//        x =~3;
//        x = !x;
//        x.value()


        StringBuffer sb = new StringBuffer("buffering");
        sb.replace(2, 7, "BUFFER");
        sb.delete(2, 4);
        String st = sb.substring(1, 5);
        System.out.println(st);

        Stream.of("dog", "over","good")
                .reduce((x1,x2)-> x1.length() ==3 ? x1:x2)
                .ifPresent(System.out::print);

        Stream.of("dog", "over","good")
                .reduce((x1,x2)-> {if(x1.equals("dog")) return x1; return x2;})
                .ifPresent(System.out::print);

        LocalDate of = LocalDate.of(2015, 4, 4);
        System.out.println(of.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println(of.format(DateTimeFormatter.ofPattern("E, MMM dd, yyyy")));
        System.out.println(of.format(DateTimeFormatter.ofPattern("MM/dd/yy")));

        Integer number1 = new Integer(1);
        Integer number2 = number1;
        number1 += 1;
        System.out.println(number1);
        System.out.println(number2);

    }



}

class MyClass {
    int data;
    public MyClass() {
  //this()
        //super()
    }

    public void best() {
        //super();
       // this();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        int data =2;
        MyClass myClass = new MyClass();
        Class c = myClass.getClass();

        System.out.println(c.getMethod("getNumber",null).toString());
        //System.out.println(c.getMethod("setNumber",null).toString());

        Runtime.getRuntime().totalMemory();
        Runtime.getRuntime().maxMemory();
        Runtime.getRuntime().freeMemory();

        Map<Integer, List<String>> collect = Arrays.asList("Jupiter", "Neptune", "Mars", "Earth")
                .stream().collect(Collectors.groupingBy(p -> p.length()));

        collect.forEach((l,s) -> System.out.println(l +" - " + s));


        Shape shape = new Rectange();
        Triangel triangel = (Triangel) shape;
    }

    public Integer getNumber(){
        return  2;
    }
    public void setNumber(Integer n) {
    }
}


class Shape {
}

class Rectange extends Shape {

}

class Triangel extends Shape{

}