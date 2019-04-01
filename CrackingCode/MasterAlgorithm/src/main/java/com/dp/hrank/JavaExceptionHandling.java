package com.dp.hrank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionHandling {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        try{
            while(sc.hasNext()){
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(x/y);
            }
        }catch(InputMismatchException  ex){
            System.out.println(ex.getClass().getName());

        }catch (ArithmeticException  ex){
            System.out.println(ex);
        }

    }
}


/**

 Exception handling is the process of responding to the occurrence, during computation, of exceptions – anomalous or exceptional conditions requiring special processing – often changing the normal flow of program execution. (Wikipedia)

 Java has built-in mechanism to handle exceptions. Using the try statement we can test a block of code for errors. The catch block contains the code that says what to do if exception occurs.

 This problem will test your knowledge on try-catch block.

 You will be given two integers  and  as input, you have to compute . If  and  are not  bit signed integers or if  is zero, exception will occur and you have to report it. Read sample Input/Output to know what to report in case of exceptions.
 */