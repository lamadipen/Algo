package com.dp.hrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JavaSort {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<StudentSort> studentList = new ArrayList<StudentSort>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            StudentSort st = new StudentSort(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }


        Comparator<StudentSort> comparator = (o1, o2) -> {
            if(o1.getCgpa() == o2.getCgpa()){
                int nameCompare = o1.getFname().compareTo(o2.getFname()); //FName compared ascending

                if(nameCompare ==  0)
                    return o1.getId() - o2.getId(); //ID compared ascending way
                else
                    return nameCompare;

            }else
            {
                return (int) (o2.getCgpa() * 1000 - o1.getCgpa() * 1000);
            }

        };

        //Using Comparator java 7 way
        studentList.sort(comparator);
        
        //java 8 comparator
        Comparator<StudentSort> comparator8 = Comparator.comparing(StudentSort::getCgpa).reversed()
                .thenComparing(StudentSort::getFname)
                .thenComparing(StudentSort::getId);

        //Using java 8 stream;
        studentList.stream().sorted(Comparator.comparing(StudentSort::getCgpa).reversed()
                .thenComparing(StudentSort::getFname)
                .thenComparing(StudentSort::getId))
                .map(StudentSort::getFname)
                .forEach(System.out::println);


        for(StudentSort st: studentList){
            System.out.println(st.getFname());
        }
    }
}


class StudentSort{
    private int id;
    private String fname;
    private double cgpa;
    public StudentSort(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class Checker implements Comparator<StudentSort>{

    public int compare(StudentSort p1, StudentSort p2){
        if(p1.getCgpa() == p2.getCgpa()){
            return (p1.getFname()).compareTo(p2.getFname());
        }else{
            return (int) (p2.getCgpa() - p1.getCgpa());
        }
    }

}

/**
 Input

5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76

 */